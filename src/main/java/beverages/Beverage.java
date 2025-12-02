/*
 * Name: Javier Esteban de Celis
 * Date: 12/01/2025
 * File Name: Beverage.java
 * Description: This file is responsible for implementing the overall abstract beverage
 *              class that provides the overall attributes and methods that every beverage 
 *              in this machine must provide.
 * Assignment #: 6
 * Course CS665
 */

package beverages;

public abstract class Beverage {
  protected String name;

  public static final double BASE_PRICE = 2.00;

  /**
   * Creates a new beverage.
   *
   * @param name the beverage's name
   */
  public Beverage(String name) {
    this.name = name;
  }

  /**
   * Get the number of milk condiments added to the beverage.
   * For decorators to override.
   * 
   * @return number of milk condiments added to the beverage
   */
  public int getMilkUnits() {
    return 0;
  }

  /**
   * Get the number of sugar condiments added to the beverage.
   * For decorators to override.
   * 
   * @return number of sugar condiments added to the beverage
   */
  public int getSugarUnits() {
    return 0;
  }

  /**
   * Prepare the beverage.
   */
  public final void prepare() {
    heatWater();
    brew();
    pour();
    addCondiments();
  }

  /**
   * Brew the type of beverage when preparing it.
   * This method will be overridden by the concrete beverage types
   * as each of them is brewed is a distinctive way.
   */
  public abstract void brew();

  /**
   * Heat the water when preparing the beverage.
   */
  protected void heatWater() {
    System.out.println("Heating water ...");
  }

  /**
   * Pour the beverage into a cup.
   */
  protected void pour() {
    System.out.println("Poring into cup ...");
  }

  /**
   * Add the condiments to the cup.
   * Base implementation does nothing; decorators override to add their condiments.
   */
  public void addCondiments() {}

  /**
   * Get the beverage's name.
   * 
   * @return the beverage's name
   */
  public String getName() {
    return this.name;
  }

  /**
   * Get the final price of the beverage.
   * 
   * @return the final price of the beverage
   */
  public double getPrice() {
    return BASE_PRICE;
  }
}
