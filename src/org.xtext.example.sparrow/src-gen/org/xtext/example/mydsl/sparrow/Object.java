/**
 * generated by Xtext 2.29.0
 */
package org.xtext.example.mydsl.sparrow;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Object</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.xtext.example.mydsl.sparrow.Object#getName <em>Name</em>}</li>
 *   <li>{@link org.xtext.example.mydsl.sparrow.Object#getObjectExpression <em>Object Expression</em>}</li>
 * </ul>
 *
 * @see org.xtext.example.mydsl.sparrow.SparrowPackage#getObject()
 * @model
 * @generated
 */
public interface Object extends EObject
{
  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see org.xtext.example.mydsl.sparrow.SparrowPackage#getObject_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link org.xtext.example.mydsl.sparrow.Object#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Object Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Object Expression</em>' containment reference.
   * @see #setObjectExpression(ObjectExpression)
   * @see org.xtext.example.mydsl.sparrow.SparrowPackage#getObject_ObjectExpression()
   * @model containment="true"
   * @generated
   */
  ObjectExpression getObjectExpression();

  /**
   * Sets the value of the '{@link org.xtext.example.mydsl.sparrow.Object#getObjectExpression <em>Object Expression</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Object Expression</em>' containment reference.
   * @see #getObjectExpression()
   * @generated
   */
  void setObjectExpression(ObjectExpression value);

} // Object
