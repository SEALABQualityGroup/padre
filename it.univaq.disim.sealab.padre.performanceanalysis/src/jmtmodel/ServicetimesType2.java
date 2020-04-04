/**
 */
package jmtmodel;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Servicetimes Type2</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link jmtmodel.ServicetimesType2#getServicetimes <em>Servicetimes</em>}</li>
 * </ul>
 *
 * @see jmtmodel.JmtmodelPackage#getServicetimesType2()
 * @model extendedMetaData="name='servicetimes_._2_._type' kind='elementOnly'"
 * @generated
 */
public interface ServicetimesType2 extends EObject {
	/**
	 * Returns the value of the '<em><b>Servicetimes</b></em>' containment reference list.
	 * The list contents are of type {@link jmtmodel.ServicetimesType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Servicetimes</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Servicetimes</em>' containment reference list.
	 * @see jmtmodel.JmtmodelPackage#getServicetimesType2_Servicetimes()
	 * @model containment="true" required="true"
	 *        extendedMetaData="kind='element' name='servicetimes' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<ServicetimesType> getServicetimes();

} // ServicetimesType2
