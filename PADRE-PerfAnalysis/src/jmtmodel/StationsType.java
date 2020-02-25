/**
 */
package jmtmodel;

import java.math.BigInteger;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.ecore.util.FeatureMap;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Stations Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link jmtmodel.StationsType#getGroup <em>Group</em>}</li>
 *   <li>{@link jmtmodel.StationsType#getDelaystation <em>Delaystation</em>}</li>
 *   <li>{@link jmtmodel.StationsType#getListation <em>Listation</em>}</li>
 *   <li>{@link jmtmodel.StationsType#getLdstation <em>Ldstation</em>}</li>
 *   <li>{@link jmtmodel.StationsType#getNumber <em>Number</em>}</li>
 * </ul>
 *
 * @see jmtmodel.JmtmodelPackage#getStationsType()
 * @model extendedMetaData="name='stations_._type' kind='elementOnly'"
 * @generated
 */
public interface StationsType extends EObject {
	/**
	 * Returns the value of the '<em><b>Group</b></em>' attribute list.
	 * The list contents are of type {@link org.eclipse.emf.ecore.util.FeatureMap.Entry}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Group</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Group</em>' attribute list.
	 * @see jmtmodel.JmtmodelPackage#getStationsType_Group()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.EFeatureMapEntry" many="true"
	 *        extendedMetaData="kind='group' name='group:0'"
	 * @generated
	 */
	FeatureMap getGroup();

	/**
	 * Returns the value of the '<em><b>Delaystation</b></em>' containment reference list.
	 * The list contents are of type {@link jmtmodel.DelaystationType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Delaystation</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Delaystation</em>' containment reference list.
	 * @see jmtmodel.JmtmodelPackage#getStationsType_Delaystation()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='delaystation' namespace='##targetNamespace' group='group:0'"
	 * @generated
	 */
	EList<DelaystationType> getDelaystation();

	/**
	 * Returns the value of the '<em><b>Listation</b></em>' containment reference list.
	 * The list contents are of type {@link jmtmodel.ListationType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Listation</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Listation</em>' containment reference list.
	 * @see jmtmodel.JmtmodelPackage#getStationsType_Listation()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='listation' namespace='##targetNamespace' group='group:0'"
	 * @generated
	 */
	EList<ListationType> getListation();

	/**
	 * Returns the value of the '<em><b>Ldstation</b></em>' containment reference list.
	 * The list contents are of type {@link jmtmodel.LdstationType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ldstation</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ldstation</em>' containment reference list.
	 * @see jmtmodel.JmtmodelPackage#getStationsType_Ldstation()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='ldstation' namespace='##targetNamespace' group='group:0'"
	 * @generated
	 */
	EList<LdstationType> getLdstation();

	/**
	 * Returns the value of the '<em><b>Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Number</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Number</em>' attribute.
	 * @see #setNumber(BigInteger)
	 * @see jmtmodel.JmtmodelPackage#getStationsType_Number()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.PositiveInteger" required="true"
	 *        extendedMetaData="kind='attribute' name='number' namespace='##targetNamespace'"
	 * @generated
	 */
	BigInteger getNumber();

	/**
	 * Sets the value of the '{@link jmtmodel.StationsType#getNumber <em>Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Number</em>' attribute.
	 * @see #getNumber()
	 * @generated
	 */
	void setNumber(BigInteger value);

} // StationsType
