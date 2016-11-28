package serialization.xml.jaxb;

import java.io.ByteArrayInputStream;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.Date;
import java.util.UUID;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;

public class MessageUtils {
  
  public static final String NOI_DUNG_TRA_VE = "NOI_DUNG_TRA_VE";
  
  public static String replaceXML(String data) {
    try {
      String dataPrefix = data.substring(0, data.indexOf("?>") + 2).toLowerCase();
      if (dataPrefix.contains("version") && dataPrefix.contains("encoding")) {
        return data.substring(data.indexOf("?>") + 2, data.length());
        //TODO Truong hop khac
      } else if (dataPrefix.contains("version") | dataPrefix.contains("encoding")) {
        return data.substring(data.indexOf("?>") + 2, data.length());
      }
      return data;
    } catch (Exception e) {
      e.printStackTrace();
    }
    return data;
  }
  
  public static String replaceSignature(String data) {
    try {
      String dataPrefix = data.substring(0, data.indexOf("<Signature>")).toLowerCase();
      return dataPrefix;
    } catch (Exception e) {
      e.printStackTrace();
    }
    return data;
  }
  
  public static Header readXmlMessageHeader(String xmlString) throws Exception {
    
    XPath xPath = XPathFactory.newInstance().newXPath();
    String expression = "Envelope/Header";//"//Body/Content";//
    
    DOMSource source = null;
    ByteArrayInputStream stream = new ByteArrayInputStream(xmlString.getBytes("UTF-8"));
    
    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    DocumentBuilder builder = factory.newDocumentBuilder();
    Document doc = builder.parse(stream);
    
    Node node = (Node) xPath.compile(expression).evaluate(doc, XPathConstants.NODE);
    source = new DOMSource(node);
    
    TransformerFactory tFactory = TransformerFactory.newInstance();
    Transformer transformer = tFactory.newTransformer();
    transformer.setOutputProperty("indent", "yes");
    transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
    
    StringWriter sw = new StringWriter();
    StreamResult result = new StreamResult(sw);
    
    transformer.transform(source, result);
    //System.out.println(sw.toString());
    
    StringReader reader = new StringReader(sw.toString());
    
    // create a JAXBContext capable of handling classes generated into
    // Document doc1 =XmlUtils.parseXmlFile("C://header.xml", false);
    
    JAXBContext jc = JAXBContext.newInstance(HeaderFactory.class);
    
    // create an Unmarshaller
    Unmarshaller unmarshaller = jc.createUnmarshaller();
    String xmlHeader = sw.toString();
    //xmlString=xmlString.replaceAll("\\<\\?xml(.+?)\\?\\>", "").trim();
    
    ByteArrayInputStream input = new ByteArrayInputStream(xmlHeader.getBytes("UTF-8"));
    
    // unmarshal a po instance document into a tree of Java content
    // objects composed of classes from the primer.po package.
    
    Header header = (Header) unmarshaller.unmarshal(input);
    return header;
    
  }
  
  public static String getStringFromDocument(Document doc) {
    try {
      DOMSource domSource = new DOMSource(doc);
      StringWriter writer = new StringWriter();
      StreamResult result = new StreamResult(writer);
      TransformerFactory tf = TransformerFactory.newInstance();
      Transformer transformer = tf.newTransformer();
      //Tạo chuổi String, trên cùng một dòng
      //transformer.setOutputProperty(OutputKeys.INDENT, "yes");
      transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
      transformer.transform(domSource, result);
      return writer.toString();
    } catch (Exception ex) {
      ex.printStackTrace();
      return null;
    }
  }
  
}
