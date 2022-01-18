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
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for public-record-or-consumer-credit-informationType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="public-record-or-consumer-credit-informationType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="court-actions" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="court-action" type="{http://vedaxml.com/vxml2/vedascore-apply-v2-0.xsd}court-actionType" maxOccurs="unbounded"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="disqualified-directorships" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="disqualified-directorship" type="{http://vedaxml.com/vxml2/vedascore-apply-v2-0.xsd}disqualified-directorshipType" maxOccurs="unbounded"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="directorships" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="directorship" type="{http://vedaxml.com/vxml2/vedascore-apply-v2-0.xsd}directorshipType" maxOccurs="unbounded"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="business-names" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="business-name" type="{http://vedaxml.com/vxml2/vedascore-apply-v2-0.xsd}business-nameType" maxOccurs="unbounded"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="personal-insolvencies" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="personal-insolvency" type="{http://vedaxml.com/vxml2/vedascore-apply-v2-0.xsd}personal-insolvencyType" maxOccurs="unbounded"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="sole-trader" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="sole-trader-registration" type="{http://vedaxml.com/vxml2/vedascore-apply-v2-0.xsd}sole-trader-registrationType" maxOccurs="unbounded"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="messages" type="{http://vedaxml.com/vxml2/vedascore-apply-v2-0.xsd}messagesType" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "public-record-or-consumer-credit-informationType", propOrder = {
    "courtActions",
    "disqualifiedDirectorships",
    "directorships",
    "businessNames",
    "personalInsolvencies",
    "soleTrader",
    "messages"
})
public class PublicRecordOrConsumerCreditInformationType {

    @XmlElement(name = "court-actions")
    protected PublicRecordOrConsumerCreditInformationType.CourtActions courtActions;
    @XmlElement(name = "disqualified-directorships")
    protected PublicRecordOrConsumerCreditInformationType.DisqualifiedDirectorships disqualifiedDirectorships;
    protected PublicRecordOrConsumerCreditInformationType.Directorships directorships;
    @XmlElement(name = "business-names")
    protected PublicRecordOrConsumerCreditInformationType.BusinessNames businessNames;
    @XmlElement(name = "personal-insolvencies")
    protected PublicRecordOrConsumerCreditInformationType.PersonalInsolvencies personalInsolvencies;
    @XmlElement(name = "sole-trader")
    protected PublicRecordOrConsumerCreditInformationType.SoleTrader soleTrader;
    protected MessagesType messages;

    /**
     * Gets the value of the courtActions property.
     * 
     * @return
     *     possible object is
     *     {@link PublicRecordOrConsumerCreditInformationType.CourtActions }
     *     
     */
    public PublicRecordOrConsumerCreditInformationType.CourtActions getCourtActions() {
        return courtActions;
    }

    /**
     * Sets the value of the courtActions property.
     * 
     * @param value
     *     allowed object is
     *     {@link PublicRecordOrConsumerCreditInformationType.CourtActions }
     *     
     */
    public void setCourtActions(PublicRecordOrConsumerCreditInformationType.CourtActions value) {
        this.courtActions = value;
    }

    /**
     * Gets the value of the disqualifiedDirectorships property.
     * 
     * @return
     *     possible object is
     *     {@link PublicRecordOrConsumerCreditInformationType.DisqualifiedDirectorships }
     *     
     */
    public PublicRecordOrConsumerCreditInformationType.DisqualifiedDirectorships getDisqualifiedDirectorships() {
        return disqualifiedDirectorships;
    }

    /**
     * Sets the value of the disqualifiedDirectorships property.
     * 
     * @param value
     *     allowed object is
     *     {@link PublicRecordOrConsumerCreditInformationType.DisqualifiedDirectorships }
     *     
     */
    public void setDisqualifiedDirectorships(PublicRecordOrConsumerCreditInformationType.DisqualifiedDirectorships value) {
        this.disqualifiedDirectorships = value;
    }

    /**
     * Gets the value of the directorships property.
     * 
     * @return
     *     possible object is
     *     {@link PublicRecordOrConsumerCreditInformationType.Directorships }
     *     
     */
    public PublicRecordOrConsumerCreditInformationType.Directorships getDirectorships() {
        return directorships;
    }

    /**
     * Sets the value of the directorships property.
     * 
     * @param value
     *     allowed object is
     *     {@link PublicRecordOrConsumerCreditInformationType.Directorships }
     *     
     */
    public void setDirectorships(PublicRecordOrConsumerCreditInformationType.Directorships value) {
        this.directorships = value;
    }

    /**
     * Gets the value of the businessNames property.
     * 
     * @return
     *     possible object is
     *     {@link PublicRecordOrConsumerCreditInformationType.BusinessNames }
     *     
     */
    public PublicRecordOrConsumerCreditInformationType.BusinessNames getBusinessNames() {
        return businessNames;
    }

    /**
     * Sets the value of the businessNames property.
     * 
     * @param value
     *     allowed object is
     *     {@link PublicRecordOrConsumerCreditInformationType.BusinessNames }
     *     
     */
    public void setBusinessNames(PublicRecordOrConsumerCreditInformationType.BusinessNames value) {
        this.businessNames = value;
    }

    /**
     * Gets the value of the personalInsolvencies property.
     * 
     * @return
     *     possible object is
     *     {@link PublicRecordOrConsumerCreditInformationType.PersonalInsolvencies }
     *     
     */
    public PublicRecordOrConsumerCreditInformationType.PersonalInsolvencies getPersonalInsolvencies() {
        return personalInsolvencies;
    }

    /**
     * Sets the value of the personalInsolvencies property.
     * 
     * @param value
     *     allowed object is
     *     {@link PublicRecordOrConsumerCreditInformationType.PersonalInsolvencies }
     *     
     */
    public void setPersonalInsolvencies(PublicRecordOrConsumerCreditInformationType.PersonalInsolvencies value) {
        this.personalInsolvencies = value;
    }

