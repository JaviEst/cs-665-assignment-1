/*
 * Name: Javier Esteban de Celis
 * Date: 12/01/2025
 * File Name: SugarDecorator.java
 * Description: Concrete decorator for adding sugar to a beverage.
 *              Uses the Decorator Pattern to add sugar condiment functionality.
 * Assignment #: 6
 * Course CS665
 */

package decorators;

import beverages.Beverage;


public class SugarDecorator extends BeverageDecorator {
  private static final double SUGAR_PRICE = 0.5;

  /**
   * Creates a sugar decorator that wraps a beverage.
   *
   * @param beverage the beverage to add sugar to
   */
  public SugarDecorator(Beverage beverage) {
    super(beverage, "Sugar");
  }

  @Override
  public String getName() {
    return wrappedBeverage.getName() + " + Sugar";
  }

  @Override
  public double getPrice() {
    return wrappedBeverage.getPrice() + SUGAR_PRICE;
  }

  @Override
  public int getSugarUnits() {
    return wrappedBeverage.getSugarUnits() + 1;
  }

  @Override
  public void addCondiments() {
    wrappedBeverage.addCondiments();
    System.out.println("Adding 1 unit of sugar");
  }
}
