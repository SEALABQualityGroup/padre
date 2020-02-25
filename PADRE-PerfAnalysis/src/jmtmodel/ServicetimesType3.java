/**
 */
package jmtmodel;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Servicetimes Type3</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link jmtmodel.ServicetimesType3#getServicetime <em>Servicetime</em>}</li>
 * </ul>
 *
 * @see jmtmodel.JmtmodelPackage#getServicetimesType3()
 * @model extendedMetaData="name='servicetimes_._3_._type' kind='elementOnly'"
 * @generated
 */
public interface ServicetimesType3 extends EObject {
	/**
	 * Returns the value of the '<em><b>Servicetime</b></em>' containment reference list.
	 * The list contents are of type {@link jmtmodel.ServicetimeType1}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Servicetime</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Servicetime</em>' containment reference list.
	 * @see jmtmodel.JmtmodelPackage#getServicetimesType3_Servicetime()
	 * @model containment="true" required="true"
	 *        extendedMetaData="kind='element' name='servicetime' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<ServicetimeType1> getServicetime();

} // ServicetimesType3
