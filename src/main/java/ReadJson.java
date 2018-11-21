

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ReadJson {

    public static void main(String [] args) throws IOException, SAXException, ParserConfigurationException, TransformerException, ParseException {
        JSONParser jsonParser = new JSONParser();

        FileReader reader = new FileReader(System.getProperty("user.dir")+"\\src\\main\\resources\\myJson.json");
        Object obj = jsonParser.parse(reader);
        JSONObject employee = (JSONObject) obj;
        employee.put("name","wipro ltd");
        File file = new File(System.getProperty("user.dir")+"\\src\\main\\resources\\mynewJson.json");
        FileWriter output = new FileWriter(file);
        output.write(employee.toJSONString());
        output.flush();




    }

}
