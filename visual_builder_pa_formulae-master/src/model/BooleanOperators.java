package model;

/**
 * It enumerates main boolean operators
 *
 */
public enum BooleanOperators {

	NOT, AND, NAND, OR, NOR, XOR, EMPTY;

	public String toString() {
		switch (this) {
		case NOT:
			return "not";
		case AND:
			return "and";
		case NAND:
			return "and not";
		case OR:
			return "or";
		case NOR:
			return "or not";
		case XOR:
			return "xor";
		case EMPTY:
			return "";
		}
		return "";
	}

}
