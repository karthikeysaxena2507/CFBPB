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
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for directorshipType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="directorshipType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="id-references" type="{http://vedaxml.com/vxml2/vedascore-apply-v2-0.xsd}IdReferencesType" minOccurs="0"/&gt;
 *         &lt;element name="date-appointed" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/&gt;
 *         &lt;element name="date-ceased" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/&gt;
 *         &lt;element name="date-last-known-as-director" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/&gt;
 *         &lt;element name="organisation" type="{http://vedaxml.com/vxml2/vedascore-apply-v2-0.xsd}organisationType" minOccurs="0"/&gt;
 *         &lt;element name="additional-data-fields" type="{http://vedaxml.com/vxml2/vedascore-apply-v2-0.xsd}additional-data-fieldsType" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attGroup ref="{http://vedaxml.com/vxml2/vedascore-apply-v2-0.xsd}disputeGroup"/&gt;
 *       &lt;attGroup ref="{http://vedaxml.com/vxml2/vedascore-apply-v2-0.xsd}asic-datesGroup"/&gt;
 *       &lt;attribute name="type" type="{http://vedaxml.com/vxml2/vedascore-apply-v2-0.xsd}currentPreviousType" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "directorshipType", propOrder = {
    "idReferences",
    "dateAppointed",
    "dateCeased",
    "dateLastKnownAsDirector",
    "organisation",
    "additionalDataFields"
})
public class DirectorshipType {

    @XmlElement(name = "id-references")
    protected IdReferencesType idReferences;
    @XmlElement(name = "date-appointed")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar dateAppointed;
    @XmlElement(name = "date-ceased")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar dateCeased;
    @XmlElement(name = "date-last-known-as-director")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar dateLastKnownAsDirector;
    protected OrganisationType organisation;
    @XmlElement(name = "additional-data-fields")
    protected AdditionalDataFieldsType additionalDataFields;
    @XmlAttribute(name = "type")
    protected CurrentPreviousType type;
    @XmlAttribute(name = "is-disputed")
    protected Boolean isDisputed;
    @XmlAttribute(name = "dispute-reported-date")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar disputeReportedDate;
    @XmlAttribute(name = "dispute-code")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "token")
    protected String disputeCode;
    @XmlAttribute(name = "last-extract-date")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar lastExtractDate;
    @XmlAttribute(name = "last-extract-time")
    @XmlSchemaType(name = "time")
    protected XMLGregorianCalendar lastExtractTime;
    @XmlAttribute(name = "last-update-date")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar lastUpdateDate;
    @XmlAttribute(name = "last-update-time")
    @XmlSchemaType(name = "time")
    protected XMLGregorianCalendar lastUpdateTime;

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
     * Gets the value of the dateAppointed property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDateAppointed() {
        return dateAppointed;
    }

    /**
     * Sets the value of the dateAppointed property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDateAppointed(XMLGregorianCalendar value) {
        this.dateAppointed = value;
    }

    /**
     * Gets the value of the dateCeased property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDateCeased() {
        return dateCeased;
    }

    /**
     * Sets the value of the dateCeased property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDateCeased(XMLGregorianCalendar value) {
        this.dateCeased = value;
    }

    /**
     * Gets the value of the dateLastKnownAsDirector property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDateLastKnownAsDirector() {
        return dateLastKnownAsDirector;
    }

    /**
     * Sets the value of the dateLastKnownAsDirector property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDateLastKnownAsDirector(XMLGregorianCalendar value) {
        this.dateLastKnownAsDirector = value;
    }

    /**
     * Gets the value of the organisation property.
     * 
     * @return
     *     possible object is
     *     {@link OrganisationType }
     *     
     */
    public OrganisationType getOrganisation() {
        return organisation;
    }

    /**
     * Sets the value of the organisation property.
     * 
     * @param value
     *     allowed object is
     *     {@link OrganisationType }
     *     
     */
    public void setOrganisation(OrganisationType value) {
        this.organisation = value;
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
     * Gets the value of the lastExtractDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getLastExtractDate() {
        return lastExtractDate;
    }

    /**
     * Sets the value of the lastExtractDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setLastExtractDate(XMLGregorianCalendar value) {
        this.lastExtractDate = value;
    }

    /**
     * Gets the value of the lastExtractTime property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getLastExtractTime() {
        return lastExtractTime;
    }

    /**
     * Sets the value of the lastExtractTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setLastExtractTime(XMLGregorianCalendar value) {
        this.lastExtractTime = value;
    }

    /**
     * Gets the value of the lastUpdateDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getLastUpdateDate() {
        return lastUpdateDate;
    }

    /**
     * Sets the value of the lastUpdateDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setLastUpdateDate(XMLGregorianCalendar value) {
        this.lastUpdateDate = value;
    }

    /**
     * Gets the value of the lastUpdateTime property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getLastUpdateTime() {
        return lastUpdateTime;
    }

    /**
     * Sets the value of the lastUpdateTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setLastUpdateTime(XMLGregorianCalendar value) {
        this.lastUpdateTime = value;
    }

}