/**
 */
package jmtmodel;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Visits Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link jmtmodel.VisitsType#getVisit <em>Visit</em>}</li>
 * </ul>
 *
 * @see jmtmodel.JmtmodelPackage#getVisitsType()
 * @model extendedMetaData="name='visits_._type' kind='elementOnly'"
 * @generated
 */
public interface VisitsType extends EObject {
	/**
	 * Returns the value of the '<em><b>Visit</b></em>' containment reference list.
	 * The list contents are of type {@link jmtmodel.VisitType1}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Visit</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Visit</em>' containment reference list.
	 * @see jmtmodel.JmtmodelPackage#getVisitsType_Visit()
	 * @model containment="true" required="true"
	 *        extendedMetaData="kind='element' name='visit' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<VisitType1> getVisit();

} // VisitsType
