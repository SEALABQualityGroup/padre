/**
 */
package jmtmodel;

import java.math.BigInteger;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ldstation Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link jmtmodel.LdstationType#getServicetimes <em>Servicetimes</em>}</li>
 *   <li>{@link jmtmodel.LdstationType#getVisits <em>Visits</em>}</li>
 *   <li>{@link jmtmodel.LdstationType#getName <em>Name</em>}</li>
 *   <li>{@link jmtmodel.LdstationType#getServers <em>Servers</em>}</li>
 * </ul>
 *
 * @see jmtmodel.JmtmodelPackage#getLdstationType()
 * @model extendedMetaData="name='ldstation_._type' kind='elementOnly'"
 * @generated
 */
public interface LdstationType extends EObject {
	/**
	 * Returns the value of the '<em><b>Servicetimes</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Servicetimes</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Servicetimes</em>' containment reference.
	 * @see #setServicetimes(ServicetimesType2)
	 * @see jmtmodel.JmtmodelPackage#getLdstationType_Servicetimes()
	 * @model containment="true" required="true"
	 *        extendedMetaData="kind='element' name='servicetimes' namespace='##targetNamespace'"
	 * @generated
	 */
	ServicetimesType2 getServicetimes();

	/**
	 * Sets the value of the '{@link jmtmodel.LdstationType#getServicetimes <em>Servicetimes</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Servicetimes</em>' containment reference.
	 * @see #getServicetimes()
	 * @generated
	 */
	void setServicetimes(ServicetimesType2 value);

	/**
	 * Returns the value of the '<em><b>Visits</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Visits</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Visits</em>' containment reference.
	 * @see #setVisits(VisitsType1)
	 * @see jmtmodel.JmtmodelPackage#getLdstationType_Visits()
	 * @model containment="true" required="true"
	 *        extendedMetaData="kind='element' name='visits' namespace='##targetNamespace'"
	 * @generated
	 */
	VisitsType1 getVisits();

	/**
	 * Sets the value of the '{@link jmtmodel.LdstationType#getVisits <em>Visits</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Visits</em>' containment reference.
	 * @see #getVisits()
	 * @generated
	 */
	void setVisits(VisitsType1 value);

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
	 * @see jmtmodel.JmtmodelPackage#getLdstationType_Name()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
	 *        extendedMetaData="kind='attribute' name='name' namespace='##targetNamespace'"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link jmtmodel.LdstationType#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Servers</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Servers</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Servers</em>' attribute.
	 * @see #setServers(BigInteger)
	 * @see jmtmodel.JmtmodelPackage#getLdstationType_Servers()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.Integer"
	 *        extendedMetaData="kind='attribute' name='servers' namespace='##targetNamespace'"
	 * @generated
	 */
	BigInteger getServers();

	/**
	 * Sets the value of the '{@link jmtmodel.LdstationType#getServers <em>Servers</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Servers</em>' attribute.
	 * @see #getServers()
	 * @generated
	 */
	void setServers(BigInteger value);

} // LdstationType
