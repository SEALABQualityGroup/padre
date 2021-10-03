package model;

import javax.xml.bind.annotation.XmlRootElement;

/** *
 *It represent the <code>title</code> shown when a fix construct is executed
 *@author Davide Di Gironimo
 */
@XmlRootElement
public class EVL_Tree_FixTitle {
	
	private String text;

	public EVL_Tree_FixTitle(String text) {
		this.text = text;
	}

	public EVL_Tree_FixTitle(){
		
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String toString(){
		return "title : \"" + this.getText() + "\"";
	}
}
