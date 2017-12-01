package model;

import java.util.List;

public class Evl {
	private Evl parent ;
	private List<Context> contextList;
	
	public Evl(){
		parent=this;
	}
	public List<Context> getContextList() {
		return contextList;
	}
	public void setContextList(List<Context> contextList) {
		this.contextList = contextList;
		this.parent=parent;
	}
	public void addContext(Context context){
		contextList.add(context);
		
	}
	//passare oggetto
	public boolean removeContext(String contextName){
		for(Context c : this.getContextList()){
			if(c.getName().equals(contextName)){
				return contextList.remove(c);
			}
				
		}
		return false;
	}
	public void addCheckToContext(Context context , Check check){
		for(Context c : this.getContextList()){
			if (c.equals(context)) {
				c.addCheck(check, this);
				
			}
		}
	}
	public void addDoToContext(Context context , Do d){
		for(Context c : this.getContextList()){
			if (c.equals(context)) {
				c.addDo(d, this);
				
			}
		}
	}
	public void removeCheckFromContext(Context context, Check check){
		for(Context c : this.getContextList()){
			if (c.equals(context)) {
				c.removeCheck(check.getName());
			}
				
			
		}
		
	}
	public void removeDoFromContext(Context context , Do d){
		for(Context c : this.getContextList()){
			if (c.equals(context)) {
				c.removeDo(d.getName());
			}
				
			
		}
		
		
	}
	public String toString(){
		String s="";
			for(Context c: contextList){
				s+= c.toString();
			
		}
			return s;
	}
}
