/**
 */
package jmtmodel.impl;

import jmtmodel.ClassesType;
import jmtmodel.JmtmodelPackage;
import jmtmodel.ParametersType;
import jmtmodel.ReferenceStationType;
import jmtmodel.StationsType;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Parameters Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link jmtmodel.impl.ParametersTypeImpl#getClasses <em>Classes</em>}</li>
 *   <li>{@link jmtmodel.impl.ParametersTypeImpl#getStations <em>Stations</em>}</li>
 *   <li>{@link jmtmodel.impl.ParametersTypeImpl#getReferenceStation <em>Reference Station</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ParametersTypeImpl extends MinimalEObjectImpl.Container implements ParametersType {
	/**
	 * The cached value of the '{@link #getClasses() <em>Classes</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClasses()
	 * @generated
	 * @ordered
	 */
	protected ClassesType classes;

	/**
	 * The cached value of the '{@link #getStations() <em>Stations</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStations()
	 * @generated
	 * @ordered
	 */
	protected StationsType stations;

	/**
	 * The cached value of the '{@link #getReferenceStation() <em>Reference Station</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReferenceStation()
	 * @generated
	 * @ordered
	 */
	protected ReferenceStationType referenceStation;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ParametersTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return JmtmodelPackage.Literals.PARAMETERS_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ClassesType getClasses() {
		return classes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetClasses(ClassesType newClasses, NotificationChain msgs) {
		ClassesType oldClasses = classes;
		classes = newClasses;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, JmtmodelPackage.PARAMETERS_TYPE__CLASSES, oldClasses, newClasses);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setClasses(ClassesType newClasses) {
		if (newClasses != classes) {
			NotificationChain msgs = null;
			if (classes != null)
				msgs = ((InternalEObject)classes).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - JmtmodelPackage.PARAMETERS_TYPE__CLASSES, null, msgs);
			if (newClasses != null)
				msgs = ((InternalEObject)newClasses).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - JmtmodelPackage.PARAMETERS_TYPE__CLASSES, null, msgs);
			msgs = basicSetClasses(newClasses, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JmtmodelPackage.PARAMETERS_TYPE__CLASSES, newClasses, newClasses));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StationsType getStations() {
		return stations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetStations(StationsType newStations, NotificationChain msgs) {
		StationsType oldStations = stations;
		stations = newStations;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, JmtmodelPackage.PARAMETERS_TYPE__STATIONS, oldStations, newStations);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStations(StationsType newStations) {
		if (newStations != stations) {
			NotificationChain msgs = null;
			if (stations != null)
				msgs = ((InternalEObject)stations).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - JmtmodelPackage.PARAMETERS_TYPE__STATIONS, null, msgs);
			if (newStations != null)
				msgs = ((InternalEObject)newStations).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - JmtmodelPackage.PARAMETERS_TYPE__STATIONS, null, msgs);
			msgs = basicSetStations(newStations, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JmtmodelPackage.PARAMETERS_TYPE__STATIONS, newStations, newStations));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ReferenceStationType getReferenceStation() {
		return referenceStation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetReferenceStation(ReferenceStationType newReferenceStation, NotificationChain msgs) {
		ReferenceStationType oldReferenceStation = referenceStation;
		referenceStation = newReferenceStation;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, JmtmodelPackage.PARAMETERS_TYPE__REFERENCE_STATION, oldReferenceStation, newReferenceStation);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReferenceStation(ReferenceStationType newReferenceStation) {
		if (newReferenceStation != referenceStation) {
			NotificationChain msgs = null;
			if (referenceStation != null)
				msgs = ((InternalEObject)referenceStation).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - JmtmodelPackage.PARAMETERS_TYPE__REFERENCE_STATION, null, msgs);
			if (newReferenceStation != null)
				msgs = ((InternalEObject)newReferenceStation).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - JmtmodelPackage.PARAMETERS_TYPE__REFERENCE_STATION, null, msgs);
			msgs = basicSetReferenceStation(newReferenceStation, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JmtmodelPackage.PARAMETERS_TYPE__REFERENCE_STATION, newReferenceStation, newReferenceStation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case JmtmodelPackage.PARAMETERS_TYPE__CLASSES:
				return basicSetClasses(null, msgs);
			case JmtmodelPackage.PARAMETERS_TYPE__STATIONS:
				return basicSetStations(null, msgs);
			case JmtmodelPackage.PARAMETERS_TYPE__REFERENCE_STATION:
				return basicSetReferenceStation(null, msgs);
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
			case JmtmodelPackage.PARAMETERS_TYPE__CLASSES:
				return getClasses();
			case JmtmodelPackage.PARAMETERS_TYPE__STATIONS:
				return getStations();
			case JmtmodelPackage.PARAMETERS_TYPE__REFERENCE_STATION:
				return getReferenceStation();
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
			case JmtmodelPackage.PARAMETERS_TYPE__CLASSES:
				setClasses((ClassesType)newValue);
				return;
			case JmtmodelPackage.PARAMETERS_TYPE__STATIONS:
				setStations((StationsType)newValue);
				return;
			case JmtmodelPackage.PARAMETERS_TYPE__REFERENCE_STATION:
				setReferenceStation((ReferenceStationType)newValue);
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
			case JmtmodelPackage.PARAMETERS_TYPE__CLASSES:
				setClasses((ClassesType)null);
				return;
			case JmtmodelPackage.PARAMETERS_TYPE__STATIONS:
				setStations((StationsType)null);
				return;
			case JmtmodelPackage.PARAMETERS_TYPE__REFERENCE_STATION:
				setReferenceStation((ReferenceStationType)null);
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
			case JmtmodelPackage.PARAMETERS_TYPE__CLASSES:
				return classes != null;
			case JmtmodelPackage.PARAMETERS_TYPE__STATIONS:
				return stations != null;
			case JmtmodelPackage.PARAMETERS_TYPE__REFERENCE_STATION:
				return referenceStation != null;
		}
		return super.eIsSet(featureID);
	}

} //ParametersTypeImpl
