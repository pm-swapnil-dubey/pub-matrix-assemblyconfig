package matrix.assemblyconfig.generic.config.rollup.model;

import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import matrix.assemblyconfig.generic.config.model.FieldType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "dimensions",
    "metrics"
})
@XmlRootElement(name = "rollupFields")
public class RollupFields implements Serializable{

  @XmlElement(required = true)
  private Dimensions dimensions;
  @XmlElement(required = true)
  private Metrics metrics;
  
  public Dimensions getDimensions() {
    return dimensions;
  }
  public void setDimensions(Dimensions dimensions) {
    this.dimensions = dimensions;
  }
  public Metrics getMetrics() {
    return metrics;
  }
  public void setMetrics(Metrics metrics) {
    this.metrics = metrics;
  }
  
  public String[] getFieldNames(){
    List<RollupField> fields = getAllFields();
    List<String> fieldNames = new ArrayList<>();
    for(RollupField rollupField : fields){
      fieldNames.add(rollupField.getName());
    }
    return Arrays.copyOf(fieldNames.toArray(), fieldNames.size(), String[].class);
  }
  private List<RollupField> getAllFields() {
    List<RollupField> fields = new ArrayList<>();
    fields.addAll(dimensions.getDimension());
    fields.addAll(metrics.getMetric());
    return fields;
  }
  
  public Type[] getFieldTypes(){
    List<RollupField> fields = getAllFields();
    List<Class> types = new ArrayList<>();
    for(RollupField field : fields){
      types.add(FieldType.getFieldTypeClass(field.getType()));
    }
    return Arrays.copyOf(types.toArray(), types.size(), Class[].class);
  }
  
  public Map<String, Class> getFieldAndTypeMap(){
    List<RollupField> fields = getAllFields();
    Map<String, Class> fieldTypeMap = new HashMap<>();
    for(RollupField field : fields){
      fieldTypeMap.put(field.getName(),FieldType.getFieldTypeClass(field.getType()));
    }
    return fieldTypeMap;
  }
  
  public Type[] getFieldTypes(String[] fields){
    Map<String, Class> fieldTypeMap = getFieldAndTypeMap();
    Type[] types = new Type[fields.length];
    for(int i=0; i<types.length; i++){
      types[i]=fieldTypeMap.get(fields[i]);
    }
    return types;
  }
  
}
