/**
 */
package jmtmodel.impl;

import jmtmodel.DropRulesType;
import jmtmodel.JmtmodelPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Drop Rules Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link jmtmodel.impl.DropRulesTypeImpl#isDropThisClass <em>Drop This Class</em>}</li>
 *   <li>{@link jmtmodel.impl.DropRulesTypeImpl#getJobClass <em>Job Class</em>}</li>
 * </ul>
 *
 * @generated
 */
public class DropRulesTypeImpl extends MinimalEObjectImpl.Container implements DropRulesType {
	/**
	 * The default value of the '{@link #isDropThisClass() <em>Drop This Class</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isDropThisClass()
	 * @generated
	 * @ordered
	 */
	protected static final boolean DROP_THIS_CLASS_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isDropThisClass() <em>Drop This Class</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isDropThisClass()
	 * @generated
	 * @ordered
	 */
	protected boolean dropThisClass = DROP_THIS_CLASS_EDEFAULT;

	/**
	 * This is true if the Drop This Class attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean dropThisClassESet;

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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DropRulesTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return JmtmodelPackage.Literals.DROP_RULES_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isDropThisClass() {
		return dropThisClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDropThisClass(boolean newDropThisClass) {
		boolean oldDropThisClass = dropThisClass;
		dropThisClass = newDropThisClass;
		boolean oldDropThisClassESet = dropThisClassESet;
		dropThisClassESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JmtmodelPackage.DROP_RULES_TYPE__DROP_THIS_CLASS, oldDropThisClass, dropThisClass, !oldDropThisClassESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetDropThisClass() {
		boolean oldDropThisClass = dropThisClass;
		boolean oldDropThisClassESet = dropThisClassESet;
		dropThisClass = DROP_THIS_CLASS_EDEFAULT;
		dropThisClassESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, JmtmodelPackage.DROP_RULES_TYPE__DROP_THIS_CLASS, oldDropThisClass, DROP_THIS_CLASS_EDEFAULT, oldDropThisClassESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetDropThisClass() {
		return dropThisClassESet;
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
			eNotify(new ENotificationImpl(this, Notification.SET, JmtmodelPackage.DROP_RULES_TYPE__JOB_CLASS, oldJobClass, jobClass));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case JmtmodelPackage.DROP_RULES_TYPE__DROP_THIS_CLASS:
				return isDropThisClass();
			case JmtmodelPackage.DROP_RULES_TYPE__JOB_CLASS:
				return getJobClass();
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
			case JmtmodelPackage.DROP_RULES_TYPE__DROP_THIS_CLASS:
				setDropThisClass((Boolean)newValue);
				return;
			case JmtmodelPackage.DROP_RULES_TYPE__JOB_CLASS:
				setJobClass((String)newValue);
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
			case JmtmodelPackage.DROP_RULES_TYPE__DROP_THIS_CLASS:
				unsetDropThisClass();
				return;
			case JmtmodelPackage.DROP_RULES_TYPE__JOB_CLASS:
				setJobClass(JOB_CLASS_EDEFAULT);
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
			case JmtmodelPackage.DROP_RULES_TYPE__DROP_THIS_CLASS:
				return isSetDropThisClass();
			case JmtmodelPackage.DROP_RULES_TYPE__JOB_CLASS:
				return JOB_CLASS_EDEFAULT == null ? jobClass != null : !JOB_CLASS_EDEFAULT.equals(jobClass);
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
		result.append(" (dropThisClass: ");
		if (dropThisClassESet) result.append(dropThisClass); else result.append("<unset>");
		result.append(", jobClass: ");
		result.append(jobClass);
		result.append(')');
		return result.toString();
	}

} //DropRulesTypeImpl
