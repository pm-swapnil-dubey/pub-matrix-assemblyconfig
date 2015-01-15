package matrix.assemblyconfig.util.jaxb;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.UnmarshalException;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import matrix.assemblyconfig.generic.generated.Assemblies;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.SAXParseException;

public class JaxbUtils {

  private static final String SCHEMA_XSD = "schema.xsd";
  private static JaxbUtils instance;
  private Schema schema;
  private JAXBContext assembliesJaxbContext;
  private final Logger LOGGER = LoggerFactory.getLogger(JaxbUtils.class);

  private JaxbUtils() {
    initialize();
  }

  private void initialize() {
    try {
      SchemaFactory sf = SchemaFactory.newInstance("http://www.w3.org/2001/XMLSchema");
      schema =
          sf.newSchema(new StreamSource(getClass().getClassLoader().getResourceAsStream(SCHEMA_XSD)));
      assembliesJaxbContext =
          JAXBContext.newInstance(matrix.assemblyconfig.generic.config.model.Assemblies.class.getPackage().getName(),
              matrix.assemblyconfig.generic.config.model.Assemblies.class.getClassLoader());
    } catch (Exception ex) {
      LOGGER.error("Error while loading schemas & initializing jaxb context", ex);
      throw new IllegalStateException(ex);
    }
  }

  /**
   * factory method to get singleton instance
   * 
   * @return
   */
  public static JaxbUtils getInstance() {
    if (instance == null) {
      synchronized (JaxbUtils.class) {
        if (instance == null) {
          instance = new JaxbUtils();
        }
      }
    }
    return instance;
  }

  public Assemblies unmarshal(String fileLocation){
    return unmarshal(fileLocation, Assemblies.class);
  }
  
  public <T> T unmarshal(String fileLocation, Class<T> clazz) {
    Unmarshaller unmarshaller = getUnMarshaller();
    InputStream toUnmarShall;
    try {
      toUnmarShall = toUnmarShall(fileLocation);
    } catch (FileNotFoundException exception) {
      StringBuilder errorMessage =
          new StringBuilder("Unable to read ").append(fileLocation)
              .append(" due to following reason: ").append(exception.getMessage());
      LOGGER.error(errorMessage.toString());
      throw new IllegalStateException(errorMessage.toString());
    }
    T o;
    try {
      o = (T) unmarshaller.unmarshal(toUnmarShall);
    } catch (JAXBException exception) {
      Throwable linkedException = exception.getLinkedException();
      if (exception instanceof UnmarshalException && linkedException instanceof SAXParseException) {
        createAnUserfriendlyUnmarshalException(fileLocation, exception, linkedException);
      }
      StringBuilder errorMessage =
          new StringBuilder("Unable to read ").append(fileLocation)
              .append(" due to following reason: ").append(linkedException.getMessage());
      LOGGER.error(errorMessage.toString());
      throw new IllegalStateException(errorMessage.toString());
    }
    return o;
  }

  private Unmarshaller getUnMarshaller() {
    Unmarshaller unmarshaller = null;
    try {
      unmarshaller = assembliesJaxbContext.createUnmarshaller();
      unmarshaller.setSchema(schema);
    } catch (JAXBException exception) {

      StringBuilder errorMessage =
          new StringBuilder("Unable to read ").append(SCHEMA_XSD)
              .append(" due to following reason: ")
              .append(exception.getLinkedException().getMessage());
      LOGGER.error(errorMessage.toString());
      throw new IllegalStateException(errorMessage.toString());
    }
    return unmarshaller;
  }

  private static InputStream toUnmarShall(String fileLocation) throws FileNotFoundException {
    File file = new File(fileLocation);
    return new FileInputStream(file);
  }

  private void createAnUserfriendlyUnmarshalException(String fileLocation, JAXBException exception,
      Throwable linkedException) {
    SAXParseException saxParseException = ((SAXParseException) linkedException);
    StringBuilder errorMessage =
        new StringBuilder("Unable to read ").append(fileLocation)
            .append(" due to following reason: ").append(saxParseException.getMessage())
            .append(". The problem is present in line number:")
            .append(saxParseException.getLineNumber()).append(" and column number: ")
            .append(saxParseException.getColumnNumber());
    LOGGER.error(errorMessage.toString());
    throw new IllegalStateException(errorMessage.toString(), saxParseException);
  }

}
