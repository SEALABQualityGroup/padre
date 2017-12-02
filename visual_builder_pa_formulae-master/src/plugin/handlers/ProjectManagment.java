package plugin.handlers;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import model.Evl;

public class ProjectManagment {
	public static void Save(Evl evl, File evl_file) throws JAXBException{
		// create JAXB context and instantiate marshaller
	    JAXBContext context = JAXBContext.newInstance(Evl.class);
	    //JAXBContext context = JAXBContext.newInstance(new Class[] {Evl.class});
	    Marshaller m = context.createMarshaller();
	    m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
	    // Write to File
	    m.marshal(evl, evl_file);
		

	}
	public static Evl Open(String path) throws JAXBException, FileNotFoundException{
			Evl evl = null;
			JAXBContext context = JAXBContext.newInstance(Evl.class);
			Unmarshaller um = context.createUnmarshaller();
		    evl = (Evl) um.unmarshal(new FileReader(path));
			
			return evl;
		    
	}
}
