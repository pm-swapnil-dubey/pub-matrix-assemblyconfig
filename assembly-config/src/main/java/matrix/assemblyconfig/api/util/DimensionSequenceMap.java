package matrix.assemblyconfig.api.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import matrix.assemblyconfig.generic.config.model.Assemblies;
import matrix.assemblyconfig.generic.config.model.Assembly;
import matrix.assemblyconfig.generic.config.model.AssemblyFields;
import matrix.assemblyconfig.generic.config.model.DimensionSequence;
import matrix.assemblyconfig.generic.config.model.DimensionSequences;
import matrix.assemblyconfig.generic.config.model.Dimensions;
import matrix.assemblyconfig.generic.config.model.SimpleDimensions;
import matrix.assemblyconfig.util.jaxb.JaxbParser;

public class DimensionSequenceMap {

	LinkedHashMap<String, Boolean> defaultDimensionSequenceMap = new LinkedHashMap();
	List<PublisherTypeDimensionSequenceData> listApplicableDimensionSequenceData = new ArrayList<>();
	private static DimensionSequenceMap dimensionSequenceMap = new DimensionSequenceMap();

	public static DimensionSequenceMap getInstance() {
		return dimensionSequenceMap;
	}

	public List<PublisherTypeDimensionSequenceData> getListApplicableDimensionSequenceData() {
		return listApplicableDimensionSequenceData;
	}

	public DimensionSequenceMap() {

		configureMap();
	}

	private void configureMap() {
		AssemblyFields assemblyFields = getAssembly();
		for (DimensionSequences currentDimSeqs : assemblyFields
				.getExtractorDimensionSequences().getDimensionSequences()) {
			
			for (DimensionSequence currentSeq : currentDimSeqs
					.getDimensionSequences()) {
				initializeApplicableDimensionSeqDataMap();
				PublisherTypeDimensionSequenceData applicableDimensionSequenceData = new PublisherTypeDimensionSequenceData();
				applicableDimensionSequenceData.setType(currentDimSeqs.getType());
				applicableDimensionSequenceData.setId(currentSeq.getId());
				for (String dimSeq : currentSeq.getName()) {
					if (null != defaultDimensionSequenceMap.get(dimSeq)) {
						defaultDimensionSequenceMap.put(dimSeq, Boolean.TRUE);
					}
				}
				applicableDimensionSequenceData
						.setApplicableDimensionSeqMap(defaultDimensionSequenceMap);
				listApplicableDimensionSequenceData
						.add(applicableDimensionSequenceData);
			}

		}
	}

	public Map<String, Boolean> getDefaultDimensionSequenceMap() {
		return defaultDimensionSequenceMap;
	}

	private void initializeApplicableDimensionSeqDataMap() {
		AssemblyFields assemblyFields = getAssembly();
		Dimensions dimensions = assemblyFields.getDimensions();
		SimpleDimensions simpleDimensions = dimensions.getSimpleDimensions();
		String[] dimensionNames = simpleDimensions.getDimensionNames();
		for (String dimensionName : dimensionNames)
			defaultDimensionSequenceMap.put(dimensionName, Boolean.FALSE);
	}

	private AssemblyFields getAssembly() {
		Assembly assembly = null;
		try {
			assembly = JaxbParser.parse(Assemblies.class).getAssembly().get(0);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		AssemblyFields assemblyFields = assembly.getAssemblyFields();
		return assemblyFields;
	}
}
