package matrix.assemblyconfig.api.util;

import java.util.HashMap;
import java.util.Map;

public class PublisherTypeDimensionSequenceData {

	String type;
	Integer id;
	Map<String, Boolean> applicableDimensionSeqMap = new HashMap<>();

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Map<String, Boolean> getApplicableDimensionSeqMap() {
		return applicableDimensionSeqMap;
	}

	public void setApplicableDimensionSeqMap(
			Map<String, Boolean> applicableDimensionSeqMap) {
		this.applicableDimensionSeqMap = applicableDimensionSeqMap;
	}

}
