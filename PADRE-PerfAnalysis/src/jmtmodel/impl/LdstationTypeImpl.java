/**
 */
package jmtmodel.impl;

import java.math.BigInteger;

import jmtmodel.JmtmodelPackage;
import jmtmodel.LdstationType;
import jmtmodel.ServicetimesType2;
import jmtmodel.VisitsType1;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ldstation Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link jmtmodel.impl.LdstationTypeImpl#getServicetimes <em>Servicetimes</em>}</li>
 *   <li>{@link jmtmodel.impl.LdstationTypeImpl#getVisits <em>Visits</em>}</li>
 *   <li>{@link jmtmodel.impl.LdstationTypeImpl#getName <em>Name</em>}</li>
 *   <li>{@link jmtmodel.impl.LdstationTypeImpl#getServers <em>Servers</em>}</li>
 * </ul>
 *
 * @generated
 */
public class LdstationTypeImpl extends MinimalEObjectImpl.Container implements LdstationType {
	/**
	 * The cached value of the '{@link #getServicetimes() <em>Servicetimes</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getServicetimes()
	 * @generated
	 * @ordered
	 */
	protected ServicetimesType2 servicetimes;

	/**
	 * The cached value of the '{@link #getVisits() <em>Visits</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVisits()
	 * @generated
	 * @ordered
	 */
	protected VisitsType1 visits;

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
	 * The default value of the '{@link #getServers() <em>Servers</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getServers()
	 * @generated
	 * @ordered
	 */
	protected static final BigInteger SERVERS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getServers() <em>Servers</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getServers()
	 * @generated
	 * @ordered
	 */
	protected BigInteger servers = SERVERS_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LdstationTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return JmtmodelPackage.Literals.LDSTATION_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ServicetimesType2 getServicetimes() {
		return servicetimes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetServicetimes(ServicetimesType2 newServicetimes, NotificationChain msgs) {
		ServicetimesType2 oldServicetimes = servicetimes;
		servicetimes = newServicetimes;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, JmtmodelPackage.LDSTATION_TYPE__SERVICETIMES, oldServicetimes, newServicetimes);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setServicetimes(ServicetimesType2 newServicetimes) {
		if (newServicetimes != servicetimes) {
			NotificationChain msgs = null;
			if (servicetimes != null)
				msgs = ((InternalEObject)servicetimes).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - JmtmodelPackage.LDSTATION_TYPE__SERVICETIMES, null, msgs);
			if (newServicetimes != null)
				msgs = ((InternalEObject)newServicetimes).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - JmtmodelPackage.LDSTATION_TYPE__SERVICETIMES, null, msgs);
			msgs = basicSetServicetimes(newServicetimes, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JmtmodelPackage.LDSTATION_TYPE__SERVICETIMES, newServicetimes, newServicetimes));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VisitsType1 getVisits() {
		return visits;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetVisits(VisitsType1 newVisits, NotificationChain msgs) {
		VisitsType1 oldVisits = visits;
		visits = newVisits;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, JmtmodelPackage.LDSTATION_TYPE__VISITS, oldVisits, newVisits);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVisits(VisitsType1 newVisits) {
		if (newVisits != visits) {
			NotificationChain msgs = null;
			if (visits != null)
				msgs = ((InternalEObject)visits).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - JmtmodelPackage.LDSTATION_TYPE__VISITS, null, msgs);
			if (newVisits != null)
				msgs = ((InternalEObject)newVisits).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - JmtmodelPackage.LDSTATION_TYPE__VISITS, null, msgs);
			msgs = basicSetVisits(newVisits, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JmtmodelPackage.LDSTATION_TYPE__VISITS, newVisits, newVisits));
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
			eNotify(new ENotificationImpl(this, Notification.SET, JmtmodelPackage.LDSTATION_TYPE__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BigInteger getServers() {
		return servers;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setServers(BigInteger newServers) {
		BigInteger oldServers = servers;
		servers = newServers;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JmtmodelPackage.LDSTATION_TYPE__SERVERS, oldServers, servers));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case JmtmodelPackage.LDSTATION_TYPE__SERVICETIMES:
				return basicSetServicetimes(null, msgs);
			case JmtmodelPackage.LDSTATION_TYPE__VISITS:
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
			case JmtmodelPackage.LDSTATION_TYPE__SERVICETIMES:
				return getServicetimes();
			case JmtmodelPackage.LDSTATION_TYPE__VISITS:
				return getVisits();
			case JmtmodelPackage.LDSTATION_TYPE__NAME:
				return getName();
			case JmtmodelPackage.LDSTATION_TYPE__SERVERS:
				return getServers();
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
			case JmtmodelPackage.LDSTATION_TYPE__SERVICETIMES:
				setServicetimes((ServicetimesType2)newValue);
				return;
			case JmtmodelPackage.LDSTATION_TYPE__VISITS:
				setVisits((VisitsType1)newValue);
				return;
			case JmtmodelPackage.LDSTATION_TYPE__NAME:
				setName((String)newValue);
				return;
			case JmtmodelPackage.LDSTATION_TYPE__SERVERS:
				setServers((BigInteger)newValue);
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
			case JmtmodelPackage.LDSTATION_TYPE__SERVICETIMES:
				setServicetimes((ServicetimesType2)null);
				return;
			case JmtmodelPackage.LDSTATION_TYPE__VISITS:
				setVisits((VisitsType1)null);
				return;
			case JmtmodelPackage.LDSTATION_TYPE__NAME:
				setName(NAME_EDEFAULT);
				return;
			case JmtmodelPackage.LDSTATION_TYPE__SERVERS:
				setServers(SERVERS_EDEFAULT);
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
			case JmtmodelPackage.LDSTATION_TYPE__SERVICETIMES:
				return servicetimes != null;
			case JmtmodelPackage.LDSTATION_TYPE__VISITS:
				return visits != null;
			case JmtmodelPackage.LDSTATION_TYPE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case JmtmodelPackage.LDSTATION_TYPE__SERVERS:
				return SERVERS_EDEFAULT == null ? servers != null : !SERVERS_EDEFAULT.equals(servers);
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
		result.append(", servers: ");
		result.append(servers);
		result.append(')');
		return result.toString();
	}

} //LdstationTypeImpl
