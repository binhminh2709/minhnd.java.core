package serialization.xml.jaxb;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
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
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class MessageFactory {
  
  public static final String NOI_DUNG_TRA_VE = "NOI_DUNG_TRA_VE";
  
  public static List<Object> converXMLMessagesContentToObject(String xmlString) {
    List<Object> objects = null;
    String content = null;
    String objectName = null;
    XPath xPath = XPathFactory.newInstance().newXPath();
    String expression = "//Body/Content";
    DOMSource source = null;
    
    try {
      ByteArrayInputStream stream = new ByteArrayInputStream(xmlString.getBytes("UTF-8"));
      
      DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
      DocumentBuilder builder = factory.newDocumentBuilder();
      Document doc = (Document) builder.parse(stream);
      
      NodeList nodeList;
      Node node1 = (Node) xPath.compile(expression).evaluate(doc, XPathConstants.NODE);
      
      objects = new ArrayList<Object>();
      if (null != node1) {
        nodeList = node1.getChildNodes();
        for (int i = 0; null != nodeList && i < nodeList.getLength(); i++) {
          Node nod = nodeList.item(i);
          if (nod.getNodeType() == Node.ELEMENT_NODE)
            objectName = nodeList.item(i).getNodeName();
          // System.out.println(nodeList.item(i).getNodeName() + " : "
          // + nod.getFirstChild().getNodeValue());
          
          if (nod instanceof Element) {
            source = new DOMSource(nod);
            // Set up the transformer to write the output string
            TransformerFactory tFactory = TransformerFactory.newInstance();
            Transformer transformer = tFactory.newTransformer();
            transformer.setOutputProperty("indent", "yes");
            transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            StringWriter sw = new StringWriter();
            StreamResult result = new StreamResult(sw);
            // Do the transformation and output
            transformer.transform(source, result);
            content = sw.toString();
            
            if ("RequestForQualityInspection".equalsIgnoreCase(objectName)) {
              //objects.add(convertXmltoRequestForQualityInspection(content));
              //objects.add(MessageFactory.converXmlToObject(content, new RequestForQualityInspectionFactory()));
            }
            
          }
        }
      }
      
    } catch (Exception e) {
      e.printStackTrace();
    }
    return objects;
  }
  
  @SuppressWarnings({ "unchecked" })
  public static <T> T converXmlToObject(String content, T t) throws IOException {
    //if (!StringUtils.isEmpty(content)) {
    if ((content != null) && content.length() > 0) {
      ByteArrayInputStream input = new ByteArrayInputStream(content.getBytes("UTF-8"));
      try {
        JAXBContext jc = JAXBContext.newInstance(t.getClass());
        
        // create an Unmarshaller
        Unmarshaller unmarshaller = jc.createUnmarshaller();
        //xmlString=xmlString.replaceAll("\\<\\?xml(.+?)\\?\\>", "").trim();
        
        // unmarshal a po instance document into a tree of Java content
        // objects composed of classes from the primer.po package.
        T obj = (T) unmarshaller.unmarshal(input);
        
        return obj;
      } catch (Exception e) {
        e.printStackTrace();
      } finally {
        input.close();
      }
    }
    return null;
  }
  
  public static <T> String convertObjectToXml(T t) throws IOException {
    
    if (t != null) {
      ByteArrayOutputStream output = new ByteArrayOutputStream();
      try {
        JAXBContext jc = JAXBContext.newInstance(t.getClass());
        
        // create an Marshaller
        Marshaller marshaller = jc.createMarshaller();
        
        //marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(t, output);
        
        return new String(output.toByteArray(), "UTF-8");
      } catch (Exception e) {
        e.printStackTrace();
      } finally {
        output.close();
      }
    }
    return null;
  }
  
}
