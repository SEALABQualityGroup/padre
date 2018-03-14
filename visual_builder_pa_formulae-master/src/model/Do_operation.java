package model;


public class Do_operation {
	
	int id;
	String name, context, method;
	String eol_file;
	
	public String getEol_file() {
		return eol_file;
	}

	public void setEol_file(String eol_file) {
		this.eol_file = eol_file;
	}

	public Do_operation(){}
	
	public Do_operation(int id, String name, String context){
		this.id = id;
		this.name = name;
		this .context = context;
	}
	
	public Do_operation(int id, String name, String context, String body){
		this.id = id;
		this.name = name;
		this .context = context;
		this.method = body;
	}
	
	public Do_operation(String name, String context, String body, String file){
		this.name = name;
		this .context = context;
		this.method = body;
		this.eol_file = file;
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

	public int getId() {
		return id;
	}

}
