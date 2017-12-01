package model;

public class Check {
	private String name;
	private String s1,op,s2;
	private Context parent;
	public Context getParent() {
		return parent;
	}
	public void setParent(Context parent) {
		this.parent = parent;
	}
	public String getS1() {
		return s1;
	}
	public Check(Context parent,String name){
		this.parent=parent;
		this.name= name;
	}
	public String getName(){
		return this.name;
	}
	public void setS1(String s1) {
		this.s1 = s1;
	}
	public String getOp() {
		return op;
	}
	public void setOp(String op) {
		this.op = op;
	}
	public String getS2() {
		return s2;
	}
	public void setS2(String s2) {
		this.s2 = s2;
	}
	public String toString(){
		return " check : "+s1+" "+op+" "+s2+" ";
	}


}
