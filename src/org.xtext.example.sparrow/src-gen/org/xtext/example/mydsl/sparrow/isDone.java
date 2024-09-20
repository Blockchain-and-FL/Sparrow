/**
 * generated by Xtext 2.29.0
 */
package org.xtext.example.mydsl.sparrow;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>is Done</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.xtext.example.mydsl.sparrow.isDone#getName <em>Name</em>}</li>
 * </ul>
 *
 * @see org.xtext.example.mydsl.sparrow.SparrowPackage#getisDone()
 * @model
 * @generated
 */
public interface isDone extends TrueCondition
{
  /**
   * Returns the value of the '<em><b>Name</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' reference.
   * @see #setName(RuleExpression)
   * @see org.xtext.example.mydsl.sparrow.SparrowPackage#getisDone_Name()
   * @model
   * @generated
   */
  RuleExpression getName();

  /**
   * Sets the value of the '{@link org.xtext.example.mydsl.sparrow.isDone#getName <em>Name</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' reference.
   * @see #getName()
   * @generated
   */
  void setName(RuleExpression value);

} // isDone
