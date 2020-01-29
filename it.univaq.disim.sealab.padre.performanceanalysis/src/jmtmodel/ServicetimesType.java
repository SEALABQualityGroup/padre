/**
 */
package jmtmodel;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Servicetimes Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link jmtmodel.ServicetimesType#getValue <em>Value</em>}</li>
 *   <li>{@link jmtmodel.ServicetimesType#getCustomerclass <em>Customerclass</em>}</li>
 * </ul>
 *
 * @see jmtmodel.JmtmodelPackage#getServicetimesType()
 * @model extendedMetaData="name='servicetimes_._type' kind='simple'"
 * @generated
 */
public interface ServicetimesType extends EObject {
	/**
	 * Returns the value of the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' attribute.
	 * @see #setValue(String)
	 * @see jmtmodel.JmtmodelPackage#getServicetimesType_Value()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="name=':0' kind='simple'"
	 * @generated
	 */
	String getValue();

	/**
	 * Sets the value of the '{@link jmtmodel.ServicetimesType#getValue <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' attribute.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(String value);

	/**
	 * Returns the value of the '<em><b>Customerclass</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Customerclass</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Customerclass</em>' attribute.
	 * @see #setCustomerclass(String)
	 * @see jmtmodel.JmtmodelPackage#getServicetimesType_Customerclass()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
	 *        extendedMetaData="kind='attribute' name='customerclass' namespace='##targetNamespace'"
	 * @generated
	 */
	String getCustomerclass();

	/**
	 * Sets the value of the '{@link jmtmodel.ServicetimesType#getCustomerclass <em>Customerclass</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Customerclass</em>' attribute.
	 * @see #getCustomerclass()
	 * @generated
	 */
	void setCustomerclass(String value);

} // ServicetimesType
