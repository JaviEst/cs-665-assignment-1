/*
 * Name: Javier Esteban de Celis
 * Date: 09/15/2025
 * File Name: BlackTea.java
 * Description: This file is responsible for implementing the black tea beverage
 *              by extending the behavior provided in the beverage abstract class.
 * Assignment #: 1
 * Course CS665
 */

package beverages;

import beverages.Beverage;

public class BlackTea extends Beverage {
  /**
   * Creates a new black tea.
   */
  public BlackTea() {
    super("Black Tea");
  }

  /**
   * Brew a black tea.
   * This method is overridden from the abstract beverage class.
   */
  @Override
  protected void brew() {
    System.out.println("Steeping black tea leaves...");
  }
}