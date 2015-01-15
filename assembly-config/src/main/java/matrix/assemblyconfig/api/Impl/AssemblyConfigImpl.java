package matrix.assemblyconfig.api.Impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import matrix.assemblyconfig.api.AssemblyConfig;
import matrix.assemblyconfig.api.util.DimensionSequenceMap;
import matrix.assemblyconfig.api.util.PublisherTypeDimensionSequenceData;
import matrix.assemblyconfig.generic.dimensionseq.PublisherTypeDimensionSequenceMap;


public class AssemblyConfigImpl implements AssemblyConfig{

	@Override
	public List<PublisherTypeDimensionSequenceData> getListApplicableDimensionSequenceData(Integer pubTypeId) throws IOException,
			Exception {
		List<PublisherTypeDimensionSequenceData> dimensionListPubType = new ArrayList<>();
		DimensionSequenceMap dimensionSequenceMap = DimensionSequenceMap
				.getInstance();
		List<PublisherTypeDimensionSequenceData> publisherTypeDimensionSequenceList = dimensionSequenceMap
				.getListApplicableDimensionSequenceData();
		PublisherTypeDimensionSequenceMap publisherTypeDimensionSequenceMap = new PublisherTypeDimensionSequenceMap();
		List<Integer> dimensionSequenceList = publisherTypeDimensionSequenceMap
				.getPubTypeDimensionSequenceMap().get(pubTypeId);
		for (Integer dimensionSeqId : dimensionSequenceList) {
			dimensionListPubType.add(publisherTypeDimensionSequenceList.get(dimensionSeqId - 1));
		}
		return dimensionListPubType;
		
	}

	
	
}
