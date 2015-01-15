package matrix.assemblyconfig.util.jaxb;

import java.io.File;
import java.io.InputStreamReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

public class JaxbParser {

	public static <T> T parse(Class<T> clazz) throws Exception {
		JAXBContext context = JAXBContext.newInstance(clazz);
		Unmarshaller unmarshaller = context.createUnmarshaller();
		T instance = (T) unmarshaller.unmarshal(Thread.currentThread().getContextClassLoader().getResource("assembly-workflow.xml"));
		return instance;
	}

}
