package model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * * It represents a Threshold value
 *
 * @author Davide Di Gironimo
 */
@XmlRootElement
public class EVL_Tree_Threshold {
	
	String text;

	public EVL_Tree_Threshold(String text) {
		this.text = text;
	}

	public EVL_Tree_Threshold() {
	}
	
	@XmlElement
	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String toString() {
		return text;
	}
}
