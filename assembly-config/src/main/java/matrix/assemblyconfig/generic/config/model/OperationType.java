//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.06.25 at 12:27:50 AM EDT 
//


package matrix.assemblyconfig.generic.config.model;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for operationType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="operationType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="AVERAGE"/>
 *     &lt;enumeration value="SUM"/>
 *     &lt;enumeration value="COUNT"/>
 *     &lt;enumeration value="FIRST"/>
 *     &lt;enumeration value="MAX"/>
 *     &lt;enumeration value="MIN"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "operationType")
@XmlEnum
public enum OperationType {

    AVERAGE,
    SUM,
    COUNT,
    FIRST,
    MAX,
    MIN;

    public String value() {
        return name();
    }

    public static OperationType fromValue(String v) {
        return valueOf(v);
    }

}
