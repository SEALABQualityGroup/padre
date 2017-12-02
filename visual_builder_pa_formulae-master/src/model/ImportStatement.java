package model;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class ImportStatement {
	private String text;
	
	public ImportStatement(String text) {
		this.text = text;
	}

	public ImportStatement() {
		this.text = null;
	}
//	@XmlElementWrapper
//	@XmlElement
//	public String getFunctions() {
//		return text;
//	}
//	public void setFunctions(String text) {
//		this.text = text;
//	}
	public String toString(){
		return "import " + this.text;
	}
}
