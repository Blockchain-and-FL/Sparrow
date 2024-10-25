/**
 * generated by Xtext 2.29.0
 */
package org.xtext.example.mydsl.sparrow;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Rule Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.xtext.example.mydsl.sparrow.RuleExpression#getRepeat <em>Repeat</em>}</li>
 *   <li>{@link org.xtext.example.mydsl.sparrow.RuleExpression#getName <em>Name</em>}</li>
 *   <li>{@link org.xtext.example.mydsl.sparrow.RuleExpression#getSet <em>Set</em>}</li>
 *   <li>{@link org.xtext.example.mydsl.sparrow.RuleExpression#getSetdate <em>Setdate</em>}</li>
 *   <li>{@link org.xtext.example.mydsl.sparrow.RuleExpression#getTotalCondition <em>Total Condition</em>}</li>
 *   <li>{@link org.xtext.example.mydsl.sparrow.RuleExpression#getTotalOperation <em>Total Operation</em>}</li>
 *   <li>{@link org.xtext.example.mydsl.sparrow.RuleExpression#getSubExpression <em>Sub Expression</em>}</li>
 *   <li>{@link org.xtext.example.mydsl.sparrow.RuleExpression#getElseExpression <em>Else Expression</em>}</li>
 * </ul>
 *
 * @see org.xtext.example.mydsl.sparrow.SparrowPackage#getRuleExpression()
 * @model
 * @generated
 */
public interface RuleExpression extends EObject
{
  /**
   * Returns the value of the '<em><b>Repeat</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Repeat</em>' attribute.
   * @see #setRepeat(String)
   * @see org.xtext.example.mydsl.sparrow.SparrowPackage#getRuleExpression_Repeat()
   * @model
   * @generated
   */
  String getRepeat();

  /**
   * Sets the value of the '{@link org.xtext.example.mydsl.sparrow.RuleExpression#getRepeat <em>Repeat</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Repeat</em>' attribute.
   * @see #getRepeat()
   * @generated
   */
  void setRepeat(String value);

  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see org.xtext.example.mydsl.sparrow.SparrowPackage#getRuleExpression_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link org.xtext.example.mydsl.sparrow.RuleExpression#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Set</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Set</em>' containment reference.
   * @see #setSet(messageExpression)
   * @see org.xtext.example.mydsl.sparrow.SparrowPackage#getRuleExpression_Set()
   * @model containment="true"
   * @generated
   */
  messageExpression getSet();

  /**
   * Sets the value of the '{@link org.xtext.example.mydsl.sparrow.RuleExpression#getSet <em>Set</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Set</em>' containment reference.
   * @see #getSet()
   * @generated
   */
  void setSet(messageExpression value);

  /**
   * Returns the value of the '<em><b>Setdate</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Setdate</em>' containment reference.
   * @see #setSetdate(setDateExpression)
   * @see org.xtext.example.mydsl.sparrow.SparrowPackage#getRuleExpression_Setdate()
   * @model containment="true"
   * @generated
   */
  setDateExpression getSetdate();

  /**
   * Sets the value of the '{@link org.xtext.example.mydsl.sparrow.RuleExpression#getSetdate <em>Setdate</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Setdate</em>' containment reference.
   * @see #getSetdate()
   * @generated
   */
  void setSetdate(setDateExpression value);

  /**
   * Returns the value of the '<em><b>Total Condition</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Total Condition</em>' containment reference.
   * @see #setTotalCondition(TotalCondition)
   * @see org.xtext.example.mydsl.sparrow.SparrowPackage#getRuleExpression_TotalCondition()
   * @model containment="true"
   * @generated
   */
  TotalCondition getTotalCondition();

  /**
   * Sets the value of the '{@link org.xtext.example.mydsl.sparrow.RuleExpression#getTotalCondition <em>Total Condition</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Total Condition</em>' containment reference.
   * @see #getTotalCondition()
   * @generated
   */
  void setTotalCondition(TotalCondition value);

  /**
   * Returns the value of the '<em><b>Total Operation</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Total Operation</em>' containment reference.
   * @see #setTotalOperation(TotalOperation)
   * @see org.xtext.example.mydsl.sparrow.SparrowPackage#getRuleExpression_TotalOperation()
   * @model containment="true"
   * @generated
   */
  TotalOperation getTotalOperation();

  /**
   * Sets the value of the '{@link org.xtext.example.mydsl.sparrow.RuleExpression#getTotalOperation <em>Total Operation</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Total Operation</em>' containment reference.
   * @see #getTotalOperation()
   * @generated
   */
  void setTotalOperation(TotalOperation value);

  /**
   * Returns the value of the '<em><b>Sub Expression</b></em>' containment reference list.
   * The list contents are of type {@link org.xtext.example.mydsl.sparrow.SubExpression}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Sub Expression</em>' containment reference list.
   * @see org.xtext.example.mydsl.sparrow.SparrowPackage#getRuleExpression_SubExpression()
   * @model containment="true"
   * @generated
   */
  EList<SubExpression> getSubExpression();

  /**
   * Returns the value of the '<em><b>Else Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Else Expression</em>' containment reference.
   * @see #setElseExpression(ElseExpression)
   * @see org.xtext.example.mydsl.sparrow.SparrowPackage#getRuleExpression_ElseExpression()
   * @model containment="true"
   * @generated
   */
  ElseExpression getElseExpression();

  /**
   * Sets the value of the '{@link org.xtext.example.mydsl.sparrow.RuleExpression#getElseExpression <em>Else Expression</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Else Expression</em>' containment reference.
   * @see #getElseExpression()
   * @generated
   */
  void setElseExpression(ElseExpression value);

} // RuleExpression
