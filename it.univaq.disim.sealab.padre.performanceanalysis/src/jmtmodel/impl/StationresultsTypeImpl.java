/**
 */
package jmtmodel.impl;

import java.util.Collection;

import jmtmodel.ClassresultsType1;
import jmtmodel.JmtmodelPackage;
import jmtmodel.StationresultsType;

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
 * An implementation of the model object '<em><b>Stationresults Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link jmtmodel.impl.StationresultsTypeImpl#getClassresults <em>Classresults</em>}</li>
 *   <li>{@link jmtmodel.impl.StationresultsTypeImpl#getStation <em>Station</em>}</li>
 * </ul>
 *
 * @generated
 */
public class StationresultsTypeImpl extends MinimalEObjectImpl.Container implements StationresultsType {
	/**
	 * The cached value of the '{@link #getClassresults() <em>Classresults</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClassresults()
	 * @generated
	 * @ordered
	 */
	protected EList<ClassresultsType1> classresults;

	/**
	 * The default value of the '{@link #getStation() <em>Station</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStation()
	 * @generated
	 * @ordered
	 */
	protected static final String STATION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getStation() <em>Station</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStation()
	 * @generated
	 * @ordered
	 */
	protected String station = STATION_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected StationresultsTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return JmtmodelPackage.Literals.STATIONRESULTS_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ClassresultsType1> getClassresults() {
		if (classresults == null) {
			classresults = new EObjectContainmentEList<ClassresultsType1>(ClassresultsType1.class, this, JmtmodelPackage.STATIONRESULTS_TYPE__CLASSRESULTS);
		}
		return classresults;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getStation() {
		return station;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStation(String newStation) {
		String oldStation = station;
		station = newStation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JmtmodelPackage.STATIONRESULTS_TYPE__STATION, oldStation, station));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case JmtmodelPackage.STATIONRESULTS_TYPE__CLASSRESULTS:
				return ((InternalEList<?>)getClassresults()).basicRemove(otherEnd, msgs);
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
			case JmtmodelPackage.STATIONRESULTS_TYPE__CLASSRESULTS:
				return getClassresults();
			case JmtmodelPackage.STATIONRESULTS_TYPE__STATION:
				return getStation();
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
			case JmtmodelPackage.STATIONRESULTS_TYPE__CLASSRESULTS:
				getClassresults().clear();
				getClassresults().addAll((Collection<? extends ClassresultsType1>)newValue);
				return;
			case JmtmodelPackage.STATIONRESULTS_TYPE__STATION:
				setStation((String)newValue);
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
			case JmtmodelPackage.STATIONRESULTS_TYPE__CLASSRESULTS:
				getClassresults().clear();
				return;
			case JmtmodelPackage.STATIONRESULTS_TYPE__STATION:
				setStation(STATION_EDEFAULT);
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
			case JmtmodelPackage.STATIONRESULTS_TYPE__CLASSRESULTS:
				return classresults != null && !classresults.isEmpty();
			case JmtmodelPackage.STATIONRESULTS_TYPE__STATION:
				return STATION_EDEFAULT == null ? station != null : !STATION_EDEFAULT.equals(station);
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
		result.append(" (station: ");
		result.append(station);
		result.append(')');
		return result.toString();
	}

} //StationresultsTypeImpl
