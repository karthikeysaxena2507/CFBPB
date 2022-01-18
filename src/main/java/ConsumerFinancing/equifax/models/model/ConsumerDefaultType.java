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
import javax.xml.bind.annotation.XmlValue;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for consumer-defaultType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="consumer-defaultType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="status" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;simpleContent&gt;
 *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema&gt;token"&gt;
 *                 &lt;attribute name="code" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" /&gt;
 *               &lt;/extension&gt;
 *             &lt;/simpleContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="status-date" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/&gt;
 *         &lt;element name="is-accelerated-debt" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="original-default" type="{http://vedaxml.com/vxml2/vedascore-apply-v2-0.xsd}consumer-default-recordType" minOccurs="0"/&gt;
 *         &lt;element name="current-default" type="{http://vedaxml.com/vxml2/vedascore-apply-v2-0.xsd}consumer-default-recordType" minOccurs="0"/&gt;
 *         &lt;element name="additional-data-fields" type="{http://vedaxml.com/vxml2/vedascore-apply-v2-0.xsd}additional-data-fieldsType" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attGroup ref="{http://vedaxml.com/vxml2/vedascore-apply-v2-0.xsd}disputeGroup"/&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "consumer-defaultType", propOrder = {
    "status",
    "statusDate",
    "isAcceleratedDebt",
    "originalDefault",
    "currentDefault",
    "additionalDataFields"
})
public class ConsumerDefaultType {

    protected ConsumerDefaultType.Status status;
    @XmlElement(name = "status-date")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar statusDate;
    @XmlElement(name = "is-accelerated-debt")
    protected Boolean isAcceleratedDebt;
    @XmlElement(name = "original-default")
    protected ConsumerDefaultRecordType originalDefault;
    @XmlElement(name = "current-default")
    protected ConsumerDefaultRecordType currentDefault;
    @XmlElement(name = "additional-data-fields")
    protected AdditionalDataFieldsType additionalDataFields;
    @XmlAttribute(name = "is-disputed")
    protected Boolean isDisputed;
    @XmlAttribute(name = "dispute-reported-date")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar disputeReportedDate;
    @XmlAttribute(name = "dispute-code")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "token")
    protected String disputeCode;

    /**
     * Gets the value of the status property.
     * 
     * @return
     *     possible object is
     *     {@link ConsumerDefaultType.Status }
     *     
     */
    public ConsumerDefaultType.Status getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     * 
     * @param value
     *     allowed object is
     *     {@link ConsumerDefaultType.Status }
     *     
     */
    public void setStatus(ConsumerDefaultType.Status value) {
        this.status = value;
    }

    /**
     * Gets the value of the statusDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getStatusDate() {
        return statusDate;
    }

    /**
     * Sets the value of the statusDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setStatusDate(XMLGregorianCalendar value) {
        this.statusDate = value;
    }

    /**
     * Gets the value of the isAcceleratedDebt property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIsAcceleratedDebt() {
        return isAcceleratedDebt;
    }

    /**
     * Sets the value of the isAcceleratedDebt property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIsAcceleratedDebt(Boolean value) {
        this.isAcceleratedDebt = value;
    }

    /**
     * Gets the value of the originalDefault property.
     * 
     * @return
     *     possible object is
     *     {@link ConsumerDefaultRecordType }
     *     
     */
    public ConsumerDefaultRecordType getOriginalDefault() {
        return originalDefault;
    }

    /**
     * Sets the value of the originalDefault property.
     * 
     * @param value
     *     allowed object is
     *     {@link ConsumerDefaultRecordType }
     *     
     */
    public void setOriginalDefault(ConsumerDefaultRecordType value) {
        this.originalDefault = value;
    }

    /**
     * Gets the value of the currentDefault property.
     * 
     * @return
     *     possible object is
     *     {@link ConsumerDefaultRecordType }
     *     
     */
    public ConsumerDefaultRecordType getCurrentDefault() {
        return currentDefault;
    }

    /**
     * Sets the value of the currentDefault property.
     * 
     * @param value
     *     allowed object is
     *     {@link ConsumerDefaultRecordType }
     *     
     */
    public void setCurrentDefault(ConsumerDefaultRecordType value) {
        this.currentDefault = value;
    }

    /**
     * Gets the value of the additionalDataFields property.
     * 
     * @return
     *     possible object is
     *     {@link AdditionalDataFieldsType }
     *     
     */
    public AdditionalDataFieldsType getAdditionalDataFields() {
        return additionalDataFields;
    }

    /**
     * Sets the value of the additionalDataFields property.
     * 
     * @param value
     *     allowed object is
     *     {@link AdditionalDataFieldsType }
     *     
     */
    public void setAdditionalDataFields(AdditionalDataFieldsType value) {
        this.additionalDataFields = value;
    }

    /**
     * Gets the value of the isDisputed property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIsDisputed() {
        return isDisputed;
    }

    /**
     * Sets the value of the isDisputed property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIsDisputed(Boolean value) {
        this.isDisputed = value;
    }

    /**
     * Gets the value of the disputeReportedDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDisputeReportedDate() {
        return disputeReportedDate;
    }

    /**
     * Sets the value of the disputeReportedDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDisputeReportedDate(XMLGregorianCalendar value) {
        this.disputeReportedDate = value;
    }

    /**
     * Gets the value of the disputeCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDisputeCode() {
        return disputeCode;
    }

    /**
     * Sets the value of the disputeCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDisputeCode(String value) {
        this.disputeCode = value;
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
     *       &lt;attribute name="code" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" /&gt;
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
    public static class Status {

        @XmlValue
        @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
        @XmlSchemaType(name = "token")
        protected String value;
        @XmlAttribute(name = "code")
        @XmlSchemaType(name = "anySimpleType")
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
