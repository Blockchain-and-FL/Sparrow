/**
 * generated by Xtext 2.29.0
 */
package org.xtext.example.mydsl.sparrow;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Duration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.xtext.example.mydsl.sparrow.Duration#getValue <em>Value</em>}</li>
 *   <li>{@link org.xtext.example.mydsl.sparrow.Duration#getSymbol <em>Symbol</em>}</li>
 * </ul>
 *
 * @see org.xtext.example.mydsl.sparrow.SparrowPackage#getDuration()
 * @model
 * @generated
 */
public interface Duration extends Value
{
  /**
   * Returns the value of the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Value</em>' attribute.
   * @see #setValue(int)
   * @see org.xtext.example.mydsl.sparrow.SparrowPackage#getDuration_Value()
   * @model
   * @generated
   */
  int getValue();

  /**
   * Sets the value of the '{@link org.xtext.example.mydsl.sparrow.Duration#getValue <em>Value</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Value</em>' attribute.
   * @see #getValue()
   * @generated
   */
  void setValue(int value);

  /**
   * Returns the value of the '<em><b>Symbol</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Symbol</em>' attribute.
   * @see #setSymbol(String)
   * @see org.xtext.example.mydsl.sparrow.SparrowPackage#getDuration_Symbol()
   * @model
   * @generated
   */
  String getSymbol();

  /**
   * Sets the value of the '{@link org.xtext.example.mydsl.sparrow.Duration#getSymbol <em>Symbol</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Symbol</em>' attribute.
   * @see #getSymbol()
   * @generated
   */
  void setSymbol(String value);

} // Duration