//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.12.27 at 03:50:24 PM EET 
//


package preprod.qa.soap;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for specialization.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="specialization">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Neurosurgeons"/>
 *     &lt;enumeration value="Pediatrician"/>
 *     &lt;enumeration value="Surgeon"/>
 *     &lt;enumeration value="Dentist"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "specialization")
@XmlEnum
public enum Specialization {

    @XmlEnumValue("Neurosurgeons")
    NEUROSURGEONS("Neurosurgeons"),
    @XmlEnumValue("Pediatrician")
    PEDIATRICIAN("Pediatrician"),
    @XmlEnumValue("Surgeon")
    SURGEON("Surgeon"),
    @XmlEnumValue("Dentist")
    DENTIST("Dentist");
    private final String value;

    Specialization(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static Specialization fromValue(String v) {
        for (Specialization c: Specialization.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
