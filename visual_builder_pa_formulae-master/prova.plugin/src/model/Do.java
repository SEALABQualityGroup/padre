package model;

public class Do {
	private String name; 
	private String body;
	private Context parent; 
	public Context getParent() {
		return parent;
	}
	public void setParent(Context parent) {
		this.parent = parent;
	}
	public Do(Context parent,String name){
		this.parent=parent;
		this.name= name;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public String getName(){
		return this.name;
	}
	public String toString(){
		return "do{"
					+body
					+"}";
	}

}
