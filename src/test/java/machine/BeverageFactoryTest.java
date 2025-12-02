/*
 * Name: Javier Esteban de Celis
 * Date: 12/01/2025
 * File Name: BeverageFactoryTest.java
 * Description: JUnit tests for the BeverageFactory class.
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
import types.BeverageTypes;

import org.junit.Assert;
import org.junit.Test;

public class BeverageFactoryTest {
  @Test
  public void testCreateEspresso() {
    Beverage b = BeverageFactory.createBeverage(BeverageTypes.ESPRESSO);
    Assert.assertTrue(b instanceof Espresso);
    Assert.assertEquals(Beverage.BASE_PRICE, b.getPrice(), 0.0001);
  }

  @Test
  public void testCreateAmericano() {
    Beverage b = BeverageFactory.createBeverage(BeverageTypes.AMERICANO);
    Assert.assertTrue(b instanceof Americano);
    Assert.assertEquals(Beverage.BASE_PRICE, b.getPrice(), 0.0001);
  }

  @Test
  public void testCreateLatteMacchiato() {
    Beverage b = BeverageFactory.createBeverage(BeverageTypes.LATTE_MACCHIATO);
    Assert.assertTrue(b instanceof LatteMacchiato);
    Assert.assertEquals(Beverage.BASE_PRICE, b.getPrice(), 0.0001);
  }

  @Test
  public void testCreateBlackTea() {
    Beverage b = BeverageFactory.createBeverage(BeverageTypes.BLACK_TEA);
    Assert.assertTrue(b instanceof BlackTea);
    Assert.assertEquals(Beverage.BASE_PRICE, b.getPrice(), 0.0001);
  }

  @Test
  public void testCreateGreenTea() {
    Beverage b = BeverageFactory.createBeverage(BeverageTypes.GREEN_TEA);
    Assert.assertTrue(b instanceof GreenTea);
    Assert.assertEquals(Beverage.BASE_PRICE, b.getPrice(), 0.0001);
  }

  @Test
  public void testCreateYellowTea() {
    Beverage b = BeverageFactory.createBeverage(BeverageTypes.YELLOW_TEA);
    Assert.assertTrue(b instanceof YellowTea);
    Assert.assertEquals(Beverage.BASE_PRICE, b.getPrice(), 0.0001);
  }
}
