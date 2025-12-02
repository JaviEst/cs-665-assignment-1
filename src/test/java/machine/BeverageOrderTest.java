/*
 * Name: Javier Esteban de Celis
 * Date: 12/01/2025
 * File Name: BeverageOrderTest.java
 * Description: JUnit tests for the BeverageOrder class.
 * Assignment #: 6
 * Course CS665
 */

package machine;

import beverages.Beverage;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.Assert;
import org.junit.Test;
import types.BeverageTypes;

public class BeverageOrderTest {
  @Test
  public void testCostWithoutCondiments() {
    BeverageOrder order = new BeverageOrderBuilder()
        .beverageType(BeverageTypes.ESPRESSO)
        .build();
    Assert.assertEquals(Beverage.BASE_PRICE, order.getCost(), 0.0001);
  }

  @Test
  public void testCostWithCondiments() {
    BeverageOrder order = new BeverageOrderBuilder()
        .beverageType(BeverageTypes.AMERICANO)
        .withMilk(2)
        .withSugar(1)
        .build();
    double expected = Beverage.BASE_PRICE + 3 * 0.5;
    Assert.assertEquals(expected, order.getCost(), 0.0001);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMilkCount() {
    new BeverageOrderBuilder()
        .beverageType(BeverageTypes.LATTE_MACCHIATO)
        .withMilk(5)
        .build();
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidSugarCount() {
    new BeverageOrderBuilder()
        .beverageType(BeverageTypes.LATTE_MACCHIATO)
        .withSugar(4)
        .build();
  }

  @Test
  public void testPrintOrderSummaryOutputsNameAndPrice() {
    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    PrintStream originalOut = System.out;
    System.setOut(new PrintStream(baos));
    try {
      BeverageOrder order = new BeverageOrderBuilder()
          .beverageType(BeverageTypes.GREEN_TEA)
          .withMilk(2)
          .withSugar(1)
          .build();
      order.printOrderSummary();
    } finally {
      System.setOut(originalOut);
    }
    String out = baos.toString();
    Assert.assertTrue(out.contains("Order Summary:"));
    Assert.assertTrue(out.contains("Green Tea"));
    Assert.assertTrue(out.contains(String.valueOf(Beverage.BASE_PRICE + 3 * 0.5)));
  }
}
