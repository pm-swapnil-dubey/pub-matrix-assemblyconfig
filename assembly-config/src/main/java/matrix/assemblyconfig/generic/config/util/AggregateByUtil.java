package matrix.assemblyconfig.generic.config.util;
import matrix.assemblyconfig.generic.config.model.FieldType;
import matrix.assemblyconfig.generic.config.model.OperationType;
import cascading.pipe.assembly.AggregateBy;
import cascading.pipe.assembly.AverageBy;
import cascading.pipe.assembly.CountBy;
import cascading.pipe.assembly.FirstBy;
import cascading.pipe.assembly.MaxBy;
import cascading.pipe.assembly.MinBy;
import cascading.pipe.assembly.SumBy;
import cascading.tuple.Fields;


public class AggregateByUtil {
  public static AggregateBy createAggregateByFromMetric(OperationType operation, String metricName, FieldType fieldType) {
    switch (operation) {
      case AVERAGE:
        return new AverageBy(new Fields(metricName), new Fields(metricName));
      case COUNT:
        return new CountBy(new Fields(metricName), new Fields(metricName));
      case SUM:
        return new SumBy(new Fields(metricName), new Fields(metricName),
            FieldType.getFieldTypeClass(fieldType));
      case MAX:
        return new MaxBy(new Fields(metricName), new Fields(metricName));
      case MIN:
        return new MinBy(new Fields(metricName), new Fields(metricName));
      case FIRST:
        return new FirstBy(new Fields(metricName));
      default:
        return null;
    }
  }

  
}
