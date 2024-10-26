/**
 * generated by Xtext 2.29.0
 */
package org.xtext.example.mydsl.sparrow;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Rule Time Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.xtext.example.mydsl.sparrow.RuleTimeExpression#getValue <em>Value</em>}</li>
 * </ul>
 *
 * @see org.xtext.example.mydsl.sparrow.SparrowPackage#getRuleTimeExpression()
 * @model
 * @generated
 */
public interface RuleTimeExpression extends SingleExpression
{
  /**
   * Returns the value of the '<em><b>Value</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Value</em>' reference.
   * @see #setValue(RuleExpression)
   * @see org.xtext.example.mydsl.sparrow.SparrowPackage#getRuleTimeExpression_Value()
   * @model
   * @generated
   */
  RuleExpression getValue();

  /**
   * Sets the value of the '{@link org.xtext.example.mydsl.sparrow.RuleTimeExpression#getValue <em>Value</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Value</em>' reference.
   * @see #getValue()
   * @generated
   */
  void setValue(RuleExpression value);

} // RuleTimeExpression
