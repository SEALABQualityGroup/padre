/**
 */
package jmtmodel;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Model Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link jmtmodel.ModelType#getDescription <em>Description</em>}</li>
 *   <li>{@link jmtmodel.ModelType#getParameters <em>Parameters</em>}</li>
 *   <li>{@link jmtmodel.ModelType#getBlockingRegion <em>Blocking Region</em>}</li>
 *   <li>{@link jmtmodel.ModelType#getWhatIf <em>What If</em>}</li>
 *   <li>{@link jmtmodel.ModelType#getSolutions <em>Solutions</em>}</li>
 *   <li>{@link jmtmodel.ModelType#isJaba <em>Jaba</em>}</li>
 * </ul>
 *
 * @see jmtmodel.JmtmodelPackage#getModelType()
 * @model extendedMetaData="name='model_._type' kind='elementOnly'"
 * @generated
 */
public interface ModelType extends EObject {
	/**
	 * Returns the value of the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Description</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Description</em>' attribute.
	 * @see #setDescription(String)
	 * @see jmtmodel.JmtmodelPackage#getModelType_Description()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='element' name='description' namespace='##targetNamespace'"
	 * @generated
	 */
	String getDescription();

	/**
	 * Sets the value of the '{@link jmtmodel.ModelType#getDescription <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Description</em>' attribute.
	 * @see #getDescription()
	 * @generated
	 */
	void setDescription(String value);

	/**
	 * Returns the value of the '<em><b>Parameters</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parameters</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parameters</em>' containment reference.
	 * @see #setParameters(ParametersType)
	 * @see jmtmodel.JmtmodelPackage#getModelType_Parameters()
	 * @model containment="true" required="true"
	 *        extendedMetaData="kind='element' name='parameters' namespace='##targetNamespace'"
	 * @generated
	 */
	ParametersType getParameters();

	/**
	 * Sets the value of the '{@link jmtmodel.ModelType#getParameters <em>Parameters</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parameters</em>' containment reference.
	 * @see #getParameters()
	 * @generated
	 */
	void setParameters(ParametersType value);

	/**
	 * Returns the value of the '<em><b>Blocking Region</b></em>' containment reference list.
	 * The list contents are of type {@link jmtmodel.BlockingRegionType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Blocking Region</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Blocking Region</em>' containment reference list.
	 * @see jmtmodel.JmtmodelPackage#getModelType_BlockingRegion()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='blockingRegion' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<BlockingRegionType> getBlockingRegion();

	/**
	 * Returns the value of the '<em><b>What If</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>What If</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>What If</em>' containment reference.
	 * @see #setWhatIf(WhatIfType)
	 * @see jmtmodel.JmtmodelPackage#getModelType_WhatIf()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='whatIf' namespace='##targetNamespace'"
	 * @generated
	 */
	WhatIfType getWhatIf();

	/**
	 * Sets the value of the '{@link jmtmodel.ModelType#getWhatIf <em>What If</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>What If</em>' containment reference.
	 * @see #getWhatIf()
	 * @generated
	 */
	void setWhatIf(WhatIfType value);

	/**
	 * Returns the value of the '<em><b>Solutions</b></em>' containment reference list.
	 * The list contents are of type {@link jmtmodel.SolutionsType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Solutions</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Solutions</em>' containment reference list.
	 * @see jmtmodel.JmtmodelPackage#getModelType_Solutions()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='solutions' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<SolutionsType> getSolutions();

	/**
	 * Returns the value of the '<em><b>Jaba</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Jaba</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Jaba</em>' attribute.
	 * @see #isSetJaba()
	 * @see #unsetJaba()
	 * @see #setJaba(boolean)
	 * @see jmtmodel.JmtmodelPackage#getModelType_Jaba()
	 * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Boolean"
	 *        extendedMetaData="kind='attribute' name='jaba' namespace='##targetNamespace'"
	 * @generated
	 */
	boolean isJaba();

	/**
	 * Sets the value of the '{@link jmtmodel.ModelType#isJaba <em>Jaba</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Jaba</em>' attribute.
	 * @see #isSetJaba()
	 * @see #unsetJaba()
	 * @see #isJaba()
	 * @generated
	 */
	void setJaba(boolean value);

	/**
	 * Unsets the value of the '{@link jmtmodel.ModelType#isJaba <em>Jaba</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetJaba()
	 * @see #isJaba()
	 * @see #setJaba(boolean)
	 * @generated
	 */
	void unsetJaba();

	/**
	 * Returns whether the value of the '{@link jmtmodel.ModelType#isJaba <em>Jaba</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Jaba</em>' attribute is set.
	 * @see #unsetJaba()
	 * @see #isJaba()
	 * @see #setJaba(boolean)
	 * @generated
	 */
	boolean isSetJaba();

} // ModelType
