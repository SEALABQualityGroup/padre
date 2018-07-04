/**
 */
package jmtmodel;

import java.math.BigInteger;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Solutions Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link jmtmodel.SolutionsType#getStationresults <em>Stationresults</em>}</li>
 *   <li>{@link jmtmodel.SolutionsType#getRegionresults <em>Regionresults</em>}</li>
 *   <li>{@link jmtmodel.SolutionsType#getIteration <em>Iteration</em>}</li>
 *   <li>{@link jmtmodel.SolutionsType#getIterationValue <em>Iteration Value</em>}</li>
 *   <li>{@link jmtmodel.SolutionsType#isOk <em>Ok</em>}</li>
 *   <li>{@link jmtmodel.SolutionsType#getSolutionMethod <em>Solution Method</em>}</li>
 * </ul>
 *
 * @see jmtmodel.JmtmodelPackage#getSolutionsType()
 * @model extendedMetaData="name='solutions_._type' kind='elementOnly'"
 * @generated
 */
public interface SolutionsType extends EObject {
	/**
	 * Returns the value of the '<em><b>Stationresults</b></em>' containment reference list.
	 * The list contents are of type {@link jmtmodel.StationresultsType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Stationresults</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Stationresults</em>' containment reference list.
	 * @see jmtmodel.JmtmodelPackage#getSolutionsType_Stationresults()
	 * @model containment="true" required="true"
	 *        extendedMetaData="kind='element' name='stationresults' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<StationresultsType> getStationresults();

	/**
	 * Returns the value of the '<em><b>Regionresults</b></em>' containment reference list.
	 * The list contents are of type {@link jmtmodel.RegionresultsType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Regionresults</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Regionresults</em>' containment reference list.
	 * @see jmtmodel.JmtmodelPackage#getSolutionsType_Regionresults()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='regionresults' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<RegionresultsType> getRegionresults();

	/**
	 * Returns the value of the '<em><b>Iteration</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Iteration</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Iteration</em>' attribute.
	 * @see #setIteration(BigInteger)
	 * @see jmtmodel.JmtmodelPackage#getSolutionsType_Iteration()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.Integer"
	 *        extendedMetaData="kind='attribute' name='iteration' namespace='##targetNamespace'"
	 * @generated
	 */
	BigInteger getIteration();

	/**
	 * Sets the value of the '{@link jmtmodel.SolutionsType#getIteration <em>Iteration</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Iteration</em>' attribute.
	 * @see #getIteration()
	 * @generated
	 */
	void setIteration(BigInteger value);

	/**
	 * Returns the value of the '<em><b>Iteration Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Iteration Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Iteration Value</em>' attribute.
	 * @see #isSetIterationValue()
	 * @see #unsetIterationValue()
	 * @see #setIterationValue(double)
	 * @see jmtmodel.JmtmodelPackage#getSolutionsType_IterationValue()
	 * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Double"
	 *        extendedMetaData="kind='attribute' name='iterationValue' namespace='##targetNamespace'"
	 * @generated
	 */
	double getIterationValue();

	/**
	 * Sets the value of the '{@link jmtmodel.SolutionsType#getIterationValue <em>Iteration Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Iteration Value</em>' attribute.
	 * @see #isSetIterationValue()
	 * @see #unsetIterationValue()
	 * @see #getIterationValue()
	 * @generated
	 */
	void setIterationValue(double value);

	/**
	 * Unsets the value of the '{@link jmtmodel.SolutionsType#getIterationValue <em>Iteration Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetIterationValue()
	 * @see #getIterationValue()
	 * @see #setIterationValue(double)
	 * @generated
	 */
	void unsetIterationValue();

	/**
	 * Returns whether the value of the '{@link jmtmodel.SolutionsType#getIterationValue <em>Iteration Value</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Iteration Value</em>' attribute is set.
	 * @see #unsetIterationValue()
	 * @see #getIterationValue()
	 * @see #setIterationValue(double)
	 * @generated
	 */
	boolean isSetIterationValue();

	/**
	 * Returns the value of the '<em><b>Ok</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ok</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ok</em>' attribute.
	 * @see #isSetOk()
	 * @see #unsetOk()
	 * @see #setOk(boolean)
	 * @see jmtmodel.JmtmodelPackage#getSolutionsType_Ok()
	 * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Boolean"
	 *        extendedMetaData="kind='attribute' name='ok' namespace='##targetNamespace'"
	 * @generated
	 */
	boolean isOk();

	/**
	 * Sets the value of the '{@link jmtmodel.SolutionsType#isOk <em>Ok</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ok</em>' attribute.
	 * @see #isSetOk()
	 * @see #unsetOk()
	 * @see #isOk()
	 * @generated
	 */
	void setOk(boolean value);

	/**
	 * Unsets the value of the '{@link jmtmodel.SolutionsType#isOk <em>Ok</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetOk()
	 * @see #isOk()
	 * @see #setOk(boolean)
	 * @generated
	 */
	void unsetOk();

	/**
	 * Returns whether the value of the '{@link jmtmodel.SolutionsType#isOk <em>Ok</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Ok</em>' attribute is set.
	 * @see #unsetOk()
	 * @see #isOk()
	 * @see #setOk(boolean)
	 * @generated
	 */
	boolean isSetOk();

	/**
	 * Returns the value of the '<em><b>Solution Method</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Solution Method</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Solution Method</em>' attribute.
	 * @see #setSolutionMethod(String)
	 * @see jmtmodel.JmtmodelPackage#getSolutionsType_SolutionMethod()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='solutionMethod' namespace='##targetNamespace'"
	 * @generated
	 */
	String getSolutionMethod();

	/**
	 * Sets the value of the '{@link jmtmodel.SolutionsType#getSolutionMethod <em>Solution Method</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Solution Method</em>' attribute.
	 * @see #getSolutionMethod()
	 * @generated
	 */
	void setSolutionMethod(String value);

} // SolutionsType
