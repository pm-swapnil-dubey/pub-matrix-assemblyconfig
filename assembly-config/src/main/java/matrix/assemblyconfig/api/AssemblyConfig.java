package matrix.assemblyconfig.api;

import java.io.IOException;
import java.util.List;

import matrix.assemblyconfig.api.util.PublisherTypeDimensionSequenceData;

public interface AssemblyConfig {
	public List<PublisherTypeDimensionSequenceData> getListApplicableDimensionSequenceData(Integer pubTypeId) throws IOException, Exception;
}
