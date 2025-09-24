/*
 * Name: Javier Esteban de Celis
 * Date: 09/15/2025
 * File Name: Americano.java
 * Description: This file is responsible for implementing the americano coffee beverage
 *              by extending the behavior provided in the beverage abstract class.
 * Assignment #: 1
 * Course CS665
 */

package beverages;

import beverages.Beverage;

public class Americano extends Beverage {
  /**
   * Creates a new americano coffee.
   */
  public Americano() {
    super("Americano");
  }

  /**
   * Brew an americano coffee.
   * This method is overridden from the abstract beverage class.
   */
  @Override
  protected void brew() {
    System.out.println("Brewing an americano with extta water...");
  }
}