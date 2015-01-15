package matrix.assemblyconfig.generic.config.model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "className",
    "filterFields"
})
@XmlRootElement(name = "assemblyFilter")
public class AssemblyFilter implements Serializable{

  @XmlElement(required = true)
  protected String className;
  protected FilterFields filterFields;
  
  public String getClassName() {
    return className;
  }
  public void setClassName(String className) {
    this.className = className;
  }
  public FilterFields getFilterFields() {
    return filterFields;
  }
  public void setFilterFields(FilterFields filterFields) {
    this.filterFields = filterFields;
  }
  
}
