/**
 */
package jmtmodel.impl;

import java.util.Collection;

import jmtmodel.BlockingRegionType;
import jmtmodel.ClassConstraintType;
import jmtmodel.ClassWeightType;
import jmtmodel.DropRulesType;
import jmtmodel.GlobalConstraintType;
import jmtmodel.JmtmodelPackage;
import jmtmodel.RegionNodeType;

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
 * An implementation of the model object '<em><b>Blocking Region Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link jmtmodel.impl.BlockingRegionTypeImpl#getRegionNode <em>Region Node</em>}</li>
 *   <li>{@link jmtmodel.impl.BlockingRegionTypeImpl#getGlobalConstraint <em>Global Constraint</em>}</li>
 *   <li>{@link jmtmodel.impl.BlockingRegionTypeImpl#getClassConstraint <em>Class Constraint</em>}</li>
 *   <li>{@link jmtmodel.impl.BlockingRegionTypeImpl#getClassWeight <em>Class Weight</em>}</li>
 *   <li>{@link jmtmodel.impl.BlockingRegionTypeImpl#getDropRules <em>Drop Rules</em>}</li>
 *   <li>{@link jmtmodel.impl.BlockingRegionTypeImpl#getName <em>Name</em>}</li>
 *   <li>{@link jmtmodel.impl.BlockingRegionTypeImpl#getType <em>Type</em>}</li>
 * </ul>
 *
 * @generated
 */
public class BlockingRegionTypeImpl extends MinimalEObjectImpl.Container implements BlockingRegionType {
	/**
	 * The cached value of the '{@link #getRegionNode() <em>Region Node</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRegionNode()
	 * @generated
	 * @ordered
	 */
	protected EList<RegionNodeType> regionNode;

	/**
	 * The cached value of the '{@link #getGlobalConstraint() <em>Global Constraint</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGlobalConstraint()
	 * @generated
	 * @ordered
	 */
	protected GlobalConstraintType globalConstraint;

	/**
	 * The cached value of the '{@link #getClassConstraint() <em>Class Constraint</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClassConstraint()
	 * @generated
	 * @ordered
	 */
	protected EList<ClassConstraintType> classConstraint;

	/**
	 * The cached value of the '{@link #getClassWeight() <em>Class Weight</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClassWeight()
	 * @generated
	 * @ordered
	 */
	protected EList<ClassWeightType> classWeight;

	/**
	 * The cached value of the '{@link #getDropRules() <em>Drop Rules</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDropRules()
	 * @generated
	 * @ordered
	 */
	protected EList<DropRulesType> dropRules;

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
	 * The default value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected static final String TYPE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected String type = TYPE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BlockingRegionTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return JmtmodelPackage.Literals.BLOCKING_REGION_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<RegionNodeType> getRegionNode() {
		if (regionNode == null) {
			regionNode = new EObjectContainmentEList<RegionNodeType>(RegionNodeType.class, this, JmtmodelPackage.BLOCKING_REGION_TYPE__REGION_NODE);
		}
		return regionNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GlobalConstraintType getGlobalConstraint() {
		return globalConstraint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetGlobalConstraint(GlobalConstraintType newGlobalConstraint, NotificationChain msgs) {
		GlobalConstraintType oldGlobalConstraint = globalConstraint;
		globalConstraint = newGlobalConstraint;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, JmtmodelPackage.BLOCKING_REGION_TYPE__GLOBAL_CONSTRAINT, oldGlobalConstraint, newGlobalConstraint);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGlobalConstraint(GlobalConstraintType newGlobalConstraint) {
		if (newGlobalConstraint != globalConstraint) {
			NotificationChain msgs = null;
			if (globalConstraint != null)
				msgs = ((InternalEObject)globalConstraint).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - JmtmodelPackage.BLOCKING_REGION_TYPE__GLOBAL_CONSTRAINT, null, msgs);
			if (newGlobalConstraint != null)
				msgs = ((InternalEObject)newGlobalConstraint).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - JmtmodelPackage.BLOCKING_REGION_TYPE__GLOBAL_CONSTRAINT, null, msgs);
			msgs = basicSetGlobalConstraint(newGlobalConstraint, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JmtmodelPackage.BLOCKING_REGION_TYPE__GLOBAL_CONSTRAINT, newGlobalConstraint, newGlobalConstraint));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ClassConstraintType> getClassConstraint() {
		if (classConstraint == null) {
			classConstraint = new EObjectContainmentEList<ClassConstraintType>(ClassConstraintType.class, this, JmtmodelPackage.BLOCKING_REGION_TYPE__CLASS_CONSTRAINT);
		}
		return classConstraint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ClassWeightType> getClassWeight() {
		if (classWeight == null) {
			classWeight = new EObjectContainmentEList<ClassWeightType>(ClassWeightType.class, this, JmtmodelPackage.BLOCKING_REGION_TYPE__CLASS_WEIGHT);
		}
		return classWeight;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<DropRulesType> getDropRules() {
		if (dropRules == null) {
			dropRules = new EObjectContainmentEList<DropRulesType>(DropRulesType.class, this, JmtmodelPackage.BLOCKING_REGION_TYPE__DROP_RULES);
		}
		return dropRules;
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
			eNotify(new ENotificationImpl(this, Notification.SET, JmtmodelPackage.BLOCKING_REGION_TYPE__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(String newType) {
		String oldType = type;
		type = newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JmtmodelPackage.BLOCKING_REGION_TYPE__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case JmtmodelPackage.BLOCKING_REGION_TYPE__REGION_NODE:
				return ((InternalEList<?>)getRegionNode()).basicRemove(otherEnd, msgs);
			case JmtmodelPackage.BLOCKING_REGION_TYPE__GLOBAL_CONSTRAINT:
				return basicSetGlobalConstraint(null, msgs);
			case JmtmodelPackage.BLOCKING_REGION_TYPE__CLASS_CONSTRAINT:
				return ((InternalEList<?>)getClassConstraint()).basicRemove(otherEnd, msgs);
			case JmtmodelPackage.BLOCKING_REGION_TYPE__CLASS_WEIGHT:
				return ((InternalEList<?>)getClassWeight()).basicRemove(otherEnd, msgs);
			case JmtmodelPackage.BLOCKING_REGION_TYPE__DROP_RULES:
				return ((InternalEList<?>)getDropRules()).basicRemove(otherEnd, msgs);
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
			case JmtmodelPackage.BLOCKING_REGION_TYPE__REGION_NODE:
				return getRegionNode();
			case JmtmodelPackage.BLOCKING_REGION_TYPE__GLOBAL_CONSTRAINT:
				return getGlobalConstraint();
			case JmtmodelPackage.BLOCKING_REGION_TYPE__CLASS_CONSTRAINT:
				return getClassConstraint();
			case JmtmodelPackage.BLOCKING_REGION_TYPE__CLASS_WEIGHT:
				return getClassWeight();
			case JmtmodelPackage.BLOCKING_REGION_TYPE__DROP_RULES:
				return getDropRules();
			case JmtmodelPackage.BLOCKING_REGION_TYPE__NAME:
				return getName();
			case JmtmodelPackage.BLOCKING_REGION_TYPE__TYPE:
				return getType();
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
			case JmtmodelPackage.BLOCKING_REGION_TYPE__REGION_NODE:
				getRegionNode().clear();
				getRegionNode().addAll((Collection<? extends RegionNodeType>)newValue);
				return;
			case JmtmodelPackage.BLOCKING_REGION_TYPE__GLOBAL_CONSTRAINT:
				setGlobalConstraint((GlobalConstraintType)newValue);
				return;
			case JmtmodelPackage.BLOCKING_REGION_TYPE__CLASS_CONSTRAINT:
				getClassConstraint().clear();
				getClassConstraint().addAll((Collection<? extends ClassConstraintType>)newValue);
				return;
			case JmtmodelPackage.BLOCKING_REGION_TYPE__CLASS_WEIGHT:
				getClassWeight().clear();
				getClassWeight().addAll((Collection<? extends ClassWeightType>)newValue);
				return;
			case JmtmodelPackage.BLOCKING_REGION_TYPE__DROP_RULES:
				getDropRules().clear();
				getDropRules().addAll((Collection<? extends DropRulesType>)newValue);
				return;
			case JmtmodelPackage.BLOCKING_REGION_TYPE__NAME:
				setName((String)newValue);
				return;
			case JmtmodelPackage.BLOCKING_REGION_TYPE__TYPE:
				setType((String)newValue);
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
			case JmtmodelPackage.BLOCKING_REGION_TYPE__REGION_NODE:
				getRegionNode().clear();
				return;
			case JmtmodelPackage.BLOCKING_REGION_TYPE__GLOBAL_CONSTRAINT:
				setGlobalConstraint((GlobalConstraintType)null);
				return;
			case JmtmodelPackage.BLOCKING_REGION_TYPE__CLASS_CONSTRAINT:
				getClassConstraint().clear();
				return;
			case JmtmodelPackage.BLOCKING_REGION_TYPE__CLASS_WEIGHT:
				getClassWeight().clear();
				return;
			case JmtmodelPackage.BLOCKING_REGION_TYPE__DROP_RULES:
				getDropRules().clear();
				return;
			case JmtmodelPackage.BLOCKING_REGION_TYPE__NAME:
				setName(NAME_EDEFAULT);
				return;
			case JmtmodelPackage.BLOCKING_REGION_TYPE__TYPE:
				setType(TYPE_EDEFAULT);
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
			case JmtmodelPackage.BLOCKING_REGION_TYPE__REGION_NODE:
				return regionNode != null && !regionNode.isEmpty();
			case JmtmodelPackage.BLOCKING_REGION_TYPE__GLOBAL_CONSTRAINT:
				return globalConstraint != null;
			case JmtmodelPackage.BLOCKING_REGION_TYPE__CLASS_CONSTRAINT:
				return classConstraint != null && !classConstraint.isEmpty();
			case JmtmodelPackage.BLOCKING_REGION_TYPE__CLASS_WEIGHT:
				return classWeight != null && !classWeight.isEmpty();
			case JmtmodelPackage.BLOCKING_REGION_TYPE__DROP_RULES:
				return dropRules != null && !dropRules.isEmpty();
			case JmtmodelPackage.BLOCKING_REGION_TYPE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case JmtmodelPackage.BLOCKING_REGION_TYPE__TYPE:
				return TYPE_EDEFAULT == null ? type != null : !TYPE_EDEFAULT.equals(type);
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
		result.append(", type: ");
		result.append(type);
		result.append(')');
		return result.toString();
	}

} //BlockingRegionTypeImpl
