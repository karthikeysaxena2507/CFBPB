//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.2 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2021.11.24 at 04:23:17 PM IST 
//


package ConsumerFinancing.equifax.models.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * ComplexType for address details
 * 
 * <p>Java class for address-inputType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="address-inputType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;choice&gt;
 *         &lt;sequence&gt;
 *           &lt;element name="property" type="{http://www.w3.org/2001/XMLSchema}token" minOccurs="0"/&gt;
 *           &lt;element name="unit-number" type="{http://www.w3.org/2001/XMLSchema}token" minOccurs="0"/&gt;
 *           &lt;element name="street-number" type="{http://www.w3.org/2001/XMLSchema}token" minOccurs="0"/&gt;
 *           &lt;element name="street-name" type="{http://www.w3.org/2001/XMLSchema}token" minOccurs="0"/&gt;
 *           &lt;element name="street-type" type="{http://www.w3.org/2001/XMLSchema}token" minOccurs="0"/&gt;
 *           &lt;element name="suburb" type="{http://www.w3.org/2001/XMLSchema}token"/&gt;
 *           &lt;element name="state" type="{http://vedaxml.com/vxml2/vedascore-apply-v2-0.xsd}stateType"/&gt;
 *           &lt;element name="postcode" type="{http://www.w3.org/2001/XMLSchema}token" minOccurs="0"/&gt;
 *           &lt;element name="DPID" type="{http://www.w3.org/2001/XMLSchema}token" minOccurs="0"/&gt;
 *           &lt;element name="country-code" type="{http://vedaxml.com/vxml2/vedascore-apply-v2-0.xsd}countryType" minOccurs="0"/&gt;
 *         &lt;/sequence&gt;
 *         &lt;element name="unformatted-address" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;maxLength value="200"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *       &lt;/choice&gt;
 *       &lt;attribute name="type" type="{http://vedaxml.com/vxml2/vedascore-apply-v2-0.xsd}currentPreviousType" /&gt;
 *       &lt;attribute name="time-at-address" type="{http://www.w3.org/2001/XMLSchema}token" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "address-inputType", propOrder = {
    "property",
    "unitNumber",
    "streetNumber",
    "streetName",
    "streetType",
    "suburb",
    "state",
    "postcode",
    "dpid",
    "countryCode",
    "unformattedAddress"
})
public class AddressInputType {

    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "token")
    protected String property;
    @XmlElement(name = "unit-number")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "token")
    protected String unitNumber;
    @XmlElement(name = "street-number")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "token")
    protected String streetNumber;
    @XmlElement(name = "street-name")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "token")
    protected String streetName;
    @XmlElement(name = "street-type")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "token")
    protected String streetType;
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "token")
    protected String suburb;
    protected StateType state;
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "token")
    protected String postcode;
    @XmlElement(name = "DPID")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "token")
    protected String dpid;
    @XmlElement(name = "country-code")
    protected CountryType countryCode;
    @XmlElement(name = "unformatted-address")
    protected String unformattedAddress;
    @XmlAttribute(name = "type")
    protected CurrentPreviousType type;
    @XmlAttribute(name = "time-at-address")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "token")
    protected String timeAtAddress;

    /**
     * Gets the value of the property property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProperty() {
        return property;
    }

    /**
     * Sets the value of the property property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProperty(String value) {
        this.property = value;
    }

    /**
     * Gets the value of the unitNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUnitNumber() {
        return unitNumber;
    }

    /**
     * Sets the value of the unitNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUnitNumber(String value) {
        this.unitNumber = value;
    }

    /**
     * Gets the value of the streetNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStreetNumber() {
        return streetNumber;
    }

    /**
     * Sets the value of the streetNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStreetNumber(String value) {
        this.streetNumber = value;
    }

    /**
     * Gets the value of the streetName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStreetName() {
        return streetName;
    }

    /**
     * Sets the value of the streetName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStreetName(String value) {
        this.streetName = value;
    }

    /**
     * Gets the value of the streetType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStreetType() {
        return streetType;
    }

    /**
     * Sets the value of the streetType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStreetType(String value) {
        this.streetType = value;
    }

    /**
     * Gets the value of the suburb property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSuburb() {
        return suburb;
    }

    /**
     * Sets the value of the suburb property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSuburb(String value) {
        this.suburb = value;
    }

    /**
     * Gets the value of the state property.
     * 
     * @return
     *     possible object is
     *     {@link StateType }
     *     
     */
    public StateType getState() {
        return state;
    }

    /**
     * Sets the value of the state property.
     * 
     * @param value
     *     allowed object is
     *     {@link StateType }
     *     
     */
    public void setState(StateType value) {
        this.state = value;
    }

    /**
     * Gets the value of the postcode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPostcode() {
        return postcode;
    }

    /**
     * Sets the value of the postcode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPostcode(String value) {
        this.postcode = value;
    }

    /**
     * Gets the value of the dpid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDPID() {
        return dpid;
    }

    /**
     * Sets the value of the dpid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDPID(String value) {
        this.dpid = value;
    }

    /**
     * Gets the value of the countryCode property.
     * 
     * @return
     *     possible object is
     *     {@link CountryType }
     *     
     */
    public CountryType getCountryCode() {
        return countryCode;
    }

    /**
     * Sets the value of the countryCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link CountryType }
     *     
     */
    public void setCountryCode(CountryType value) {
        this.countryCode = value;
    }

    /**
     * Gets the value of the unformattedAddress property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUnformattedAddress() {
        return unformattedAddress;
    }

    /**
     * Sets the value of the unformattedAddress property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUnformattedAddress(String value) {
        this.unformattedAddress = value;
    }

    /**
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link CurrentPreviousType }
     *     
     */
    public CurrentPreviousType getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link CurrentPreviousType }
     *     
     */
    public void setType(CurrentPreviousType value) {
        this.type = value;
    }

    /**
     * Gets the value of the timeAtAddress property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTimeAtAddress() {
        return timeAtAddress;
    }

    /**
     * Sets the value of the timeAtAddress property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTimeAtAddress(String value) {
        this.timeAtAddress = value;
    }

}
