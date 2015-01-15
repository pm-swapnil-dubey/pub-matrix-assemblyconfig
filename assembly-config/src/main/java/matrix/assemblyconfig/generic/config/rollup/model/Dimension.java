package matrix.assemblyconfig.generic.config.rollup.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "name",
    "type",
    "exclude"
})
@XmlRootElement(name = "dimension")
public class Dimension extends RollupField{
  private boolean exclude = false;

  public boolean isExclude() {
    return exclude;
  }

  public void setExclude(boolean exclude) {
    this.exclude = exclude;
  }
  
  
}
