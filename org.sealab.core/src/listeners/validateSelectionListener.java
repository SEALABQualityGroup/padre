package listeners;

import java.io.File;
import java.util.Collection;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.apache.commons.io.FileUtils;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchManager;
import org.eclipse.debug.ui.DebugUITools;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Shell;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

/**
 * It allows to create an EVL Validation 'Run configuration' 
 * But it is not parameterized, it need the EVL and UML model as parameters
 * 
 * @author Stefano
 *
 */
public class validateSelectionListener implements SelectionListener {

	private Shell shell;
	private String namespace;
	private org.eclipse.swt.widgets.List UMLLibrary;

	public validateSelectionListener(Shell s, String namespace, org.eclipse.swt.widgets.List UMLLibrary) {

		this.shell = s;
		this.namespace = namespace;
		this.UMLLibrary = UMLLibrary;
	}

	public void widgetSelected(SelectionEvent event) {

		IWorkspace workspace = ResourcesPlugin.getWorkspace();

		try {

			Collection<File> umlModels = FileUtils.listFiles(new File(namespace), new String[] { "uml" }, true);

			if (umlModels.isEmpty()) {
				UMLLibrary.add("No files");
			} else {
				for (File f : umlModels) {
					UMLLibrary.add(f.getName());
				}
			}


//			IPath location = Path.fromOSString(namespace + "/bgcs.launch");
//			IFile f = workspace.getRoot().getFileForLocation(location);
			
			
			

			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

			// root elements
			Document doc = docBuilder.newDocument();
			Element rootElement = doc.createElement("launchConfiguration");
			doc.appendChild(rootElement);

			Attr attr = doc.createAttribute("type");
			attr.setValue("org.epsilon.evl.eclipse.dt.launching.EvlLaunchConfigurationDelegate");
			rootElement.setAttributeNode(attr);

			rootElement.appendChild(getbooleanAttribute(doc, "fine_grained_profiling", "false"));

			Element listAttribute = doc.createElement("listAttribute");
			rootElement.appendChild(listAttribute);
			listAttribute.setAttribute("key", "models");

			Element listEntry = doc.createElement("listEntry");
			listAttribute.appendChild(listEntry);

			Attr entryAttribute = doc.createAttribute("value");
			entryAttribute.setValue("#Tue Dec 12 17:25:58 CET 2017\n" + "isMetamodelFileBased=false\n" + "name=bgcs\n"
					+ "readOnLoad=true\n" + "storeOnDisposal=true\n" + "aliases=\ncached=true\n"
					+ "fileBasedMetamodelUri=\n"
					+ "metamodelUri=http\\://www.eclipse.org/emf/2002/Ecore,http\\://www.eclipse.org/uml2/5.0.0/UML/Profile/Standard,http\\://www.eclipse.org/uml2/5.0.0/UML\nmodelUri=platform\\:/resource/it.spe.disim.epsilon.antipattern_d-s/prova1/BGCS.uml\n"
					+ "reuseUnmodifiedFileBasedMetamodels=true\n" + "type=UML\n"
					+ "modelFile=/it.spe.disim.epsilon.antipattern_d-s/prova1/BGCS.uml\n" + "expand=true\n"
					+ "metamodelFile=");
			listEntry.setAttributeNode(entryAttribute);

			rootElement.appendChild(getbooleanAttribute(doc, "optimizeConstraints", "false"));
			rootElement.appendChild(getbooleanAttribute(doc, "profile_model_loading", "false"));
			rootElement.appendChild(getbooleanAttribute(doc, "profiling_enabled", "false"));
			rootElement.appendChild(getbooleanAttribute(doc, "reset_profiler", "false"));

			Element stringAttribute = doc.createElement("stringAttribute");
			rootElement.appendChild(stringAttribute);

			stringAttribute.setAttribute("key", "source");
			stringAttribute.setAttribute("value", "/it.spe.disim.epsilon.antipattern_d-s/prova1/AP-UML-MARTE.evl");

			// write the content into xml file
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File(namespace + "/bgcs.launch"));

			transformer.transform(source, result);

		} catch (ParserConfigurationException pce) {
			pce.printStackTrace();
		} catch (TransformerException tfe) {
			tfe.printStackTrace();
		}

		ILaunchManager manager = DebugPlugin.getDefault().getLaunchManager();

		IPath location = Path.fromOSString(namespace + "/bgcs.launch");
		IFile f = workspace.getRoot().getFileForLocation(location);

		ILaunchConfiguration g = manager.getLaunchConfiguration(f);
		DebugUITools.launch(g, ILaunchManager.DEBUG_MODE);

		shell.close();
	}

	private static Node getbooleanAttribute(Document doc, String key, String value) {
		Element company = doc.createElement("booleanAttribute");
		company.setAttribute("key", key);
		company.setAttribute("value", value);

		return company;
	}

	public void widgetDefaultSelected(SelectionEvent event) {

	}
}
