package model;

import javax.xml.bind.annotation.XmlRootElement;

/** *
 *It represent the <code>title</code> shown when a fix construct is executed
 *@author Davide Di Gironimo
 */
@XmlRootElement
public class Title {
	private String text;

	public Title(String text) {
		//super();
		this.text = text;
	}

	public Title(){
		
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
