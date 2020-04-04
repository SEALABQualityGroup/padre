/**
 */
package jmtmodel.impl;

import java.util.Collection;

import jmtmodel.ClassresultsType1;
import jmtmodel.JmtmodelPackage;
import jmtmodel.MeasureType1;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Classresults Type1</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link jmtmodel.impl.ClassresultsType1Impl#getMeasure <em>Measure</em>}</li>
 *   <li>{@link jmtmodel.impl.ClassresultsType1Impl#getCustomerclass <em>Customerclass</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ClassresultsType1Impl extends MinimalEObjectImpl.Container implements ClassresultsType1 {
	/**
	 * The cached value of the '{@link #getMeasure() <em>Measure</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMeasure()
	 * @generated
	 * @ordered
	 */
	protected EList<MeasureType1> measure;

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
	protected ClassresultsType1Impl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return JmtmodelPackage.Literals.CLASSRESULTS_TYPE1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<MeasureType1> getMeasure() {
		if (measure == null) {
			measure = new EObjectContainmentEList<MeasureType1>(MeasureType1.class, this, JmtmodelPackage.CLASSRESULTS_TYPE1__MEASURE);
		}
		return measure;
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
			eNotify(new ENotificationImpl(this, Notification.SET, JmtmodelPackage.CLASSRESULTS_TYPE1__CUSTOMERCLASS, oldCustomerclass, customerclass));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case JmtmodelPackage.CLASSRESULTS_TYPE1__MEASURE:
				return ((InternalEList<?>)getMeasure()).basicRemove(otherEnd, msgs);
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
			case JmtmodelPackage.CLASSRESULTS_TYPE1__MEASURE:
				return getMeasure();
			case JmtmodelPackage.CLASSRESULTS_TYPE1__CUSTOMERCLASS:
				return getCustomerclass();
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
			case JmtmodelPackage.CLASSRESULTS_TYPE1__MEASURE:
				getMeasure().clear();
				getMeasure().addAll((Collection<? extends MeasureType1>)newValue);
				return;
			case JmtmodelPackage.CLASSRESULTS_TYPE1__CUSTOMERCLASS:
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
			case JmtmodelPackage.CLASSRESULTS_TYPE1__MEASURE:
				getMeasure().clear();
				return;
			case JmtmodelPackage.CLASSRESULTS_TYPE1__CUSTOMERCLASS:
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
			case JmtmodelPackage.CLASSRESULTS_TYPE1__MEASURE:
				return measure != null && !measure.isEmpty();
			case JmtmodelPackage.CLASSRESULTS_TYPE1__CUSTOMERCLASS:
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
		result.append(" (customerclass: ");
		result.append(customerclass);
		result.append(')');
		return result.toString();
	}

} //ClassresultsType1Impl
