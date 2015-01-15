package matrix.assemblyconfig.generic.config.model;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import matrix.assemblyconfig.util.Util;

import org.apache.commons.lang3.ArrayUtils;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "name"
})
@XmlRootElement(name = "partitionFields")
public class PartitionFields implements Serializable{

  @XmlElement(required = true)
  protected List<String> name;

  public List<String> getName() {
    return name;
  }

  public void setName(List<String> name) {
    this.name = name;
  }

  public String[] getPartitionFieldsWithGroupKey(){
    return ArrayUtils.addAll(Util.convertToStringArray(name), new String[]{"group_key"});
  }
}
