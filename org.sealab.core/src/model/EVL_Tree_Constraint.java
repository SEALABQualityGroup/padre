package model;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Constraint construct.
 *
 * @author Davide Di Gironimo {@inheritDoc}
 */
@XmlRootElement
public class EVL_Tree_Constraint extends EVL_Tree_Container {

	public EVL_Tree_Constraint(String context, String Name) {
		super(context, Name);
		this.type = "constraint";
	}

	public EVL_Tree_Constraint(String context) {
		super(context);
	}

	public EVL_Tree_Constraint() {
	}

	public String toString() {
		String res = "constraint " + name + "{\n";
		if (this.check != null)
			res += check.toString();
		if (this.message != null)
			res += message.toString();
		for (EVL_Tree_FixStatement f : this.getFixList()) {
			res += f.toString();
		}
		res += "\n\t}";
		return res;
	}

}
