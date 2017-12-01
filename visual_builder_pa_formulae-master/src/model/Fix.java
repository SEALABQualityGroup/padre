package model;


import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


/** *
 *It represent the <code>fix</code> construct 
 *@author Davide Di Gironimo
 */
@XmlRootElement
public class Fix {
	/**
	  * This is the title shown when a fix construct is executed. 
	  * 
	  */
	private Title title;
	/**
	  * This is the list of Do executed.
	  * 
	  */
	private Do doList;
	
	/**
	   * Constructor of the class.
	   * It initialize the <code>Title</code> and the <code>DoList</code>.
	   * 
	   * @param title Fix title
	   * @param doList Listo of Do 
	   * 
	   */
	public Fix(Title title, Do doList) {
		//super();
		this.title = title;
		this.doList = doList;
	}
	public Fix(){
		this.title=null;
		this.doList = new Do();
	}
	public Title getTitle() {
		return title;
	}
	public void setTitle(Title title) {
		this.title = title;
	}
	
	@XmlElement
	public Do getDoList() {
		return doList;
	}
	public void setDoList(Do doList) {
		this.doList = doList;
	}
	public String toString(){
		
		String res = "\t\tfix {\n";
		if(title!=null)
			res+="\t\t\t\t"+title.toString()+" \n";
		
		/*for(Do d : this.getDoList()){
			res+="\t\t\t\tdo {\n";
			for(String s : d.getFunctions()){
				res+="\t\t\t\t\t"+s+"\n";
			}
			res+="\t\t\t\t}\n";
		}*/
		if (this.doList!=null) {
			res+="\t\t\t\tdo {\n";
			
				res+=""+this.doList.toString()+"\n";
			
			res+="\t\t\t\t}\n";
		}
		
		res+="\t\t\t}\n";
		return res;
	}
	
}
