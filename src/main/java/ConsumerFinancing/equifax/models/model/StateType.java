//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.2 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2021.11.24 at 04:23:17 PM IST 
//


package ConsumerFinancing.equifax.models.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;


/**
 * Enumerated complexType for Australian states
 * 
 * <p>Java class for stateType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="stateType"&gt;
 *   &lt;simpleContent&gt;
 *     &lt;extension base="&lt;http://vedaxml.com/vxml2/vedascore-apply-v2-0.xsd&gt;AustralianStateType"&gt;
 *     &lt;/extension&gt;
 *   &lt;/simpleContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "stateType", propOrder = {
    "value"
})
public class StateType {

    @XmlValue
    protected AustralianStateType value;

    public StateType() {

    }

    public StateType(AustralianStateType value) {
        this.value = value;
    }

    /**
     * Enumeration of Australian states
     * 
     * @return
     *     possible object is
     *     {@link AustralianStateType }
     *     
     */
    public AustralianStateType getValue() {
        return value;
    }

    /**
     * Sets the value of the value property.
     * 
     * @param value
     *     allowed object is
     *     {@link AustralianStateType }
     *     
     */
    public void setValue(AustralianStateType value) {
        this.value = value;
    }

}
