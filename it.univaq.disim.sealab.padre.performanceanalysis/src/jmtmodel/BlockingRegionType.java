/**
 */
package jmtmodel;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Blocking Region Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link jmtmodel.BlockingRegionType#getRegionNode <em>Region Node</em>}</li>
 *   <li>{@link jmtmodel.BlockingRegionType#getGlobalConstraint <em>Global Constraint</em>}</li>
 *   <li>{@link jmtmodel.BlockingRegionType#getClassConstraint <em>Class Constraint</em>}</li>
 *   <li>{@link jmtmodel.BlockingRegionType#getClassWeight <em>Class Weight</em>}</li>
 *   <li>{@link jmtmodel.BlockingRegionType#getDropRules <em>Drop Rules</em>}</li>
 *   <li>{@link jmtmodel.BlockingRegionType#getName <em>Name</em>}</li>
 *   <li>{@link jmtmodel.BlockingRegionType#getType <em>Type</em>}</li>
 * </ul>
 *
 * @see jmtmodel.JmtmodelPackage#getBlockingRegionType()
 * @model extendedMetaData="name='blockingRegion_._type' kind='elementOnly'"
 * @generated
 */
public interface BlockingRegionType extends EObject {
	/**
	 * Returns the value of the '<em><b>Region Node</b></em>' containment reference list.
	 * The list contents are of type {@link jmtmodel.RegionNodeType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Region Node</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Region Node</em>' containment reference list.
	 * @see jmtmodel.JmtmodelPackage#getBlockingRegionType_RegionNode()
	 * @model containment="true" required="true"
	 *        extendedMetaData="kind='element' name='regionNode' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<RegionNodeType> getRegionNode();

	/**
	 * Returns the value of the '<em><b>Global Constraint</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Global Constraint</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Global Constraint</em>' containment reference.
	 * @see #setGlobalConstraint(GlobalConstraintType)
	 * @see jmtmodel.JmtmodelPackage#getBlockingRegionType_GlobalConstraint()
	 * @model containment="true" required="true"
	 *        extendedMetaData="kind='element' name='globalConstraint' namespace='##targetNamespace'"
	 * @generated
	 */
	GlobalConstraintType getGlobalConstraint();

	/**
	 * Sets the value of the '{@link jmtmodel.BlockingRegionType#getGlobalConstraint <em>Global Constraint</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Global Constraint</em>' containment reference.
	 * @see #getGlobalConstraint()
	 * @generated
	 */
	void setGlobalConstraint(GlobalConstraintType value);

	/**
	 * Returns the value of the '<em><b>Class Constraint</b></em>' containment reference list.
	 * The list contents are of type {@link jmtmodel.ClassConstraintType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Class Constraint</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Class Constraint</em>' containment reference list.
	 * @see jmtmodel.JmtmodelPackage#getBlockingRegionType_ClassConstraint()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='classConstraint' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<ClassConstraintType> getClassConstraint();

	/**
	 * Returns the value of the '<em><b>Class Weight</b></em>' containment reference list.
	 * The list contents are of type {@link jmtmodel.ClassWeightType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Class Weight</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Class Weight</em>' containment reference list.
	 * @see jmtmodel.JmtmodelPackage#getBlockingRegionType_ClassWeight()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='classWeight' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<ClassWeightType> getClassWeight();

	/**
	 * Returns the value of the '<em><b>Drop Rules</b></em>' containment reference list.
	 * The list contents are of type {@link jmtmodel.DropRulesType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Drop Rules</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Drop Rules</em>' containment reference list.
	 * @see jmtmodel.JmtmodelPackage#getBlockingRegionType_DropRules()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='dropRules' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<DropRulesType> getDropRules();

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
	 * @see jmtmodel.JmtmodelPackage#getBlockingRegionType_Name()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
	 *        extendedMetaData="kind='attribute' name='name' namespace='##targetNamespace'"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link jmtmodel.BlockingRegionType#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see #setType(String)
	 * @see jmtmodel.JmtmodelPackage#getBlockingRegionType_Type()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='type' namespace='##targetNamespace'"
	 * @generated
	 */
	String getType();

	/**
	 * Sets the value of the '{@link jmtmodel.BlockingRegionType#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see #getType()
	 * @generated
	 */
	void setType(String value);

} // BlockingRegionType
