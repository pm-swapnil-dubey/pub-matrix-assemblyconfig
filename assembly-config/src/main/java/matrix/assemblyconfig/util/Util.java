package matrix.assemblyconfig.util;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.apache.avro.Schema;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Util {

  private static final Logger LOGGER = LoggerFactory.getLogger(Util.class);
  
  /**
   * Creates instance of specified class
   * @param className
   * @return
   */
  public static Object createInstance(String className){
    Object o=null;
    try {
      o=Class.forName(className).newInstance();
    } catch (Exception e) {
      new RuntimeException(e);
    }
    return o;
  }
  
  
  
  public static Map<String, Integer> getPositionMap(List<String> allFields, List<String> subsetFields){
    Map<String, Integer> positionMap = new HashMap<String, Integer>();
    for(String field : subsetFields){
      positionMap.put(field, allFields.indexOf(field));
    }
    return positionMap;
  }
  
  public static String[] convertToStringArray(List<String> input){
    return Arrays.copyOf(input.toArray(), input.size(), String[].class);
  }
  
 

  public static String[] getStrFields(final Schema schema) {
    final List<Schema.Field> schemaFields = schema.getFields();
    final String[] strFieldsArr = new String[schemaFields.size()];
    for(int i=0; i < schemaFields.size(); i++) {
      strFieldsArr[i] = schemaFields.get(i).name();
    }
    return strFieldsArr;
  }
}
