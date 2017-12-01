package model;

import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlTransient;

/** *
 *This class represents a single "Predicate" in the Check's Guard.
 *A predicate can be of two types:
 *{@link BinaryPredicate} 
 *{@link UnaryPredicate} 
 *@author Davide Di Gironimo
 *
 */
@XmlTransient
@XmlSeeAlso({BinaryPredicate.class,UnaryPredicate.class})
public class Predicate{

	public Predicate(){
		
	}
	

}
