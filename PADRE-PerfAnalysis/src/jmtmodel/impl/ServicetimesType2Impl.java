/**
 */
package jmtmodel.impl;

import java.util.Collection;

import jmtmodel.JmtmodelPackage;
import jmtmodel.ServicetimesType;
import jmtmodel.ServicetimesType2;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Servicetimes Type2</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link jmtmodel.impl.ServicetimesType2Impl#getServicetimes <em>Servicetimes</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ServicetimesType2Impl extends MinimalEObjectImpl.Container implements ServicetimesType2 {
	/**
	 * The cached value of the '{@link #getServicetimes() <em>Servicetimes</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getServicetimes()
	 * @generated
	 * @ordered
	 */
	protected EList<ServicetimesType> servicetimes;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ServicetimesType2Impl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return JmtmodelPackage.Literals.SERVICETIMES_TYPE2;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ServicetimesType> getServicetimes() {
		if (servicetimes == null) {
			servicetimes = new EObjectContainmentEList<ServicetimesType>(ServicetimesType.class, this, JmtmodelPackage.SERVICETIMES_TYPE2__SERVICETIMES);
		}
		return servicetimes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case JmtmodelPackage.SERVICETIMES_TYPE2__SERVICETIMES:
				return ((InternalEList<?>)getServicetimes()).basicRemove(otherEnd, msgs);
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
			case JmtmodelPackage.SERVICETIMES_TYPE2__SERVICETIMES:
				return getServicetimes();
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
			case JmtmodelPackage.SERVICETIMES_TYPE2__SERVICETIMES:
				getServicetimes().clear();
				getServicetimes().addAll((Collection<? extends ServicetimesType>)newValue);
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
			case JmtmodelPackage.SERVICETIMES_TYPE2__SERVICETIMES:
				getServicetimes().clear();
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
			case JmtmodelPackage.SERVICETIMES_TYPE2__SERVICETIMES:
				return servicetimes != null && !servicetimes.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ServicetimesType2Impl
