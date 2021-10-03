package model;

public class EOL_Library_Th_Operation extends EOL_Library_Operation_Superclass {

	String name, method;

	public EOL_Library_Th_Operation(int database_id, String name) {
		super(database_id);
		this.name = name;
	}

	public EOL_Library_Th_Operation(int database_id, String name, String body) {
		super(database_id);
		this.name = name;
		this.method = body;
	}

	public EOL_Library_Th_Operation(String name, String body, String file) {
		this.name = name;
		this.method = body;
		this.eol_file = file;
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

}
