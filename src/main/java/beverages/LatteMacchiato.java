/*
 * Name: Javier Esteban de Celis
 * Date: 09/15/2025
 * File Name: LatteMacchiato.java
 * Description: This file is responsible for implementing the latte macchiato coffee beverage
 *              by extending the behavior provided in the beverage abstract class.
 * Assignment #: 1
 * Course CS665
 */

package beverages;

import beverages.Beverage;

public class LatteMacchiato extends Beverage {
  /**
   * Creates a new latte macchiato coffee.
   */
  public LatteMacchiato() {
    super("Latte Macchiato");
  }

  /**
   * Brew a latte macchiato coffee.
   * This method is overridden from the abstract beverage class.
   */
  @Override
  protected void brew() {
    System.out.println("Brewing a latte macchiato with espresso and steamed milk...");
  }
}