/**
 */
package jmtmodel;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Measure Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link jmtmodel.MeasureType#getAlfa <em>Alfa</em>}</li>
 *   <li>{@link jmtmodel.MeasureType#getAnalyzedSamples <em>Analyzed Samples</em>}</li>
 *   <li>{@link jmtmodel.MeasureType#getDiscardedSamples <em>Discarded Samples</em>}</li>
 *   <li>{@link jmtmodel.MeasureType#getLowerLimit <em>Lower Limit</em>}</li>
 *   <li>{@link jmtmodel.MeasureType#getMaxSamples <em>Max Samples</em>}</li>
 *   <li>{@link jmtmodel.MeasureType#getMeanValue <em>Mean Value</em>}</li>
 *   <li>{@link jmtmodel.MeasureType#getMeasureType <em>Measure Type</em>}</li>
 *   <li>{@link jmtmodel.MeasureType#getNodeType <em>Node Type</em>}</li>
 *   <li>{@link jmtmodel.MeasureType#getPrecision <em>Precision</em>}</li>
 *   <li>{@link jmtmodel.MeasureType#isSuccessful <em>Successful</em>}</li>
 *   <li>{@link jmtmodel.MeasureType#getUpperLimit <em>Upper Limit</em>}</li>
 * </ul>
 *
 * @see jmtmodel.JmtmodelPackage#getMeasureType()
 * @model extendedMetaData="name='measure_._type' kind='empty'"
 * @generated
 */
public interface MeasureType extends EObject {
	/**
	 * Returns the value of the '<em><b>Alfa</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Alfa</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Alfa</em>' attribute.
	 * @see #isSetAlfa()
	 * @see #unsetAlfa()
	 * @see #setAlfa(double)
	 * @see jmtmodel.JmtmodelPackage#getMeasureType_Alfa()
	 * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Double"
	 *        extendedMetaData="kind='attribute' name='alfa' namespace='##targetNamespace'"
	 * @generated
	 */
	double getAlfa();

	/**
	 * Sets the value of the '{@link jmtmodel.MeasureType#getAlfa <em>Alfa</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Alfa</em>' attribute.
	 * @see #isSetAlfa()
	 * @see #unsetAlfa()
	 * @see #getAlfa()
	 * @generated
	 */
	void setAlfa(double value);

	/**
	 * Unsets the value of the '{@link jmtmodel.MeasureType#getAlfa <em>Alfa</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetAlfa()
	 * @see #getAlfa()
	 * @see #setAlfa(double)
	 * @generated
	 */
	void unsetAlfa();

	/**
	 * Returns whether the value of the '{@link jmtmodel.MeasureType#getAlfa <em>Alfa</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Alfa</em>' attribute is set.
	 * @see #unsetAlfa()
	 * @see #getAlfa()
	 * @see #setAlfa(double)
	 * @generated
	 */
	boolean isSetAlfa();

	/**
	 * Returns the value of the '<em><b>Analyzed Samples</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Analyzed Samples</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Analyzed Samples</em>' attribute.
	 * @see #isSetAnalyzedSamples()
	 * @see #unsetAnalyzedSamples()
	 * @see #setAnalyzedSamples(int)
	 * @see jmtmodel.JmtmodelPackage#getMeasureType_AnalyzedSamples()
	 * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Int"
	 *        extendedMetaData="kind='attribute' name='analyzedSamples' namespace='##targetNamespace'"
	 * @generated
	 */
	int getAnalyzedSamples();

	/**
	 * Sets the value of the '{@link jmtmodel.MeasureType#getAnalyzedSamples <em>Analyzed Samples</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Analyzed Samples</em>' attribute.
	 * @see #isSetAnalyzedSamples()
	 * @see #unsetAnalyzedSamples()
	 * @see #getAnalyzedSamples()
	 * @generated
	 */
	void setAnalyzedSamples(int value);

	/**
	 * Unsets the value of the '{@link jmtmodel.MeasureType#getAnalyzedSamples <em>Analyzed Samples</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetAnalyzedSamples()
	 * @see #getAnalyzedSamples()
	 * @see #setAnalyzedSamples(int)
	 * @generated
	 */
	void unsetAnalyzedSamples();

	/**
	 * Returns whether the value of the '{@link jmtmodel.MeasureType#getAnalyzedSamples <em>Analyzed Samples</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Analyzed Samples</em>' attribute is set.
	 * @see #unsetAnalyzedSamples()
	 * @see #getAnalyzedSamples()
	 * @see #setAnalyzedSamples(int)
	 * @generated
	 */
	boolean isSetAnalyzedSamples();

	/**
	 * Returns the value of the '<em><b>Discarded Samples</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Discarded Samples</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Discarded Samples</em>' attribute.
	 * @see #isSetDiscardedSamples()
	 * @see #unsetDiscardedSamples()
	 * @see #setDiscardedSamples(int)
	 * @see jmtmodel.JmtmodelPackage#getMeasureType_DiscardedSamples()
	 * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Int"
	 *        extendedMetaData="kind='attribute' name='discardedSamples' namespace='##targetNamespace'"
	 * @generated
	 */
	int getDiscardedSamples();

	/**
	 * Sets the value of the '{@link jmtmodel.MeasureType#getDiscardedSamples <em>Discarded Samples</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Discarded Samples</em>' attribute.
	 * @see #isSetDiscardedSamples()
	 * @see #unsetDiscardedSamples()
	 * @see #getDiscardedSamples()
	 * @generated
	 */
	void setDiscardedSamples(int value);

	/**
	 * Unsets the value of the '{@link jmtmodel.MeasureType#getDiscardedSamples <em>Discarded Samples</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetDiscardedSamples()
	 * @see #getDiscardedSamples()
	 * @see #setDiscardedSamples(int)
	 * @generated
	 */
	void unsetDiscardedSamples();

	/**
	 * Returns whether the value of the '{@link jmtmodel.MeasureType#getDiscardedSamples <em>Discarded Samples</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Discarded Samples</em>' attribute is set.
	 * @see #unsetDiscardedSamples()
	 * @see #getDiscardedSamples()
	 * @see #setDiscardedSamples(int)
	 * @generated
	 */
	boolean isSetDiscardedSamples();

	/**
	 * Returns the value of the '<em><b>Lower Limit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Lower Limit</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Lower Limit</em>' attribute.
	 * @see #isSetLowerLimit()
	 * @see #unsetLowerLimit()
	 * @see #setLowerLimit(double)
	 * @see jmtmodel.JmtmodelPackage#getMeasureType_LowerLimit()
	 * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Double"
	 *        extendedMetaData="kind='attribute' name='lowerLimit' namespace='##targetNamespace'"
	 * @generated
	 */
	double getLowerLimit();

	/**
	 * Sets the value of the '{@link jmtmodel.MeasureType#getLowerLimit <em>Lower Limit</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Lower Limit</em>' attribute.
	 * @see #isSetLowerLimit()
	 * @see #unsetLowerLimit()
	 * @see #getLowerLimit()
	 * @generated
	 */
	void setLowerLimit(double value);

	/**
	 * Unsets the value of the '{@link jmtmodel.MeasureType#getLowerLimit <em>Lower Limit</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetLowerLimit()
	 * @see #getLowerLimit()
	 * @see #setLowerLimit(double)
	 * @generated
	 */
	void unsetLowerLimit();

	/**
	 * Returns whether the value of the '{@link jmtmodel.MeasureType#getLowerLimit <em>Lower Limit</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Lower Limit</em>' attribute is set.
	 * @see #unsetLowerLimit()
	 * @see #getLowerLimit()
	 * @see #setLowerLimit(double)
	 * @generated
	 */
	boolean isSetLowerLimit();

	/**
	 * Returns the value of the '<em><b>Max Samples</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Max Samples</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Max Samples</em>' attribute.
	 * @see #isSetMaxSamples()
	 * @see #unsetMaxSamples()
	 * @see #setMaxSamples(int)
	 * @see jmtmodel.JmtmodelPackage#getMeasureType_MaxSamples()
	 * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Int"
	 *        extendedMetaData="kind='attribute' name='maxSamples' namespace='##targetNamespace'"
	 * @generated
	 */
	int getMaxSamples();

	/**
	 * Sets the value of the '{@link jmtmodel.MeasureType#getMaxSamples <em>Max Samples</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Max Samples</em>' attribute.
	 * @see #isSetMaxSamples()
	 * @see #unsetMaxSamples()
	 * @see #getMaxSamples()
	 * @generated
	 */
	void setMaxSamples(int value);

	/**
	 * Unsets the value of the '{@link jmtmodel.MeasureType#getMaxSamples <em>Max Samples</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetMaxSamples()
	 * @see #getMaxSamples()
	 * @see #setMaxSamples(int)
	 * @generated
	 */
	void unsetMaxSamples();

	/**
	 * Returns whether the value of the '{@link jmtmodel.MeasureType#getMaxSamples <em>Max Samples</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Max Samples</em>' attribute is set.
	 * @see #unsetMaxSamples()
	 * @see #getMaxSamples()
	 * @see #setMaxSamples(int)
	 * @generated
	 */
	boolean isSetMaxSamples();

	/**
	 * Returns the value of the '<em><b>Mean Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mean Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mean Value</em>' attribute.
	 * @see #isSetMeanValue()
	 * @see #unsetMeanValue()
	 * @see #setMeanValue(double)
	 * @see jmtmodel.JmtmodelPackage#getMeasureType_MeanValue()
	 * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Double"
	 *        extendedMetaData="kind='attribute' name='meanValue' namespace='##targetNamespace'"
	 * @generated
	 */
	double getMeanValue();

	/**
	 * Sets the value of the '{@link jmtmodel.MeasureType#getMeanValue <em>Mean Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Mean Value</em>' attribute.
	 * @see #isSetMeanValue()
	 * @see #unsetMeanValue()
	 * @see #getMeanValue()
	 * @generated
	 */
	void setMeanValue(double value);

	/**
	 * Unsets the value of the '{@link jmtmodel.MeasureType#getMeanValue <em>Mean Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetMeanValue()
	 * @see #getMeanValue()
	 * @see #setMeanValue(double)
	 * @generated
	 */
	void unsetMeanValue();

	/**
	 * Returns whether the value of the '{@link jmtmodel.MeasureType#getMeanValue <em>Mean Value</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Mean Value</em>' attribute is set.
	 * @see #unsetMeanValue()
	 * @see #getMeanValue()
	 * @see #setMeanValue(double)
	 * @generated
	 */
	boolean isSetMeanValue();

	/**
	 * Returns the value of the '<em><b>Measure Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Measure Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Measure Type</em>' attribute.
	 * @see #setMeasureType(String)
	 * @see jmtmodel.JmtmodelPackage#getMeasureType_MeasureType()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
	 *        extendedMetaData="kind='attribute' name='measureType' namespace='##targetNamespace'"
	 * @generated
	 */
	String getMeasureType();

	/**
	 * Sets the value of the '{@link jmtmodel.MeasureType#getMeasureType <em>Measure Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Measure Type</em>' attribute.
	 * @see #getMeasureType()
	 * @generated
	 */
	void setMeasureType(String value);

	/**
	 * Returns the value of the '<em><b>Node Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Node Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Node Type</em>' attribute.
	 * @see #setNodeType(String)
	 * @see jmtmodel.JmtmodelPackage#getMeasureType_NodeType()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='nodeType' namespace='##targetNamespace'"
	 * @generated
	 */
	String getNodeType();

	/**
	 * Sets the value of the '{@link jmtmodel.MeasureType#getNodeType <em>Node Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Node Type</em>' attribute.
	 * @see #getNodeType()
	 * @generated
	 */
	void setNodeType(String value);

	/**
	 * Returns the value of the '<em><b>Precision</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Precision</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Precision</em>' attribute.
	 * @see #isSetPrecision()
	 * @see #unsetPrecision()
	 * @see #setPrecision(double)
	 * @see jmtmodel.JmtmodelPackage#getMeasureType_Precision()
	 * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Double"
	 *        extendedMetaData="kind='attribute' name='precision' namespace='##targetNamespace'"
	 * @generated
	 */
	double getPrecision();

	/**
	 * Sets the value of the '{@link jmtmodel.MeasureType#getPrecision <em>Precision</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Precision</em>' attribute.
	 * @see #isSetPrecision()
	 * @see #unsetPrecision()
	 * @see #getPrecision()
	 * @generated
	 */
	void setPrecision(double value);

	/**
	 * Unsets the value of the '{@link jmtmodel.MeasureType#getPrecision <em>Precision</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetPrecision()
	 * @see #getPrecision()
	 * @see #setPrecision(double)
	 * @generated
	 */
	void unsetPrecision();

	/**
	 * Returns whether the value of the '{@link jmtmodel.MeasureType#getPrecision <em>Precision</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Precision</em>' attribute is set.
	 * @see #unsetPrecision()
	 * @see #getPrecision()
	 * @see #setPrecision(double)
	 * @generated
	 */
	boolean isSetPrecision();

	/**
	 * Returns the value of the '<em><b>Successful</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Successful</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Successful</em>' attribute.
	 * @see #isSetSuccessful()
	 * @see #unsetSuccessful()
	 * @see #setSuccessful(boolean)
	 * @see jmtmodel.JmtmodelPackage#getMeasureType_Successful()
	 * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Boolean" required="true"
	 *        extendedMetaData="kind='attribute' name='successful' namespace='##targetNamespace'"
	 * @generated
	 */
	boolean isSuccessful();

	/**
	 * Sets the value of the '{@link jmtmodel.MeasureType#isSuccessful <em>Successful</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Successful</em>' attribute.
	 * @see #isSetSuccessful()
	 * @see #unsetSuccessful()
	 * @see #isSuccessful()
	 * @generated
	 */
	void setSuccessful(boolean value);

	/**
	 * Unsets the value of the '{@link jmtmodel.MeasureType#isSuccessful <em>Successful</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetSuccessful()
	 * @see #isSuccessful()
	 * @see #setSuccessful(boolean)
	 * @generated
	 */
	void unsetSuccessful();

	/**
	 * Returns whether the value of the '{@link jmtmodel.MeasureType#isSuccessful <em>Successful</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Successful</em>' attribute is set.
	 * @see #unsetSuccessful()
	 * @see #isSuccessful()
	 * @see #setSuccessful(boolean)
	 * @generated
	 */
	boolean isSetSuccessful();

	/**
	 * Returns the value of the '<em><b>Upper Limit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Upper Limit</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Upper Limit</em>' attribute.
	 * @see #isSetUpperLimit()
	 * @see #unsetUpperLimit()
	 * @see #setUpperLimit(double)
	 * @see jmtmodel.JmtmodelPackage#getMeasureType_UpperLimit()
	 * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Double"
	 *        extendedMetaData="kind='attribute' name='upperLimit' namespace='##targetNamespace'"
	 * @generated
	 */
	double getUpperLimit();

	/**
	 * Sets the value of the '{@link jmtmodel.MeasureType#getUpperLimit <em>Upper Limit</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Upper Limit</em>' attribute.
	 * @see #isSetUpperLimit()
	 * @see #unsetUpperLimit()
	 * @see #getUpperLimit()
	 * @generated
	 */
	void setUpperLimit(double value);

	/**
	 * Unsets the value of the '{@link jmtmodel.MeasureType#getUpperLimit <em>Upper Limit</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetUpperLimit()
	 * @see #getUpperLimit()
	 * @see #setUpperLimit(double)
	 * @generated
	 */
	void unsetUpperLimit();

	/**
	 * Returns whether the value of the '{@link jmtmodel.MeasureType#getUpperLimit <em>Upper Limit</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Upper Limit</em>' attribute is set.
	 * @see #unsetUpperLimit()
	 * @see #getUpperLimit()
	 * @see #setUpperLimit(double)
	 * @generated
	 */
	boolean isSetUpperLimit();

} // MeasureType
