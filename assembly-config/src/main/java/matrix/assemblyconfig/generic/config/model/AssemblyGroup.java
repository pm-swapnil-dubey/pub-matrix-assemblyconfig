//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.07.25 at 08:58:02 AM EDT 
//


package matrix.assemblyconfig.generic.config.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import org.apache.commons.lang3.ArrayUtils;


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
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element ref="{http://matrix.pubmatic.com/matrix/reports}assemblyGroupDimensions"/>
 *         &lt;element ref="{http://matrix.pubmatic.com/matrix/reports}assemblyGroupOutSequence"/>
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
    "name",
    "assemblyGroupDimensions",
    "derivedFromOtherDimensions",
    "assemblyFilters",
    "assemblyGroupOutSequence"
})
@XmlRootElement(name = "assemblyGroup")
public class AssemblyGroup implements Serializable{

    @XmlElement(required = true)
    protected AssemblyGroupName name;
    @XmlElement(required = true)
    protected AssemblyGroupDimensions assemblyGroupDimensions;
    protected DerivedFromOtherDimensions derivedFromOtherDimensions;
    protected AssemblyFilters assemblyFilters;
    @XmlElement(required = true)
    protected AssemblyGroupOutSequence assemblyGroupOutSequence;

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public AssemblyGroupName getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(AssemblyGroupName value) {
        this.name = value;
    }

    /**
     * Gets the value of the assemblyGroupDimensions property.
     * 
     * @return
     *     possible object is
     *     {@link AssemblyGroupDimensions }
     *     
     */
    public AssemblyGroupDimensions getAssemblyGroupDimensions() {
        return assemblyGroupDimensions;
    }

    /**
     * Sets the value of the assemblyGroupDimensions property.
     * 
     * @param value
     *     allowed object is
     *     {@link AssemblyGroupDimensions }
     *     
     */
    public void setAssemblyGroupDimensions(AssemblyGroupDimensions value) {
        this.assemblyGroupDimensions = value;
    }

    /**
     * Gets the value of the assemblyGroupOutSequence property.
     * 
     * @return
     *     possible object is
     *     {@link AssemblyGroupOutSequence }
     *     
     */
    public AssemblyGroupOutSequence getAssemblyGroupOutSequence() {
        return assemblyGroupOutSequence;
    }

    /**
     * Sets the value of the assemblyGroupOutSequence property.
     * 
     * @param value
     *     allowed object is
     *     {@link AssemblyGroupOutSequence }
     *     
     */
    public void setAssemblyGroupOutSequence(AssemblyGroupOutSequence value) {
        this.assemblyGroupOutSequence = value;
    }
    
    public DerivedFromOtherDimensions getDerivedFromOtherDimensions() {
      return derivedFromOtherDimensions;
    }

    public void setDerivedFromOtherDimensions(DerivedFromOtherDimensions derivedFromOtherDimensions) {
      this.derivedFromOtherDimensions = derivedFromOtherDimensions;
    }

    public AssemblyFilters getAssemblyFilters() {
      return assemblyFilters;
    }

    public void setAssemblyFilters(AssemblyFilters assemblyFilters) {
      this.assemblyFilters = assemblyFilters;
    }

    public List<String> getDimensionNames(){
      List<String> dimensionNames = new ArrayList<>();
      for(AssemblyGroupDimension dimension : assemblyGroupDimensions.getAssemblyGroupDimension()){
        dimensionNames.add(dimension.getName());
      }
      return dimensionNames;
    }
    
    public List<String> getCubicFields(){
      List<String> cubicFields = new ArrayList<>();
      for(AssemblyGroupDimension dimension : assemblyGroupDimensions.assemblyGroupDimension){
        if(dimension.isCubic()){
          cubicFields.add(dimension.getName());
        }
      }
      return cubicFields;
    }

    public String[] getOutSequence(){
      List<String> outFields = new ArrayList<>();
      for(String field : assemblyGroupOutSequence.getName()){
        outFields.add(field);
      }
      return Arrays.copyOf(outFields.toArray(), outFields.size(), String[].class);
    }
    
    /*public String[] getOutSequenceWithGroupKey(){
      return ArrayUtils.addAll(new String[]{CommonConstants.GROUP_RECORD_KEY}, getOutSequence());
    }*/
}
