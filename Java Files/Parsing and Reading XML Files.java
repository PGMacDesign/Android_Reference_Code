import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

//This uses the XML file "cars_example.xml" in the XML folder and the example file to read and parse
public class XMLParser {

	public void getAllUserNames(String fileName) {
		try {
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			File file = new File(fileName);
			
			if (file.exists()) {
				Document doc = db.parse(file);
				Element docEle = doc.getDocumentElement();
				System.out.println("Root element of the document: "
				+ docEle.getNodeName());
				NodeList carList = docEle.getElementsByTagName("car");
				
				if (carList != null && carList.getLength() > 0) {
					for (int i = 0; i < carList.getLength(); i++) {
						Node node = carList.item(i);
						
						if (node.getNodeType() == Node.ELEMENT_NODE) {
							Element e = (Element) node;
							NodeList nodeList = e.getElementsByTagName("name");
							System.out.println("Name: " + nodeList.item(0).getChildNodes().item(0).getNodeValue());
							nodeList = e.getElementsByTagName("grade");
							System.out.println("Grade: " + nodeList.item(0).getChildNodes().item(0).getNodeValue());
						}
					}
				} else {
					System.exit(1);
				}
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public static void main(String[] args) {
		XMLParser parser = new XMLParser();
		parser.getAllUserNames("test.xml");
	}
}