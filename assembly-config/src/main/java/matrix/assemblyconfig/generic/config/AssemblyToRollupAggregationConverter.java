package matrix.assemblyconfig.generic.config;

import java.util.HashMap;
import java.util.Map;

import matrix.assemblyconfig.generic.config.model.Assembly;
import matrix.assemblyconfig.generic.config.model.AssemblyGroup;
import matrix.assemblyconfig.generic.config.model.AssemblyGroupName;
import matrix.assemblyconfig.generic.config.model.DerivedFromOtherDimension;
import matrix.assemblyconfig.generic.config.model.DerivedFromOtherDimensions;
import matrix.assemblyconfig.generic.config.model.FieldType;
import matrix.assemblyconfig.generic.config.rollup.model.Dimension;
import matrix.assemblyconfig.generic.config.rollup.model.Dimensions;
import matrix.assemblyconfig.generic.config.rollup.model.Meta;
import matrix.assemblyconfig.generic.config.rollup.model.Metric;
import matrix.assemblyconfig.generic.config.rollup.model.Metrics;
import matrix.assemblyconfig.generic.config.rollup.model.RollupAggregation;
import matrix.assemblyconfig.generic.config.rollup.model.RollupFields;

public class AssemblyToRollupAggregationConverter {

  public static RollupAggregation convert(Assembly assembly, AssemblyGroupName groupName){
    RollupAggregation rollupAggregation = new RollupAggregation();
    rollupAggregation.setRollupFields(new RollupFields());
    rollupAggregation.getRollupFields().setDimensions(new Dimensions());
    rollupAggregation.getRollupFields().setMetrics(new Metrics());
    rollupAggregation.setMeta(new Meta());
    
    
    Map<String, FieldType> dimensionTypeMap = new HashMap<String, FieldType>();
    Map<String, FieldType> metricTypeMap = assembly.getAssemblyFields().getMetrics().getFieldAndTypeMap();
    
    dimensionTypeMap.putAll(assembly.getAssemblyFields().getDimensions().getFieldAndTypeMap());
    AssemblyGroup group = assembly.getAssemblyGroups().getAssemblyGroup(groupName);
    DerivedFromOtherDimensions derivedFromOtherDimensions = group.getDerivedFromOtherDimensions();
    if(derivedFromOtherDimensions!=null){
      dimensionTypeMap.putAll(derivedFromOtherDimensions.getFieldAndTypeMap());
    }
    
    setDimensionsAndMetrics(assembly, groupName, rollupAggregation, dimensionTypeMap, metricTypeMap);
    rollupAggregation.getMeta().setDateField(assembly.getMeta().getDateField());
    rollupAggregation.setOutSequence(group.getAssemblyGroupOutSequence());
    return rollupAggregation;
  }

  private static void setDimensionsAndMetrics(Assembly assembly, AssemblyGroupName groupName,
      RollupAggregation rollupAggregation, Map<String, FieldType> dimensionTypeMap,
      Map<String, FieldType> metricTypeMap) {
    for(String field : assembly.getAssemblyGroups().getAssemblyGroup(groupName).getAssemblyGroupOutSequence().getName()){
      if(dimensionTypeMap.containsKey(field)){
        Dimension dimension = new Dimension();
        dimension.setName(field);
        dimension.setType(dimensionTypeMap.get(field));
        rollupAggregation.getRollupFields().getDimensions().addDimension(dimension);
      }else{
        Metric metric = new Metric();
        metric.setName(field);
        metric.setType(metricTypeMap.get(field));
        rollupAggregation.getRollupFields().getMetrics().addMetric(metric);
      }
    }
  }
  
}
