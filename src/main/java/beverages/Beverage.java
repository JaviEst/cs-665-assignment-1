/*
 * Name: Javier Esteban de Celis
 * Date: 09/15/2025
 * File Name: Beverage.java
 * Description: This file is responsible for implementing the overall abstract beverage
 *              class that provides the overall attributes and methods that every beverage 
 *              in this machine must provide.
 * Assignment #: 1
 * Course CS665
 */

package beverages;

import types.CondimentTypes;

public abstract class Beverage {
  protected String name;
  protected int milkUnits = 0;
  protected int sugarUnits = 0;

  public static final double BASE_PRICE = 2.00;
  public static final double CONDIMENT_UNIT_PRICE = 0.5;
  public static final int MAX_PER_CONDIMENT_UNITS = 3;

  /**
   * Creates a new beverage.
   *
   * @param name the beverage's name
   */
  public Beverage(String name) {
    this.name = name;
  }

  /**
   * Validate the number of condiments used is between 0 and 3.
   * 
   * @param numCondiments the number of condiments to validate
   * @param condimentType the condiment's type
   * @return true if the amount of condiments is valid
   */
  private boolean validateCondiments(int numCondiments, CondimentTypes condimentType) {
    if (numCondiments < 0 || numCondiments > MAX_PER_CONDIMENT_UNITS) {
      System.out.printf("%s units must be between 0 and %d%n",
                        condimentType.toString().toLowerCase(), MAX_PER_CONDIMENT_UNITS);
      return false;
    }
    return true;
  }

  /**
   * Get the number of milk condiments added to the beverage.
   * 
   * @return number of milk condiments added to the beverage
   */
  public int getMilkUnits() {
    return this.milkUnits;
  }

  /**
   * Get the number of sugar condiments added to the beverage.
   * 
   * @return number of sugar condiments added to the beverage
   */
  public int getSugarUnits() {
    return this.sugarUnits;
  }


  /**
   * Adds the provided number of milk units to the beverage.
   * 
   * @param milkUnits the number of milk units to add to the beverage
   */
  public void setMilkUnits(int milkUnits) {
    boolean validMilkUnits = validateCondiments(milkUnits, CondimentTypes.MILK);
    if (validMilkUnits) {
      this.milkUnits = milkUnits;
    }
  }

  /**
   * Adds the provided number of sugar units to the beverage.
   * 
   * @param sugarUnits the number of sugar units to add to the beverage
   */
  public void setSugarUnits(int sugarUnits) {
    boolean validSugarUnits = validateCondiments(sugarUnits, CondimentTypes.SUGAR);
    if (validSugarUnits) {
      this.sugarUnits = sugarUnits;
    }
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
  protected abstract void brew();

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
   * Add the condiments set earlier to the cup.
   */
  protected void addCondiments() {
    if (this.milkUnits > 0) {
      System.out.printf("Adding %d unit(s) of milk%n", this.milkUnits);
    }
    if (this.sugarUnits > 0) {
      System.out.printf("Adding %d unit(s) of sugar%n", this.sugarUnits);
    }
  }

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
    return BASE_PRICE + (this.milkUnits + this.sugarUnits) * CONDIMENT_UNIT_PRICE;
  }
}
