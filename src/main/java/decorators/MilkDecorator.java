/*
 * Name: Javier Esteban de Celis
 * Date: 12/01/2025
 * File Name: MilkDecorator.java
 * Description: Concrete decorator for adding milk to a beverage.
 *              Uses the Decorator Pattern to add milk condiment functionality.
 * Assignment #: 6
 * Course CS665
 */

package decorators;

import beverages.Beverage;


public class MilkDecorator extends BeverageDecorator {
  private static final double MILK_PRICE = 0.5;

  /**
   * Creates a milk decorator that wraps a beverage.
   *
   * @param beverage the beverage to add milk to
   */
  public MilkDecorator(Beverage beverage) {
    super(beverage, "Milk");
  }

  @Override
  public String getName() {
    return wrappedBeverage.getName() + " + Milk";
  }

  @Override
  public double getPrice() {
    return wrappedBeverage.getPrice() + MILK_PRICE;
  }

  @Override
  public int getMilkUnits() {
    return wrappedBeverage.getMilkUnits() + 1;
  }

  @Override
  public void addCondiments() {
    wrappedBeverage.addCondiments();
    System.out.println("Adding 1 unit of milk");
  }
}
