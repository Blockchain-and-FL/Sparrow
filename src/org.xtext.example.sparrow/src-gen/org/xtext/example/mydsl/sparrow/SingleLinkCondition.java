/**
 * generated by Xtext 2.29.0
 */
package org.xtext.example.mydsl.sparrow;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Single Link Condition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.xtext.example.mydsl.sparrow.SingleLinkCondition#getNo <em>No</em>}</li>
 *   <li>{@link org.xtext.example.mydsl.sparrow.SingleLinkCondition#getLinkCondition <em>Link Condition</em>}</li>
 * </ul>
 *
 * @see org.xtext.example.mydsl.sparrow.SparrowPackage#getSingleLinkCondition()
 * @model
 * @generated
 */
public interface SingleLinkCondition extends EObject
{
  /**
   * Returns the value of the '<em><b>No</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>No</em>' attribute.
   * @see #setNo(String)
   * @see org.xtext.example.mydsl.sparrow.SparrowPackage#getSingleLinkCondition_No()
   * @model
   * @generated
   */
  String getNo();

  /**
   * Sets the value of the '{@link org.xtext.example.mydsl.sparrow.SingleLinkCondition#getNo <em>No</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>No</em>' attribute.
   * @see #getNo()
   * @generated
   */
  void setNo(String value);

  /**
   * Returns the value of the '<em><b>Link Condition</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Link Condition</em>' reference.
   * @see #setLinkCondition(ConditionLink)
   * @see org.xtext.example.mydsl.sparrow.SparrowPackage#getSingleLinkCondition_LinkCondition()
   * @model
   * @generated
   */
  ConditionLink getLinkCondition();

  /**
   * Sets the value of the '{@link org.xtext.example.mydsl.sparrow.SingleLinkCondition#getLinkCondition <em>Link Condition</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Link Condition</em>' reference.
   * @see #getLinkCondition()
   * @generated
   */
  void setLinkCondition(ConditionLink value);

} // SingleLinkCondition
