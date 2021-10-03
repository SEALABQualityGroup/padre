package model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * It represent the <code>fix</code> construct
 * 
 * @author Davide Di Gironimo
 */
@XmlRootElement
public class EVL_Tree_FixStatement {

	private String context;
	/**
	 * This is the title shown when a fix construct is executed.
	 * 
	 */
	private EVL_Tree_FixTitle title;
	/**
	 * This is the list of Do executed.
	 * 
	 */
	private EVL_Tree_FixOperations doList;

	/**
	 * Constructor of the class. It initialize the context to which this fix
	 * belongs, the <code>Title</code> and the <code>DoList</code>.
	 * 
	 * @param context
	 * @param title
	 * @param doList
	 */
	public EVL_Tree_FixStatement(String context, EVL_Tree_FixTitle title, EVL_Tree_FixOperations doList) {
		this.context = context;
		this.title = title;
		this.doList = doList;
	}

	/**
	 * Constructor of the class. It initialize the context to which this fix
	 * belongs.
	 * 
	 * @param context The name of the Context to which this Fix belongs
	 */
	public EVL_Tree_FixStatement(String context) {
		this.context = context;
		this.title = null;
		this.doList = new EVL_Tree_FixOperations(context);
	}

	public EVL_Tree_FixStatement() {
	}

	public String getContext() {
		return context;
	}

	public EVL_Tree_FixTitle getTitle() {
		return title;
	}

	public void setTitle(EVL_Tree_FixTitle title) {
		this.title = title;
	}

	@XmlElement
	public EVL_Tree_FixOperations getDoList() {
		return doList;
	}

	public void setDoList(EVL_Tree_FixOperations doList) {
		this.doList = doList;
	}

	public String toString() {

		String res = "\t\tfix {\n";
		if (title != null)
			res += "\t\t\t\t" + title.toString() + " \n";

		/*
		 * for(Do d : this.getDoList()){ res+="\t\t\t\tdo {\n"; for(String s :
		 * d.getFunctions()){ res+="\t\t\t\t\t"+s+"\n"; } res+="\t\t\t\t}\n"; }
		 */
		if (this.doList != null) {
			res += "\t\t\t\tdo {\n";

			res += "" + this.doList.toString() + "\n";

			res += "\t\t\t\t}\n";
		}

		res += "\t\t\t}\n";
		return res;
	}

}
