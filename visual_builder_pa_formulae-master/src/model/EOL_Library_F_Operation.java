package model;

/**
 * It represents the functions available in the library
 * 
 * @author Stefano
 *
 */
public class EOL_Library_F_Operation extends EOL_Library_Operation_Superclass {

	String name, context, method;

	public EOL_Library_F_Operation() {
	}

	public EOL_Library_F_Operation(int database_id, String name, String context) {
		super(database_id);
		this.name = name;
		this.context = context;
	}

	public EOL_Library_F_Operation(int database_id, String name, String context, String body) {
		super(database_id);
		this.name = name;
		this.context = context;
		this.method = body;
	}

	public EOL_Library_F_Operation(String name, String context, String body, String file) {
		super(file);
		this.name = name;
		this.context = context;
		this.method = body;
	}

	public String getContext() {
		return context;
	}

	public void setContext(String context) {
		this.context = context;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public String toString() {
		return "self." + this.name;
	}

}
