package matrix.assemblyconfig.generic.config.rollup.model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "dateField",
    "timeZoneEntity"
})
@XmlRootElement(name = "meta")
public class Meta implements Serializable{
  
  @XmlElement(required = true)
  String dateField;
  
  public String getDateField() {
    return dateField;
  }
  public void setDateField(String dateField) {
    this.dateField = dateField;
  }
  
}
