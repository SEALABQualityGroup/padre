/**
 */
package jmtmodel;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Delaystation Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link jmtmodel.DelaystationType#getServicetimes <em>Servicetimes</em>}</li>
 *   <li>{@link jmtmodel.DelaystationType#getVisits <em>Visits</em>}</li>
 *   <li>{@link jmtmodel.DelaystationType#getName <em>Name</em>}</li>
 * </ul>
 *
 * @see jmtmodel.JmtmodelPackage#getDelaystationType()
 * @model extendedMetaData="name='delaystation_._type' kind='elementOnly'"
 * @generated
 */
public interface DelaystationType extends EObject {
	/**
	 * Returns the value of the '<em><b>Servicetimes</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Servicetimes</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Servicetimes</em>' containment reference.
	 * @see #setServicetimes(ServicetimesType3)
	 * @see jmtmodel.JmtmodelPackage#getDelaystationType_Servicetimes()
	 * @model containment="true" required="true"
	 *        extendedMetaData="kind='element' name='servicetimes' namespace='##targetNamespace'"
	 * @generated
	 */
	ServicetimesType3 getServicetimes();

	/**
	 * Sets the value of the '{@link jmtmodel.DelaystationType#getServicetimes <em>Servicetimes</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Servicetimes</em>' containment reference.
	 * @see #getServicetimes()
	 * @generated
	 */
	void setServicetimes(ServicetimesType3 value);

	/**
	 * Returns the value of the '<em><b>Visits</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Visits</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Visits</em>' containment reference.
	 * @see #setVisits(VisitsType2)
	 * @see jmtmodel.JmtmodelPackage#getDelaystationType_Visits()
	 * @model containment="true" required="true"
	 *        extendedMetaData="kind='element' name='visits' namespace='##targetNamespace'"
	 * @generated
	 */
	VisitsType2 getVisits();

	/**
	 * Sets the value of the '{@link jmtmodel.DelaystationType#getVisits <em>Visits</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Visits</em>' containment reference.
	 * @see #getVisits()
	 * @generated
	 */
	void setVisits(VisitsType2 value);

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see jmtmodel.JmtmodelPackage#getDelaystationType_Name()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
	 *        extendedMetaData="kind='attribute' name='name' namespace='##targetNamespace'"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link jmtmodel.DelaystationType#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

} // DelaystationType
