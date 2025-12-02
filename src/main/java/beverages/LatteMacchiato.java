/*
 * Name: Javier Esteban de Celis
 * Date: 12/01/2025
 * File Name: LatteMacchiato.java
 * Description: This file is responsible for implementing the latte macchiato coffee beverage
 *              by extending the behavior provided in the beverage abstract class.
 * Assignment #: 6
 * Course CS665
 */

package beverages;


public class LatteMacchiato extends Beverage {
  /**
   * Creates a new latte macchiato coffee.
   */
  public LatteMacchiato() {
    super("Latte Macchiato");
  }

  /**
   * Brew a Latte Macchiato coffee.
   * This method is overridden from the abstract beverage class.
   */
  @Override
  public void brew() {
    System.out.println("Brewing a Latte Macchiato with steamed milk and espresso...");
  }
}