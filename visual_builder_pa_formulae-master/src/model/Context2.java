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
public class Context2 {
	private String name;
	/**
	  * the list of Invariant contained in the context
	  *  
	  */
	private List<F_operation> effe;
	private List<Do_operation> du;
	/**
	   * Constructor of the class.
	   * It initialize the <code>invariantList</code> with the parameter, and set the name of the Context
	   * 
	   * @param name Context name
	   * @param c List of Invariant
	   * 
	   */
	
	public Context2(){
		this.effe = new ArrayList<F_operation>();
		this.du = new ArrayList<Do_operation>();
	}
	/**
	  * returns the context name 
	  * @return    contextName
	  */
	@XmlElement
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	/**
	  * returns the invariant list 
	  * @return    invariantList
	  */
	@XmlElementWrapper
	@XmlElement(name="effe")
	public List<F_operation> geteffe() {
		if(this.effe==null)
			return null;
		return  this.effe;
	}
	public void seteffe(List<F_operation> c) {
		this.effe = c;
		
	}
	@XmlElementWrapper
	@XmlElement(name="du")
	public List<Do_operation> getdu() {
		if(this.du==null)
			return null;
		return  this.du;
	}
	public void setdu(List<Do_operation> nuovodu) {
		this.du = nuovodu;
		
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
}
