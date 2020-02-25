/**
 */
package jmtmodel.impl;

import java.math.BigInteger;

import java.util.Collection;

import jmtmodel.ClassesType;
import jmtmodel.ClosedclassType;
import jmtmodel.JmtmodelPackage;
import jmtmodel.OpenclassType;

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
 * An implementation of the model object '<em><b>Classes Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link jmtmodel.impl.ClassesTypeImpl#getGroup <em>Group</em>}</li>
 *   <li>{@link jmtmodel.impl.ClassesTypeImpl#getClosedclass <em>Closedclass</em>}</li>
 *   <li>{@link jmtmodel.impl.ClassesTypeImpl#getOpenclass <em>Openclass</em>}</li>
 *   <li>{@link jmtmodel.impl.ClassesTypeImpl#getNumber <em>Number</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ClassesTypeImpl extends MinimalEObjectImpl.Container implements ClassesType {
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
	protected ClassesTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return JmtmodelPackage.Literals.CLASSES_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureMap getGroup() {
		if (group == null) {
			group = new BasicFeatureMap(this, JmtmodelPackage.CLASSES_TYPE__GROUP);
		}
		return group;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ClosedclassType> getClosedclass() {
		return getGroup().list(JmtmodelPackage.Literals.CLASSES_TYPE__CLOSEDCLASS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<OpenclassType> getOpenclass() {
		return getGroup().list(JmtmodelPackage.Literals.CLASSES_TYPE__OPENCLASS);
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
			eNotify(new ENotificationImpl(this, Notification.SET, JmtmodelPackage.CLASSES_TYPE__NUMBER, oldNumber, number));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case JmtmodelPackage.CLASSES_TYPE__GROUP:
				return ((InternalEList<?>)getGroup()).basicRemove(otherEnd, msgs);
			case JmtmodelPackage.CLASSES_TYPE__CLOSEDCLASS:
				return ((InternalEList<?>)getClosedclass()).basicRemove(otherEnd, msgs);
			case JmtmodelPackage.CLASSES_TYPE__OPENCLASS:
				return ((InternalEList<?>)getOpenclass()).basicRemove(otherEnd, msgs);
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
			case JmtmodelPackage.CLASSES_TYPE__GROUP:
				if (coreType) return getGroup();
				return ((FeatureMap.Internal)getGroup()).getWrapper();
			case JmtmodelPackage.CLASSES_TYPE__CLOSEDCLASS:
				return getClosedclass();
			case JmtmodelPackage.CLASSES_TYPE__OPENCLASS:
				return getOpenclass();
			case JmtmodelPackage.CLASSES_TYPE__NUMBER:
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
			case JmtmodelPackage.CLASSES_TYPE__GROUP:
				((FeatureMap.Internal)getGroup()).set(newValue);
				return;
			case JmtmodelPackage.CLASSES_TYPE__CLOSEDCLASS:
				getClosedclass().clear();
				getClosedclass().addAll((Collection<? extends ClosedclassType>)newValue);
				return;
			case JmtmodelPackage.CLASSES_TYPE__OPENCLASS:
				getOpenclass().clear();
				getOpenclass().addAll((Collection<? extends OpenclassType>)newValue);
				return;
			case JmtmodelPackage.CLASSES_TYPE__NUMBER:
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
			case JmtmodelPackage.CLASSES_TYPE__GROUP:
				getGroup().clear();
				return;
			case JmtmodelPackage.CLASSES_TYPE__CLOSEDCLASS:
				getClosedclass().clear();
				return;
			case JmtmodelPackage.CLASSES_TYPE__OPENCLASS:
				getOpenclass().clear();
				return;
			case JmtmodelPackage.CLASSES_TYPE__NUMBER:
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
			case JmtmodelPackage.CLASSES_TYPE__GROUP:
				return group != null && !group.isEmpty();
			case JmtmodelPackage.CLASSES_TYPE__CLOSEDCLASS:
				return !getClosedclass().isEmpty();
			case JmtmodelPackage.CLASSES_TYPE__OPENCLASS:
				return !getOpenclass().isEmpty();
			case JmtmodelPackage.CLASSES_TYPE__NUMBER:
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

} //ClassesTypeImpl