    /**
     * Gets the value of the soleTrader property.
     * 
     * @return
     *     possible object is
     *     {@link PublicRecordOrConsumerCreditInformationType.SoleTrader }
     *     
     */
    public PublicRecordOrConsumerCreditInformationType.SoleTrader getSoleTrader() {
        return soleTrader;
    }

    /**
     * Sets the value of the soleTrader property.
     * 
     * @param value
     *     allowed object is
     *     {@link PublicRecordOrConsumerCreditInformationType.SoleTrader }
     *     
     */
    public void setSoleTrader(PublicRecordOrConsumerCreditInformationType.SoleTrader value) {
        this.soleTrader = value;
    }

    /**
     * Gets the value of the messages property.
     * 
     * @return
     *     possible object is
     *     {@link MessagesType }
     *     
     */
    public MessagesType getMessages() {
        return messages;
    }

    /**
     * Sets the value of the messages property.
     * 
     * @param value
     *     allowed object is
     *     {@link MessagesType }
     *     
     */
    public void setMessages(MessagesType value) {
        this.messages = value;
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
     *         &lt;element name="business-name" type="{http://vedaxml.com/vxml2/vedascore-apply-v2-0.xsd}business-nameType" maxOccurs="unbounded"/&gt;
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
        "businessName"
    })
    public static class BusinessNames {

        @XmlElement(name = "business-name", required = true)
        protected List<BusinessNameType> businessName;

        /**
         * Gets the value of the businessName property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the businessName property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getBusinessName().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link BusinessNameType }
         * 
         * 
         */
        public List<BusinessNameType> getBusinessName() {
            if (businessName == null) {
                businessName = new ArrayList<BusinessNameType>();
            }
            return this.businessName;
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
     *         &lt;element name="court-action" type="{http://vedaxml.com/vxml2/vedascore-apply-v2-0.xsd}court-actionType" maxOccurs="unbounded"/&gt;
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
        "courtAction"
    })
    public static class CourtActions {

        @XmlElement(name = "court-action", required = true)
        protected List<CourtActionType> courtAction;

        /**
         * Gets the value of the courtAction property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the courtAction property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getCourtAction().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link CourtActionType }
         * 
         * 
         */
        public List<CourtActionType> getCourtAction() {
            if (courtAction == null) {
                courtAction = new ArrayList<CourtActionType>();
            }
            return this.courtAction;
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
     *         &lt;element name="directorship" type="{http://vedaxml.com/vxml2/vedascore-apply-v2-0.xsd}directorshipType" maxOccurs="unbounded"/&gt;
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
        "directorship"
    })
    public static class Directorships {

        @XmlElement(required = true)
        protected List<DirectorshipType> directorship;

        /**
         * Gets the value of the directorship property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the directorship property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getDirectorship().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link DirectorshipType }
         * 
         * 
         */
        public List<DirectorshipType> getDirectorship() {
            if (directorship == null) {
                directorship = new ArrayList<DirectorshipType>();
            }
            return this.directorship;
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
     *         &lt;element name="disqualified-directorship" type="{http://vedaxml.com/vxml2/vedascore-apply-v2-0.xsd}disqualified-directorshipType" maxOccurs="unbounded"/&gt;
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
        "disqualifiedDirectorship"
    })
    public static class DisqualifiedDirectorships {

        @XmlElement(name = "disqualified-directorship", required = true)
        protected List<DisqualifiedDirectorshipType> disqualifiedDirectorship;

        /**
         * Gets the value of the disqualifiedDirectorship property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the disqualifiedDirectorship property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getDisqualifiedDirectorship().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link DisqualifiedDirectorshipType }
         * 
         * 
         */
        public List<DisqualifiedDirectorshipType> getDisqualifiedDirectorship() {
            if (disqualifiedDirectorship == null) {
                disqualifiedDirectorship = new ArrayList<DisqualifiedDirectorshipType>();
            }
            return this.disqualifiedDirectorship;
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
     *         &lt;element name="personal-insolvency" type="{http://vedaxml.com/vxml2/vedascore-apply-v2-0.xsd}personal-insolvencyType" maxOccurs="unbounded"/&gt;
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
        "personalInsolvency"
    })
    public static class PersonalInsolvencies {

        @XmlElement(name = "personal-insolvency", required = true)
        protected List<PersonalInsolvencyType> personalInsolvency;

        /**
         * Gets the value of the personalInsolvency property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the personalInsolvency property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getPersonalInsolvency().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link PersonalInsolvencyType }
         * 
         * 
         */
        public List<PersonalInsolvencyType> getPersonalInsolvency() {
            if (personalInsolvency == null) {
                personalInsolvency = new ArrayList<PersonalInsolvencyType>();
            }
            return this.personalInsolvency;
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
     *         &lt;element name="sole-trader-registration" type="{http://vedaxml.com/vxml2/vedascore-apply-v2-0.xsd}sole-trader-registrationType" maxOccurs="unbounded"/&gt;
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
        "soleTraderRegistration"
    })
    public static class SoleTrader {

        @XmlElement(name = "sole-trader-registration", required = true)
        protected List<SoleTraderRegistrationType> soleTraderRegistration;

        /**
         * Gets the value of the soleTraderRegistration property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the soleTraderRegistration property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getSoleTraderRegistration().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link SoleTraderRegistrationType }
         * 
         * 
         */
        public List<SoleTraderRegistrationType> getSoleTraderRegistration() {
            if (soleTraderRegistration == null) {
                soleTraderRegistration = new ArrayList<SoleTraderRegistrationType>();
            }
            return this.soleTraderRegistration;
        }

    }

}