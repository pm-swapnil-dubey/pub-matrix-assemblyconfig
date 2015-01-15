package matrix.assemblyconfig.generic.config.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "name"
})
@XmlRootElement(name = "filterFields")
public class FilterFields implements Serializable{

  @XmlElement(required = true)
  protected List<String> name;
  
  public List<String> getName() {
    if (name == null) {
        name = new ArrayList<String>();
    }
    return this.name;
  }
  
}
