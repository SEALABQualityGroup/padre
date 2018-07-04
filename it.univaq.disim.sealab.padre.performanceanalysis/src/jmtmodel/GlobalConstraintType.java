/**
 */
package jmtmodel;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Global Constraint Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link jmtmodel.GlobalConstraintType#getMaxJobs <em>Max Jobs</em>}</li>
 * </ul>
 *
 * @see jmtmodel.JmtmodelPackage#getGlobalConstraintType()
 * @model extendedMetaData="name='globalConstraint_._type' kind='empty'"
 * @generated
 */
public interface GlobalConstraintType extends EObject {
	/**
	 * Returns the value of the '<em><b>Max Jobs</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Max Jobs</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Max Jobs</em>' attribute.
	 * @see #isSetMaxJobs()
	 * @see #unsetMaxJobs()
	 * @see #setMaxJobs(double)
	 * @see jmtmodel.JmtmodelPackage#getGlobalConstraintType_MaxJobs()
	 * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Double" required="true"
	 *        extendedMetaData="kind='attribute' name='maxJobs' namespace='##targetNamespace'"
	 * @generated
	 */
	double getMaxJobs();

	/**
	 * Sets the value of the '{@link jmtmodel.GlobalConstraintType#getMaxJobs <em>Max Jobs</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Max Jobs</em>' attribute.
	 * @see #isSetMaxJobs()
	 * @see #unsetMaxJobs()
	 * @see #getMaxJobs()
	 * @generated
	 */
	void setMaxJobs(double value);

	/**
	 * Unsets the value of the '{@link jmtmodel.GlobalConstraintType#getMaxJobs <em>Max Jobs</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetMaxJobs()
	 * @see #getMaxJobs()
	 * @see #setMaxJobs(double)
	 * @generated
	 */
	void unsetMaxJobs();

	/**
	 * Returns whether the value of the '{@link jmtmodel.GlobalConstraintType#getMaxJobs <em>Max Jobs</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Max Jobs</em>' attribute is set.
	 * @see #unsetMaxJobs()
	 * @see #getMaxJobs()
	 * @see #setMaxJobs(double)
	 * @generated
	 */
	boolean isSetMaxJobs();

} // GlobalConstraintType
