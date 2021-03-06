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
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * <p>Java class for scoreType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="scoreType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="scorecard" type="{http://vedaxml.com/vxml2/vedascore-apply-v2-0.xsd}scorecardType"/&gt;
 *         &lt;element name="risk-odds" type="{http://www.w3.org/2001/XMLSchema}token" minOccurs="0"/&gt;
 *         &lt;element name="key-contributing-factors" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="contributing-factor" type="{http://vedaxml.com/vxml2/vedascore-apply-v2-0.xsd}contributing-factorType" maxOccurs="unbounded"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="score-masterscale" type="{http://www.w3.org/2001/XMLSchema}token"/&gt;
 *         &lt;element name="additional-fields" type="{http://vedaxml.com/vxml2/vedascore-apply-v2-0.xsd}additional-data-fieldsType" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="is-gated" type="{http://www.w3.org/2001/XMLSchema}boolean" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "scoreType", propOrder = {
    "scorecard",
    "riskOdds",
    "keyContributingFactors",
    "scoreMasterscale",
    "additionalFields"
})
public class ScoreType {

    @XmlElement(required = true)
    protected ScorecardType scorecard;
    @XmlElement(name = "risk-odds")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "token")
    protected String riskOdds;
    @XmlElement(name = "key-contributing-factors")
    protected ScoreType.KeyContributingFactors keyContributingFactors;
    @XmlElement(name = "score-masterscale", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "token")
    protected String scoreMasterscale;
    @XmlElement(name = "additional-fields")
    protected AdditionalDataFieldsType additionalFields;
    @XmlAttribute(name = "is-gated")
    protected Boolean isGated;

    /**
     * Gets the value of the scorecard property.
     * 
     * @return
     *     possible object is
     *     {@link ScorecardType }
     *     
     */
    public ScorecardType getScorecard() {
        return scorecard;
    }

    /**
     * Sets the value of the scorecard property.
     * 
     * @param value
     *     allowed object is
     *     {@link ScorecardType }
     *     
     */
    public void setScorecard(ScorecardType value) {
        this.scorecard = value;
    }

    /**
     * Gets the value of the riskOdds property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRiskOdds() {
        return riskOdds;
    }

    /**
     * Sets the value of the riskOdds property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRiskOdds(String value) {
        this.riskOdds = value;
    }

    /**
     * Gets the value of the keyContributingFactors property.
     * 
     * @return
     *     possible object is
     *     {@link ScoreType.KeyContributingFactors }
     *     
     */
    public ScoreType.KeyContributingFactors getKeyContributingFactors() {
        return keyContributingFactors;
    }

    /**
     * Sets the value of the keyContributingFactors property.
     * 
     * @param value
     *     allowed object is
     *     {@link ScoreType.KeyContributingFactors }
     *     
     */
    public void setKeyContributingFactors(ScoreType.KeyContributingFactors value) {
        this.keyContributingFactors = value;
    }

    /**
     * Gets the value of the scoreMasterscale property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getScoreMasterscale() {
        return scoreMasterscale;
    }

    /**
     * Sets the value of the scoreMasterscale property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setScoreMasterscale(String value) {
        this.scoreMasterscale = value;
    }

    /**
     * Gets the value of the additionalFields property.
     * 
     * @return
     *     possible object is
     *     {@link AdditionalDataFieldsType }
     *     
     */
    public AdditionalDataFieldsType getAdditionalFields() {
        return additionalFields;
    }

    /**
     * Sets the value of the additionalFields property.
     * 
     * @param value
     *     allowed object is
     *     {@link AdditionalDataFieldsType }
     *     
     */
    public void setAdditionalFields(AdditionalDataFieldsType value) {
        this.additionalFields = value;
    }

    /**
     * Gets the value of the isGated property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIsGated() {
        return isGated;
    }

    /**
     * Sets the value of the isGated property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIsGated(Boolean value) {
        this.isGated = value;
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
     *         &lt;element name="contributing-factor" type="{http://vedaxml.com/vxml2/vedascore-apply-v2-0.xsd}contributing-factorType" maxOccurs="unbounded"/&gt;
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
        "contributingFactor"
    })
    public static class KeyContributingFactors {

        @XmlElement(name = "contributing-factor", required = true)
        protected List<ContributingFactorType> contributingFactor;

        /**
         * Gets the value of the contributingFactor property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the contributingFactor property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getContributingFactor().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link ContributingFactorType }
         * 
         * 
         */
        public List<ContributingFactorType> getContributingFactor() {
            if (contributingFactor == null) {
                contributingFactor = new ArrayList<ContributingFactorType>();
            }
            return this.contributingFactor;
        }

    }

}
