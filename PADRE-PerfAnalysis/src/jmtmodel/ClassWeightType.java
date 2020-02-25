/**
 */
package jmtmodel;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Class Weight Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link jmtmodel.ClassWeightType#getJobClass <em>Job Class</em>}</li>
 *   <li>{@link jmtmodel.ClassWeightType#getWeight <em>Weight</em>}</li>
 * </ul>
 *
 * @see jmtmodel.JmtmodelPackage#getClassWeightType()
 * @model extendedMetaData="name='classWeight_._type' kind='empty'"
 * @generated
 */
public interface ClassWeightType extends EObject {
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
	 * @see jmtmodel.JmtmodelPackage#getClassWeightType_JobClass()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
	 *        extendedMetaData="kind='attribute' name='jobClass' namespace='##targetNamespace'"
	 * @generated
	 */
	String getJobClass();

	/**
	 * Sets the value of the '{@link jmtmodel.ClassWeightType#getJobClass <em>Job Class</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Job Class</em>' attribute.
	 * @see #getJobClass()
	 * @generated
	 */
	void setJobClass(String value);

	/**
	 * Returns the value of the '<em><b>Weight</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Weight</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Weight</em>' attribute.
	 * @see #isSetWeight()
	 * @see #unsetWeight()
	 * @see #setWeight(double)
	 * @see jmtmodel.JmtmodelPackage#getClassWeightType_Weight()
	 * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Double" required="true"
	 *        extendedMetaData="kind='attribute' name='weight' namespace='##targetNamespace'"
	 * @generated
	 */
	double getWeight();

	/**
	 * Sets the value of the '{@link jmtmodel.ClassWeightType#getWeight <em>Weight</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Weight</em>' attribute.
	 * @see #isSetWeight()
	 * @see #unsetWeight()
	 * @see #getWeight()
	 * @generated
	 */
	void setWeight(double value);

	/**
	 * Unsets the value of the '{@link jmtmodel.ClassWeightType#getWeight <em>Weight</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetWeight()
	 * @see #getWeight()
	 * @see #setWeight(double)
	 * @generated
	 */
	void unsetWeight();

	/**
	 * Returns whether the value of the '{@link jmtmodel.ClassWeightType#getWeight <em>Weight</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Weight</em>' attribute is set.
	 * @see #unsetWeight()
	 * @see #getWeight()
	 * @see #setWeight(double)
	 * @generated
	 */
	boolean isSetWeight();

} // ClassWeightType
