/**
 * generated by Xtext 2.29.0
 */
package org.xtext.example.mydsl.sparrow;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Sub Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.xtext.example.mydsl.sparrow.SubExpression#getTotalExpression <em>Total Expression</em>}</li>
 * </ul>
 *
 * @see org.xtext.example.mydsl.sparrow.SparrowPackage#getSubExpression()
 * @model
 * @generated
 */
public interface SubExpression extends EObject
{
  /**
   * Returns the value of the '<em><b>Total Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Total Expression</em>' containment reference.
   * @see #setTotalExpression(TotalExpression)
   * @see org.xtext.example.mydsl.sparrow.SparrowPackage#getSubExpression_TotalExpression()
   * @model containment="true"
   * @generated
   */
  TotalExpression getTotalExpression();

  /**
   * Sets the value of the '{@link org.xtext.example.mydsl.sparrow.SubExpression#getTotalExpression <em>Total Expression</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Total Expression</em>' containment reference.
   * @see #getTotalExpression()
   * @generated
   */
  void setTotalExpression(TotalExpression value);

} // SubExpression
