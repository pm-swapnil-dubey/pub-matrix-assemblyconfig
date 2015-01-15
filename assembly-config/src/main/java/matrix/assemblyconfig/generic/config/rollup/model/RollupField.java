package matrix.assemblyconfig.generic.config.rollup.model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;

import matrix.assemblyconfig.generic.config.model.FieldType;

@XmlTransient
public abstract class RollupField implements Serializable{
  
  @XmlElement(required = true)
  private String name;
  @XmlElement(required = true)
  private FieldType type;
  
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public FieldType getType() {
    return type;
  }
  public void setType(FieldType type) {
    this.type = type;
  }

  
}
