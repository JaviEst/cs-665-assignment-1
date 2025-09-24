/*
 * Name: Javier Esteban de Celis
 * Date: 09/15/2025
 * File Name: YellowTea.java
 * Description: This file is responsible for implementing the yellow tea beverage
 *              by extending the behavior provided in the beverage abstract class.
 * Assignment #: 1
 * Course CS665
 */

package beverages;

import beverages.Beverage;

public class YellowTea extends Beverage {
  /**
   * Creates a new yellow tea.
   */
  public YellowTea() {
    super("Yellow Tea");
  }

  /**
   * Brew a yellow tea.
   * This method is overridden from the abstract beverage class.
   */
  @Override
  protected void brew() {
    System.out.println("Steeping yellow tea leaves...");
  }
}