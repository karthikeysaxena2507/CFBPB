//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.2 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2021.11.24 at 04:23:17 PM IST 
//


package ConsumerFinancing.equifax.models.model;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for product-headerType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="product-headerType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="enquiry-id" type="{http://vedaxml.com/vxml2/vedascore-apply-v2-0.xsd}EnquiryIdSimpleType"/&gt;
 *         &lt;element name="datetime-requested" type="{http://www.w3.org/2001/XMLSchema}dateTime"/&gt;
 *         &lt;element name="datetime-generated" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *         &lt;element name="client-reference" type="{http://www.w3.org/2001/XMLSchema}token" minOccurs="0"/&gt;
 *         &lt;element name="operator-id" type="{http://www.w3.org/2001/XMLSchema}token" minOccurs="0"/&gt;
 *         &lt;element name="operator-name" type="{http://www.w3.org/2001/XMLSchema}token" minOccurs="0"/&gt;
 *         &lt;element name="product-name" type="{http://www.w3.org/2001/XMLSchema}token" minOccurs="0"/&gt;
 *         &lt;element name="permission-type" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;simpleContent&gt;
 *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema&gt;token"&gt;
 *                 &lt;attribute name="code" type="{http://www.w3.org/2001/XMLSchema}token" /&gt;
 *               &lt;/extension&gt;
 *             &lt;/simpleContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="product-data-level" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;simpleContent&gt;
 *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema&gt;token"&gt;
 *                 &lt;attribute name="code" type="{http://www.w3.org/2001/XMLSchema}token" /&gt;
 *               &lt;/extension&gt;
 *             &lt;/simpleContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="product-version" type="{http://www.w3.org/2001/XMLSchema}token" minOccurs="0"/&gt;
 *         &lt;element name="possible-matches" type="{http://vedaxml.com/vxml2/vedascore-apply-v2-0.xsd}possible-matchesType" minOccurs="0"/&gt;
 *         &lt;element name="custom-input-parameters" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="custom-input-parameter" type="{http://vedaxml.com/vxml2/vedascore-apply-v2-0.xsd}key-value-pairType" maxOccurs="unbounded"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="configuration-data-attributes" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="configuration-data-attribute" type="{http://vedaxml.com/vxml2/vedascore-apply-v2-0.xsd}key-value-pairType" maxOccurs="unbounded"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "product-headerType", propOrder = {
    "enquiryId",
    "datetimeRequested",
    "datetimeGenerated",
    "clientReference",
    "operatorId",
    "operatorName",
    "productName",
    "permissionType",
    "productDataLevel",
    "productVersion",
    "possibleMatches",
    "customInputParameters",
    "configurationDataAttributes"
})
public class ProductHeaderType {

