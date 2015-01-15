package matrix.assemblyconfig.generic.config.rollup.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.sun.tools.javac.code.Attribute.Array;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "dimension"
})
@XmlRootElement(name = "dimensions")
public class Dimensions implements Serializable{

  @XmlElement(required = true)
  private List<Dimension> dimension = new ArrayList<>();

  public List<Dimension> getDimension() {
    return dimension;
  }

  public void setDimension(List<Dimension> dimension) {
    this.dimension = dimension;
  }
  
  public void addDimension(Dimension d){
    dimension.add(d);
  }
  
  public Integer getPosition(String dimensionName){
    Integer position = -1;
    for(int i=0; i<dimension.size(); i++){
      Dimension d = dimension.get(i);
      if(d.getName().equals(dimensionName)){
        position = i;
        break;
      }
    }
    return position;
  }
  
  public String[] getDimensionNames(){
    List<String> dimensions = new ArrayList<>();
    for(Dimension d : dimension){
      dimensions.add(d.getName());
    }
    return Arrays.copyOf(dimensions.toArray(), dimensions.size(), String[].class);
  }
  
  public String[] getFinalDimensionNames(){
    List<String> dimensions = new ArrayList<>();
    for(Dimension d : dimension){
      if(!d.isExclude()){
        dimensions.add(d.getName());
      }
    }
    return Arrays.copyOf(dimensions.toArray(), dimensions.size(), String[].class);
  }
}
