/*
 * Name: Javier Esteban de Celis
 * Date: 12/01/2025
 * File Name: BlackTeaTest.java
 * Description: JUnit tests for the Black Tea beverage class.
 * Assignment #: 6
 * Course CS665
 */

package beverages;

import decorators.MilkDecorator;
import decorators.SugarDecorator;
import org.junit.Assert;
import org.junit.Test;

public class BlackTeaTest {
  @Test
  public void testCreateBlackTea() {
    BlackTea a = new BlackTea();
    Assert.assertEquals("Black Tea", a.getName());
  }

  @Test
  public void testBasePriceNoCondiments() {
    BlackTea a = new BlackTea();
    Assert.assertEquals(Beverage.BASE_PRICE, a.getPrice(), 0.0001);
    Assert.assertEquals(0, a.getMilkUnits());
    Assert.assertEquals(0, a.getSugarUnits());
  }

  @Test
  public void testPriceWithDecorators() {
    Beverage a = new BlackTea();
    a = new MilkDecorator(a);
    a = new MilkDecorator(a);
    a = new SugarDecorator(a);
    
    double expected = Beverage.BASE_PRICE + 3 * 0.5;
    Assert.assertEquals(expected, a.getPrice(), 0.0001);
    Assert.assertEquals(2, a.getMilkUnits());
    Assert.assertEquals(1, a.getSugarUnits());
  }
}
