/**
 */
package jmtmodel.impl;

import java.math.BigInteger;

import java.util.Collection;

import jmtmodel.DelaystationType;
import jmtmodel.JmtmodelPackage;
import jmtmodel.LdstationType;
import jmtmodel.ListationType;
import jmtmodel.StationsType;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.BasicFeatureMap;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Stations Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link jmtmodel.impl.StationsTypeImpl#getGroup <em>Group</em>}</li>
 *   <li>{@link jmtmodel.impl.StationsTypeImpl#getDelaystation <em>Delaystation</em>}</li>
 *   <li>{@link jmtmodel.impl.StationsTypeImpl#getListation <em>Listation</em>}</li>
 *   <li>{@link jmtmodel.impl.StationsTypeImpl#getLdstation <em>Ldstation</em>}</li>
 *   <li>{@link jmtmodel.impl.StationsTypeImpl#getNumber <em>Number</em>}</li>
 * </ul>
 *
 * @generated
 */
public class StationsTypeImpl extends MinimalEObjectImpl.Container implements StationsType {
	/**
	 * The cached value of the '{@link #getGroup() <em>Group</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGroup()
	 * @generated
	 * @ordered
	 */
	protected FeatureMap group;

	/**
	 * The default value of the '{@link #getNumber() <em>Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNumber()
	 * @generated
	 * @ordered
	 */
	protected static final BigInteger NUMBER_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getNumber() <em>Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNumber()
	 * @generated
	 * @ordered
	 */
	protected BigInteger number = NUMBER_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected StationsTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return JmtmodelPackage.Literals.STATIONS_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureMap getGroup() {
		if (group == null) {
			group = new BasicFeatureMap(this, JmtmodelPackage.STATIONS_TYPE__GROUP);
		}
		return group;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<DelaystationType> getDelaystation() {
		return getGroup().list(JmtmodelPackage.Literals.STATIONS_TYPE__DELAYSTATION);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ListationType> getListation() {
		return getGroup().list(JmtmodelPackage.Literals.STATIONS_TYPE__LISTATION);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<LdstationType> getLdstation() {
		return getGroup().list(JmtmodelPackage.Literals.STATIONS_TYPE__LDSTATION);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BigInteger getNumber() {
		return number;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNumber(BigInteger newNumber) {
		BigInteger oldNumber = number;
		number = newNumber;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JmtmodelPackage.STATIONS_TYPE__NUMBER, oldNumber, number));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case JmtmodelPackage.STATIONS_TYPE__GROUP:
				return ((InternalEList<?>)getGroup()).basicRemove(otherEnd, msgs);
			case JmtmodelPackage.STATIONS_TYPE__DELAYSTATION:
				return ((InternalEList<?>)getDelaystation()).basicRemove(otherEnd, msgs);
			case JmtmodelPackage.STATIONS_TYPE__LISTATION:
				return ((InternalEList<?>)getListation()).basicRemove(otherEnd, msgs);
			case JmtmodelPackage.STATIONS_TYPE__LDSTATION:
				return ((InternalEList<?>)getLdstation()).basicRemove(otherEnd, msgs);
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
			case JmtmodelPackage.STATIONS_TYPE__GROUP:
				if (coreType) return getGroup();
				return ((FeatureMap.Internal)getGroup()).getWrapper();
			case JmtmodelPackage.STATIONS_TYPE__DELAYSTATION:
				return getDelaystation();
			case JmtmodelPackage.STATIONS_TYPE__LISTATION:
				return getListation();
			case JmtmodelPackage.STATIONS_TYPE__LDSTATION:
				return getLdstation();
			case JmtmodelPackage.STATIONS_TYPE__NUMBER:
				return getNumber();
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
			case JmtmodelPackage.STATIONS_TYPE__GROUP:
				((FeatureMap.Internal)getGroup()).set(newValue);
				return;
			case JmtmodelPackage.STATIONS_TYPE__DELAYSTATION:
				getDelaystation().clear();
				getDelaystation().addAll((Collection<? extends DelaystationType>)newValue);
				return;
			case JmtmodelPackage.STATIONS_TYPE__LISTATION:
				getListation().clear();
				getListation().addAll((Collection<? extends ListationType>)newValue);
				return;
			case JmtmodelPackage.STATIONS_TYPE__LDSTATION:
				getLdstation().clear();
				getLdstation().addAll((Collection<? extends LdstationType>)newValue);
				return;
			case JmtmodelPackage.STATIONS_TYPE__NUMBER:
				setNumber((BigInteger)newValue);
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
			case JmtmodelPackage.STATIONS_TYPE__GROUP:
				getGroup().clear();
				return;
			case JmtmodelPackage.STATIONS_TYPE__DELAYSTATION:
				getDelaystation().clear();
				return;
			case JmtmodelPackage.STATIONS_TYPE__LISTATION:
				getListation().clear();
				return;
			case JmtmodelPackage.STATIONS_TYPE__LDSTATION:
				getLdstation().clear();
				return;
			case JmtmodelPackage.STATIONS_TYPE__NUMBER:
				setNumber(NUMBER_EDEFAULT);
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
			case JmtmodelPackage.STATIONS_TYPE__GROUP:
				return group != null && !group.isEmpty();
			case JmtmodelPackage.STATIONS_TYPE__DELAYSTATION:
				return !getDelaystation().isEmpty();
			case JmtmodelPackage.STATIONS_TYPE__LISTATION:
				return !getListation().isEmpty();
			case JmtmodelPackage.STATIONS_TYPE__LDSTATION:
				return !getLdstation().isEmpty();
			case JmtmodelPackage.STATIONS_TYPE__NUMBER:
				return NUMBER_EDEFAULT == null ? number != null : !NUMBER_EDEFAULT.equals(number);
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
		result.append(" (group: ");
		result.append(group);
		result.append(", number: ");
		result.append(number);
		result.append(')');
		return result.toString();
	}

} //StationsTypeImpl
