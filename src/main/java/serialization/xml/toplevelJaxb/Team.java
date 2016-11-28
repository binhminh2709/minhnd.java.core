//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2013.07.28 at 11:54:40 AM BST 
//

package serialization.xml.toplevelJaxb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;

/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="DateFounded" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element ref="{}Players"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "name", "dateFounded", "players" })
@XmlRootElement(name = "Team")
public class Team {
  
  @XmlElement(name = "Name", required = true)
  protected String name;
  @XmlElement(name = "DateFounded", required = true)
  @XmlSchemaType(name = "date")
  protected XMLGregorianCalendar dateFounded;
  @XmlElement(name = "Players", required = true)
  protected Players players;
  
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
   * Gets the value of the dateFounded property.
   * 
   * @return
   *     possible object is
   *     {@link XMLGregorianCalendar }
   *     
   */
  public XMLGregorianCalendar getDateFounded() {
    return dateFounded;
  }
  
  /**
   * Sets the value of the dateFounded property.
   * 
   * @param value
   *     allowed object is
   *     {@link XMLGregorianCalendar }
   *     
   */
  public void setDateFounded(XMLGregorianCalendar value) {
    this.dateFounded = value;
  }
  
  /**
   * Gets the value of the players property.
   * 
   * @return
   *     possible object is
   *     {@link Players }
   *     
   */
  public Players getPlayers() {
    return players;
  }
  
  /**
   * Sets the value of the players property.
   * 
   * @param value
   *     allowed object is
   *     {@link Players }
   *     
   */
  public void setPlayers(Players value) {
    this.players = value;
  }
  
}
