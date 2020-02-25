/**
 */
package jmtmodel;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Visits Type2</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link jmtmodel.VisitsType2#getVisit <em>Visit</em>}</li>
 * </ul>
 *
 * @see jmtmodel.JmtmodelPackage#getVisitsType2()
 * @model extendedMetaData="name='visits_._2_._type' kind='elementOnly'"
 * @generated
 */
public interface VisitsType2 extends EObject {
	/**
	 * Returns the value of the '<em><b>Visit</b></em>' containment reference list.
	 * The list contents are of type {@link jmtmodel.VisitType2}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Visit</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Visit</em>' containment reference list.
	 * @see jmtmodel.JmtmodelPackage#getVisitsType2_Visit()
	 * @model containment="true" required="true"
	 *        extendedMetaData="kind='element' name='visit' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<VisitType2> getVisit();

} // VisitsType2
