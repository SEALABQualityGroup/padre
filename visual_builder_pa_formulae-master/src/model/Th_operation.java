package model;


public class Th_operation {
	
	int id;
	String name, method;
	
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
