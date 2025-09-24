/*
 * Name: Javier Esteban de Celis
 * Date: 09/15/2025
 * File Name: GreenTea.java
 * Description: This file is responsible for implementing the green tea beverage
 *              by extending the behavior provided in the beverage abstract class.
 * Assignment #: 1
 * Course CS665
 */

package beverages;

import beverages.Beverage;

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
  protected void brew() {
    System.out.println("Steeping green tea leaves...");
  }
}