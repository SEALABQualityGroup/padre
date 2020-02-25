/**
 */
package jmtmodel.impl;

import java.util.Collection;

import jmtmodel.JmtmodelPackage;
import jmtmodel.ServicetimeType1;
import jmtmodel.ServicetimesType3;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Servicetimes Type3</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link jmtmodel.impl.ServicetimesType3Impl#getServicetime <em>Servicetime</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ServicetimesType3Impl extends MinimalEObjectImpl.Container implements ServicetimesType3 {
	/**
	 * The cached value of the '{@link #getServicetime() <em>Servicetime</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getServicetime()
	 * @generated
	 * @ordered
	 */
	protected EList<ServicetimeType1> servicetime;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ServicetimesType3Impl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return JmtmodelPackage.Literals.SERVICETIMES_TYPE3;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ServicetimeType1> getServicetime() {
		if (servicetime == null) {
			servicetime = new EObjectContainmentEList<ServicetimeType1>(ServicetimeType1.class, this, JmtmodelPackage.SERVICETIMES_TYPE3__SERVICETIME);
		}
		return servicetime;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case JmtmodelPackage.SERVICETIMES_TYPE3__SERVICETIME:
				return ((InternalEList<?>)getServicetime()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case JmtmodelPackage.SERVICETIMES_TYPE3__SERVICETIME:
				return getServicetime();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case JmtmodelPackage.SERVICETIMES_TYPE3__SERVICETIME:
				getServicetime().clear();
				getServicetime().addAll((Collection<? extends ServicetimeType1>)newValue);
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
			case JmtmodelPackage.SERVICETIMES_TYPE3__SERVICETIME:
				getServicetime().clear();
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
			case JmtmodelPackage.SERVICETIMES_TYPE3__SERVICETIME:
				return servicetime != null && !servicetime.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ServicetimesType3Impl
