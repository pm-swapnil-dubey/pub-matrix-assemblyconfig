package matrix.assemblyconfig.generic.config.rollup.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import matrix.assemblyconfig.generic.config.model.FieldType;
import matrix.assemblyconfig.generic.config.model.OperationType;
import matrix.assemblyconfig.generic.config.util.AggregateByUtil;
import cascading.pipe.assembly.AggregateBy;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "metric"
})
@XmlRootElement(name = "metrics")
public class Metrics implements Serializable{

  @XmlElement(required = true)
  private List<Metric> metric = new ArrayList<>();

  public List<Metric> getMetric() {
    return metric;
  }

  public void setMetric(List<Metric> metric) {
    this.metric = metric;
  }
  
  public void addMetric(Metric m){
    metric.add(m);
  }
  
  public AggregateBy[] getAggregateBySubAssemblies(){
    AggregateBy[] aggregateBy = new AggregateBy[metric.size()];
    int i=0;
    for(Metric m : metric){
      aggregateBy[i] = AggregateByUtil.createAggregateByFromMetric(OperationType.SUM, m.getName(), m.getType());
      i++;
    }
    return aggregateBy;
  }
  public AggregateBy[] getAggregateBySubAssemblies(String[] metricsStr){
    AggregateBy[] aggregateBy = new AggregateBy[metricsStr.length + 1];
    int i=0;
    for (String metricStr : metricsStr) {
      for(Metric m : metric){
        if(m.getName().equals(metricStr))
        {
          aggregateBy[i] = AggregateByUtil.createAggregateByFromMetric(OperationType.SUM, m.getName(), m.getType());
          i++;
        }
      }
    }
    aggregateBy[i] = AggregateByUtil.createAggregateByFromMetric(OperationType.COUNT,"adconfig_ad_id", FieldType.INTEGER);
    return aggregateBy;
  }
}
