package model;

public enum UnaryOperator {
	NOT,EMPTY;
	
	public String toString() {
		switch (this) { 
		case NOT:
			return "not";
			
		}
		return "";
	}
	

}
