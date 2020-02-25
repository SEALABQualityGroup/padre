/**
 */
package jmtmodel;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Regionresults Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link jmtmodel.RegionresultsType#getClassresults <em>Classresults</em>}</li>
 *   <li>{@link jmtmodel.RegionresultsType#getRegion <em>Region</em>}</li>
 * </ul>
 *
 * @see jmtmodel.JmtmodelPackage#getRegionresultsType()
 * @model extendedMetaData="name='regionresults_._type' kind='elementOnly'"
 * @generated
 */
public interface RegionresultsType extends EObject {
	/**
	 * Returns the value of the '<em><b>Classresults</b></em>' containment reference list.
	 * The list contents are of type {@link jmtmodel.ClassresultsType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Classresults</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Classresults</em>' containment reference list.
	 * @see jmtmodel.JmtmodelPackage#getRegionresultsType_Classresults()
	 * @model containment="true" required="true"
	 *        extendedMetaData="kind='element' name='classresults' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<ClassresultsType> getClassresults();

	/**
	 * Returns the value of the '<em><b>Region</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Region</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Region</em>' attribute.
	 * @see #setRegion(String)
	 * @see jmtmodel.JmtmodelPackage#getRegionresultsType_Region()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
	 *        extendedMetaData="kind='attribute' name='region' namespace='##targetNamespace'"
	 * @generated
	 */
	String getRegion();

	/**
	 * Sets the value of the '{@link jmtmodel.RegionresultsType#getRegion <em>Region</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Region</em>' attribute.
	 * @see #getRegion()
	 * @generated
	 */
	void setRegion(String value);

} // RegionresultsType
