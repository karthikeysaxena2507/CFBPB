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
 * ComplexType for the elements of an individual's full name
 * 
 * <p>Java class for individual-name-inputType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="individual-name-inputType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="title" type="{http://www.w3.org/2001/XMLSchema}token" minOccurs="0"/&gt;
 *         &lt;element name="family-name"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://vedaxml.com/vxml2/vedascore-apply-v2-0.xsd}family-nameType"&gt;
 *               &lt;minLength value="1"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="first-given-name"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://vedaxml.com/vxml2/vedascore-apply-v2-0.xsd}first-given-nameType"&gt;
 *               &lt;minLength value="1"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="other-given-name" maxOccurs="unbounded" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://vedaxml.com/vxml2/vedascore-apply-v2-0.xsd}other-given-nameType"&gt;
 *               &lt;minLength value="1"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
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
@XmlType(name = "individual-name-inputType", propOrder = {
    "title",
    "familyName",
    "firstGivenName",
    "otherGivenName"
})
public class IndividualNameInputType {

    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "token")
    protected String title;
    @XmlElement(name = "family-name", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String familyName;
    @XmlElement(name = "first-given-name", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String firstGivenName;
    @XmlElement(name = "other-given-name")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected List<String> otherGivenName;

    /**
     * Gets the value of the title property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the value of the title property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTitle(String value) {
        this.title = value;
    }

    /**
     * Gets the value of the familyName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFamilyName() {
        return familyName;
    }

    /**
     * Sets the value of the familyName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFamilyName(String value) {
        this.familyName = value;
    }

    /**
     * Gets the value of the firstGivenName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFirstGivenName() {
        return firstGivenName;
    }

    /**
     * Sets the value of the firstGivenName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFirstGivenName(String value) {
        this.firstGivenName = value;
    }

    /**
     * Gets the value of the otherGivenName property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the otherGivenName property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOtherGivenName().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getOtherGivenName() {
        if (otherGivenName == null) {
            otherGivenName = new ArrayList<String>();
        }
        return this.otherGivenName;
    }

}
