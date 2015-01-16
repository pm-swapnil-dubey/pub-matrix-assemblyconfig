package matrix.assemblyconfig.util.jaxb;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

public class OldJaxbPaarser {
	public static <T> T parse(Class<T> clazz) throws Exception {
		JAXBContext context = JAXBContext.newInstance(clazz);
		Unmarshaller unmarshaller = context.createUnmarshaller();
		T instance = (T) unmarshaller.unmarshal(Thread.currentThread().getContextClassLoader().getResource("old-assembly-workflow.xml"));
		return instance;
	}
}
