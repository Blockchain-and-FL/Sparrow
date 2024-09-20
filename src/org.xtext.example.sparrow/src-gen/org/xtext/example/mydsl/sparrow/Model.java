/**
 * generated by Xtext 2.29.0
 */
package org.xtext.example.mydsl.sparrow;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.xtext.example.mydsl.sparrow.Model#getPackageName <em>Package Name</em>}</li>
 *   <li>{@link org.xtext.example.mydsl.sparrow.Model#getName <em>Name</em>}</li>
 *   <li>{@link org.xtext.example.mydsl.sparrow.Model#getExtendName <em>Extend Name</em>}</li>
 *   <li>{@link org.xtext.example.mydsl.sparrow.Model#getSubjects <em>Subjects</em>}</li>
 *   <li>{@link org.xtext.example.mydsl.sparrow.Model#getObjects <em>Objects</em>}</li>
 *   <li>{@link org.xtext.example.mydsl.sparrow.Model#getGroup <em>Group</em>}</li>
 *   <li>{@link org.xtext.example.mydsl.sparrow.Model#getInitialize <em>Initialize</em>}</li>
 *   <li>{@link org.xtext.example.mydsl.sparrow.Model#getContractMessage <em>Contract Message</em>}</li>
 *   <li>{@link org.xtext.example.mydsl.sparrow.Model#getConditions <em>Conditions</em>}</li>
 *   <li>{@link org.xtext.example.mydsl.sparrow.Model#getOperations <em>Operations</em>}</li>
 *   <li>{@link org.xtext.example.mydsl.sparrow.Model#getRuleStructures <em>Rule Structures</em>}</li>
 *   <li>{@link org.xtext.example.mydsl.sparrow.Model#getRequire <em>Require</em>}</li>
 * </ul>
 *
 * @see org.xtext.example.mydsl.sparrow.SparrowPackage#getModel()
 * @model
 * @generated
 */
public interface Model extends EObject
{
  /**
   * Returns the value of the '<em><b>Package Name</b></em>' attribute list.
   * The list contents are of type {@link java.lang.String}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Package Name</em>' attribute list.
   * @see org.xtext.example.mydsl.sparrow.SparrowPackage#getModel_PackageName()
   * @model unique="false"
   * @generated
   */
  EList<String> getPackageName();

  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see org.xtext.example.mydsl.sparrow.SparrowPackage#getModel_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link org.xtext.example.mydsl.sparrow.Model#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Extend Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Extend Name</em>' attribute.
   * @see #setExtendName(String)
   * @see org.xtext.example.mydsl.sparrow.SparrowPackage#getModel_ExtendName()
   * @model
   * @generated
   */
  String getExtendName();

  /**
   * Sets the value of the '{@link org.xtext.example.mydsl.sparrow.Model#getExtendName <em>Extend Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Extend Name</em>' attribute.
   * @see #getExtendName()
   * @generated
   */
  void setExtendName(String value);

  /**
   * Returns the value of the '<em><b>Subjects</b></em>' containment reference list.
   * The list contents are of type {@link org.xtext.example.mydsl.sparrow.Subject}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Subjects</em>' containment reference list.
   * @see org.xtext.example.mydsl.sparrow.SparrowPackage#getModel_Subjects()
   * @model containment="true"
   * @generated
   */
  EList<Subject> getSubjects();

  /**
   * Returns the value of the '<em><b>Objects</b></em>' containment reference list.
   * The list contents are of type {@link org.xtext.example.mydsl.sparrow.Object}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Objects</em>' containment reference list.
   * @see org.xtext.example.mydsl.sparrow.SparrowPackage#getModel_Objects()
   * @model containment="true"
   * @generated
   */
  EList<org.xtext.example.mydsl.sparrow.Object> getObjects();

  /**
   * Returns the value of the '<em><b>Group</b></em>' containment reference list.
   * The list contents are of type {@link org.xtext.example.mydsl.sparrow.Group}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Group</em>' containment reference list.
   * @see org.xtext.example.mydsl.sparrow.SparrowPackage#getModel_Group()
   * @model containment="true"
   * @generated
   */
  EList<Group> getGroup();

  /**
   * Returns the value of the '<em><b>Initialize</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Initialize</em>' containment reference.
   * @see #setInitialize(Initialize)
   * @see org.xtext.example.mydsl.sparrow.SparrowPackage#getModel_Initialize()
   * @model containment="true"
   * @generated
   */
  Initialize getInitialize();

  /**
   * Sets the value of the '{@link org.xtext.example.mydsl.sparrow.Model#getInitialize <em>Initialize</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Initialize</em>' containment reference.
   * @see #getInitialize()
   * @generated
   */
  void setInitialize(Initialize value);

  /**
   * Returns the value of the '<em><b>Contract Message</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Contract Message</em>' containment reference.
   * @see #setContractMessage(ContractMessage)
   * @see org.xtext.example.mydsl.sparrow.SparrowPackage#getModel_ContractMessage()
   * @model containment="true"
   * @generated
   */
  ContractMessage getContractMessage();

  /**
   * Sets the value of the '{@link org.xtext.example.mydsl.sparrow.Model#getContractMessage <em>Contract Message</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Contract Message</em>' containment reference.
   * @see #getContractMessage()
   * @generated
   */
  void setContractMessage(ContractMessage value);

  /**
   * Returns the value of the '<em><b>Conditions</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Conditions</em>' containment reference.
   * @see #setConditions(Condition)
   * @see org.xtext.example.mydsl.sparrow.SparrowPackage#getModel_Conditions()
   * @model containment="true"
   * @generated
   */
  Condition getConditions();

  /**
   * Sets the value of the '{@link org.xtext.example.mydsl.sparrow.Model#getConditions <em>Conditions</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Conditions</em>' containment reference.
   * @see #getConditions()
   * @generated
   */
  void setConditions(Condition value);

  /**
   * Returns the value of the '<em><b>Operations</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Operations</em>' containment reference.
   * @see #setOperations(Operation)
   * @see org.xtext.example.mydsl.sparrow.SparrowPackage#getModel_Operations()
   * @model containment="true"
   * @generated
   */
  Operation getOperations();

  /**
   * Sets the value of the '{@link org.xtext.example.mydsl.sparrow.Model#getOperations <em>Operations</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Operations</em>' containment reference.
   * @see #getOperations()
   * @generated
   */
  void setOperations(Operation value);

  /**
   * Returns the value of the '<em><b>Rule Structures</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Rule Structures</em>' containment reference.
   * @see #setRuleStructures(RuleStructure)
   * @see org.xtext.example.mydsl.sparrow.SparrowPackage#getModel_RuleStructures()
   * @model containment="true"
   * @generated
   */
  RuleStructure getRuleStructures();

  /**
   * Sets the value of the '{@link org.xtext.example.mydsl.sparrow.Model#getRuleStructures <em>Rule Structures</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Rule Structures</em>' containment reference.
   * @see #getRuleStructures()
   * @generated
   */
  void setRuleStructures(RuleStructure value);

  /**
   * Returns the value of the '<em><b>Require</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Require</em>' containment reference.
   * @see #setRequire(Require)
   * @see org.xtext.example.mydsl.sparrow.SparrowPackage#getModel_Require()
   * @model containment="true"
   * @generated
   */
  Require getRequire();

  /**
   * Sets the value of the '{@link org.xtext.example.mydsl.sparrow.Model#getRequire <em>Require</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Require</em>' containment reference.
   * @see #getRequire()
   * @generated
   */
  void setRequire(Require value);

} // Model