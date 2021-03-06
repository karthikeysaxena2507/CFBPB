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
 * <p>Java class for credit-enquiryType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="credit-enquiryType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="id-references" type="{http://vedaxml.com/vxml2/vedascore-apply-v2-0.xsd}IdReferencesType" minOccurs="0"/&gt;
 *         &lt;element name="account-type" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;simpleContent&gt;
 *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema&gt;token"&gt;
 *                 &lt;attribute name="code" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" /&gt;
 *               &lt;/extension&gt;
 *             &lt;/simpleContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="enquiry-amount" type="{http://vedaxml.com/vxml2/vedascore-apply-v2-0.xsd}MoneyType" minOccurs="0"/&gt;
 *         &lt;element name="is-unlimited-credit" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="secured-credit" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;simpleContent&gt;
 *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema&gt;token"&gt;
 *                 &lt;attribute name="code" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" /&gt;
 *               &lt;/extension&gt;
 *             &lt;/simpleContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="relationship" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;simpleContent&gt;
 *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema&gt;token"&gt;
 *                 &lt;attribute name="code" type="{http://www.w3.org/2001/XMLSchema}token" /&gt;
 *               &lt;/extension&gt;
 *             &lt;/simpleContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="co-borrower" type="{http://www.w3.org/2001/XMLSchema}token" minOccurs="0"/&gt;
 *         &lt;element name="credit-enquirer" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}token" minOccurs="0"/&gt;
 *                   &lt;element name="classification" type="{http://www.w3.org/2001/XMLSchema}token" minOccurs="0"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="enquiry-client-reference" type="{http://www.w3.org/2001/XMLSchema}token" minOccurs="0"/&gt;
 *         &lt;element name="additional-data-fields" type="{http://vedaxml.com/vxml2/vedascore-apply-v2-0.xsd}additional-data-fieldsType" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attGroup ref="{http://vedaxml.com/vxml2/vedascore-apply-v2-0.xsd}disputeGroup"/&gt;
 *       &lt;attribute name="type" type="{http://www.w3.org/2001/XMLSchema}token" /&gt;
 *       &lt;attribute name="enquiry-date" type="{http://www.w3.org/2001/XMLSchema}date" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "credit-enquiryType", propOrder = {
    "idReferences",
    "accountType",
    "enquiryAmount",
    "isUnlimitedCredit",
    "securedCredit",
    "relationship",
    "coBorrower",
    "creditEnquirer",
    "enquiryClientReference",
    "additionalDataFields"
})
public class CreditEnquiryType {

