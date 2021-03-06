//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.06.25 at 12:27:50 AM EDT 
//


package matrix.assemblyconfig.generic.config.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://matrix.pubmatic.com/matrix/reports}derviedFromJoinDimension" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "derivedFromJoinDimension"
})
@XmlRootElement(name = "derivedFromJoinDimensions")
public class DerivedFromJoinDimensions implements Serializable{

    @XmlElement(required = true)
    protected List<DerivedFromJoinDimension> derivedFromJoinDimension;

    /**
     * Gets the value of the derviedFromJoinDimension property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the derviedFromJoinDimension property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDerviedFromJoinDimension().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DerivedFromJoinDimension }
     * 
     * 
     */
    public List<DerivedFromJoinDimension> getDerivedFromJoinDimension() {
        if (derivedFromJoinDimension == null) {
          derivedFromJoinDimension = new ArrayList<DerivedFromJoinDimension>();
        }
        return this.derivedFromJoinDimension;
    }
    
    public Map<String, String> getJoinDimensionFieldMap(){
      Map<String, String> map = new HashMap<>();
      if(null!=derivedFromJoinDimension) {
        for (DerivedFromJoinDimension dimension : derivedFromJoinDimension) {
          map.put(dimension.getJoinField(), dimension.getName());
        }
      }
      return map;
    }
    
    /*public List<String> getCubicFields(){
      List<String> cubicFields = new ArrayList<>();
      for(int i=0; i<derivedFromJoinDimension.size() ;i++){
        DerivedFromJoinDimension dimension = derivedFromJoinDimension.get(i);
        if(dimension.isIsCubic()){
          cubicFields.add(dimension.getName());
        }
      }
      return cubicFields;
    }
    
    public Map<String, FieldType> getCubicFieldAndTypeMap(){
      return getFieldAndTypeMap(true);
    }*/
    
    public Map<String, FieldType> getFieldAndTypeMap(){
      Map<String, FieldType> fieldAndTypeMap = new HashMap<>();
      if(null!=derivedFromJoinDimension) {
        for (int i = 0; i < derivedFromJoinDimension.size(); i++) {
          DerivedFromJoinDimension dimension = derivedFromJoinDimension.get(i);
          fieldAndTypeMap.put(dimension.getName(), dimension.getType());
        }
      }
      return fieldAndTypeMap;
    }
    
}
