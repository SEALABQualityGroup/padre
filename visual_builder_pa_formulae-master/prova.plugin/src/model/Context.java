package model;

import java.util.ArrayList;
import java.util.List;

public class Context {
	private Evl parent;
	String name;
	List<Check> checkList;
	List<Do> doList;
	public Context(List<Check> checkList, List<Do> doList,Evl parent, String name) {
		super();
		this.checkList = checkList;
		this.doList = doList;
		this.parent=parent;
		this.name= name;
	}
	public Context(String string,Evl parent) {
		name=string;
		this.parent=parent;
		this.checkList = new ArrayList<Check>();
		this.doList = new ArrayList<Do>();
		
	}

	
	public List<Check> getCheckList() {
		return checkList;
	}
	public void setCheckList(List<Check> checkList,Evl parent) {
		this.checkList = checkList;
		this.parent=parent;
	}
	public void addCheck(Check check , Evl parent){
		checkList.add(check);
		this.parent=parent;
	}
	public List<Do> getDoList() {
		return doList;
	}
	public void setDoList(List<Do> doList,Evl parent) {
		this.doList = doList;
		this.parent=parent;
	}
	public void addDo(Do d , Evl parent){
		doList.add(d);
		this.parent=parent;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean removeCheck(String checkName){
		for(Check c : this.getCheckList()){
			if(c.getName().equals(checkName)){
				return this.checkList.remove(c);
			}
				
		}
		return false;
	}
	public boolean removeDo(String doName){
		for(Do d : this.getDoList()){
			if(d.getName().equals(doName)){
				return this.doList.remove(d);
			}
				
		}
		return false;
	}
	public Evl getParent() {
		return parent;
	}
	public void setParent(Evl parent) {
		this.parent = parent;
	}
	public String toString(){
		String res="context{";
		for(Check c : checkList){
			res+=""+c.toString();
			
		}
		for(Do d : doList){
			res+= " "+d.toString();
		}
		res+=" "+
				"}";
		return res;
	}


}
