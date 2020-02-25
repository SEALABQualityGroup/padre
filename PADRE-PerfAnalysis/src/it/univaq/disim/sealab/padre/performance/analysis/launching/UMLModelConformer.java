package it.univaq.disim.sealab.padre.performance.analysis.launching;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class UMLModelConformer {

	public static final int NORMAL_MODE = 0;
	public static final int OVERWRITE_MODE = 1;
	private int mode;

	public UMLModelConformer(int mode) {
		this.mode = mode;
	}
	//
	// public static void main(String argv[]) {
	// UMLModelConformer c = new UMLModelConformer(OVERWRITE_MODE);
	// c.conform(System.getProperty("user.dir").toString() +
	// "/resources/examples/BGCS/BGCSPerf-Papyrus.uml");
	// }

	public boolean conform(String umlFilePath) {
		try {
			System.out.println("Conforming UML-MARTE model...");
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
			Document doc = docBuilder.parse(umlFilePath);
			NodeList list = doc.getElementsByTagName("packagedElement");
			for (int i = 0; i < list.getLength(); i++) {
				if (list.item(i).getAttributes().getNamedItem("xmi:type").getNodeValue().equals("uml:Usage")) {
					// System.out.println("Usage");
					if (list.item(i).getAttributes().getNamedItem("client") != null) {
						// System.out.println("\tclient: " +
						// list.item(i).getAttributes().getNamedItem("client").getNodeValue().toString());
						String newValue = list.item(i).getAttributes().getNamedItem("client").getNodeValue().toString()
								.split(" ")[0];
						((Element) list.item(i)).setAttribute("client", newValue);
						// System.out.println("\tNew value for client: " +
						// list.item(i).getAttributes().getNamedItem("client").getNodeValue().toString());
					}
					if (list.item(i).getAttributes().getNamedItem("supplier") != null) {
						// System.out.println("\tsupplier: " +
						// list.item(i).getAttributes().getNamedItem("supplier").getNodeValue().toString());
						String newValue = list.item(i).getAttributes().getNamedItem("supplier").getNodeValue()
								.toString().split(" ")[0];
						((Element) list.item(i)).setAttribute("supplier", newValue);
						// System.out.println("\tNew value for supplier: " +
						// list.item(i).getAttributes().getNamedItem("supplier").getNodeValue().toString());
					}
				}
			}
			NodeList intReals = doc.getElementsByTagName("interfaceRealization");
			for (int i = 0; i < intReals.getLength(); i++) {
				// System.out.println("InterfaceRealization");
				if (intReals.item(i).getAttributes().getNamedItem("client") != null) {
					// System.out.println("\tclient: " +
					// intReals.item(i).getAttributes().getNamedItem("client").getNodeValue().toString());
					String newValue = intReals.item(i).getAttributes().getNamedItem("client").getNodeValue().toString()
							.split(" ")[0];
					((Element) intReals.item(i)).setAttribute("client", newValue);
					// System.out.println("\tNew value for client: " +
					// intReals.item(i).getAttributes().getNamedItem("client").getNodeValue().toString());
				}
				if (intReals.item(i).getAttributes().getNamedItem("supplier") != null) {
					// System.out.println("\tsupplier: " +
					// intReals.item(i).getAttributes().getNamedItem("supplier").getNodeValue().toString());
					String newValue = intReals.item(i).getAttributes().getNamedItem("supplier").getNodeValue()
							.toString().split(" ")[0];
					((Element) intReals.item(i)).setAttribute("supplier", newValue);
					// System.out.println("\tNew value for supplier: " +
					// intReals.item(i).getAttributes().getNamedItem("supplier").getNodeValue().toString());
				}

			}
			NodeList compReals = doc.getElementsByTagName("realization");
			for (int i = 0; i < compReals.getLength(); i++) {
				// System.out.println("ComponentRealization");
				if (compReals.item(i).getAttributes().getNamedItem("client") != null) {
					// System.out.println("\tclient: " +
					// compReals.item(i).getAttributes().getNamedItem("client").getNodeValue().toString());
					String newValue = compReals.item(i).getAttributes().getNamedItem("client").getNodeValue().toString()
							.split(" ")[0];
					((Element) compReals.item(i)).setAttribute("client", newValue);
					// System.out.println("\tNew value for client: " +
					// compReals.item(i).getAttributes().getNamedItem("client").getNodeValue().toString());
				}
				if (compReals.item(i).getAttributes().getNamedItem("supplier") != null) {
					// System.out.println("\tsupplier: " +
					// compReals.item(i).getAttributes().getNamedItem("supplier").getNodeValue().toString());
					String newValue = compReals.item(i).getAttributes().getNamedItem("supplier").getNodeValue()
							.toString().split(" ")[0];
					((Element) compReals.item(i)).setAttribute("supplier", newValue);
					// System.out.println("\tNew value for supplier: " +
					// compReals.item(i).getAttributes().getNamedItem("supplier").getNodeValue().toString());
				}
			}
			NodeList deploymList = doc.getElementsByTagName("deployment");
			for (int i = 0; i < deploymList.getLength(); i++) {
				// System.out.println("Deployment");
				if (deploymList.item(i).getAttributes().getNamedItem("client") != null) {
					// System.out.println("\tclient: " +
					// deploymList.item(i).getAttributes().getNamedItem("client").getNodeValue().toString());
					String newValue = deploymList.item(i).getAttributes().getNamedItem("client").getNodeValue()
							.toString().split(" ")[0];
					((Element) deploymList.item(i)).setAttribute("client", newValue);
					// System.out.println("\tNew value for client: " +
					// deploymList.item(i).getAttributes().getNamedItem("client").getNodeValue().toString());
				}
				if (deploymList.item(i).getAttributes().getNamedItem("supplier") != null) {
					// System.out.println("\tsupplier: " +
					// deploymList.item(i).getAttributes().getNamedItem("supplier").getNodeValue().toString());
					String newValue = deploymList.item(i).getAttributes().getNamedItem("supplier").getNodeValue()
							.toString().split(" ")[0];
					((Element) deploymList.item(i)).setAttribute("supplier", newValue);
					// System.out.println("\tNew value for supplier: " +
					// deploymList.item(i).getAttributes().getNamedItem("supplier").getNodeValue().toString());
				}
			}
			NodeList templateList = doc.getElementsByTagName("ownedTemplateSignature");
			for (int i = 0; i < templateList.getLength(); i++) {
				// System.out.println("TamplateSignature");
				if (templateList.item(i).getAttributes().getNamedItem("parameter") != null) {
					// System.out.println("\tparameter: " +
					// templateList.item(i).getAttributes().getNamedItem("parameter").getNodeValue().toString());
					String newValue = templateList.item(i).getAttributes().getNamedItem("parameter").getNodeValue()
							.toString().split(" ")[0];
					((Element) templateList.item(i)).setAttribute("parameter", newValue);
					// System.out.println("\tNew value for parameter: " +
					// templateList.item(i).getAttributes().getNamedItem("parameter").getNodeValue().toString());
				}
			}

			// write the content into xml file
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File(umlFilePath));
			switch (this.mode) {
			case NORMAL_MODE:
				// TODO
				result = new StreamResult(
						new File(umlFilePath.substring(0, umlFilePath.length() - 4) + "-conforming.uml"));
				break;
			case OVERWRITE_MODE:
				result = new StreamResult(new File(umlFilePath));
				break;
			}
			transformer.transform(source, result);
			System.out.println("Done");

		} catch (DOMException e) {
			return false;
		} catch (ParserConfigurationException pce) {
			return false;
		} catch (IOException ioe) {
			return false;
		} catch (SAXException sae) {
			return false;
		} catch (TransformerConfigurationException e) {
			return false;
		} catch (TransformerException e) {
			return false;
		}
		return true;
	}
}
