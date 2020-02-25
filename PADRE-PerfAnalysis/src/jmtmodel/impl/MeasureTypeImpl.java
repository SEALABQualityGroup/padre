/**
 */
package jmtmodel.impl;

import jmtmodel.JmtmodelPackage;
import jmtmodel.MeasureType;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Measure Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link jmtmodel.impl.MeasureTypeImpl#getAlfa <em>Alfa</em>}</li>
 *   <li>{@link jmtmodel.impl.MeasureTypeImpl#getAnalyzedSamples <em>Analyzed Samples</em>}</li>
 *   <li>{@link jmtmodel.impl.MeasureTypeImpl#getDiscardedSamples <em>Discarded Samples</em>}</li>
 *   <li>{@link jmtmodel.impl.MeasureTypeImpl#getLowerLimit <em>Lower Limit</em>}</li>
 *   <li>{@link jmtmodel.impl.MeasureTypeImpl#getMaxSamples <em>Max Samples</em>}</li>
 *   <li>{@link jmtmodel.impl.MeasureTypeImpl#getMeanValue <em>Mean Value</em>}</li>
 *   <li>{@link jmtmodel.impl.MeasureTypeImpl#getMeasureType <em>Measure Type</em>}</li>
 *   <li>{@link jmtmodel.impl.MeasureTypeImpl#getNodeType <em>Node Type</em>}</li>
 *   <li>{@link jmtmodel.impl.MeasureTypeImpl#getPrecision <em>Precision</em>}</li>
 *   <li>{@link jmtmodel.impl.MeasureTypeImpl#isSuccessful <em>Successful</em>}</li>
 *   <li>{@link jmtmodel.impl.MeasureTypeImpl#getUpperLimit <em>Upper Limit</em>}</li>
 * </ul>
 *
 * @generated
 */
public class MeasureTypeImpl extends MinimalEObjectImpl.Container implements MeasureType {
	/**
	 * The default value of the '{@link #getAlfa() <em>Alfa</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAlfa()
	 * @generated
	 * @ordered
	 */
	protected static final double ALFA_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getAlfa() <em>Alfa</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAlfa()
	 * @generated
	 * @ordered
	 */
	protected double alfa = ALFA_EDEFAULT;

	/**
	 * This is true if the Alfa attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean alfaESet;

	/**
	 * The default value of the '{@link #getAnalyzedSamples() <em>Analyzed Samples</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAnalyzedSamples()
	 * @generated
	 * @ordered
	 */
	protected static final int ANALYZED_SAMPLES_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getAnalyzedSamples() <em>Analyzed Samples</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAnalyzedSamples()
	 * @generated
	 * @ordered
	 */
	protected int analyzedSamples = ANALYZED_SAMPLES_EDEFAULT;

	/**
	 * This is true if the Analyzed Samples attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean analyzedSamplesESet;

	/**
	 * The default value of the '{@link #getDiscardedSamples() <em>Discarded Samples</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDiscardedSamples()
	 * @generated
	 * @ordered
	 */
	protected static final int DISCARDED_SAMPLES_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getDiscardedSamples() <em>Discarded Samples</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDiscardedSamples()
	 * @generated
	 * @ordered
	 */
	protected int discardedSamples = DISCARDED_SAMPLES_EDEFAULT;

	/**
	 * This is true if the Discarded Samples attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean discardedSamplesESet;

	/**
	 * The default value of the '{@link #getLowerLimit() <em>Lower Limit</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLowerLimit()
	 * @generated
	 * @ordered
	 */
	protected static final double LOWER_LIMIT_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getLowerLimit() <em>Lower Limit</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLowerLimit()
	 * @generated
	 * @ordered
	 */
	protected double lowerLimit = LOWER_LIMIT_EDEFAULT;

	/**
	 * This is true if the Lower Limit attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean lowerLimitESet;

	/**
	 * The default value of the '{@link #getMaxSamples() <em>Max Samples</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxSamples()
	 * @generated
	 * @ordered
	 */
	protected static final int MAX_SAMPLES_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getMaxSamples() <em>Max Samples</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxSamples()
	 * @generated
	 * @ordered
	 */
	protected int maxSamples = MAX_SAMPLES_EDEFAULT;

	/**
	 * This is true if the Max Samples attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean maxSamplesESet;

	/**
	 * The default value of the '{@link #getMeanValue() <em>Mean Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMeanValue()
	 * @generated
	 * @ordered
	 */
	protected static final double MEAN_VALUE_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getMeanValue() <em>Mean Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMeanValue()
	 * @generated
	 * @ordered
	 */
	protected double meanValue = MEAN_VALUE_EDEFAULT;

	/**
	 * This is true if the Mean Value attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean meanValueESet;

	/**
	 * The default value of the '{@link #getMeasureType() <em>Measure Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMeasureType()
	 * @generated
	 * @ordered
	 */
	protected static final String MEASURE_TYPE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMeasureType() <em>Measure Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMeasureType()
	 * @generated
	 * @ordered
	 */
	protected String measureType = MEASURE_TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getNodeType() <em>Node Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNodeType()
	 * @generated
	 * @ordered
	 */
	protected static final String NODE_TYPE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getNodeType() <em>Node Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNodeType()
	 * @generated
	 * @ordered
	 */
	protected String nodeType = NODE_TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getPrecision() <em>Precision</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPrecision()
	 * @generated
	 * @ordered
	 */
	protected static final double PRECISION_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getPrecision() <em>Precision</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPrecision()
	 * @generated
	 * @ordered
	 */
	protected double precision = PRECISION_EDEFAULT;

	/**
	 * This is true if the Precision attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean precisionESet;

	/**
	 * The default value of the '{@link #isSuccessful() <em>Successful</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSuccessful()
	 * @generated
	 * @ordered
	 */
	protected static final boolean SUCCESSFUL_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isSuccessful() <em>Successful</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSuccessful()
	 * @generated
	 * @ordered
	 */
	protected boolean successful = SUCCESSFUL_EDEFAULT;

	/**
	 * This is true if the Successful attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean successfulESet;

	/**
	 * The default value of the '{@link #getUpperLimit() <em>Upper Limit</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUpperLimit()
	 * @generated
	 * @ordered
	 */
	protected static final double UPPER_LIMIT_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getUpperLimit() <em>Upper Limit</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUpperLimit()
	 * @generated
	 * @ordered
	 */
	protected double upperLimit = UPPER_LIMIT_EDEFAULT;

	/**
	 * This is true if the Upper Limit attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean upperLimitESet;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MeasureTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return JmtmodelPackage.Literals.MEASURE_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getAlfa() {
		return alfa;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAlfa(double newAlfa) {
		double oldAlfa = alfa;
		alfa = newAlfa;
		boolean oldAlfaESet = alfaESet;
		alfaESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JmtmodelPackage.MEASURE_TYPE__ALFA, oldAlfa, alfa, !oldAlfaESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetAlfa() {
		double oldAlfa = alfa;
		boolean oldAlfaESet = alfaESet;
		alfa = ALFA_EDEFAULT;
		alfaESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, JmtmodelPackage.MEASURE_TYPE__ALFA, oldAlfa, ALFA_EDEFAULT, oldAlfaESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetAlfa() {
		return alfaESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getAnalyzedSamples() {
		return analyzedSamples;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAnalyzedSamples(int newAnalyzedSamples) {
		int oldAnalyzedSamples = analyzedSamples;
		analyzedSamples = newAnalyzedSamples;
		boolean oldAnalyzedSamplesESet = analyzedSamplesESet;
		analyzedSamplesESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JmtmodelPackage.MEASURE_TYPE__ANALYZED_SAMPLES, oldAnalyzedSamples, analyzedSamples, !oldAnalyzedSamplesESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetAnalyzedSamples() {
		int oldAnalyzedSamples = analyzedSamples;
		boolean oldAnalyzedSamplesESet = analyzedSamplesESet;
		analyzedSamples = ANALYZED_SAMPLES_EDEFAULT;
		analyzedSamplesESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, JmtmodelPackage.MEASURE_TYPE__ANALYZED_SAMPLES, oldAnalyzedSamples, ANALYZED_SAMPLES_EDEFAULT, oldAnalyzedSamplesESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetAnalyzedSamples() {
		return analyzedSamplesESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getDiscardedSamples() {
		return discardedSamples;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDiscardedSamples(int newDiscardedSamples) {
		int oldDiscardedSamples = discardedSamples;
		discardedSamples = newDiscardedSamples;
		boolean oldDiscardedSamplesESet = discardedSamplesESet;
		discardedSamplesESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JmtmodelPackage.MEASURE_TYPE__DISCARDED_SAMPLES, oldDiscardedSamples, discardedSamples, !oldDiscardedSamplesESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetDiscardedSamples() {
		int oldDiscardedSamples = discardedSamples;
		boolean oldDiscardedSamplesESet = discardedSamplesESet;
		discardedSamples = DISCARDED_SAMPLES_EDEFAULT;
		discardedSamplesESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, JmtmodelPackage.MEASURE_TYPE__DISCARDED_SAMPLES, oldDiscardedSamples, DISCARDED_SAMPLES_EDEFAULT, oldDiscardedSamplesESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetDiscardedSamples() {
		return discardedSamplesESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getLowerLimit() {
		return lowerLimit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLowerLimit(double newLowerLimit) {
		double oldLowerLimit = lowerLimit;
		lowerLimit = newLowerLimit;
		boolean oldLowerLimitESet = lowerLimitESet;
		lowerLimitESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JmtmodelPackage.MEASURE_TYPE__LOWER_LIMIT, oldLowerLimit, lowerLimit, !oldLowerLimitESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetLowerLimit() {
		double oldLowerLimit = lowerLimit;
		boolean oldLowerLimitESet = lowerLimitESet;
		lowerLimit = LOWER_LIMIT_EDEFAULT;
		lowerLimitESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, JmtmodelPackage.MEASURE_TYPE__LOWER_LIMIT, oldLowerLimit, LOWER_LIMIT_EDEFAULT, oldLowerLimitESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetLowerLimit() {
		return lowerLimitESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getMaxSamples() {
		return maxSamples;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMaxSamples(int newMaxSamples) {
		int oldMaxSamples = maxSamples;
		maxSamples = newMaxSamples;
		boolean oldMaxSamplesESet = maxSamplesESet;
		maxSamplesESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JmtmodelPackage.MEASURE_TYPE__MAX_SAMPLES, oldMaxSamples, maxSamples, !oldMaxSamplesESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetMaxSamples() {
		int oldMaxSamples = maxSamples;
		boolean oldMaxSamplesESet = maxSamplesESet;
		maxSamples = MAX_SAMPLES_EDEFAULT;
		maxSamplesESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, JmtmodelPackage.MEASURE_TYPE__MAX_SAMPLES, oldMaxSamples, MAX_SAMPLES_EDEFAULT, oldMaxSamplesESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetMaxSamples() {
		return maxSamplesESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getMeanValue() {
		return meanValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMeanValue(double newMeanValue) {
		double oldMeanValue = meanValue;
		meanValue = newMeanValue;
		boolean oldMeanValueESet = meanValueESet;
		meanValueESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JmtmodelPackage.MEASURE_TYPE__MEAN_VALUE, oldMeanValue, meanValue, !oldMeanValueESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetMeanValue() {
		double oldMeanValue = meanValue;
		boolean oldMeanValueESet = meanValueESet;
		meanValue = MEAN_VALUE_EDEFAULT;
		meanValueESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, JmtmodelPackage.MEASURE_TYPE__MEAN_VALUE, oldMeanValue, MEAN_VALUE_EDEFAULT, oldMeanValueESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetMeanValue() {
		return meanValueESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getMeasureType() {
		return measureType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMeasureType(String newMeasureType) {
		String oldMeasureType = measureType;
		measureType = newMeasureType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JmtmodelPackage.MEASURE_TYPE__MEASURE_TYPE, oldMeasureType, measureType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getNodeType() {
		return nodeType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNodeType(String newNodeType) {
		String oldNodeType = nodeType;
		nodeType = newNodeType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JmtmodelPackage.MEASURE_TYPE__NODE_TYPE, oldNodeType, nodeType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getPrecision() {
		return precision;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPrecision(double newPrecision) {
		double oldPrecision = precision;
		precision = newPrecision;
		boolean oldPrecisionESet = precisionESet;
		precisionESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JmtmodelPackage.MEASURE_TYPE__PRECISION, oldPrecision, precision, !oldPrecisionESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetPrecision() {
		double oldPrecision = precision;
		boolean oldPrecisionESet = precisionESet;
		precision = PRECISION_EDEFAULT;
		precisionESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, JmtmodelPackage.MEASURE_TYPE__PRECISION, oldPrecision, PRECISION_EDEFAULT, oldPrecisionESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetPrecision() {
		return precisionESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSuccessful() {
		return successful;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSuccessful(boolean newSuccessful) {
		boolean oldSuccessful = successful;
		successful = newSuccessful;
		boolean oldSuccessfulESet = successfulESet;
		successfulESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JmtmodelPackage.MEASURE_TYPE__SUCCESSFUL, oldSuccessful, successful, !oldSuccessfulESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetSuccessful() {
		boolean oldSuccessful = successful;
		boolean oldSuccessfulESet = successfulESet;
		successful = SUCCESSFUL_EDEFAULT;
		successfulESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, JmtmodelPackage.MEASURE_TYPE__SUCCESSFUL, oldSuccessful, SUCCESSFUL_EDEFAULT, oldSuccessfulESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetSuccessful() {
		return successfulESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getUpperLimit() {
		return upperLimit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUpperLimit(double newUpperLimit) {
		double oldUpperLimit = upperLimit;
		upperLimit = newUpperLimit;
		boolean oldUpperLimitESet = upperLimitESet;
		upperLimitESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JmtmodelPackage.MEASURE_TYPE__UPPER_LIMIT, oldUpperLimit, upperLimit, !oldUpperLimitESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetUpperLimit() {
		double oldUpperLimit = upperLimit;
		boolean oldUpperLimitESet = upperLimitESet;
		upperLimit = UPPER_LIMIT_EDEFAULT;
		upperLimitESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, JmtmodelPackage.MEASURE_TYPE__UPPER_LIMIT, oldUpperLimit, UPPER_LIMIT_EDEFAULT, oldUpperLimitESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetUpperLimit() {
		return upperLimitESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case JmtmodelPackage.MEASURE_TYPE__ALFA:
				return getAlfa();
			case JmtmodelPackage.MEASURE_TYPE__ANALYZED_SAMPLES:
				return getAnalyzedSamples();
			case JmtmodelPackage.MEASURE_TYPE__DISCARDED_SAMPLES:
				return getDiscardedSamples();
			case JmtmodelPackage.MEASURE_TYPE__LOWER_LIMIT:
				return getLowerLimit();
			case JmtmodelPackage.MEASURE_TYPE__MAX_SAMPLES:
				return getMaxSamples();
			case JmtmodelPackage.MEASURE_TYPE__MEAN_VALUE:
				return getMeanValue();
			case JmtmodelPackage.MEASURE_TYPE__MEASURE_TYPE:
				return getMeasureType();
			case JmtmodelPackage.MEASURE_TYPE__NODE_TYPE:
				return getNodeType();
			case JmtmodelPackage.MEASURE_TYPE__PRECISION:
				return getPrecision();
			case JmtmodelPackage.MEASURE_TYPE__SUCCESSFUL:
				return isSuccessful();
			case JmtmodelPackage.MEASURE_TYPE__UPPER_LIMIT:
				return getUpperLimit();
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
			case JmtmodelPackage.MEASURE_TYPE__ALFA:
				setAlfa((Double)newValue);
				return;
			case JmtmodelPackage.MEASURE_TYPE__ANALYZED_SAMPLES:
				setAnalyzedSamples((Integer)newValue);
				return;
			case JmtmodelPackage.MEASURE_TYPE__DISCARDED_SAMPLES:
				setDiscardedSamples((Integer)newValue);
				return;
			case JmtmodelPackage.MEASURE_TYPE__LOWER_LIMIT:
				setLowerLimit((Double)newValue);
				return;
			case JmtmodelPackage.MEASURE_TYPE__MAX_SAMPLES:
				setMaxSamples((Integer)newValue);
				return;
			case JmtmodelPackage.MEASURE_TYPE__MEAN_VALUE:
				setMeanValue((Double)newValue);
				return;
			case JmtmodelPackage.MEASURE_TYPE__MEASURE_TYPE:
				setMeasureType((String)newValue);
				return;
			case JmtmodelPackage.MEASURE_TYPE__NODE_TYPE:
				setNodeType((String)newValue);
				return;
			case JmtmodelPackage.MEASURE_TYPE__PRECISION:
				setPrecision((Double)newValue);
				return;
			case JmtmodelPackage.MEASURE_TYPE__SUCCESSFUL:
				setSuccessful((Boolean)newValue);
				return;
			case JmtmodelPackage.MEASURE_TYPE__UPPER_LIMIT:
				setUpperLimit((Double)newValue);
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
			case JmtmodelPackage.MEASURE_TYPE__ALFA:
				unsetAlfa();
				return;
			case JmtmodelPackage.MEASURE_TYPE__ANALYZED_SAMPLES:
				unsetAnalyzedSamples();
				return;
			case JmtmodelPackage.MEASURE_TYPE__DISCARDED_SAMPLES:
				unsetDiscardedSamples();
				return;
			case JmtmodelPackage.MEASURE_TYPE__LOWER_LIMIT:
				unsetLowerLimit();
				return;
			case JmtmodelPackage.MEASURE_TYPE__MAX_SAMPLES:
				unsetMaxSamples();
				return;
			case JmtmodelPackage.MEASURE_TYPE__MEAN_VALUE:
				unsetMeanValue();
				return;
			case JmtmodelPackage.MEASURE_TYPE__MEASURE_TYPE:
				setMeasureType(MEASURE_TYPE_EDEFAULT);
				return;
			case JmtmodelPackage.MEASURE_TYPE__NODE_TYPE:
				setNodeType(NODE_TYPE_EDEFAULT);
				return;
			case JmtmodelPackage.MEASURE_TYPE__PRECISION:
				unsetPrecision();
				return;
			case JmtmodelPackage.MEASURE_TYPE__SUCCESSFUL:
				unsetSuccessful();
				return;
			case JmtmodelPackage.MEASURE_TYPE__UPPER_LIMIT:
				unsetUpperLimit();
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
			case JmtmodelPackage.MEASURE_TYPE__ALFA:
				return isSetAlfa();
			case JmtmodelPackage.MEASURE_TYPE__ANALYZED_SAMPLES:
				return isSetAnalyzedSamples();
			case JmtmodelPackage.MEASURE_TYPE__DISCARDED_SAMPLES:
				return isSetDiscardedSamples();
			case JmtmodelPackage.MEASURE_TYPE__LOWER_LIMIT:
				return isSetLowerLimit();
			case JmtmodelPackage.MEASURE_TYPE__MAX_SAMPLES:
				return isSetMaxSamples();
			case JmtmodelPackage.MEASURE_TYPE__MEAN_VALUE:
				return isSetMeanValue();
			case JmtmodelPackage.MEASURE_TYPE__MEASURE_TYPE:
				return MEASURE_TYPE_EDEFAULT == null ? measureType != null : !MEASURE_TYPE_EDEFAULT.equals(measureType);
			case JmtmodelPackage.MEASURE_TYPE__NODE_TYPE:
				return NODE_TYPE_EDEFAULT == null ? nodeType != null : !NODE_TYPE_EDEFAULT.equals(nodeType);
			case JmtmodelPackage.MEASURE_TYPE__PRECISION:
				return isSetPrecision();
			case JmtmodelPackage.MEASURE_TYPE__SUCCESSFUL:
				return isSetSuccessful();
			case JmtmodelPackage.MEASURE_TYPE__UPPER_LIMIT:
				return isSetUpperLimit();
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
		result.append(" (alfa: ");
		if (alfaESet) result.append(alfa); else result.append("<unset>");
		result.append(", analyzedSamples: ");
		if (analyzedSamplesESet) result.append(analyzedSamples); else result.append("<unset>");
		result.append(", discardedSamples: ");
		if (discardedSamplesESet) result.append(discardedSamples); else result.append("<unset>");
		result.append(", lowerLimit: ");
		if (lowerLimitESet) result.append(lowerLimit); else result.append("<unset>");
		result.append(", maxSamples: ");
		if (maxSamplesESet) result.append(maxSamples); else result.append("<unset>");
		result.append(", meanValue: ");
		if (meanValueESet) result.append(meanValue); else result.append("<unset>");
		result.append(", measureType: ");
		result.append(measureType);
		result.append(", nodeType: ");
		result.append(nodeType);
		result.append(", precision: ");
		if (precisionESet) result.append(precision); else result.append("<unset>");
		result.append(", successful: ");
		if (successfulESet) result.append(successful); else result.append("<unset>");
		result.append(", upperLimit: ");
		if (upperLimitESet) result.append(upperLimit); else result.append("<unset>");
		result.append(')');
		return result.toString();
	}

} //MeasureTypeImpl
