/**
 */
package jmtmodel.impl;

import jmtmodel.ClassWeightType;
import jmtmodel.JmtmodelPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Class Weight Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link jmtmodel.impl.ClassWeightTypeImpl#getJobClass <em>Job Class</em>}</li>
 *   <li>{@link jmtmodel.impl.ClassWeightTypeImpl#getWeight <em>Weight</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ClassWeightTypeImpl extends MinimalEObjectImpl.Container implements ClassWeightType {
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
	 * The default value of the '{@link #getWeight() <em>Weight</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWeight()
	 * @generated
	 * @ordered
	 */
	protected static final double WEIGHT_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getWeight() <em>Weight</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWeight()
	 * @generated
	 * @ordered
	 */
	protected double weight = WEIGHT_EDEFAULT;

	/**
	 * This is true if the Weight attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean weightESet;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ClassWeightTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return JmtmodelPackage.Literals.CLASS_WEIGHT_TYPE;
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
			eNotify(new ENotificationImpl(this, Notification.SET, JmtmodelPackage.CLASS_WEIGHT_TYPE__JOB_CLASS, oldJobClass, jobClass));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getWeight() {
		return weight;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWeight(double newWeight) {
		double oldWeight = weight;
		weight = newWeight;
		boolean oldWeightESet = weightESet;
		weightESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JmtmodelPackage.CLASS_WEIGHT_TYPE__WEIGHT, oldWeight, weight, !oldWeightESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetWeight() {
		double oldWeight = weight;
		boolean oldWeightESet = weightESet;
		weight = WEIGHT_EDEFAULT;
		weightESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, JmtmodelPackage.CLASS_WEIGHT_TYPE__WEIGHT, oldWeight, WEIGHT_EDEFAULT, oldWeightESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetWeight() {
		return weightESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case JmtmodelPackage.CLASS_WEIGHT_TYPE__JOB_CLASS:
				return getJobClass();
			case JmtmodelPackage.CLASS_WEIGHT_TYPE__WEIGHT:
				return getWeight();
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
			case JmtmodelPackage.CLASS_WEIGHT_TYPE__JOB_CLASS:
				setJobClass((String)newValue);
				return;
			case JmtmodelPackage.CLASS_WEIGHT_TYPE__WEIGHT:
				setWeight((Double)newValue);
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
			case JmtmodelPackage.CLASS_WEIGHT_TYPE__JOB_CLASS:
				setJobClass(JOB_CLASS_EDEFAULT);
				return;
			case JmtmodelPackage.CLASS_WEIGHT_TYPE__WEIGHT:
				unsetWeight();
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
			case JmtmodelPackage.CLASS_WEIGHT_TYPE__JOB_CLASS:
				return JOB_CLASS_EDEFAULT == null ? jobClass != null : !JOB_CLASS_EDEFAULT.equals(jobClass);
			case JmtmodelPackage.CLASS_WEIGHT_TYPE__WEIGHT:
				return isSetWeight();
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
		result.append(", weight: ");
		if (weightESet) result.append(weight); else result.append("<unset>");
		result.append(')');
		return result.toString();
	}

} //ClassWeightTypeImpl
