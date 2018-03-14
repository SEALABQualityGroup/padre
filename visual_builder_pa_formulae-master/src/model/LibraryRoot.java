package model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;


/** *
 *It represents the <code>context</code> in the <code>.evl</code> file
 *
 *@author Stefano Di Francesco
 */
@XmlRootElement
public class LibraryRoot {
	/**
	  * the list of Invariant contained in the context
	  *  
	  */
	private String name;
	private List<Context2> cs;
	private List<Th_operation> ths;
	/**
	   * Constructor of the class.
	   * It initialize the <code>invariantList</code> with the parameter, and set the name of the Context
	   * 
	   * @param name Context name
	   * @param c List of Invariant
	   * 
	   */
	
	public LibraryRoot(List<Context2> cs, List<Th_operation> ths, String libraryName){
		this.cs = cs;
		this.ths = ths;
		this.setName(libraryName);
	}

	/**
	  * returns the invariant list 
	  * @return    invariantList
	  */
	@XmlElementWrapper
	@XmlElement(name="cs")
	public List<Context2> getListContexts() {
		if(this.cs==null)
			return null;
		return  this.cs;
	}
	public void setListContexts(List<Context2> cs) {
		this.cs = cs;
		
	}
	@XmlElementWrapper
	@XmlElement(name="ths")
	public List<Th_operation> getths() {
		if(this.ths==null)
			return null;
		return this.ths;
	}
	public void setths(List<Th_operation> ths) {
		this.ths = ths;
		
	}
//	public String toString(){
//		String res="";
//		res+="context "+this.getName()+"{\n";
//			for(Container c : this.getContainers()){
//				if (containers!=null){
//					res+="\t"+c.toString()+"\n";
//				}
//			}
//		
//		res+="}\n";
//		return res;
//	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
