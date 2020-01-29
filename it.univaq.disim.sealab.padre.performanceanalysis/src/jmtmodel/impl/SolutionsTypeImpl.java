/**
 */
package jmtmodel.impl;

import java.math.BigInteger;

import java.util.Collection;

import jmtmodel.JmtmodelPackage;
import jmtmodel.RegionresultsType;
import jmtmodel.SolutionsType;
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
 * An implementation of the model object '<em><b>Solutions Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link jmtmodel.impl.SolutionsTypeImpl#getStationresults <em>Stationresults</em>}</li>
 *   <li>{@link jmtmodel.impl.SolutionsTypeImpl#getRegionresults <em>Regionresults</em>}</li>
 *   <li>{@link jmtmodel.impl.SolutionsTypeImpl#getIteration <em>Iteration</em>}</li>
 *   <li>{@link jmtmodel.impl.SolutionsTypeImpl#getIterationValue <em>Iteration Value</em>}</li>
 *   <li>{@link jmtmodel.impl.SolutionsTypeImpl#isOk <em>Ok</em>}</li>
 *   <li>{@link jmtmodel.impl.SolutionsTypeImpl#getSolutionMethod <em>Solution Method</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SolutionsTypeImpl extends MinimalEObjectImpl.Container implements SolutionsType {
	/**
	 * The cached value of the '{@link #getStationresults() <em>Stationresults</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStationresults()
	 * @generated
	 * @ordered
	 */
	protected EList<StationresultsType> stationresults;

	/**
	 * The cached value of the '{@link #getRegionresults() <em>Regionresults</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRegionresults()
	 * @generated
	 * @ordered
	 */
	protected EList<RegionresultsType> regionresults;

	/**
	 * The default value of the '{@link #getIteration() <em>Iteration</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIteration()
	 * @generated
	 * @ordered
	 */
	protected static final BigInteger ITERATION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getIteration() <em>Iteration</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIteration()
	 * @generated
	 * @ordered
	 */
	protected BigInteger iteration = ITERATION_EDEFAULT;

	/**
	 * The default value of the '{@link #getIterationValue() <em>Iteration Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIterationValue()
	 * @generated
	 * @ordered
	 */
	protected static final double ITERATION_VALUE_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getIterationValue() <em>Iteration Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIterationValue()
	 * @generated
	 * @ordered
	 */
	protected double iterationValue = ITERATION_VALUE_EDEFAULT;

	/**
	 * This is true if the Iteration Value attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean iterationValueESet;

	/**
	 * The default value of the '{@link #isOk() <em>Ok</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isOk()
	 * @generated
	 * @ordered
	 */
	protected static final boolean OK_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isOk() <em>Ok</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isOk()
	 * @generated
	 * @ordered
	 */
	protected boolean ok = OK_EDEFAULT;

	/**
	 * This is true if the Ok attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean okESet;

	/**
	 * The default value of the '{@link #getSolutionMethod() <em>Solution Method</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSolutionMethod()
	 * @generated
	 * @ordered
	 */
	protected static final String SOLUTION_METHOD_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSolutionMethod() <em>Solution Method</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSolutionMethod()
	 * @generated
	 * @ordered
	 */
	protected String solutionMethod = SOLUTION_METHOD_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SolutionsTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return JmtmodelPackage.Literals.SOLUTIONS_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<StationresultsType> getStationresults() {
		if (stationresults == null) {
			stationresults = new EObjectContainmentEList<StationresultsType>(StationresultsType.class, this, JmtmodelPackage.SOLUTIONS_TYPE__STATIONRESULTS);
		}
		return stationresults;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<RegionresultsType> getRegionresults() {
		if (regionresults == null) {
			regionresults = new EObjectContainmentEList<RegionresultsType>(RegionresultsType.class, this, JmtmodelPackage.SOLUTIONS_TYPE__REGIONRESULTS);
		}
		return regionresults;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BigInteger getIteration() {
		return iteration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIteration(BigInteger newIteration) {
		BigInteger oldIteration = iteration;
		iteration = newIteration;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JmtmodelPackage.SOLUTIONS_TYPE__ITERATION, oldIteration, iteration));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getIterationValue() {
		return iterationValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIterationValue(double newIterationValue) {
		double oldIterationValue = iterationValue;
		iterationValue = newIterationValue;
		boolean oldIterationValueESet = iterationValueESet;
		iterationValueESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JmtmodelPackage.SOLUTIONS_TYPE__ITERATION_VALUE, oldIterationValue, iterationValue, !oldIterationValueESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetIterationValue() {
		double oldIterationValue = iterationValue;
		boolean oldIterationValueESet = iterationValueESet;
		iterationValue = ITERATION_VALUE_EDEFAULT;
		iterationValueESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, JmtmodelPackage.SOLUTIONS_TYPE__ITERATION_VALUE, oldIterationValue, ITERATION_VALUE_EDEFAULT, oldIterationValueESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetIterationValue() {
		return iterationValueESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isOk() {
		return ok;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOk(boolean newOk) {
		boolean oldOk = ok;
		ok = newOk;
		boolean oldOkESet = okESet;
		okESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JmtmodelPackage.SOLUTIONS_TYPE__OK, oldOk, ok, !oldOkESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetOk() {
		boolean oldOk = ok;
		boolean oldOkESet = okESet;
		ok = OK_EDEFAULT;
		okESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, JmtmodelPackage.SOLUTIONS_TYPE__OK, oldOk, OK_EDEFAULT, oldOkESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetOk() {
		return okESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSolutionMethod() {
		return solutionMethod;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSolutionMethod(String newSolutionMethod) {
		String oldSolutionMethod = solutionMethod;
		solutionMethod = newSolutionMethod;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JmtmodelPackage.SOLUTIONS_TYPE__SOLUTION_METHOD, oldSolutionMethod, solutionMethod));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case JmtmodelPackage.SOLUTIONS_TYPE__STATIONRESULTS:
				return ((InternalEList<?>)getStationresults()).basicRemove(otherEnd, msgs);
			case JmtmodelPackage.SOLUTIONS_TYPE__REGIONRESULTS:
				return ((InternalEList<?>)getRegionresults()).basicRemove(otherEnd, msgs);
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
			case JmtmodelPackage.SOLUTIONS_TYPE__STATIONRESULTS:
				return getStationresults();
			case JmtmodelPackage.SOLUTIONS_TYPE__REGIONRESULTS:
				return getRegionresults();
			case JmtmodelPackage.SOLUTIONS_TYPE__ITERATION:
				return getIteration();
			case JmtmodelPackage.SOLUTIONS_TYPE__ITERATION_VALUE:
				return getIterationValue();
			case JmtmodelPackage.SOLUTIONS_TYPE__OK:
				return isOk();
			case JmtmodelPackage.SOLUTIONS_TYPE__SOLUTION_METHOD:
				return getSolutionMethod();
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
			case JmtmodelPackage.SOLUTIONS_TYPE__STATIONRESULTS:
				getStationresults().clear();
				getStationresults().addAll((Collection<? extends StationresultsType>)newValue);
				return;
			case JmtmodelPackage.SOLUTIONS_TYPE__REGIONRESULTS:
				getRegionresults().clear();
				getRegionresults().addAll((Collection<? extends RegionresultsType>)newValue);
				return;
			case JmtmodelPackage.SOLUTIONS_TYPE__ITERATION:
				setIteration((BigInteger)newValue);
				return;
			case JmtmodelPackage.SOLUTIONS_TYPE__ITERATION_VALUE:
				setIterationValue((Double)newValue);
				return;
			case JmtmodelPackage.SOLUTIONS_TYPE__OK:
				setOk((Boolean)newValue);
				return;
			case JmtmodelPackage.SOLUTIONS_TYPE__SOLUTION_METHOD:
				setSolutionMethod((String)newValue);
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
			case JmtmodelPackage.SOLUTIONS_TYPE__STATIONRESULTS:
				getStationresults().clear();
				return;
			case JmtmodelPackage.SOLUTIONS_TYPE__REGIONRESULTS:
				getRegionresults().clear();
				return;
			case JmtmodelPackage.SOLUTIONS_TYPE__ITERATION:
				setIteration(ITERATION_EDEFAULT);
				return;
			case JmtmodelPackage.SOLUTIONS_TYPE__ITERATION_VALUE:
				unsetIterationValue();
				return;
			case JmtmodelPackage.SOLUTIONS_TYPE__OK:
				unsetOk();
				return;
			case JmtmodelPackage.SOLUTIONS_TYPE__SOLUTION_METHOD:
				setSolutionMethod(SOLUTION_METHOD_EDEFAULT);
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
			case JmtmodelPackage.SOLUTIONS_TYPE__STATIONRESULTS:
				return stationresults != null && !stationresults.isEmpty();
			case JmtmodelPackage.SOLUTIONS_TYPE__REGIONRESULTS:
				return regionresults != null && !regionresults.isEmpty();
			case JmtmodelPackage.SOLUTIONS_TYPE__ITERATION:
				return ITERATION_EDEFAULT == null ? iteration != null : !ITERATION_EDEFAULT.equals(iteration);
			case JmtmodelPackage.SOLUTIONS_TYPE__ITERATION_VALUE:
				return isSetIterationValue();
			case JmtmodelPackage.SOLUTIONS_TYPE__OK:
				return isSetOk();
			case JmtmodelPackage.SOLUTIONS_TYPE__SOLUTION_METHOD:
				return SOLUTION_METHOD_EDEFAULT == null ? solutionMethod != null : !SOLUTION_METHOD_EDEFAULT.equals(solutionMethod);
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
		result.append(" (iteration: ");
		result.append(iteration);
		result.append(", iterationValue: ");
		if (iterationValueESet) result.append(iterationValue); else result.append("<unset>");
		result.append(", ok: ");
		if (okESet) result.append(ok); else result.append("<unset>");
		result.append(", solutionMethod: ");
		result.append(solutionMethod);
		result.append(')');
		return result.toString();
	}

} //SolutionsTypeImpl
