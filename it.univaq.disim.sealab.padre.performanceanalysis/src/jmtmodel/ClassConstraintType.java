/**
 */
package jmtmodel;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Class Constraint Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link jmtmodel.ClassConstraintType#getJobClass <em>Job Class</em>}</li>
 *   <li>{@link jmtmodel.ClassConstraintType#getMaxJobsPerClass <em>Max Jobs Per Class</em>}</li>
 * </ul>
 *
 * @see jmtmodel.JmtmodelPackage#getClassConstraintType()
 * @model extendedMetaData="name='classConstraint_._type' kind='empty'"
 * @generated
 */
public interface ClassConstraintType extends EObject {
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
	 * @see jmtmodel.JmtmodelPackage#getClassConstraintType_JobClass()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
	 *        extendedMetaData="kind='attribute' name='jobClass' namespace='##targetNamespace'"
	 * @generated
	 */
	String getJobClass();

	/**
	 * Sets the value of the '{@link jmtmodel.ClassConstraintType#getJobClass <em>Job Class</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Job Class</em>' attribute.
	 * @see #getJobClass()
	 * @generated
	 */
	void setJobClass(String value);

	/**
	 * Returns the value of the '<em><b>Max Jobs Per Class</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Max Jobs Per Class</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Max Jobs Per Class</em>' attribute.
	 * @see #isSetMaxJobsPerClass()
	 * @see #unsetMaxJobsPerClass()
	 * @see #setMaxJobsPerClass(double)
	 * @see jmtmodel.JmtmodelPackage#getClassConstraintType_MaxJobsPerClass()
	 * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Double" required="true"
	 *        extendedMetaData="kind='attribute' name='maxJobsPerClass' namespace='##targetNamespace'"
	 * @generated
	 */
	double getMaxJobsPerClass();

	/**
	 * Sets the value of the '{@link jmtmodel.ClassConstraintType#getMaxJobsPerClass <em>Max Jobs Per Class</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Max Jobs Per Class</em>' attribute.
	 * @see #isSetMaxJobsPerClass()
	 * @see #unsetMaxJobsPerClass()
	 * @see #getMaxJobsPerClass()
	 * @generated
	 */
	void setMaxJobsPerClass(double value);

	/**
	 * Unsets the value of the '{@link jmtmodel.ClassConstraintType#getMaxJobsPerClass <em>Max Jobs Per Class</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetMaxJobsPerClass()
	 * @see #getMaxJobsPerClass()
	 * @see #setMaxJobsPerClass(double)
	 * @generated
	 */
	void unsetMaxJobsPerClass();

	/**
	 * Returns whether the value of the '{@link jmtmodel.ClassConstraintType#getMaxJobsPerClass <em>Max Jobs Per Class</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Max Jobs Per Class</em>' attribute is set.
	 * @see #unsetMaxJobsPerClass()
	 * @see #getMaxJobsPerClass()
	 * @see #setMaxJobsPerClass(double)
	 * @generated
	 */
	boolean isSetMaxJobsPerClass();

} // ClassConstraintType
