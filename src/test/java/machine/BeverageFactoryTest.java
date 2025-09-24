/*
 * Name: Javier Esteban de Celis
 * Date: 09/23/2025
 * File Name: BeverageFactoryTest.java
 * Description: JUnit tests for the BeverageFactory class.
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

import org.junit.Assert;
import org.junit.Test;

public class BeverageFactoryTest {
  @Test
  public void testCreateEspressoNoCondiments() {
    Beverage b = BeverageFactory.createBeverage(BeverageTypes.ESPRESSO, 0, 0);
    Assert.assertTrue(b instanceof Espresso);
    Assert.assertEquals(Beverage.BASE_PRICE, b.getPrice(), 0.0001);
  }

  @Test
  public void testCreateAmericanoWithCondiments() {
    Beverage b = BeverageFactory.createBeverage(BeverageTypes.AMERICANO, 2, 1);
    Assert.assertTrue(b instanceof Americano);
    double expected = Beverage.BASE_PRICE + 3 * Beverage.CONDIMENT_UNIT_PRICE;
    Assert.assertEquals(expected, b.getPrice(), 0.0001);
  }

  @Test
  public void testCreateLatteMacchiatoWithInvalidCondiments() {
    Beverage b = BeverageFactory.createBeverage(BeverageTypes.LATTE_MACCHIATO, 5, 4);
    Assert.assertTrue(b instanceof LatteMacchiato);
    // Invalid counts should be ignored by Beverage validation; price remains base
    Assert.assertEquals(Beverage.BASE_PRICE, b.getPrice(), 0.0001);
  }

  @Test
  public void testCreateBlackTea() {
    Beverage b = BeverageFactory.createBeverage(BeverageTypes.BLACK_TEA, 1, 0);
    Assert.assertTrue(b instanceof BlackTea);
    double expected = Beverage.BASE_PRICE + 1 * Beverage.CONDIMENT_UNIT_PRICE;
    Assert.assertEquals(expected, b.getPrice(), 0.0001);
  }

  @Test
  public void testCreateGreenTea() {
    Beverage b = BeverageFactory.createBeverage(BeverageTypes.GREEN_TEA, 0, 2);
    Assert.assertTrue(b instanceof GreenTea);
    double expected = Beverage.BASE_PRICE + 2 * Beverage.CONDIMENT_UNIT_PRICE;
    Assert.assertEquals(expected, b.getPrice(), 0.0001);
  }

  @Test
  public void testCreateYellowTea() {
    Beverage b = BeverageFactory.createBeverage(BeverageTypes.YELLOW_TEA, 1, 2);
    Assert.assertTrue(b instanceof YellowTea);
    double expected = Beverage.BASE_PRICE + 3 * Beverage.CONDIMENT_UNIT_PRICE;
    Assert.assertEquals(expected, b.getPrice(), 0.0001);
  }
}
