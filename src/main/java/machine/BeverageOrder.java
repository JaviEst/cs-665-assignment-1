/*
 * Name: Javier Esteban de Celis
 * Date: 09/15/2025
 * File Name: BeverageOrder.java
 * Description: This file is responsible for taking a beverage order and creating the
 *              correct beverage using the BeverageFactory (machine).
 * Assignment #: 1
 * Course CS665
 */

package machine;

import beverages.Beverage;
import machine.BeverageFactory;
import types.BeverageTypes;

public class BeverageOrder {
  private final Beverage beverage;

  /**
   * Order a beverage given a type and condiments.
   *
   * @param type the beverage's type (Espresso, Americano, Black Tea, ...)
   * @param milk the number of milk units to add to the beverage when preparing it
   * @param sugar the number of sugar units to add to the beverage when preparing it
   */
  public BeverageOrder(BeverageTypes type, int milk, int sugar) {
    this.beverage = BeverageFactory.createBeverage(type, milk, sugar);
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
