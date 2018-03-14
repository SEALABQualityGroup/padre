package model;


public class Th_operation {
	
	int id;
	String name, method, eol_file;
	
	
	public Th_operation(){}
	
	public Th_operation(int id, String name){
		this.id = id;
		this.name = name;
	}
	
	public Th_operation(int id, String name, String body){
		this.id = id;
		this.name = name;
		this.method = body;
	}
	
	public Th_operation(String name, String body, String file){
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

	public int getId() {
		return id;
	}
	
	public String getEol_file() {
		return eol_file;
	}

	public void setEol_file(String eol_file) {
		this.eol_file = eol_file;
	}


}
