package model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;


/** *
 *It represents the <code>context</code> in the <code>.evl</code> file
 *
 *@author Davide Di Gironimo
 */
@XmlRootElement
public class Context {
	private String name;
	/**
	  * the list of Invariant contained in the context
	  *  
	  */
	private List<Container> containers;
	/**
	   * Constructor of the class.
	   * It initialize the <code>invariantList</code> with the parameter, and set the name of the Context
	   * 
	   * @param name Context name
	   * @param c List of Invariant
	   * 
	   */
	public Context(String name, List<Container> c) {
		super();
		this.name = name;
		this.containers = c;
		
	}

	public Context(String contextName) {
		this.name=contextName;
		this.containers = new ArrayList<Container>();
		
	}
	public Context(){
		this.containers = new ArrayList<Container>();
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
	@XmlElement(name="container")
	public List<Container> getContainers() {
		if(this.containers==null)
			return null;
		return  this.containers;
	}
	public void setContainer(List<Container> c) {
		this.containers = c;
		
	}
	public String toString(){
		String res="";
		res+="context "+this.getName()+"{\n";
			for(Container c : this.getContainers()){
				if (containers!=null){
					res+="\t"+c.toString()+"\n";
				}
			}
		
		res+="}\n";
		return res;
	}
}
