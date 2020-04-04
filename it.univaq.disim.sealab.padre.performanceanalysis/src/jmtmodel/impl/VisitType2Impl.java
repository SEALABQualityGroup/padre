/**
 */
package jmtmodel.impl;

import jmtmodel.JmtmodelPackage;
import jmtmodel.VisitType2;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Visit Type2</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link jmtmodel.impl.VisitType2Impl#getValue <em>Value</em>}</li>
 *   <li>{@link jmtmodel.impl.VisitType2Impl#getCustomerclass <em>Customerclass</em>}</li>
 * </ul>
 *
 * @generated
 */
public class VisitType2Impl extends MinimalEObjectImpl.Container implements VisitType2 {
	/**
	 * The default value of the '{@link #getValue() <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValue()
	 * @generated
	 * @ordered
	 */
	protected static final double VALUE_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getValue() <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValue()
	 * @generated
	 * @ordered
	 */
	protected double value = VALUE_EDEFAULT;

	/**
	 * This is true if the Value attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean valueESet;

	/**
	 * The default value of the '{@link #getCustomerclass() <em>Customerclass</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCustomerclass()
	 * @generated
	 * @ordered
	 */
	protected static final String CUSTOMERCLASS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCustomerclass() <em>Customerclass</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCustomerclass()
	 * @generated
	 * @ordered
	 */
	protected String customerclass = CUSTOMERCLASS_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected VisitType2Impl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return JmtmodelPackage.Literals.VISIT_TYPE2;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getValue() {
		return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setValue(double newValue) {
		double oldValue = value;
		value = newValue;
		boolean oldValueESet = valueESet;
		valueESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JmtmodelPackage.VISIT_TYPE2__VALUE, oldValue, value, !oldValueESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetValue() {
		double oldValue = value;
		boolean oldValueESet = valueESet;
		value = VALUE_EDEFAULT;
		valueESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, JmtmodelPackage.VISIT_TYPE2__VALUE, oldValue, VALUE_EDEFAULT, oldValueESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetValue() {
		return valueESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getCustomerclass() {
		return customerclass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCustomerclass(String newCustomerclass) {
		String oldCustomerclass = customerclass;
		customerclass = newCustomerclass;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JmtmodelPackage.VISIT_TYPE2__CUSTOMERCLASS, oldCustomerclass, customerclass));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case JmtmodelPackage.VISIT_TYPE2__VALUE:
				return getValue();
			case JmtmodelPackage.VISIT_TYPE2__CUSTOMERCLASS:
				return getCustomerclass();
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
			case JmtmodelPackage.VISIT_TYPE2__VALUE:
				setValue((Double)newValue);
				return;
			case JmtmodelPackage.VISIT_TYPE2__CUSTOMERCLASS:
				setCustomerclass((String)newValue);
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
			case JmtmodelPackage.VISIT_TYPE2__VALUE:
				unsetValue();
				return;
			case JmtmodelPackage.VISIT_TYPE2__CUSTOMERCLASS:
				setCustomerclass(CUSTOMERCLASS_EDEFAULT);
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
			case JmtmodelPackage.VISIT_TYPE2__VALUE:
				return isSetValue();
			case JmtmodelPackage.VISIT_TYPE2__CUSTOMERCLASS:
				return CUSTOMERCLASS_EDEFAULT == null ? customerclass != null : !CUSTOMERCLASS_EDEFAULT.equals(customerclass);
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
		result.append(" (value: ");
		if (valueESet) result.append(value); else result.append("<unset>");
		result.append(", customerclass: ");
		result.append(customerclass);
		result.append(')');
		return result.toString();
	}

} //VisitType2Impl
