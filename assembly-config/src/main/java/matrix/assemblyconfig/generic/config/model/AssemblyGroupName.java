package matrix.assemblyconfig.generic.config.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


@XmlType(name = "assemblyGroupName")
@XmlEnum
public enum AssemblyGroupName{
  PUB,
  DSP,
  BUYER,
  PUB_AdNetwork,
  PUB_AdNetwork_RECONCILED;
  
  public String value() {
    return name();
  }

  public static AssemblyGroupName fromValue(String v) {
    return valueOf(v);
  }
  
  public static List<AssemblyGroupName> parse(String names){
    List<AssemblyGroupName> nameList = new ArrayList<>();
    String[] nameArr = names.split(",");
    for(String n : nameArr){
      nameList.add(AssemblyGroupName.valueOf(n));
    }
    return nameList;
  }
}