    @XmlElement(name = "id-references")
    protected IdReferencesType idReferences;
    @XmlElement(name = "account-type")
    protected CreditEnquiryType.AccountType accountType;
    @XmlElement(name = "enquiry-amount")
    protected MoneyType enquiryAmount;
    @XmlElement(name = "is-unlimited-credit")
    protected Boolean isUnlimitedCredit;
    @XmlElement(name = "secured-credit")
    protected CreditEnquiryType.SecuredCredit securedCredit;
    protected CreditEnquiryType.Relationship relationship;
    @XmlElement(name = "co-borrower")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "token")
    protected String coBorrower;
    @XmlElement(name = "credit-enquirer")
    protected CreditEnquiryType.CreditEnquirer creditEnquirer;
    @XmlElement(name = "enquiry-client-reference")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "token")
    protected String enquiryClientReference;
    @XmlElement(name = "additional-data-fields")
    protected AdditionalDataFieldsType additionalDataFields;
    @XmlAttribute(name = "type")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "token")
    protected String type;
    @XmlAttribute(name = "enquiry-date")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar enquiryDate;
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
     * Gets the value of the idReferences property.
     * 
     * @return
     *     possible object is
     *     {@link IdReferencesType }
     *     
     */
    public IdReferencesType getIdReferences() {
        return idReferences;
    }

    /**
     * Sets the value of the idReferences property.
     * 
     * @param value
     *     allowed object is
     *     {@link IdReferencesType }
     *     
     */
    public void setIdReferences(IdReferencesType value) {
        this.idReferences = value;
    }

    /**
     * Gets the value of the accountType property.
     * 
     * @return
     *     possible object is
     *     {@link CreditEnquiryType.AccountType }
     *     
     */
    public CreditEnquiryType.AccountType getAccountType() {
        return accountType;
    }

    /**
     * Sets the value of the accountType property.
     * 
     * @param value
     *     allowed object is
     *     {@link CreditEnquiryType.AccountType }
     *     
     */
    public void setAccountType(CreditEnquiryType.AccountType value) {
        this.accountType = value;
    }

    /**
     * Gets the value of the enquiryAmount property.
     * 
     * @return
     *     possible object is
     *     {@link MoneyType }
     *     
     */
    public MoneyType getEnquiryAmount() {
        return enquiryAmount;
    }

    /**
     * Sets the value of the enquiryAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link MoneyType }
     *     
     */
    public void setEnquiryAmount(MoneyType value) {
        this.enquiryAmount = value;
    }

    /**
     * Gets the value of the isUnlimitedCredit property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIsUnlimitedCredit() {
        return isUnlimitedCredit;
    }

    /**
     * Sets the value of the isUnlimitedCredit property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIsUnlimitedCredit(Boolean value) {
        this.isUnlimitedCredit = value;
    }

    /**
     * Gets the value of the securedCredit property.
     * 
     * @return
     *     possible object is
     *     {@link CreditEnquiryType.SecuredCredit }
     *     
     */
    public CreditEnquiryType.SecuredCredit getSecuredCredit() {
        return securedCredit;
    }

    /**
     * Sets the value of the securedCredit property.
     * 
     * @param value
     *     allowed object is
     *     {@link CreditEnquiryType.SecuredCredit }
     *     
     */
    public void setSecuredCredit(CreditEnquiryType.SecuredCredit value) {
        this.securedCredit = value;
    }

    /**
     * Gets the value of the relationship property.
     * 
     * @return
     *     possible object is
     *     {@link CreditEnquiryType.Relationship }
     *     
     */
    public CreditEnquiryType.Relationship getRelationship() {
        return relationship;
    }

    /**
     * Sets the value of the relationship property.
     * 
     * @param value
     *     allowed object is
     *     {@link CreditEnquiryType.Relationship }
     *     
     */
    public void setRelationship(CreditEnquiryType.Relationship value) {
        this.relationship = value;
    }

    /**
     * Gets the value of the coBorrower property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCoBorrower() {
        return coBorrower;
    }

    /**
     * Sets the value of the coBorrower property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCoBorrower(String value) {
        this.coBorrower = value;
    }

    /**
     * Gets the value of the creditEnquirer property.
     * 
     * @return
     *     possible object is
     *     {@link CreditEnquiryType.CreditEnquirer }
     *     
     */
    public CreditEnquiryType.CreditEnquirer getCreditEnquirer() {
        return creditEnquirer;
    }

    /**
     * Sets the value of the creditEnquirer property.
     * 
     * @param value
     *     allowed object is
     *     {@link CreditEnquiryType.CreditEnquirer }
     *     
     */
    public void setCreditEnquirer(CreditEnquiryType.CreditEnquirer value) {
        this.creditEnquirer = value;
    }

    /**
     * Gets the value of the enquiryClientReference property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEnquiryClientReference() {
        return enquiryClientReference;
    }

    /**
     * Sets the value of the enquiryClientReference property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEnquiryClientReference(String value) {
        this.enquiryClientReference = value;
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
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setType(String value) {
        this.type = value;
    }

    /**
     * Gets the value of the enquiryDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getEnquiryDate() {
        return enquiryDate;
    }

    /**
     * Sets the value of the enquiryDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setEnquiryDate(XMLGregorianCalendar value) {
        this.enquiryDate = value;
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
    public static class AccountType {

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
     *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}token" minOccurs="0"/&gt;
     *         &lt;element name="classification" type="{http://www.w3.org/2001/XMLSchema}token" minOccurs="0"/&gt;
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
        "name",
        "classification"
    })
    public static class CreditEnquirer {

        @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
        @XmlSchemaType(name = "token")
        protected String name;
        @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
        @XmlSchemaType(name = "token")
        protected String classification;

        /**
         * Gets the value of the name property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getName() {
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
        public void setName(String value) {
            this.name = value;
        }

        /**
         * Gets the value of the classification property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getClassification() {
            return classification;
        }

        /**
         * Sets the value of the classification property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setClassification(String value) {
            this.classification = value;
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
    public static class Relationship {

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
    public static class SecuredCredit {

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
