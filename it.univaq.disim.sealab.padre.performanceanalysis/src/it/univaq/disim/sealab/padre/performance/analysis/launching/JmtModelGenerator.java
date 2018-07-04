package it.univaq.disim.sealab.padre.performance.analysis.launching;

import java.io.File;
import org.w3c.dom.Element;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.eclipse.epsilon.eol.tools.ProfilerTool;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class JmtModelGenerator {

	public JmtModelGenerator() {
	}

	// public static void main(String argv[]) {
	// JmtModelGenerator g = new JmtModelGenerator();
	// g.generate(System.getProperty("user.dir").toString() +
	// "/resources/examples/BGCS/BGCS-JMVA.jmva");
	// }

	public void generate(String jmvaFilePath, String jmtFilePath) {
		System.out.println("Generating JMVA model.");
		try {
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
			// String filepath = jmvaFilePath;
			Document doc = docBuilder.parse(jmvaFilePath);
			Node model = doc.getFirstChild();

			doc.renameNode(model, "jmtmodel", "ModelType");
			((Element) model).setAttribute("xmlns:xmi", "2.0");
			((Element) model).setAttribute("xmlns:xmi", "http://www.omg.org/XMI");
			((Element) model).setAttribute("xmlns:jmtmodel", "jmtmodel");

			NamedNodeMap modelAttrs = doc.getFirstChild().getAttributes();
			if (modelAttrs.getNamedItem("xsi:noNamespaceSchemaLocation") != null)
				modelAttrs.removeNamedItem("xsi:noNamespaceSchemaLocation");
			if (modelAttrs.getNamedItem("xmlns:xsi") != null)
				modelAttrs.removeNamedItem("xmlns:xsi");
			Node refStationNew = doc.createElement("referenceStation");
			NodeList classes = doc.getElementsByTagName("Class");
			for (int i = 0; i < classes.getLength(); i++) {
				Node newClass = doc.createElement("class");
				NamedNodeMap classAttrs = classes.item(i).getAttributes();
				((Element) newClass).setAttribute("name", classAttrs.getNamedItem("name").getNodeValue());
				((Element) newClass).setAttribute("refStation", classAttrs.getNamedItem("refStation").getNodeValue());
				refStationNew.appendChild(newClass);
			}

			NodeList parList = doc.getElementsByTagName("parameters");
			if (parList != null)
				if (parList.getLength() > 0) {
					Node parameters = parList.item(0);
					NodeList refStationList = doc.getElementsByTagName("ReferenceStation");
					if (refStationList != null)
						if (refStationList.getLength() > 0) {
							Node refStation = refStationList.item(0);
							parameters.replaceChild(refStationNew, refStation);
						}
				}

			NodeList algParamsList = doc.getElementsByTagName("algParams");
			if (algParamsList != null)
				if (algParamsList.getLength() > 0) {
					Node algParams = algParamsList.item(0);
					doc.getFirstChild().removeChild(algParams);
				}

			NodeList solutionsList = doc.getElementsByTagName("solutions");
			if (solutionsList != null)
				if (solutionsList.getLength() > 0) {
					Node solutions = solutionsList.item(0);
					NamedNodeMap solutionsAttrs = solutions.getAttributes();
					if (solutionsAttrs.getNamedItem("algCount") != null)
						solutionsAttrs.removeNamedItem("algCount");
					Node algorithm = doc.getElementsByTagName("algorithm").item(0);
					NodeList algChildren = algorithm.getChildNodes();
					for (int i = 0; i < algChildren.getLength(); i++) {
						solutions.appendChild(algChildren.item(i).cloneNode(true));
					}
					solutions.removeChild(algorithm);
				}

			// write the content into xml file
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			// StreamResult result = new StreamResult(new File(jmvaFilePath.substring(0,
			// jmvaFilePath.length() - 5) + ".xmi"));
			StreamResult result = new StreamResult(new File(jmtFilePath));
			transformer.transform(source, result);
			System.out.println("Done");
		} catch (DOMException e) {
			e.printStackTrace();
		} catch (ParserConfigurationException pce) {
			pce.printStackTrace();
		} catch (TransformerException tfe) {
			tfe.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} catch (SAXException sae) {
			sae.printStackTrace();
		}
	}
}
