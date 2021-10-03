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
public class EVL_Tree_Root{
	
	List<EVL_Tree_ImportStatement> importList;
	List<EVL_Tree_Context_Item> contextList;
	
	
	/**
	   * Constructor of the class.
	   * It initialize the <code>contextList</code> with the parameter.
	   * 
	   * @param contextList List of Context
	   * 
	   */
	public EVL_Tree_Root(List<EVL_Tree_Context_Item> contextList) {
		super();
		this.contextList = contextList;
	}
	/**
	   * Blank Constructor
	   */
	public EVL_Tree_Root() {
		this.contextList = new ArrayList<EVL_Tree_Context_Item>();
		this.importList = new ArrayList<EVL_Tree_ImportStatement>();
	}
	
	@XmlElementWrapper
	@XmlElement(name="importStatement")
	public List<EVL_Tree_ImportStatement> getImportList() {
		return importList;
	}
	public void setImportList(List<EVL_Tree_ImportStatement> importList) {
		this.importList = importList;
	}

	@XmlElementWrapper
	@XmlElement(name="context")
	public List<EVL_Tree_Context_Item> getContextList() {
		return contextList;
	}
	public void setContextList(List<EVL_Tree_Context_Item> contextList) {
		this.contextList = contextList;
	}
	public String toString(){
		String res="";
		
		for (EVL_Tree_ImportStatement i : this.getImportList()) {
			res += i.toString();
			res += "\n";
		}
		
		res += "\n";
		
		for(EVL_Tree_Context_Item c : this.getContextList()) {
			res += c.toString();
		}
		return res;
	}

}