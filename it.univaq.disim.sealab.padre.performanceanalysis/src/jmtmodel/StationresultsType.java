/**
 */
package jmtmodel;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Stationresults Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link jmtmodel.StationresultsType#getClassresults <em>Classresults</em>}</li>
 *   <li>{@link jmtmodel.StationresultsType#getStation <em>Station</em>}</li>
 * </ul>
 *
 * @see jmtmodel.JmtmodelPackage#getStationresultsType()
 * @model extendedMetaData="name='stationresults_._type' kind='elementOnly'"
 * @generated
 */
public interface StationresultsType extends EObject {
	/**
	 * Returns the value of the '<em><b>Classresults</b></em>' containment reference list.
	 * The list contents are of type {@link jmtmodel.ClassresultsType1}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Classresults</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Classresults</em>' containment reference list.
	 * @see jmtmodel.JmtmodelPackage#getStationresultsType_Classresults()
	 * @model containment="true" required="true"
	 *        extendedMetaData="kind='element' name='classresults' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<ClassresultsType1> getClassresults();

	/**
	 * Returns the value of the '<em><b>Station</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Station</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Station</em>' attribute.
	 * @see #setStation(String)
	 * @see jmtmodel.JmtmodelPackage#getStationresultsType_Station()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
	 *        extendedMetaData="kind='attribute' name='station' namespace='##targetNamespace'"
	 * @generated
	 */
	String getStation();

	/**
	 * Sets the value of the '{@link jmtmodel.StationresultsType#getStation <em>Station</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Station</em>' attribute.
	 * @see #getStation()
	 * @generated
	 */
	void setStation(String value);

} // StationresultsType
