/**
 * generated by Xtext 2.29.0
 */
package org.xtext.example.mydsl.sparrow;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Else Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.xtext.example.mydsl.sparrow.ElseExpression#getSet <em>Set</em>}</li>
 *   <li>{@link org.xtext.example.mydsl.sparrow.ElseExpression#getTotalCondition <em>Total Condition</em>}</li>
 *   <li>{@link org.xtext.example.mydsl.sparrow.ElseExpression#getTotalOperation <em>Total Operation</em>}</li>
 * </ul>
 *
 * @see org.xtext.example.mydsl.sparrow.SparrowPackage#getElseExpression()
 * @model
 * @generated
 */
public interface ElseExpression extends EObject
{
  /**
   * Returns the value of the '<em><b>Set</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Set</em>' containment reference.
   * @see #setSet(messageExpression)
   * @see org.xtext.example.mydsl.sparrow.SparrowPackage#getElseExpression_Set()
   * @model containment="true"
   * @generated
   */
  messageExpression getSet();

  /**
   * Sets the value of the '{@link org.xtext.example.mydsl.sparrow.ElseExpression#getSet <em>Set</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Set</em>' containment reference.
   * @see #getSet()
   * @generated
   */
  void setSet(messageExpression value);

  /**
   * Returns the value of the '<em><b>Total Condition</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Total Condition</em>' containment reference.
   * @see #setTotalCondition(TotalCondition)
   * @see org.xtext.example.mydsl.sparrow.SparrowPackage#getElseExpression_TotalCondition()
   * @model containment="true"
   * @generated
   */
  TotalCondition getTotalCondition();

  /**
   * Sets the value of the '{@link org.xtext.example.mydsl.sparrow.ElseExpression#getTotalCondition <em>Total Condition</em>}' containment reference.
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
   * @see org.xtext.example.mydsl.sparrow.SparrowPackage#getElseExpression_TotalOperation()
   * @model containment="true"
   * @generated
   */
  TotalOperation getTotalOperation();

  /**
   * Sets the value of the '{@link org.xtext.example.mydsl.sparrow.ElseExpression#getTotalOperation <em>Total Operation</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Total Operation</em>' containment reference.
   * @see #getTotalOperation()
   * @generated
   */
  void setTotalOperation(TotalOperation value);

} // ElseExpression
