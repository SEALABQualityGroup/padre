package editors;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XmlEditor {
	// Open an XML file for reading and writing
	// Getting all the attributes and tag names
	// Changing the style of the tag/attribute (text)	
	public void temp(File xml) throws Exception {
		//Xml temp = new Xml();
		//Document a = Xml.parse(xml);
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();

        Document document = documentBuilder.parse(xml);
        NodeList nodes = document.getChildNodes();
        
        for(int i = 0; i < nodes.getLength(); i++) {
        	Node a = nodes.item(i);
        	String name = a.getNodeName();
        	document.renameNode(a, name, "bubba");
        }
        
        write(document, xml.getAbsolutePath());
	}
	
	public void write(Document doc, String outputFile) throws TransformerException {
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource domSource = new DOMSource(doc);

        StreamResult streamResult = new StreamResult(new File(outputFile));
        transformer.transform(domSource, streamResult);

	}
}