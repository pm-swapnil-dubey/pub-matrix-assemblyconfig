package matrix.assemblyconfig.generic.config.model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "partitionFields",
    "dateField"
})
@XmlRootElement(name = "meta")
public class Meta implements Serializable{
  
  @XmlElement(required = true)
  protected PartitionFields partitionFields;
  @XmlElement(required = true)
  protected String dateField;
  
  public String getDateField() {
    return dateField;
  }
  public void setDateField(String dateField) {
    this.dateField = dateField;
  }

  public PartitionFields getPartitionFields() {
    return partitionFields;
  }

  public void setPartitionFields(PartitionFields partitionFields) {
    this.partitionFields = partitionFields;
  }
  
}
