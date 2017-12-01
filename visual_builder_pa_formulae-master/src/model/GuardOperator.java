package model;

public enum GuardOperator {
	AND,OR,XOR,EMPTY;
	public String toString(){
		switch (this) {
		case AND:
			return "and";
		case OR:
			return "or";
		case XOR:
			return "xor";
		case EMPTY:
			return "";
			

		
		}
		return "";
	}

}
