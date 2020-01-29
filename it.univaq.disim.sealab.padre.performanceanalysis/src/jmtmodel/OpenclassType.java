/**
 */
package jmtmodel;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Openclass Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link jmtmodel.OpenclassType#getName <em>Name</em>}</li>
 *   <li>{@link jmtmodel.OpenclassType#getRate <em>Rate</em>}</li>
 * </ul>
 *
 * @see jmtmodel.JmtmodelPackage#getOpenclassType()
 * @model extendedMetaData="name='openclass_._type' kind='empty'"
 * @generated
 */
public interface OpenclassType extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see jmtmodel.JmtmodelPackage#getOpenclassType_Name()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
	 *        extendedMetaData="kind='attribute' name='name' namespace='##targetNamespace'"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link jmtmodel.OpenclassType#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Rate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rate</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rate</em>' attribute.
	 * @see #isSetRate()
	 * @see #unsetRate()
	 * @see #setRate(double)
	 * @see jmtmodel.JmtmodelPackage#getOpenclassType_Rate()
	 * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Double" required="true"
	 *        extendedMetaData="kind='attribute' name='rate' namespace='##targetNamespace'"
	 * @generated
	 */
	double getRate();

	/**
	 * Sets the value of the '{@link jmtmodel.OpenclassType#getRate <em>Rate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rate</em>' attribute.
	 * @see #isSetRate()
	 * @see #unsetRate()
	 * @see #getRate()
	 * @generated
	 */
	void setRate(double value);

	/**
	 * Unsets the value of the '{@link jmtmodel.OpenclassType#getRate <em>Rate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetRate()
	 * @see #getRate()
	 * @see #setRate(double)
	 * @generated
	 */
	void unsetRate();

	/**
	 * Returns whether the value of the '{@link jmtmodel.OpenclassType#getRate <em>Rate</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Rate</em>' attribute is set.
	 * @see #unsetRate()
	 * @see #getRate()
	 * @see #setRate(double)
	 * @generated
	 */
	boolean isSetRate();

} // OpenclassType
