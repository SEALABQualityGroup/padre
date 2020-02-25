/**
 */
package jmtmodel;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Classresults Type1</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link jmtmodel.ClassresultsType1#getMeasure <em>Measure</em>}</li>
 *   <li>{@link jmtmodel.ClassresultsType1#getCustomerclass <em>Customerclass</em>}</li>
 * </ul>
 *
 * @see jmtmodel.JmtmodelPackage#getClassresultsType1()
 * @model extendedMetaData="name='classresults_._1_._type' kind='elementOnly'"
 * @generated
 */
public interface ClassresultsType1 extends EObject {
	/**
	 * Returns the value of the '<em><b>Measure</b></em>' containment reference list.
	 * The list contents are of type {@link jmtmodel.MeasureType1}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Measure</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Measure</em>' containment reference list.
	 * @see jmtmodel.JmtmodelPackage#getClassresultsType1_Measure()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='measure' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<MeasureType1> getMeasure();

	/**
	 * Returns the value of the '<em><b>Customerclass</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Customerclass</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Customerclass</em>' attribute.
	 * @see #setCustomerclass(String)
	 * @see jmtmodel.JmtmodelPackage#getClassresultsType1_Customerclass()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
	 *        extendedMetaData="kind='attribute' name='customerclass' namespace='##targetNamespace'"
	 * @generated
	 */
	String getCustomerclass();

	/**
	 * Sets the value of the '{@link jmtmodel.ClassresultsType1#getCustomerclass <em>Customerclass</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Customerclass</em>' attribute.
	 * @see #getCustomerclass()
	 * @generated
	 */
	void setCustomerclass(String value);

} // ClassresultsType1
