/**
 */
package jmtmodel;

import java.math.BigInteger;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.ecore.util.FeatureMap;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Classes Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link jmtmodel.ClassesType#getGroup <em>Group</em>}</li>
 *   <li>{@link jmtmodel.ClassesType#getClosedclass <em>Closedclass</em>}</li>
 *   <li>{@link jmtmodel.ClassesType#getOpenclass <em>Openclass</em>}</li>
 *   <li>{@link jmtmodel.ClassesType#getNumber <em>Number</em>}</li>
 * </ul>
 *
 * @see jmtmodel.JmtmodelPackage#getClassesType()
 * @model extendedMetaData="name='classes_._type' kind='elementOnly'"
 * @generated
 */
public interface ClassesType extends EObject {
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
	 * @see jmtmodel.JmtmodelPackage#getClassesType_Group()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.EFeatureMapEntry" many="true"
	 *        extendedMetaData="kind='group' name='group:0'"
	 * @generated
	 */
	FeatureMap getGroup();

	/**
	 * Returns the value of the '<em><b>Closedclass</b></em>' containment reference list.
	 * The list contents are of type {@link jmtmodel.ClosedclassType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Closedclass</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Closedclass</em>' containment reference list.
	 * @see jmtmodel.JmtmodelPackage#getClassesType_Closedclass()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='closedclass' namespace='##targetNamespace' group='group:0'"
	 * @generated
	 */
	EList<ClosedclassType> getClosedclass();

	/**
	 * Returns the value of the '<em><b>Openclass</b></em>' containment reference list.
	 * The list contents are of type {@link jmtmodel.OpenclassType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Openclass</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Openclass</em>' containment reference list.
	 * @see jmtmodel.JmtmodelPackage#getClassesType_Openclass()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='openclass' namespace='##targetNamespace' group='group:0'"
	 * @generated
	 */
	EList<OpenclassType> getOpenclass();

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
	 * @see jmtmodel.JmtmodelPackage#getClassesType_Number()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.PositiveInteger" required="true"
	 *        extendedMetaData="kind='attribute' name='number' namespace='##targetNamespace'"
	 * @generated
	 */
	BigInteger getNumber();

	/**
	 * Sets the value of the '{@link jmtmodel.ClassesType#getNumber <em>Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Number</em>' attribute.
	 * @see #getNumber()
	 * @generated
	 */
	void setNumber(BigInteger value);

} // ClassesType
