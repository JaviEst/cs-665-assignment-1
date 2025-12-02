/*
 * Name: Javier Esteban de Celis
 * Date: 12/01/2025
 * File Name: Espresso.java
 * Description: This file is responsible for implementing the espresso coffee beverage
 *              by extending the behavior provided in the beverage abstract class.
 * Assignment #: 6
 * Course CS665
 */

package beverages;


public class Espresso extends Beverage {
  /**
   * Creates a new espresso coffee.
   */
  public Espresso() {
    super("Espresso");
  }

  /**
   * Brew an espresso coffee.
   * This method is overridden from the abstract beverage class.
   */
  @Override
  public void brew() {
    System.out.println("Brewing a strong espresso shot...");
  }
}
