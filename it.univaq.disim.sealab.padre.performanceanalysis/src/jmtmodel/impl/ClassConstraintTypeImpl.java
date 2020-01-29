/**
 */
package jmtmodel.impl;

import jmtmodel.ClassConstraintType;
import jmtmodel.JmtmodelPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Class Constraint Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link jmtmodel.impl.ClassConstraintTypeImpl#getJobClass <em>Job Class</em>}</li>
 *   <li>{@link jmtmodel.impl.ClassConstraintTypeImpl#getMaxJobsPerClass <em>Max Jobs Per Class</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ClassConstraintTypeImpl extends MinimalEObjectImpl.Container implements ClassConstraintType {
	/**
	 * The default value of the '{@link #getJobClass() <em>Job Class</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getJobClass()
	 * @generated
	 * @ordered
	 */
	protected static final String JOB_CLASS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getJobClass() <em>Job Class</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getJobClass()
	 * @generated
	 * @ordered
	 */
	protected String jobClass = JOB_CLASS_EDEFAULT;

	/**
	 * The default value of the '{@link #getMaxJobsPerClass() <em>Max Jobs Per Class</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxJobsPerClass()
	 * @generated
	 * @ordered
	 */
	protected static final double MAX_JOBS_PER_CLASS_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getMaxJobsPerClass() <em>Max Jobs Per Class</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxJobsPerClass()
	 * @generated
	 * @ordered
	 */
	protected double maxJobsPerClass = MAX_JOBS_PER_CLASS_EDEFAULT;

	/**
	 * This is true if the Max Jobs Per Class attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean maxJobsPerClassESet;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ClassConstraintTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return JmtmodelPackage.Literals.CLASS_CONSTRAINT_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getJobClass() {
		return jobClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setJobClass(String newJobClass) {
		String oldJobClass = jobClass;
		jobClass = newJobClass;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JmtmodelPackage.CLASS_CONSTRAINT_TYPE__JOB_CLASS, oldJobClass, jobClass));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getMaxJobsPerClass() {
		return maxJobsPerClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMaxJobsPerClass(double newMaxJobsPerClass) {
		double oldMaxJobsPerClass = maxJobsPerClass;
		maxJobsPerClass = newMaxJobsPerClass;
		boolean oldMaxJobsPerClassESet = maxJobsPerClassESet;
		maxJobsPerClassESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JmtmodelPackage.CLASS_CONSTRAINT_TYPE__MAX_JOBS_PER_CLASS, oldMaxJobsPerClass, maxJobsPerClass, !oldMaxJobsPerClassESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetMaxJobsPerClass() {
		double oldMaxJobsPerClass = maxJobsPerClass;
		boolean oldMaxJobsPerClassESet = maxJobsPerClassESet;
		maxJobsPerClass = MAX_JOBS_PER_CLASS_EDEFAULT;
		maxJobsPerClassESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, JmtmodelPackage.CLASS_CONSTRAINT_TYPE__MAX_JOBS_PER_CLASS, oldMaxJobsPerClass, MAX_JOBS_PER_CLASS_EDEFAULT, oldMaxJobsPerClassESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetMaxJobsPerClass() {
		return maxJobsPerClassESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case JmtmodelPackage.CLASS_CONSTRAINT_TYPE__JOB_CLASS:
				return getJobClass();
			case JmtmodelPackage.CLASS_CONSTRAINT_TYPE__MAX_JOBS_PER_CLASS:
				return getMaxJobsPerClass();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case JmtmodelPackage.CLASS_CONSTRAINT_TYPE__JOB_CLASS:
				setJobClass((String)newValue);
				return;
			case JmtmodelPackage.CLASS_CONSTRAINT_TYPE__MAX_JOBS_PER_CLASS:
				setMaxJobsPerClass((Double)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case JmtmodelPackage.CLASS_CONSTRAINT_TYPE__JOB_CLASS:
				setJobClass(JOB_CLASS_EDEFAULT);
				return;
			case JmtmodelPackage.CLASS_CONSTRAINT_TYPE__MAX_JOBS_PER_CLASS:
				unsetMaxJobsPerClass();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case JmtmodelPackage.CLASS_CONSTRAINT_TYPE__JOB_CLASS:
				return JOB_CLASS_EDEFAULT == null ? jobClass != null : !JOB_CLASS_EDEFAULT.equals(jobClass);
			case JmtmodelPackage.CLASS_CONSTRAINT_TYPE__MAX_JOBS_PER_CLASS:
				return isSetMaxJobsPerClass();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (jobClass: ");
		result.append(jobClass);
		result.append(", maxJobsPerClass: ");
		if (maxJobsPerClassESet) result.append(maxJobsPerClass); else result.append("<unset>");
		result.append(')');
		return result.toString();
	}

} //ClassConstraintTypeImpl
