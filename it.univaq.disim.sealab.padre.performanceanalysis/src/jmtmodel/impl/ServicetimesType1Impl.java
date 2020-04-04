/**
 */
package jmtmodel.impl;

import java.util.Collection;

import jmtmodel.JmtmodelPackage;
import jmtmodel.ServicetimeType;
import jmtmodel.ServicetimesType1;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Servicetimes Type1</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link jmtmodel.impl.ServicetimesType1Impl#getServicetime <em>Servicetime</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ServicetimesType1Impl extends MinimalEObjectImpl.Container implements ServicetimesType1 {
	/**
	 * The cached value of the '{@link #getServicetime() <em>Servicetime</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getServicetime()
	 * @generated
	 * @ordered
	 */
	protected EList<ServicetimeType> servicetime;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ServicetimesType1Impl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return JmtmodelPackage.Literals.SERVICETIMES_TYPE1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ServicetimeType> getServicetime() {
		if (servicetime == null) {
			servicetime = new EObjectContainmentEList<ServicetimeType>(ServicetimeType.class, this, JmtmodelPackage.SERVICETIMES_TYPE1__SERVICETIME);
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
			case JmtmodelPackage.SERVICETIMES_TYPE1__SERVICETIME:
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
			case JmtmodelPackage.SERVICETIMES_TYPE1__SERVICETIME:
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
			case JmtmodelPackage.SERVICETIMES_TYPE1__SERVICETIME:
				getServicetime().clear();
				getServicetime().addAll((Collection<? extends ServicetimeType>)newValue);
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
			case JmtmodelPackage.SERVICETIMES_TYPE1__SERVICETIME:
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
			case JmtmodelPackage.SERVICETIMES_TYPE1__SERVICETIME:
				return servicetime != null && !servicetime.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ServicetimesType1Impl