    @XmlElement(name = "enquiry-id", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "token")
    protected String enquiryId;
    @XmlElement(name = "datetime-requested", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar datetimeRequested;
    @XmlElement(name = "datetime-generated")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar datetimeGenerated;
    @XmlElement(name = "client-reference")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "token")
    protected String clientReference;
    @XmlElement(name = "operator-id")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "token")
    protected String operatorId;
    @XmlElement(name = "operator-name")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "token")
    protected String operatorName;
    @XmlElement(name = "product-name")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "token")
    protected String productName;
    @XmlElement(name = "permission-type")
    protected ProductHeaderType.PermissionType permissionType;
    @XmlElement(name = "product-data-level")
    protected ProductHeaderType.ProductDataLevel productDataLevel;
    @XmlElement(name = "product-version")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "token")
    protected String productVersion;
    @XmlElement(name = "possible-matches")
    protected PossibleMatchesType possibleMatches;
    @XmlElement(name = "custom-input-parameters")
    protected ProductHeaderType.CustomInputParameters customInputParameters;
    @XmlElement(name = "configuration-data-attributes")
    protected ProductHeaderType.ConfigurationDataAttributes configurationDataAttributes;

    /**
     * Gets the value of the enquiryId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEnquiryId() {
        return enquiryId;
    }

    /**
     * Sets the value of the enquiryId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEnquiryId(String value) {
        this.enquiryId = value;
    }

    /**
     * Gets the value of the datetimeRequested property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDatetimeRequested() {
        return datetimeRequested;
    }

    /**
     * Sets the value of the datetimeRequested property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDatetimeRequested(XMLGregorianCalendar value) {
        this.datetimeRequested = value;
    }

    /**
     * Gets the value of the datetimeGenerated property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDatetimeGenerated() {
        return datetimeGenerated;
    }

    /**
     * Sets the value of the datetimeGenerated property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDatetimeGenerated(XMLGregorianCalendar value) {
        this.datetimeGenerated = value;
    }

    /**
     * Gets the value of the clientReference property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClientReference() {
        return clientReference;
    }

    /**
     * Sets the value of the clientReference property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClientReference(String value) {
        this.clientReference = value;
    }

    /**
     * Gets the value of the operatorId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOperatorId() {
        return operatorId;
    }

    /**
     * Sets the value of the operatorId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOperatorId(String value) {
        this.operatorId = value;
    }

    /**
     * Gets the value of the operatorName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOperatorName() {
        return operatorName;
    }

    /**
     * Sets the value of the operatorName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOperatorName(String value) {
        this.operatorName = value;
    }

    /**
     * Gets the value of the productName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProductName() {
        return productName;
    }

    /**
     * Sets the value of the productName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProductName(String value) {
        this.productName = value;
    }

    /**
     * Gets the value of the permissionType property.
     * 
     * @return
     *     possible object is
     *     {@link ProductHeaderType.PermissionType }
     *     
     */
    public ProductHeaderType.PermissionType getPermissionType() {
        return permissionType;
    }

    /**
     * Sets the value of the permissionType property.
     * 
     * @param value
     *     allowed object is
     *     {@link ProductHeaderType.PermissionType }
     *     
     */
    public void setPermissionType(ProductHeaderType.PermissionType value) {
        this.permissionType = value;
    }

    /**
     * Gets the value of the productDataLevel property.
     * 
     * @return
     *     possible object is
     *     {@link ProductHeaderType.ProductDataLevel }
     *     
     */
    public ProductHeaderType.ProductDataLevel getProductDataLevel() {
        return productDataLevel;
    }

    /**
     * Sets the value of the productDataLevel property.
     * 
     * @param value
     *     allowed object is
     *     {@link ProductHeaderType.ProductDataLevel }
     *     
     */
    public void setProductDataLevel(ProductHeaderType.ProductDataLevel value) {
        this.productDataLevel = value;
    }

    /**
     * Gets the value of the productVersion property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProductVersion() {
        return productVersion;
    }

    /**
     * Sets the value of the productVersion property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProductVersion(String value) {
        this.productVersion = value;
    }

    /**
     * Gets the value of the possibleMatches property.
     * 
     * @return
     *     possible object is
     *     {@link PossibleMatchesType }
     *     
     */
    public PossibleMatchesType getPossibleMatches() {
        return possibleMatches;
    }

    /**
     * Sets the value of the possibleMatches property.
     * 
     * @param value
     *     allowed object is
     *     {@link PossibleMatchesType }
     *     
     */
    public void setPossibleMatches(PossibleMatchesType value) {
        this.possibleMatches = value;
    }

    /**
     * Gets the value of the customInputParameters property.
     * 
     * @return
     *     possible object is
     *     {@link ProductHeaderType.CustomInputParameters }
     *     
     */
    public ProductHeaderType.CustomInputParameters getCustomInputParameters() {
        return customInputParameters;
    }

    /**
     * Sets the value of the customInputParameters property.
     * 
     * @param value
     *     allowed object is
     *     {@link ProductHeaderType.CustomInputParameters }
     *     
     */
    public void setCustomInputParameters(ProductHeaderType.CustomInputParameters value) {
        this.customInputParameters = value;
    }

    /**
     * Gets the value of the configurationDataAttributes property.
     * 
     * @return
     *     possible object is
     *     {@link ProductHeaderType.ConfigurationDataAttributes }
     *     
     */
    public ProductHeaderType.ConfigurationDataAttributes getConfigurationDataAttributes() {
        return configurationDataAttributes;
    }

    /**
     * Sets the value of the configurationDataAttributes property.
     * 
     * @param value
     *     allowed object is
     *     {@link ProductHeaderType.ConfigurationDataAttributes }
     *     
     */
    public void setConfigurationDataAttributes(ProductHeaderType.ConfigurationDataAttributes value) {
        this.configurationDataAttributes = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *       &lt;sequence&gt;
     *         &lt;element name="configuration-data-attribute" type="{http://vedaxml.com/vxml2/vedascore-apply-v2-0.xsd}key-value-pairType" maxOccurs="unbounded"/&gt;
     *       &lt;/sequence&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "configurationDataAttribute"
    })
    public static class ConfigurationDataAttributes {

        @XmlElement(name = "configuration-data-attribute", required = true)
        protected List<KeyValuePairType> configurationDataAttribute;

        /**
         * Gets the value of the configurationDataAttribute property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the configurationDataAttribute property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getConfigurationDataAttribute().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link KeyValuePairType }
         * 
         * 
         */
        public List<KeyValuePairType> getConfigurationDataAttribute() {
            if (configurationDataAttribute == null) {
                configurationDataAttribute = new ArrayList<KeyValuePairType>();
            }
            return this.configurationDataAttribute;
        }

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *       &lt;sequence&gt;
     *         &lt;element name="custom-input-parameter" type="{http://vedaxml.com/vxml2/vedascore-apply-v2-0.xsd}key-value-pairType" maxOccurs="unbounded"/&gt;
     *       &lt;/sequence&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "customInputParameter"
    })
    public static class CustomInputParameters {

        @XmlElement(name = "custom-input-parameter", required = true)
        protected List<KeyValuePairType> customInputParameter;

        /**
         * Gets the value of the customInputParameter property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the customInputParameter property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getCustomInputParameter().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link KeyValuePairType }
         * 
         * 
         */
        public List<KeyValuePairType> getCustomInputParameter() {
            if (customInputParameter == null) {
                customInputParameter = new ArrayList<KeyValuePairType>();
            }
            return this.customInputParameter;
        }

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType&gt;
     *   &lt;simpleContent&gt;
     *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema&gt;token"&gt;
     *       &lt;attribute name="code" type="{http://www.w3.org/2001/XMLSchema}token" /&gt;
     *     &lt;/extension&gt;
     *   &lt;/simpleContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "value"
    })
    public static class PermissionType {

        @XmlValue
        @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
        @XmlSchemaType(name = "token")
        protected String value;
        @XmlAttribute(name = "code")
        @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
        @XmlSchemaType(name = "token")
        protected String code;

        /**
         * Gets the value of the value property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getValue() {
            return value;
        }

        /**
         * Sets the value of the value property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setValue(String value) {
            this.value = value;
        }

        /**
         * Gets the value of the code property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCode() {
            return code;
        }

        /**
         * Sets the value of the code property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCode(String value) {
            this.code = value;
        }

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType&gt;
     *   &lt;simpleContent&gt;
     *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema&gt;token"&gt;
     *       &lt;attribute name="code" type="{http://www.w3.org/2001/XMLSchema}token" /&gt;
     *     &lt;/extension&gt;
     *   &lt;/simpleContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "value"
    })
    public static class ProductDataLevel {

        @XmlValue
        @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
        @XmlSchemaType(name = "token")
        protected String value;
        @XmlAttribute(name = "code")
        @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
        @XmlSchemaType(name = "token")
        protected String code;

        /**
         * Gets the value of the value property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getValue() {
            return value;
        }

        /**
         * Sets the value of the value property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setValue(String value) {
            this.value = value;
        }

        /**
         * Gets the value of the code property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCode() {
            return code;
        }

        /**
         * Sets the value of the code property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCode(String value) {
            this.code = value;
        }

    }

}
