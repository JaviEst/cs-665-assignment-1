/*
 * Name: Javier Esteban de Celis
 * Date: 12/01/2025
 * File Name: GreenTea.java
 * Description: This file is responsible for implementing the green tea beverage
 *              by extending the behavior provided in the beverage abstract class.
 * Assignment #: 6
 * Course CS665
 */

package beverages;


public class GreenTea extends Beverage {
  /**
   * Creates a new green tea.
   */
  public GreenTea() {
    super("Green Tea");
  }

  /**
   * Brew a green tea.
   * This method is overridden from the abstract beverage class.
   */
  @Override
  public void brew() {
    System.out.println("Steeping green tea leaves...");
  }
}