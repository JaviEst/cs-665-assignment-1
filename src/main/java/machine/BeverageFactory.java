/*
 * Name: Javier Esteban de Celis
 * Date: 09/15/2025
 * File Name: BeverageFactory.java
 * Description: This file is responsible for implementing the beverage machine / factory.
 *              The beverage factory serves a new beverage based on the type and condiments
 *              provided by the user through the beverage order.
 * Assignment #: 1
 * Course CS665
 */

package machine;

import beverages.Americano;
import beverages.Beverage;
import beverages.BlackTea;
import beverages.Espresso;
import beverages.GreenTea;
import beverages.LatteMacchiato;
import beverages.YellowTea;
import types.BeverageTypes;

public class BeverageFactory {
  /**
   * Given a beverage type and condiments create and prepare the specified beverage.
   *
   * @param type the beverage's type (Espresso, Americano, Black Tea, ...)
   * @param milk the number of milk units to add to the beverage when preparing it
   * @param sugar the number of sugar units to add to the beverage when preparing it
   */
  public static Beverage createBeverage(BeverageTypes type, int milk, int sugar) {
    Beverage beverage = null;
    switch (type) {
      case ESPRESSO:
        beverage = new Espresso();
        break;
      case AMERICANO:
        beverage = new Americano();
        break;
      case LATTE_MACCHIATO:
        beverage = new LatteMacchiato();
        break;
      case BLACK_TEA:
        beverage = new BlackTea();
        break;
      case GREEN_TEA:
        beverage = new GreenTea();
        break;
      case YELLOW_TEA:
        beverage = new YellowTea();
        break;
      default:
        System.out.println("Sorry, we do not have the type of beverage you ordered.");
    }
    if (beverage != null) {
      beverage.setMilkUnits(milk);
      beverage.setSugarUnits(sugar);
      beverage.prepare();
    }
    return beverage;
  }
}
