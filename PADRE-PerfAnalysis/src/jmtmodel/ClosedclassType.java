/**
 */
package jmtmodel;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Closedclass Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link jmtmodel.ClosedclassType#getName <em>Name</em>}</li>
 *   <li>{@link jmtmodel.ClosedclassType#getPopulation <em>Population</em>}</li>
 * </ul>
 *
 * @see jmtmodel.JmtmodelPackage#getClosedclassType()
 * @model extendedMetaData="name='closedclass_._type' kind='empty'"
 * @generated
 */
public interface ClosedclassType extends EObject {
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
	 * @see jmtmodel.JmtmodelPackage#getClosedclassType_Name()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
	 *        extendedMetaData="kind='attribute' name='name' namespace='##targetNamespace'"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link jmtmodel.ClosedclassType#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Population</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Population</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Population</em>' attribute.
	 * @see #isSetPopulation()
	 * @see #unsetPopulation()
	 * @see #setPopulation(double)
	 * @see jmtmodel.JmtmodelPackage#getClosedclassType_Population()
	 * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Double" required="true"
	 *        extendedMetaData="kind='attribute' name='population' namespace='##targetNamespace'"
	 * @generated
	 */
	double getPopulation();

	/**
	 * Sets the value of the '{@link jmtmodel.ClosedclassType#getPopulation <em>Population</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Population</em>' attribute.
	 * @see #isSetPopulation()
	 * @see #unsetPopulation()
	 * @see #getPopulation()
	 * @generated
	 */
	void setPopulation(double value);

	/**
	 * Unsets the value of the '{@link jmtmodel.ClosedclassType#getPopulation <em>Population</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetPopulation()
	 * @see #getPopulation()
	 * @see #setPopulation(double)
	 * @generated
	 */
	void unsetPopulation();

	/**
	 * Returns whether the value of the '{@link jmtmodel.ClosedclassType#getPopulation <em>Population</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Population</em>' attribute is set.
	 * @see #unsetPopulation()
	 * @see #getPopulation()
	 * @see #setPopulation(double)
	 * @generated
	 */
	boolean isSetPopulation();

} // ClosedclassType
