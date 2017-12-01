package model;

public class ConstraintOrCritiqueExc extends Throwable {
	
	public ConstraintOrCritiqueExc(String s){
		System.out.println("Label must be 'Critique' or 'Constraint'");
	}

}

