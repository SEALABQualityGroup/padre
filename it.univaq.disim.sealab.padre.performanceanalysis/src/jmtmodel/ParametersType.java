/**
 */
package jmtmodel;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Parameters Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link jmtmodel.ParametersType#getClasses <em>Classes</em>}</li>
 *   <li>{@link jmtmodel.ParametersType#getStations <em>Stations</em>}</li>
 *   <li>{@link jmtmodel.ParametersType#getReferenceStation <em>Reference Station</em>}</li>
 * </ul>
 *
 * @see jmtmodel.JmtmodelPackage#getParametersType()
 * @model extendedMetaData="name='parameters_._type' kind='elementOnly'"
 * @generated
 */
public interface ParametersType extends EObject {
	/**
	 * Returns the value of the '<em><b>Classes</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Classes</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Classes</em>' containment reference.
	 * @see #setClasses(ClassesType)
	 * @see jmtmodel.JmtmodelPackage#getParametersType_Classes()
	 * @model containment="true" required="true"
	 *        extendedMetaData="kind='element' name='classes' namespace='##targetNamespace'"
	 * @generated
	 */
	ClassesType getClasses();

	/**
	 * Sets the value of the '{@link jmtmodel.ParametersType#getClasses <em>Classes</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Classes</em>' containment reference.
	 * @see #getClasses()
	 * @generated
	 */
	void setClasses(ClassesType value);

	/**
	 * Returns the value of the '<em><b>Stations</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Stations</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Stations</em>' containment reference.
	 * @see #setStations(StationsType)
	 * @see jmtmodel.JmtmodelPackage#getParametersType_Stations()
	 * @model containment="true" required="true"
	 *        extendedMetaData="kind='element' name='stations' namespace='##targetNamespace'"
	 * @generated
	 */
	StationsType getStations();

	/**
	 * Sets the value of the '{@link jmtmodel.ParametersType#getStations <em>Stations</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Stations</em>' containment reference.
	 * @see #getStations()
	 * @generated
	 */
	void setStations(StationsType value);

	/**
	 * Returns the value of the '<em><b>Reference Station</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Reference Station</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Reference Station</em>' containment reference.
	 * @see #setReferenceStation(ReferenceStationType)
	 * @see jmtmodel.JmtmodelPackage#getParametersType_ReferenceStation()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='referenceStation' namespace='##targetNamespace'"
	 * @generated
	 */
	ReferenceStationType getReferenceStation();

	/**
	 * Sets the value of the '{@link jmtmodel.ParametersType#getReferenceStation <em>Reference Station</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Reference Station</em>' containment reference.
	 * @see #getReferenceStation()
	 * @generated
	 */
	void setReferenceStation(ReferenceStationType value);

} // ParametersType
