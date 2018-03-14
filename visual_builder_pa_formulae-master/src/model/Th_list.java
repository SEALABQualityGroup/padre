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
public class Th_list {
	/**
	  * the list of Invariant contained in the context
	  *  
	  */
	private List<Th_operation> ths;
	/**
	   * Constructor of the class.
	   * It initialize the <code>invariantList</code> with the parameter, and set the name of the Context
	   * 
	   * @param name Context name
	   * @param c List of Invariant
	   * 
	   */
	
	public Th_list(List<Th_operation> ops){
		this.ths = ops;
	}

	/**
	  * returns the invariant list 
	  * @return    invariantList
	  */
	@XmlElementWrapper
	@XmlElement(name="ths")
	public List<Th_operation> getListThresholds() {
		if(this.ths==null)
			return null;
		return  this.ths;
	}
	public void setListThresholds(List<Th_operation> c) {
		this.ths = c;
		
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
