package matrix.assemblyconfig.generic.config.rollup.model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import matrix.assemblyconfig.generic.config.model.AssemblyGroupOutSequence;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "rollupFields",
    "meta"
})
@XmlRootElement(name = "rollupAggregation")
public class RollupAggregation implements Serializable{

  @XmlElement(required = true)
  private RollupFields rollupFields;
  @XmlElement(required = true)
  private Meta meta;
  private AssemblyGroupOutSequence outSequence;
  
  public RollupFields getRollupFields() {
    return rollupFields;
  }
  public void setRollupFields(RollupFields rollupFields) {
    this.rollupFields = rollupFields;
  }
  public Meta getMeta() {
    return meta;
  }
  public void setMeta(Meta meta) {
    this.meta = meta;
  }
  public AssemblyGroupOutSequence getOutSequence() {
    return outSequence;
  }
  public void setOutSequence(AssemblyGroupOutSequence outSequence) {
    this.outSequence = outSequence;
  }
}
