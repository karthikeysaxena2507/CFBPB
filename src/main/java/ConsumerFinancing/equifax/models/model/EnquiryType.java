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
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * <p>Java class for enquiryType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="enquiryType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="permitted-disclosure" type="{http://www.w3.org/2001/XMLSchema}token" minOccurs="0"/&gt;
 *         &lt;element name="account-type-code" type="{http://www.w3.org/2001/XMLSchema}token" minOccurs="0"/&gt;
 *         &lt;element name="enquiry-amount" type="{http://vedaxml.com/vxml2/vedascore-apply-v2-0.xsd}MoneyType" minOccurs="0"/&gt;
 *         &lt;element name="is-credit-review" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="is-unlimited-credit" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="secured-credit-code" type="{http://www.w3.org/2001/XMLSchema}token" minOccurs="0"/&gt;
 *         &lt;element name="relationship-code" type="{http://www.w3.org/2001/XMLSchema}token" minOccurs="0"/&gt;
 *         &lt;element name="co-borrower" type="{http://www.w3.org/2001/XMLSchema}token" minOccurs="0"/&gt;
 *         &lt;element name="enquiry-client-reference" type="{http://www.w3.org/2001/XMLSchema}token" minOccurs="0"/&gt;
 *         &lt;element name="other-enquiry-attributes" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="enquiry-attribute" type="{http://vedaxml.com/vxml2/vedascore-apply-v2-0.xsd}key-value-pairType" maxOccurs="unbounded"/&gt;
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
@XmlType(name = "enquiryType", propOrder = {
    "permittedDisclosure",
    "accountTypeCode",
    "enquiryAmount",
    "isCreditReview",
    "isUnlimitedCredit",
    "securedCreditCode",
    "relationshipCode",
    "coBorrower",
    "enquiryClientReference",
    "otherEnquiryAttributes"
})
public class EnquiryType {

    @XmlElement(name = "permitted-disclosure")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "token")
    protected String permittedDisclosure;
    @XmlElement(name = "account-type-code")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "token")
    protected String accountTypeCode;
    @XmlElement(name = "enquiry-amount")
    protected MoneyType enquiryAmount;
    @XmlElement(name = "is-credit-review")
    protected Boolean isCreditReview;
    @XmlElement(name = "is-unlimited-credit")
    protected Boolean isUnlimitedCredit;
    @XmlElement(name = "secured-credit-code")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "token")
    protected String securedCreditCode;
    @XmlElement(name = "relationship-code")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "token")
    protected String relationshipCode;
    @XmlElement(name = "co-borrower")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "token")
    protected String coBorrower;
    @XmlElement(name = "enquiry-client-reference")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "token")
    protected String enquiryClientReference;
    @XmlElement(name = "other-enquiry-attributes")
    protected EnquiryType.OtherEnquiryAttributes otherEnquiryAttributes;

    /**
     * Gets the value of the permittedDisclosure property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPermittedDisclosure() {
        return permittedDisclosure;
    }

    /**
     * Sets the value of the permittedDisclosure property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPermittedDisclosure(String value) {
        this.permittedDisclosure = value;
    }

    /**
     * Gets the value of the accountTypeCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAccountTypeCode() {
        return accountTypeCode;
    }

    /**
     * Sets the value of the accountTypeCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAccountTypeCode(String value) {
        this.accountTypeCode = value;
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
     * Gets the value of the isCreditReview property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIsCreditReview() {
        return isCreditReview;
    }

    /**
     * Sets the value of the isCreditReview property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIsCreditReview(Boolean value) {
        this.isCreditReview = value;
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
     * Gets the value of the securedCreditCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSecuredCreditCode() {
        return securedCreditCode;
    }

    /**
     * Sets the value of the securedCreditCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSecuredCreditCode(String value) {
        this.securedCreditCode = value;
    }

    /**
     * Gets the value of the relationshipCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRelationshipCode() {
        return relationshipCode;
    }

    /**
     * Sets the value of the relationshipCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRelationshipCode(String value) {
        this.relationshipCode = value;
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
     * Gets the value of the otherEnquiryAttributes property.
     * 
     * @return
     *     possible object is
     *     {@link EnquiryType.OtherEnquiryAttributes }
     *     
     */
    public EnquiryType.OtherEnquiryAttributes getOtherEnquiryAttributes() {
        return otherEnquiryAttributes;
    }

    /**
     * Sets the value of the otherEnquiryAttributes property.
     * 
     * @param value
     *     allowed object is
     *     {@link EnquiryType.OtherEnquiryAttributes }
     *     
     */
    public void setOtherEnquiryAttributes(EnquiryType.OtherEnquiryAttributes value) {
        this.otherEnquiryAttributes = value;
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
     *         &lt;element name="enquiry-attribute" type="{http://vedaxml.com/vxml2/vedascore-apply-v2-0.xsd}key-value-pairType" maxOccurs="unbounded"/&gt;
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
        "enquiryAttribute"
    })
    public static class OtherEnquiryAttributes {

        @XmlElement(name = "enquiry-attribute", required = true)
        protected List<KeyValuePairType> enquiryAttribute;

        /**
         * Gets the value of the enquiryAttribute property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the enquiryAttribute property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getEnquiryAttribute().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link KeyValuePairType }
         * 
         * 
         */
        public List<KeyValuePairType> getEnquiryAttribute() {
            if (enquiryAttribute == null) {
                enquiryAttribute = new ArrayList<KeyValuePairType>();
            }
            return this.enquiryAttribute;
        }

    }

}
