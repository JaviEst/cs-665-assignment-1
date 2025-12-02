/*
 * Name: Javier Esteban de Celis
 * Date: 12/01/2025
 * File Name: BeverageOrder.java
 * Description: This file is responsible for taking a beverage order.
 * Assignment #: 6
 * Course CS665
 */

package machine;

import beverages.Beverage;

public class BeverageOrder {
  private final Beverage beverage;

  /**
   * Order a beverage with a pre-configured beverage object.
   * Used by the Builder pattern to inject decorated beverages.
   *
   * @param beverage the fully configured beverage
   */
  public BeverageOrder(Beverage beverage) {
    this.beverage = beverage;
  }

  /**
   * Get the cost for the beverage order.
   * 
   * @return the beverage order final cost
   */
  public double getCost() {
    return this.beverage.getPrice();
  }

  /**
   * Display a summary of the order including the beverage name and cost.
   */
  public void printOrderSummary() {
    System.out.println("Order Summary:");
    System.out.println("- " + this.beverage.getName() + " : $" + this.beverage.getPrice());
  }
}
