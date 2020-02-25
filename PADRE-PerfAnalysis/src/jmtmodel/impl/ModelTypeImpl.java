/**
 */
package jmtmodel.impl;

import java.util.Collection;

import jmtmodel.BlockingRegionType;
import jmtmodel.JmtmodelPackage;
import jmtmodel.ModelType;
import jmtmodel.ParametersType;
import jmtmodel.SolutionsType;
import jmtmodel.WhatIfType;

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
 * An implementation of the model object '<em><b>Model Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link jmtmodel.impl.ModelTypeImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link jmtmodel.impl.ModelTypeImpl#getParameters <em>Parameters</em>}</li>
 *   <li>{@link jmtmodel.impl.ModelTypeImpl#getBlockingRegion <em>Blocking Region</em>}</li>
 *   <li>{@link jmtmodel.impl.ModelTypeImpl#getWhatIf <em>What If</em>}</li>
 *   <li>{@link jmtmodel.impl.ModelTypeImpl#getSolutions <em>Solutions</em>}</li>
 *   <li>{@link jmtmodel.impl.ModelTypeImpl#isJaba <em>Jaba</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ModelTypeImpl extends MinimalEObjectImpl.Container implements ModelType {
	/**
	 * The default value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected static final String DESCRIPTION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected String description = DESCRIPTION_EDEFAULT;

	/**
	 * The cached value of the '{@link #getParameters() <em>Parameters</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParameters()
	 * @generated
	 * @ordered
	 */
	protected ParametersType parameters;

	/**
	 * The cached value of the '{@link #getBlockingRegion() <em>Blocking Region</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBlockingRegion()
	 * @generated
	 * @ordered
	 */
	protected EList<BlockingRegionType> blockingRegion;

	/**
	 * The cached value of the '{@link #getWhatIf() <em>What If</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWhatIf()
	 * @generated
	 * @ordered
	 */
	protected WhatIfType whatIf;

	/**
	 * The cached value of the '{@link #getSolutions() <em>Solutions</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSolutions()
	 * @generated
	 * @ordered
	 */
	protected EList<SolutionsType> solutions;

	/**
	 * The default value of the '{@link #isJaba() <em>Jaba</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isJaba()
	 * @generated
	 * @ordered
	 */
	protected static final boolean JABA_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isJaba() <em>Jaba</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isJaba()
	 * @generated
	 * @ordered
	 */
	protected boolean jaba = JABA_EDEFAULT;

	/**
	 * This is true if the Jaba attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean jabaESet;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ModelTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return JmtmodelPackage.Literals.MODEL_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDescription(String newDescription) {
		String oldDescription = description;
		description = newDescription;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JmtmodelPackage.MODEL_TYPE__DESCRIPTION, oldDescription, description));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ParametersType getParameters() {
		return parameters;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetParameters(ParametersType newParameters, NotificationChain msgs) {
		ParametersType oldParameters = parameters;
		parameters = newParameters;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, JmtmodelPackage.MODEL_TYPE__PARAMETERS, oldParameters, newParameters);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParameters(ParametersType newParameters) {
		if (newParameters != parameters) {
			NotificationChain msgs = null;
			if (parameters != null)
				msgs = ((InternalEObject)parameters).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - JmtmodelPackage.MODEL_TYPE__PARAMETERS, null, msgs);
			if (newParameters != null)
				msgs = ((InternalEObject)newParameters).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - JmtmodelPackage.MODEL_TYPE__PARAMETERS, null, msgs);
			msgs = basicSetParameters(newParameters, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JmtmodelPackage.MODEL_TYPE__PARAMETERS, newParameters, newParameters));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<BlockingRegionType> getBlockingRegion() {
		if (blockingRegion == null) {
			blockingRegion = new EObjectContainmentEList<BlockingRegionType>(BlockingRegionType.class, this, JmtmodelPackage.MODEL_TYPE__BLOCKING_REGION);
		}
		return blockingRegion;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WhatIfType getWhatIf() {
		return whatIf;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetWhatIf(WhatIfType newWhatIf, NotificationChain msgs) {
		WhatIfType oldWhatIf = whatIf;
		whatIf = newWhatIf;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, JmtmodelPackage.MODEL_TYPE__WHAT_IF, oldWhatIf, newWhatIf);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWhatIf(WhatIfType newWhatIf) {
		if (newWhatIf != whatIf) {
			NotificationChain msgs = null;
			if (whatIf != null)
				msgs = ((InternalEObject)whatIf).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - JmtmodelPackage.MODEL_TYPE__WHAT_IF, null, msgs);
			if (newWhatIf != null)
				msgs = ((InternalEObject)newWhatIf).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - JmtmodelPackage.MODEL_TYPE__WHAT_IF, null, msgs);
			msgs = basicSetWhatIf(newWhatIf, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JmtmodelPackage.MODEL_TYPE__WHAT_IF, newWhatIf, newWhatIf));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SolutionsType> getSolutions() {
		if (solutions == null) {
			solutions = new EObjectContainmentEList<SolutionsType>(SolutionsType.class, this, JmtmodelPackage.MODEL_TYPE__SOLUTIONS);
		}
		return solutions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isJaba() {
		return jaba;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setJaba(boolean newJaba) {
		boolean oldJaba = jaba;
		jaba = newJaba;
		boolean oldJabaESet = jabaESet;
		jabaESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JmtmodelPackage.MODEL_TYPE__JABA, oldJaba, jaba, !oldJabaESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetJaba() {
		boolean oldJaba = jaba;
		boolean oldJabaESet = jabaESet;
		jaba = JABA_EDEFAULT;
		jabaESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, JmtmodelPackage.MODEL_TYPE__JABA, oldJaba, JABA_EDEFAULT, oldJabaESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetJaba() {
		return jabaESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case JmtmodelPackage.MODEL_TYPE__PARAMETERS:
				return basicSetParameters(null, msgs);
			case JmtmodelPackage.MODEL_TYPE__BLOCKING_REGION:
				return ((InternalEList<?>)getBlockingRegion()).basicRemove(otherEnd, msgs);
			case JmtmodelPackage.MODEL_TYPE__WHAT_IF:
				return basicSetWhatIf(null, msgs);
			case JmtmodelPackage.MODEL_TYPE__SOLUTIONS:
				return ((InternalEList<?>)getSolutions()).basicRemove(otherEnd, msgs);
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
			case JmtmodelPackage.MODEL_TYPE__DESCRIPTION:
				return getDescription();
			case JmtmodelPackage.MODEL_TYPE__PARAMETERS:
				return getParameters();
			case JmtmodelPackage.MODEL_TYPE__BLOCKING_REGION:
				return getBlockingRegion();
			case JmtmodelPackage.MODEL_TYPE__WHAT_IF:
				return getWhatIf();
			case JmtmodelPackage.MODEL_TYPE__SOLUTIONS:
				return getSolutions();
			case JmtmodelPackage.MODEL_TYPE__JABA:
				return isJaba();
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
			case JmtmodelPackage.MODEL_TYPE__DESCRIPTION:
				setDescription((String)newValue);
				return;
			case JmtmodelPackage.MODEL_TYPE__PARAMETERS:
				setParameters((ParametersType)newValue);
				return;
			case JmtmodelPackage.MODEL_TYPE__BLOCKING_REGION:
				getBlockingRegion().clear();
				getBlockingRegion().addAll((Collection<? extends BlockingRegionType>)newValue);
				return;
			case JmtmodelPackage.MODEL_TYPE__WHAT_IF:
				setWhatIf((WhatIfType)newValue);
				return;
			case JmtmodelPackage.MODEL_TYPE__SOLUTIONS:
				getSolutions().clear();
				getSolutions().addAll((Collection<? extends SolutionsType>)newValue);
				return;
			case JmtmodelPackage.MODEL_TYPE__JABA:
				setJaba((Boolean)newValue);
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
			case JmtmodelPackage.MODEL_TYPE__DESCRIPTION:
				setDescription(DESCRIPTION_EDEFAULT);
				return;
			case JmtmodelPackage.MODEL_TYPE__PARAMETERS:
				setParameters((ParametersType)null);
				return;
			case JmtmodelPackage.MODEL_TYPE__BLOCKING_REGION:
				getBlockingRegion().clear();
				return;
			case JmtmodelPackage.MODEL_TYPE__WHAT_IF:
				setWhatIf((WhatIfType)null);
				return;
			case JmtmodelPackage.MODEL_TYPE__SOLUTIONS:
				getSolutions().clear();
				return;
			case JmtmodelPackage.MODEL_TYPE__JABA:
				unsetJaba();
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
			case JmtmodelPackage.MODEL_TYPE__DESCRIPTION:
				return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
			case JmtmodelPackage.MODEL_TYPE__PARAMETERS:
				return parameters != null;
			case JmtmodelPackage.MODEL_TYPE__BLOCKING_REGION:
				return blockingRegion != null && !blockingRegion.isEmpty();
			case JmtmodelPackage.MODEL_TYPE__WHAT_IF:
				return whatIf != null;
			case JmtmodelPackage.MODEL_TYPE__SOLUTIONS:
				return solutions != null && !solutions.isEmpty();
			case JmtmodelPackage.MODEL_TYPE__JABA:
				return isSetJaba();
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
		result.append(" (description: ");
		result.append(description);
		result.append(", jaba: ");
		if (jabaESet) result.append(jaba); else result.append("<unset>");
		result.append(')');
		return result.toString();
	}

} //ModelTypeImpl
