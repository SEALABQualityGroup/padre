/**
 */
package jmtmodel;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Drop Rules Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link jmtmodel.DropRulesType#isDropThisClass <em>Drop This Class</em>}</li>
 *   <li>{@link jmtmodel.DropRulesType#getJobClass <em>Job Class</em>}</li>
 * </ul>
 *
 * @see jmtmodel.JmtmodelPackage#getDropRulesType()
 * @model extendedMetaData="name='dropRules_._type' kind='empty'"
 * @generated
 */
public interface DropRulesType extends EObject {
	/**
	 * Returns the value of the '<em><b>Drop This Class</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Drop This Class</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Drop This Class</em>' attribute.
	 * @see #isSetDropThisClass()
	 * @see #unsetDropThisClass()
	 * @see #setDropThisClass(boolean)
	 * @see jmtmodel.JmtmodelPackage#getDropRulesType_DropThisClass()
	 * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Boolean" required="true"
	 *        extendedMetaData="kind='attribute' name='dropThisClass' namespace='##targetNamespace'"
	 * @generated
	 */
	boolean isDropThisClass();

	/**
	 * Sets the value of the '{@link jmtmodel.DropRulesType#isDropThisClass <em>Drop This Class</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Drop This Class</em>' attribute.
	 * @see #isSetDropThisClass()
	 * @see #unsetDropThisClass()
	 * @see #isDropThisClass()
	 * @generated
	 */
	void setDropThisClass(boolean value);

	/**
	 * Unsets the value of the '{@link jmtmodel.DropRulesType#isDropThisClass <em>Drop This Class</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetDropThisClass()
	 * @see #isDropThisClass()
	 * @see #setDropThisClass(boolean)
	 * @generated
	 */
	void unsetDropThisClass();

	/**
	 * Returns whether the value of the '{@link jmtmodel.DropRulesType#isDropThisClass <em>Drop This Class</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Drop This Class</em>' attribute is set.
	 * @see #unsetDropThisClass()
	 * @see #isDropThisClass()
	 * @see #setDropThisClass(boolean)
	 * @generated
	 */
	boolean isSetDropThisClass();

	/**
	 * Returns the value of the '<em><b>Job Class</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Job Class</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Job Class</em>' attribute.
	 * @see #setJobClass(String)
	 * @see jmtmodel.JmtmodelPackage#getDropRulesType_JobClass()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
	 *        extendedMetaData="kind='attribute' name='jobClass' namespace='##targetNamespace'"
	 * @generated
	 */
	String getJobClass();

	/**
	 * Sets the value of the '{@link jmtmodel.DropRulesType#getJobClass <em>Job Class</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Job Class</em>' attribute.
	 * @see #getJobClass()
	 * @generated
	 */
	void setJobClass(String value);

} // DropRulesType
