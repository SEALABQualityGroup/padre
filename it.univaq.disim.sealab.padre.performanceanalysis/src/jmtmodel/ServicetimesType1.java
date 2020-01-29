/**
 */
package jmtmodel;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Servicetimes Type1</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link jmtmodel.ServicetimesType1#getServicetime <em>Servicetime</em>}</li>
 * </ul>
 *
 * @see jmtmodel.JmtmodelPackage#getServicetimesType1()
 * @model extendedMetaData="name='servicetimes_._1_._type' kind='elementOnly'"
 * @generated
 */
public interface ServicetimesType1 extends EObject {
	/**
	 * Returns the value of the '<em><b>Servicetime</b></em>' containment reference list.
	 * The list contents are of type {@link jmtmodel.ServicetimeType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Servicetime</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Servicetime</em>' containment reference list.
	 * @see jmtmodel.JmtmodelPackage#getServicetimesType1_Servicetime()
	 * @model containment="true" required="true"
	 *        extendedMetaData="kind='element' name='servicetime' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<ServicetimeType> getServicetime();

} // ServicetimesType1
