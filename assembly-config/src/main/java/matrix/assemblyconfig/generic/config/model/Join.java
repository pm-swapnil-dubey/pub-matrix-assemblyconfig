//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.06.25 at 12:27:50 AM EDT 
//


package matrix.assemblyconfig.generic.config.model;

import java.io.Serializable;

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
 *         &lt;element name="type" type="{http://matrix.pubmatic.com/matrix/reports}joinType"/>
 *         &lt;element ref="{http://matrix.pubmatic.com/matrix/reports}joinFields"/>
 *         &lt;element ref="{http://matrix.pubmatic.com/matrix/reports}withDimensions"/>
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
    "type",
    "joinFields",
    "withDimensions"
})
@XmlRootElement(name = "join")
public class Join implements Serializable{

    @XmlElement(required = true)
    protected JoinType type;
    @XmlElement(required = true)
    protected JoinFields joinFields;
    @XmlElement(required = true)
    protected WithDimensions withDimensions;

    /**
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link JoinType }
     *     
     */
    public JoinType getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link JoinType }
     *     
     */
    public void setType(JoinType value) {
        this.type = value;
    }

    /**
     * Gets the value of the joinFields property.
     * 
     * @return
     *     possible object is
     *     {@link JoinFields }
     *     
     */
    public JoinFields getJoinFields() {
        return joinFields;
    }

    /**
     * Sets the value of the joinFields property.
     * 
     * @param value
     *     allowed object is
     *     {@link JoinFields }
     *     
     */
    public void setJoinFields(JoinFields value) {
        this.joinFields = value;
    }

    /**
     * Gets the value of the withDimensions property.
     * 
     * @return
     *     possible object is
     *     {@link WithDimensions }
     *     
     */
    public WithDimensions getWithDimensions() {
        return withDimensions;
    }

    /**
     * Sets the value of the withDimensions property.
     * 
     * @param value
     *     allowed object is
     *     {@link WithDimensions }
     *     
     */
    public void setWithDimensions(WithDimensions value) {
        this.withDimensions = value;
    }
    
    public String[] getDimensionNames(){
      String[] dimensions = new String[withDimensions.name.size()];
      int i = 0;
      for(String d : withDimensions.name){
        dimensions[i] = d;
        i++;
      }
      return dimensions;
    }

}
