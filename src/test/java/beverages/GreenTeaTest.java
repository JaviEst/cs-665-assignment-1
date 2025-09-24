/*
 * Name: Javier Esteban de Celis
 * Date: 09/23/2025
 * File Name: GreenTeaTest.java
 * Description: JUnit tests for the Green Tea beverage class.
 * Assignment #: 1
 * Course CS665
 */

package beverages;

import org.junit.Assert;
import org.junit.Test;

public class GreenTeaTest {
  @Test
  public void testCreateGreenTea() {
    GreenTea a = new GreenTea();
    Assert.assertEquals("Green Tea", a.getName());
  }

  @Test
  public void testValidNumberOfCondiments() {
    GreenTea a = new GreenTea();

    a.setMilkUnits(2);
    a.setSugarUnits(1);

    Assert.assertEquals(2, a.getMilkUnits());
    Assert.assertEquals(1, a.getSugarUnits());
  }

  @Test
  public void testInvalidNumberOfCondiments() {
    GreenTea a = new GreenTea();

    // Invalid number since the max units for a condiment is 3.
    a.setMilkUnits(4);
    a.setSugarUnits(1);

    Assert.assertEquals(0, a.getMilkUnits());
    Assert.assertEquals(1, a.getSugarUnits());
  }

  @Test
  public void testBasePriceNoCondiments() {
    GreenTea a = new GreenTea();
    Assert.assertEquals(Beverage.BASE_PRICE, a.getPrice(), 0.0001);
  }

  @Test
  public void testPriceWithCondiments() {
    GreenTea a = new GreenTea();
    a.setMilkUnits(2);
    a.setSugarUnits(1);
    double expected = Beverage.BASE_PRICE + 3 * Beverage.CONDIMENT_UNIT_PRICE;
    Assert.assertEquals(expected, a.getPrice(), 0.0001);
  }
}
