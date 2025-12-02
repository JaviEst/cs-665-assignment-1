/*
 * Name: Javier Esteban de Celis
 * Date: 12/01/2025
 * File Name: BeverageFactory.java
 * Description: This file is responsible for implementing the beverage machine / factory.
 *              The beverage factory serves a new beverage based on the type and condiments
 *              provided by the user through the beverage order.
 * Assignment #: 6
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
import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;
import types.BeverageTypes;

public class BeverageFactory {  
  private static final Map<BeverageTypes, Supplier<Beverage>> beverageRegistry = new HashMap<>();
  
  static {
    beverageRegistry.put(BeverageTypes.ESPRESSO, Espresso::new);
    beverageRegistry.put(BeverageTypes.AMERICANO, Americano::new);
    beverageRegistry.put(BeverageTypes.LATTE_MACCHIATO, LatteMacchiato::new);
    beverageRegistry.put(BeverageTypes.BLACK_TEA, BlackTea::new);
    beverageRegistry.put(BeverageTypes.GREEN_TEA, GreenTea::new);
    beverageRegistry.put(BeverageTypes.YELLOW_TEA, YellowTea::new);
  }

  /**
   * Creates a base beverage without condiments.
   * Uses the registry pattern to eliminate switch statements and improve OCP compliance.
   *
   * @param type the beverage's type
   * @return a new beverage instance, or null if type is not registered
   */
  public static Beverage createBeverage(BeverageTypes type) {
    Supplier<Beverage> beverageSupplier = beverageRegistry.get(type);
    
    if (beverageSupplier == null) {
      System.out.println("Sorry, we do not have the type of beverage you ordered.");
      return null;
    }
    
    return beverageSupplier.get();
  }
  
  /**
   * Register a new beverage type dynamically.
   * This allows for runtime extension of available beverages.
   *
   * @param type the beverage type to register
   * @param supplier the supplier that creates instances of this beverage
   */
  public static void registerBeverage(BeverageTypes type, Supplier<Beverage> supplier) {
    beverageRegistry.put(type, supplier);
  }
}

