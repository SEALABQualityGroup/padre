package model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/** *
 *It represents a Threshold value
 *
 *@author Davide Di Gironimo
 */
@XmlRootElement
public class Threshold {
	String text;
	public Threshold(String text){
		this.text=text;
	}
	public Threshold() {
	}
	@XmlElement
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String toString(){
		return text;
	}

}
