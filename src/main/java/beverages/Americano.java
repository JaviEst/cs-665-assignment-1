/*
 * Name: Javier Esteban de Celis
 * Date: 12/01/2025
 * File Name: Americano.java
 * Description: This file is responsible for implementing the americano coffee beverage
 *              by extending the behavior provided in the beverage abstract class.
 * Assignment #: 6
 * Course CS665
 */

package beverages;


public class Americano extends Beverage {
  /**
   * Creates a new americano coffee.
   */
  public Americano() {
    super("Americano");
  }

  /**
   * Brew an Americano coffee.
   * This method is overridden from the abstract beverage class.
   */
  @Override
  public void brew() {
    System.out.println("Brewing an Americano with hot water and espresso...");
  }
}