package model;

import javax.xml.bind.annotation.XmlRootElement;



/** 
 *It's the Message construct contained in the Invariant
 *@author Davide Di Gironimo
 */
@XmlRootElement
public class EVL_Tree_Message {
	
	private String text;

	public EVL_Tree_Message(String text) {
		super();
		this.text = text;
	}
	public EVL_Tree_Message() {
	}

	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String toString(){
		return "\t\tmessage : " + text + " \n";
	}

}
