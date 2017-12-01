package model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;


/** *
 *This is the list of <code>Do</code> 
 *@author Davide Di Gironimo
 */
@XmlRootElement
public class Do {
	
	private List<String> functions;
	
	public Do(){
		
		functions = new ArrayList<String>();
		
	}
	@XmlElementWrapper
	@XmlElement
	public List<String> getFunctions() {
		return functions;
	}
	public void setFunctions(List<String> functions) {
		this.functions = functions;
	}
	public String toString(){
		String res ="";
		for(String s : this.getFunctions()){
			res+="\t\t\t\t\tself."+s+"();\n";
		}
		return res;
	}

}
