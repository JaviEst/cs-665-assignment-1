/*
 * Name: Javier Esteban de Celis
 * Date: 12/01/2025
 * File Name: EspressoTest.java
 * Description: JUnit tests for the Espresso beverage class.
 * Assignment #: 6
 * Course CS665
 */

package beverages;

import decorators.MilkDecorator;
import decorators.SugarDecorator;
import org.junit.Assert;
import org.junit.Test;

public class EspressoTest {
  @Test
  public void testCreateEspresso() {
    Espresso a = new Espresso();
    Assert.assertEquals("Espresso", a.getName());
  }

  @Test
  public void testBasePriceNoCondiments() {
    Espresso a = new Espresso();
    Assert.assertEquals(Beverage.BASE_PRICE, a.getPrice(), 0.0001);
    Assert.assertEquals(0, a.getMilkUnits());
    Assert.assertEquals(0, a.getSugarUnits());
  }

  @Test
  public void testPriceWithMilkDecorator() {
    Beverage a = new Espresso();
    a = new MilkDecorator(a);
    a = new MilkDecorator(a);
    
    double expected = Beverage.BASE_PRICE + 2 * 0.5;
    Assert.assertEquals(expected, a.getPrice(), 0.0001);
    Assert.assertEquals(2, a.getMilkUnits());
  }

  @Test
  public void testPriceWithBothDecorators() {
    Beverage a = new Espresso();
    a = new MilkDecorator(a);
    a = new MilkDecorator(a);
    a = new SugarDecorator(a);
    
    double expected = Beverage.BASE_PRICE + 3 * 0.5;
    Assert.assertEquals(expected, a.getPrice(), 0.0001);
    Assert.assertEquals(2, a.getMilkUnits());
    Assert.assertEquals(1, a.getSugarUnits());
  }
}
