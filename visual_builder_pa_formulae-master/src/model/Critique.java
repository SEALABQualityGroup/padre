package model;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Critique construct.
 *
 *@author Davide Di Gironimo
 *{@inheritDoc}
 */
@XmlRootElement
public class Critique extends Container{
	public Critique(String Name) {
		super(Name);
		this.type="critique";
	}
	public Critique(){
		super();
	}
	public String toString(){
		String res="critique "+name+"{\n";
		if(this.check!=null)
			res+="\t"+check.toString();
		if(this.message!=null)
			res+="\t"+message.toString();
		for(Fix f : this.getFixList()){
			res+="\t"+f.toString();
		}
		res +="\n\t}"; 
		return res;
	}
	
	
	

}
