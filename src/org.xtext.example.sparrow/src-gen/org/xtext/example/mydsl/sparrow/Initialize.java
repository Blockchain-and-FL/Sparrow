/**
 * generated by Xtext 2.29.0
 */
package org.xtext.example.mydsl.sparrow;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Initialize</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.xtext.example.mydsl.sparrow.Initialize#getInits <em>Inits</em>}</li>
 *   <li>{@link org.xtext.example.mydsl.sparrow.Initialize#getInito <em>Inito</em>}</li>
 * </ul>
 *
 * @see org.xtext.example.mydsl.sparrow.SparrowPackage#getInitialize()
 * @model
 * @generated
 */
public interface Initialize extends EObject
{
  /**
   * Returns the value of the '<em><b>Inits</b></em>' containment reference list.
   * The list contents are of type {@link org.xtext.example.mydsl.sparrow.initExpressions}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Inits</em>' containment reference list.
   * @see org.xtext.example.mydsl.sparrow.SparrowPackage#getInitialize_Inits()
   * @model containment="true"
   * @generated
   */
  EList<initExpressions> getInits();

  /**
   * Returns the value of the '<em><b>Inito</b></em>' containment reference list.
   * The list contents are of type {@link org.xtext.example.mydsl.sparrow.initExpressiono}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Inito</em>' containment reference list.
   * @see org.xtext.example.mydsl.sparrow.SparrowPackage#getInitialize_Inito()
   * @model containment="true"
   * @generated
   */
  EList<initExpressiono> getInito();

} // Initialize