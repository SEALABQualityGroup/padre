package helpers;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import model.EVL_Tree_Root;

public class ProjectManagment {
	public static void Save(EVL_Tree_Root evl, File evl_file) throws JAXBException{
		// create JAXB context and instantiate marshaller
	    JAXBContext context = JAXBContext.newInstance(EVL_Tree_Root.class);
	    //JAXBContext context = JAXBContext.newInstance(new Class[] {Evl.class});
	    Marshaller m = context.createMarshaller();
	    m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
	    // Write to File
	    m.marshal(evl, evl_file);
		

	}
	public static EVL_Tree_Root Open(String path) throws JAXBException, FileNotFoundException{
			EVL_Tree_Root evl = null;
			JAXBContext context = JAXBContext.newInstance(EVL_Tree_Root.class);
			Unmarshaller um = context.createUnmarshaller();
		    evl = (EVL_Tree_Root) um.unmarshal(new FileReader(path));
			
			return evl;
		    
	}
}
