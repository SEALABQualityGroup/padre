package it.univaq.disim.sealab.padre.performance.analysis.launching;

import java.io.File;
import org.w3c.dom.Element;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

//import javax.xml.parsers.DocumentBuilder;
//import javax.xml.parsers.DocumentBuilderFactory;
//import javax.xml.parsers.ParserConfigurationException;
//import javax.xml.transform.Transformer;
//import javax.xml.transform.TransformerException;
//import javax.xml.transform.TransformerFactory;
//import javax.xml.transform.dom.DOMSource;
//import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class JmvaFileGenerator {

	private String jmvaFilePath;

	/**
	 * jmvaFP is the destination jmva file path
	 * 
	 * @param jmvaFP
	 */
	public JmvaFileGenerator(String jmvaFP) {
		jmvaFilePath = jmvaFP;
	}

	public void generate(String jmtModelFilePath) {
		System.out.println("Generating JMVA file.");
		try {
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
			Document doc = docBuilder.parse(jmtModelFilePath);
			Node model = doc.getFirstChild();

			doc.renameNode(model, model.getNamespaceURI(), "model");

			NamedNodeMap modelAttrs = doc.getFirstChild().getAttributes();
			if (modelAttrs.getNamedItem("description") != null)
				modelAttrs.removeNamedItem("description");
			if (modelAttrs.getNamedItem("xmi:version") != null)
				modelAttrs.removeNamedItem("xmi:version");
			if (modelAttrs.getNamedItem("xmlns:model") != null)
				modelAttrs.removeNamedItem("xmlns:model");
			if (modelAttrs.getNamedItem("xmlns:xmi") != null)
				modelAttrs.removeNamedItem("xmlns:xmi");
			if (modelAttrs.getNamedItem("xsi:schemaLocation") != null)
				modelAttrs.getNamedItem("xsi:schemaLocation").setNodeValue("JMTModel.xsd");
			if (modelAttrs.getNamedItem("xmlns:jmtmodel") != null)
				modelAttrs.removeNamedItem("xmlns:jmtmodel");
			// for(int i = 0; i < modelAttrs.getLength(); i++) {
			// System.out.println(modelAttrs.item(i).toString());
			// }
			((Element) model).setAttribute("xmlns:xsi", "http://www.w3.org/2001/XMLSchema-instance");
			((Element) model).setAttribute("xsi:noNamespaceSchemaLocation", "JMTmodel.xsd");
			NodeList serviceTimeList = doc.getElementsByTagName("servicetime");
			for (int i = 0; i < serviceTimeList.getLength(); i++) {
				NamedNodeMap currentAttrs = serviceTimeList.item(i).getAttributes();
				if (currentAttrs.getNamedItem("value") != null) {
					if (currentAttrs.getNamedItem("value").getNodeValue() != null) {
						serviceTimeList.item(i).setTextContent(currentAttrs.getNamedItem("value").getNodeValue());
						currentAttrs.removeNamedItem("value");
					}
				}
			}
			NodeList serviceTimesList = doc.getElementsByTagName("servicetimes");
			for (int i = 0; i < serviceTimesList.getLength(); i++) {
				NamedNodeMap currentAttrs = serviceTimesList.item(i).getAttributes();
				if (currentAttrs.getNamedItem("value") != null) {
					if (currentAttrs.getNamedItem("value").getNodeValue() != null) {
						serviceTimesList.item(i).setTextContent(currentAttrs.getNamedItem("value").getNodeValue());
						currentAttrs.removeNamedItem("value");
					}
				}
			}
			NodeList visitsList = doc.getElementsByTagName("visit");
			for (int i = 0; i < visitsList.getLength(); i++) {
				NamedNodeMap currentAttrs = visitsList.item(i).getAttributes();
				if (currentAttrs.getNamedItem("value") != null) {
					if (currentAttrs.getNamedItem("value").getNodeValue() != null) {
						visitsList.item(i).setTextContent(currentAttrs.getNamedItem("value").getNodeValue());
						currentAttrs.removeNamedItem("value");
					}
				}
			}
			// write the content into xml file
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File(jmvaFilePath));
			transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
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
