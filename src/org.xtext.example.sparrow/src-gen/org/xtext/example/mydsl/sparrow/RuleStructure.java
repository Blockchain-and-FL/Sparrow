/**
 * generated by Xtext 2.29.0
 */
package org.xtext.example.mydsl.sparrow;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Rule Structure</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.xtext.example.mydsl.sparrow.RuleStructure#getManyRuleExpression <em>Many Rule Expression</em>}</li>
 * </ul>
 *
 * @see org.xtext.example.mydsl.sparrow.SparrowPackage#getRuleStructure()
 * @model
 * @generated
 */
public interface RuleStructure extends EObject
{
  /**
   * Returns the value of the '<em><b>Many Rule Expression</b></em>' containment reference list.
   * The list contents are of type {@link org.xtext.example.mydsl.sparrow.ManyRuleExpression}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Many Rule Expression</em>' containment reference list.
   * @see org.xtext.example.mydsl.sparrow.SparrowPackage#getRuleStructure_ManyRuleExpression()
   * @model containment="true"
   * @generated
   */
  EList<ManyRuleExpression> getManyRuleExpression();

} // RuleStructure
