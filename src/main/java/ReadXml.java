import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;

public class ReadXml {

    public static void main(String [] args) throws IOException, SAXException, ParserConfigurationException, TransformerException {




        File fXmlFile = new File(System.getProperty("user.dir")+"\\src\\main\\resources\\myxml.xml");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(fXmlFile);

        doc.getDocumentElement().normalize();
        NodeList nList =doc.getElementsByTagName("name");
        Node n=nList.item(0).getFirstChild();
        n.setNodeValue("Wipro ltd");

        TransformerFactory transformerFactory = TransformerFactory.newInstance();

        Transformer transformer = transformerFactory.newTransformer();

        DOMSource domSource = new DOMSource(doc);

        StreamResult streamResult = new StreamResult(new File(System.getProperty("user.dir")+"\\src\\main\\resources\\newXml.xml"));

        transformer.transform(domSource, streamResult);
    }
}
