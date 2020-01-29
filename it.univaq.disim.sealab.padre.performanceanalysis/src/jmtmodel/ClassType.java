/**
 */
package jmtmodel;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Class Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link jmtmodel.ClassType#getName <em>Name</em>}</li>
 *   <li>{@link jmtmodel.ClassType#getRefStation <em>Ref Station</em>}</li>
 * </ul>
 *
 * @see jmtmodel.JmtmodelPackage#getClassType()
 * @model extendedMetaData="name='class_._type' kind='empty'"
 * @generated
 */
public interface ClassType extends EObject {
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
	 * @see jmtmodel.JmtmodelPackage#getClassType_Name()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
	 *        extendedMetaData="kind='attribute' name='name' namespace='##targetNamespace'"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link jmtmodel.ClassType#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Ref Station</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ref Station</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ref Station</em>' attribute.
	 * @see #isSetRefStation()
	 * @see #unsetRefStation()
	 * @see #setRefStation(String)
	 * @see jmtmodel.JmtmodelPackage#getClassType_RefStation()
	 * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
	 *        extendedMetaData="kind='attribute' name='refStation' namespace='##targetNamespace'"
	 * @generated
	 */
	String getRefStation();

	/**
	 * Sets the value of the '{@link jmtmodel.ClassType#getRefStation <em>Ref Station</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ref Station</em>' attribute.
	 * @see #isSetRefStation()
	 * @see #unsetRefStation()
	 * @see #getRefStation()
	 * @generated
	 */
	void setRefStation(String value);

	/**
	 * Unsets the value of the '{@link jmtmodel.ClassType#getRefStation <em>Ref Station</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetRefStation()
	 * @see #getRefStation()
	 * @see #setRefStation(String)
	 * @generated
	 */
	void unsetRefStation();

	/**
	 * Returns whether the value of the '{@link jmtmodel.ClassType#getRefStation <em>Ref Station</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Ref Station</em>' attribute is set.
	 * @see #unsetRefStation()
	 * @see #getRefStation()
	 * @see #setRefStation(String)
	 * @generated
	 */
	boolean isSetRefStation();

} // ClassType
