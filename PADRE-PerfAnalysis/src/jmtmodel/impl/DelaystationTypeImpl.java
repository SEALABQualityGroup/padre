/**
 */
package jmtmodel.impl;

import jmtmodel.DelaystationType;
import jmtmodel.JmtmodelPackage;
import jmtmodel.ServicetimesType3;
import jmtmodel.VisitsType2;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Delaystation Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link jmtmodel.impl.DelaystationTypeImpl#getServicetimes <em>Servicetimes</em>}</li>
 *   <li>{@link jmtmodel.impl.DelaystationTypeImpl#getVisits <em>Visits</em>}</li>
 *   <li>{@link jmtmodel.impl.DelaystationTypeImpl#getName <em>Name</em>}</li>
 * </ul>
 *
 * @generated
 */
public class DelaystationTypeImpl extends MinimalEObjectImpl.Container implements DelaystationType {
	/**
	 * The cached value of the '{@link #getServicetimes() <em>Servicetimes</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getServicetimes()
	 * @generated
	 * @ordered
	 */
	protected ServicetimesType3 servicetimes;

	/**
	 * The cached value of the '{@link #getVisits() <em>Visits</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVisits()
	 * @generated
	 * @ordered
	 */
	protected VisitsType2 visits;

	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DelaystationTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return JmtmodelPackage.Literals.DELAYSTATION_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ServicetimesType3 getServicetimes() {
		return servicetimes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetServicetimes(ServicetimesType3 newServicetimes, NotificationChain msgs) {
		ServicetimesType3 oldServicetimes = servicetimes;
		servicetimes = newServicetimes;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, JmtmodelPackage.DELAYSTATION_TYPE__SERVICETIMES, oldServicetimes, newServicetimes);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setServicetimes(ServicetimesType3 newServicetimes) {
		if (newServicetimes != servicetimes) {
			NotificationChain msgs = null;
			if (servicetimes != null)
				msgs = ((InternalEObject)servicetimes).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - JmtmodelPackage.DELAYSTATION_TYPE__SERVICETIMES, null, msgs);
			if (newServicetimes != null)
				msgs = ((InternalEObject)newServicetimes).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - JmtmodelPackage.DELAYSTATION_TYPE__SERVICETIMES, null, msgs);
			msgs = basicSetServicetimes(newServicetimes, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JmtmodelPackage.DELAYSTATION_TYPE__SERVICETIMES, newServicetimes, newServicetimes));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VisitsType2 getVisits() {
		return visits;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetVisits(VisitsType2 newVisits, NotificationChain msgs) {
		VisitsType2 oldVisits = visits;
		visits = newVisits;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, JmtmodelPackage.DELAYSTATION_TYPE__VISITS, oldVisits, newVisits);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVisits(VisitsType2 newVisits) {
		if (newVisits != visits) {
			NotificationChain msgs = null;
			if (visits != null)
				msgs = ((InternalEObject)visits).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - JmtmodelPackage.DELAYSTATION_TYPE__VISITS, null, msgs);
			if (newVisits != null)
				msgs = ((InternalEObject)newVisits).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - JmtmodelPackage.DELAYSTATION_TYPE__VISITS, null, msgs);
			msgs = basicSetVisits(newVisits, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JmtmodelPackage.DELAYSTATION_TYPE__VISITS, newVisits, newVisits));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JmtmodelPackage.DELAYSTATION_TYPE__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case JmtmodelPackage.DELAYSTATION_TYPE__SERVICETIMES:
				return basicSetServicetimes(null, msgs);
			case JmtmodelPackage.DELAYSTATION_TYPE__VISITS:
				return basicSetVisits(null, msgs);
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
			case JmtmodelPackage.DELAYSTATION_TYPE__SERVICETIMES:
				return getServicetimes();
			case JmtmodelPackage.DELAYSTATION_TYPE__VISITS:
				return getVisits();
			case JmtmodelPackage.DELAYSTATION_TYPE__NAME:
				return getName();
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
			case JmtmodelPackage.DELAYSTATION_TYPE__SERVICETIMES:
				setServicetimes((ServicetimesType3)newValue);
				return;
			case JmtmodelPackage.DELAYSTATION_TYPE__VISITS:
				setVisits((VisitsType2)newValue);
				return;
			case JmtmodelPackage.DELAYSTATION_TYPE__NAME:
				setName((String)newValue);
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
			case JmtmodelPackage.DELAYSTATION_TYPE__SERVICETIMES:
				setServicetimes((ServicetimesType3)null);
				return;
			case JmtmodelPackage.DELAYSTATION_TYPE__VISITS:
				setVisits((VisitsType2)null);
				return;
			case JmtmodelPackage.DELAYSTATION_TYPE__NAME:
				setName(NAME_EDEFAULT);
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
			case JmtmodelPackage.DELAYSTATION_TYPE__SERVICETIMES:
				return servicetimes != null;
			case JmtmodelPackage.DELAYSTATION_TYPE__VISITS:
				return visits != null;
			case JmtmodelPackage.DELAYSTATION_TYPE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
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
		result.append(" (name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}

} //DelaystationTypeImpl
