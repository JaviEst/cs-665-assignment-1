/*
 * Name: Javier Esteban de Celis
 * Date: 12/01/2025
 * File Name: BeverageDecorator.java
 * Description: Abstract decorator class for adding condiments to beverages.
 *              Implements the Decorator Pattern to allow flexible addition of
 *              condiments without modifying the base Beverage class.
 * Assignment #: 6
 * Course CS665
 */

package decorators;

import beverages.Beverage;


public abstract class BeverageDecorator extends Beverage {
  protected Beverage wrappedBeverage;

  /**
   * Creates a new beverage decorator.
   *
   * @param beverage the beverage to be decorated
   * @param name the name of this decorator layer
   */
  public BeverageDecorator(Beverage beverage, String name) {
    super(name);
    this.wrappedBeverage = beverage;
  }

  /**
   * Get the base beverage being decorated.
   * 
   * @return the wrapped beverage
   */
  public Beverage getWrappedBeverage() {
    return wrappedBeverage;
  }

  @Override
  public void brew() {
    wrappedBeverage.brew();
  }

  @Override
  public String getName() {
    return wrappedBeverage.getName();
  }

  @Override
  public double getPrice() {
    return wrappedBeverage.getPrice();
  }

  @Override
  public int getMilkUnits() {
    return wrappedBeverage.getMilkUnits();
  }

  @Override
  public int getSugarUnits() {
    return wrappedBeverage.getSugarUnits();
  }
}
