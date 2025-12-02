/*
 * Name: Javier Esteban de Celis
 * Date: 12/01/2025
 * File Name: BeverageOrderBuilder.java
 * Description: Builder class for creating BeverageOrder objects.
 *              Implements the Builder Pattern to provide a flexible and readable
 *              way to construct beverage orders with optional condiments.
 * Assignment #: 6
 * Course CS665
 */

package machine;

import beverages.Beverage;
import decorators.MilkDecorator;
import decorators.SugarDecorator;
import types.BeverageTypes;


public class BeverageOrderBuilder {
  private BeverageTypes beverageType;
  private int milkUnits = 0;
  private int sugarUnits = 0;
  private static final int MAX_CONDIMENT_UNITS = 3;

  /**
   * Sets the type of beverage for this order.
   *
   * @param type the beverage type
   * @return this builder for method chaining
   */
  public BeverageOrderBuilder beverageType(BeverageTypes type) {
    this.beverageType = type;
    return this;
  }

  /**
   * Sets the number of milk units for this order.
   *
   * @param units number of milk units (0-3)
   * @return this builder for method chaining
   * @throws IllegalArgumentException if units is outside valid range
   */
  public BeverageOrderBuilder withMilk(int units) {
    if (units < 0 || units > MAX_CONDIMENT_UNITS) {
      throw new IllegalArgumentException(
          "Milk units must be between 0 and " + MAX_CONDIMENT_UNITS);
    }
    this.milkUnits = units;
    return this;
  }

  /**
   * Sets the number of sugar units for this order.
   *
   * @param units number of sugar units (0-3)
   * @return this builder for method chaining
   * @throws IllegalArgumentException if units is outside valid range
   */
  public BeverageOrderBuilder withSugar(int units) {
    if (units < 0 || units > MAX_CONDIMENT_UNITS) {
      throw new IllegalArgumentException(
          "Sugar units must be between 0 and " + MAX_CONDIMENT_UNITS);
    }
    this.sugarUnits = units;
    return this;
  }

  /**
   * Builds the BeverageOrder using the Decorator pattern for condiments.
   *
   * @return a new BeverageOrder
   * @throws IllegalStateException if beverage type is not set
   */
  public BeverageOrder build() {
    if (beverageType == null) {
      throw new IllegalStateException("Beverage type must be set");
    }

    // Create base beverage
    Beverage beverage = BeverageFactory.createBeverage(beverageType);
    
    // Apply decorators for condiments
    for (int i = 0; i < milkUnits; i++) {
      beverage = new MilkDecorator(beverage);
    }
    
    for (int i = 0; i < sugarUnits; i++) {
      beverage = new SugarDecorator(beverage);
    }

    beverage.prepare();
    
    return new BeverageOrder(beverage);
  }
}
