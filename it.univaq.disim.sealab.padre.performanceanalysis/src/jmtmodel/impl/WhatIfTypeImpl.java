/**
 */
package jmtmodel.impl;

import jmtmodel.JmtmodelPackage;
import jmtmodel.WhatIfType;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>What If Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link jmtmodel.impl.WhatIfTypeImpl#getClassName <em>Class Name</em>}</li>
 *   <li>{@link jmtmodel.impl.WhatIfTypeImpl#getStationName <em>Station Name</em>}</li>
 *   <li>{@link jmtmodel.impl.WhatIfTypeImpl#getType <em>Type</em>}</li>
 *   <li>{@link jmtmodel.impl.WhatIfTypeImpl#getValues <em>Values</em>}</li>
 * </ul>
 *
 * @generated
 */
public class WhatIfTypeImpl extends MinimalEObjectImpl.Container implements WhatIfType {
	/**
	 * The default value of the '{@link #getClassName() <em>Class Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClassName()
	 * @generated
	 * @ordered
	 */
	protected static final String CLASS_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getClassName() <em>Class Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClassName()
	 * @generated
	 * @ordered
	 */
	protected String className = CLASS_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getStationName() <em>Station Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStationName()
	 * @generated
	 * @ordered
	 */
	protected static final String STATION_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getStationName() <em>Station Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStationName()
	 * @generated
	 * @ordered
	 */
	protected String stationName = STATION_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected static final String TYPE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected String type = TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getValues() <em>Values</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValues()
	 * @generated
	 * @ordered
	 */
	protected static final String VALUES_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getValues() <em>Values</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValues()
	 * @generated
	 * @ordered
	 */
	protected String values = VALUES_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected WhatIfTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return JmtmodelPackage.Literals.WHAT_IF_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getClassName() {
		return className;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setClassName(String newClassName) {
		String oldClassName = className;
		className = newClassName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JmtmodelPackage.WHAT_IF_TYPE__CLASS_NAME, oldClassName, className));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getStationName() {
		return stationName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStationName(String newStationName) {
		String oldStationName = stationName;
		stationName = newStationName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JmtmodelPackage.WHAT_IF_TYPE__STATION_NAME, oldStationName, stationName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(String newType) {
		String oldType = type;
		type = newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JmtmodelPackage.WHAT_IF_TYPE__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getValues() {
		return values;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setValues(String newValues) {
		String oldValues = values;
		values = newValues;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JmtmodelPackage.WHAT_IF_TYPE__VALUES, oldValues, values));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case JmtmodelPackage.WHAT_IF_TYPE__CLASS_NAME:
				return getClassName();
			case JmtmodelPackage.WHAT_IF_TYPE__STATION_NAME:
				return getStationName();
			case JmtmodelPackage.WHAT_IF_TYPE__TYPE:
				return getType();
			case JmtmodelPackage.WHAT_IF_TYPE__VALUES:
				return getValues();
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
			case JmtmodelPackage.WHAT_IF_TYPE__CLASS_NAME:
				setClassName((String)newValue);
				return;
			case JmtmodelPackage.WHAT_IF_TYPE__STATION_NAME:
				setStationName((String)newValue);
				return;
			case JmtmodelPackage.WHAT_IF_TYPE__TYPE:
				setType((String)newValue);
				return;
			case JmtmodelPackage.WHAT_IF_TYPE__VALUES:
				setValues((String)newValue);
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
			case JmtmodelPackage.WHAT_IF_TYPE__CLASS_NAME:
				setClassName(CLASS_NAME_EDEFAULT);
				return;
			case JmtmodelPackage.WHAT_IF_TYPE__STATION_NAME:
				setStationName(STATION_NAME_EDEFAULT);
				return;
			case JmtmodelPackage.WHAT_IF_TYPE__TYPE:
				setType(TYPE_EDEFAULT);
				return;
			case JmtmodelPackage.WHAT_IF_TYPE__VALUES:
				setValues(VALUES_EDEFAULT);
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
			case JmtmodelPackage.WHAT_IF_TYPE__CLASS_NAME:
				return CLASS_NAME_EDEFAULT == null ? className != null : !CLASS_NAME_EDEFAULT.equals(className);
			case JmtmodelPackage.WHAT_IF_TYPE__STATION_NAME:
				return STATION_NAME_EDEFAULT == null ? stationName != null : !STATION_NAME_EDEFAULT.equals(stationName);
			case JmtmodelPackage.WHAT_IF_TYPE__TYPE:
				return TYPE_EDEFAULT == null ? type != null : !TYPE_EDEFAULT.equals(type);
			case JmtmodelPackage.WHAT_IF_TYPE__VALUES:
				return VALUES_EDEFAULT == null ? values != null : !VALUES_EDEFAULT.equals(values);
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
		result.append(" (className: ");
		result.append(className);
		result.append(", stationName: ");
		result.append(stationName);
		result.append(", type: ");
		result.append(type);
		result.append(", values: ");
		result.append(values);
		result.append(')');
		return result.toString();
	}

} //WhatIfTypeImpl
