package matrix.assemblyconfig.generic.dimensionseq;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;

public class PublisherTypeDimensionSequenceMap {

	public PublisherTypeDimensionSequenceMap() throws IOException {
		init();
	}

	private static final Map<Integer, List<Integer>> PUB_TYPE_DIMENSION_SEQUENCE_MAP = new HashMap();

	private void init() throws IOException {
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();  
		BufferedReader reader = new BufferedReader(new InputStreamReader(Thread
				.currentThread().getContextClassLoader()
				.getResourceAsStream("PubTypeDimensionSequence.csv")));
		String line = "";
		while ((line = reader.readLine()) != null) {
			String[] tokens = line.split("=");
			List<Integer> dimeSeqList = new ArrayList();
			for (String currentVal : tokens[1].split(",")) {
				dimeSeqList.add(Integer.parseInt(currentVal));
			}
			PUB_TYPE_DIMENSION_SEQUENCE_MAP.put(Integer.parseInt(tokens[0]),
					dimeSeqList);
		}
	}

	public Map<Integer, List<Integer>> getPubTypeDimensionSequenceMap() {
		return PUB_TYPE_DIMENSION_SEQUENCE_MAP;
	}
}
