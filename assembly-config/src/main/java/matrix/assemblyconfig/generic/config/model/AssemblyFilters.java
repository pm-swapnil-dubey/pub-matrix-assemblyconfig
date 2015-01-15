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
    "assemblyFilter"
})
@XmlRootElement(name = "assemblyFilters")
public class AssemblyFilters implements Serializable{

  @XmlElement(required = true)
  protected List<AssemblyFilter> assemblyFilter;
  
  public List<AssemblyFilter> getAssemblyFilter() {
    if (assemblyFilter == null) {
      assemblyFilter = new ArrayList<AssemblyFilter>();
    }
    return this.assemblyFilter;
  }
  
}
