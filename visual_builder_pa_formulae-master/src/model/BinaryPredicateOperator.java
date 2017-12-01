package model;

public enum BinaryPredicateOperator {
	GREATER, GREATER_OR_EQUAL, LOWER, LOWER_OR_EQUAL, EQUAL, DIFFERENT , EMPTY;
	public String toString() { 
		switch (this) {
		case EMPTY:
			return "";
		case GREATER:
			return">";
		case GREATER_OR_EQUAL:
			return">=";
		case LOWER:
			return "<";
		case LOWER_OR_EQUAL:
			return "<=";
		case EQUAL:
			return "=";
		case DIFFERENT:
			return "<>";
		}
	return "";
	}
	

}
