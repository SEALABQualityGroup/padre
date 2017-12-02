package model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;



/** 
 *Evl is the main class, it represent the <code>.evl</code> file
 *@author Davide Di Gironimo
 */
@XmlRootElement(namespace = "model")
public class Evl{
	
	List<ImportStatement> importList;
	List<Context> contextList;
	
	
	/**
	   * Constructor of the class.
	   * It initialize the <code>contextList</code> with the parameter.
	   * 
	   * @param contextList List of Context
	   * 
	   */
	public Evl(List<Context> contextList) {
		super();
		this.contextList = contextList;
	}
	/**
	   * Blank Constructor
	   */
	public Evl() {
		this.contextList = new ArrayList<Context>();
		this.importList = new ArrayList<ImportStatement>();
	}
	
	@XmlElementWrapper
	@XmlElement(name="importStatement")
	public List<ImportStatement> getImportList() {
		return importList;
	}
	public void setImportList(List<ImportStatement> importList) {
		this.importList = importList;
	}

	@XmlElementWrapper
	@XmlElement(name="context")
	public List<Context> getContextList() {
		return contextList;
	}
	public void setContextList(List<Context> contextList) {
		this.contextList = contextList;
	}
	public String toString(){
		String res="";
		
		for (ImportStatement i : this.getImportList()) {
			res += i.toString();
		}
		
		res += "\n";
		
		for(Context c : this.getContextList()) {
			res += c.toString();
		}
		return res;
	}

}