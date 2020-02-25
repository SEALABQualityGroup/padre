/**
 */
package jmtmodel.impl;

import jmtmodel.GlobalConstraintType;
import jmtmodel.JmtmodelPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Global Constraint Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link jmtmodel.impl.GlobalConstraintTypeImpl#getMaxJobs <em>Max Jobs</em>}</li>
 * </ul>
 *
 * @generated
 */
public class GlobalConstraintTypeImpl extends MinimalEObjectImpl.Container implements GlobalConstraintType {
	/**
	 * The default value of the '{@link #getMaxJobs() <em>Max Jobs</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxJobs()
	 * @generated
	 * @ordered
	 */
	protected static final double MAX_JOBS_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getMaxJobs() <em>Max Jobs</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxJobs()
	 * @generated
	 * @ordered
	 */
	protected double maxJobs = MAX_JOBS_EDEFAULT;

	/**
	 * This is true if the Max Jobs attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean maxJobsESet;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GlobalConstraintTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return JmtmodelPackage.Literals.GLOBAL_CONSTRAINT_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getMaxJobs() {
		return maxJobs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMaxJobs(double newMaxJobs) {
		double oldMaxJobs = maxJobs;
		maxJobs = newMaxJobs;
		boolean oldMaxJobsESet = maxJobsESet;
		maxJobsESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JmtmodelPackage.GLOBAL_CONSTRAINT_TYPE__MAX_JOBS, oldMaxJobs, maxJobs, !oldMaxJobsESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetMaxJobs() {
		double oldMaxJobs = maxJobs;
		boolean oldMaxJobsESet = maxJobsESet;
		maxJobs = MAX_JOBS_EDEFAULT;
		maxJobsESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, JmtmodelPackage.GLOBAL_CONSTRAINT_TYPE__MAX_JOBS, oldMaxJobs, MAX_JOBS_EDEFAULT, oldMaxJobsESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetMaxJobs() {
		return maxJobsESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case JmtmodelPackage.GLOBAL_CONSTRAINT_TYPE__MAX_JOBS:
				return getMaxJobs();
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
			case JmtmodelPackage.GLOBAL_CONSTRAINT_TYPE__MAX_JOBS:
				setMaxJobs((Double)newValue);
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
			case JmtmodelPackage.GLOBAL_CONSTRAINT_TYPE__MAX_JOBS:
				unsetMaxJobs();
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
			case JmtmodelPackage.GLOBAL_CONSTRAINT_TYPE__MAX_JOBS:
				return isSetMaxJobs();
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
		result.append(" (maxJobs: ");
		if (maxJobsESet) result.append(maxJobs); else result.append("<unset>");
		result.append(')');
		return result.toString();
	}

} //GlobalConstraintTypeImpl
