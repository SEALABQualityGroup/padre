package model;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Critique construct.
 *
 * @author Davide Di Gironimo {@inheritDoc}
 */
@XmlRootElement
public class EVL_Tree_Critique extends EVL_Tree_Container {
	
	public EVL_Tree_Critique(String context, String Name) {
		super(context, Name);
		this.type = "critique";
	}

	public EVL_Tree_Critique(String context) {
		super(context);
	}

	public EVL_Tree_Critique() {
	}

	public String toString() {
		String res = "critique " + name + "{\n";
		if (this.check != null)
			res += "\t" + check.toString();
		if (this.message != null)
			res += "\t" + message.toString();
		for (EVL_Tree_FixStatement f : this.getFixList()) {
			res += "\t" + f.toString();
		}
		res += "\n\t}";
		return res;
	}

}
