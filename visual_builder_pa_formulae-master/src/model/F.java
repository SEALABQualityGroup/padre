package model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/** *
 *This class represents an F
 *
 *@author Davide Di Gironimo
 */
@XmlRootElement
public class F extends Threshold{
	private String  card,returnType;
	
	public F(String text , String card, String returnType) {
		super(text);
		this.card = card;
		this.returnType = returnType;
	}
	public F(String text , String card) {
		super(text);
		this.card = card;
	}
	public F(){
		super();
	}
	@XmlElement
	public String getCard() {
		return card;
	}
	public void setCard(String card) {
		this.card = card;
	}
	public String getReturnType() {
		return returnType;
	}
	public void setReturnType(String returnType) {
		this.returnType = returnType;
	}
	public String toString(){
		return "self."+this.text+"()";
	}
}
