/*
 * Name: Javier Esteban de Celis
 * Date: 09/23/2025
 * File Name: BeverageOrderTest.java
 * Description: JUnit tests for the BeverageOrder class.
 * Assignment #: 1
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
    BeverageOrder order = new BeverageOrder(BeverageTypes.ESPRESSO, 0, 0);
    Assert.assertEquals(Beverage.BASE_PRICE, order.getCost(), 0.0001);
  }

  @Test
  public void testCostWithCondiments() {
    BeverageOrder order = new BeverageOrder(BeverageTypes.AMERICANO, 2, 1);
    double expected = Beverage.BASE_PRICE + 3 * Beverage.CONDIMENT_UNIT_PRICE;
    Assert.assertEquals(expected, order.getCost(), 0.0001);
  }

  @Test
  public void testInvalidCondimentCountsCappedByBeverageValidation() {
    BeverageOrder order = new BeverageOrder(BeverageTypes.LATTE_MACCHIATO, 5, 4);
    double expected = Beverage.BASE_PRICE + 0 * Beverage.CONDIMENT_UNIT_PRICE;
    Assert.assertEquals(expected, order.getCost(), 0.0001);
  }

  @Test
  public void testPrintOrderSummaryOutputsNameAndPrice() {
    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    PrintStream originalOut = System.out;
    System.setOut(new PrintStream(baos));
    try {
      BeverageOrder order = new BeverageOrder(BeverageTypes.GREEN_TEA, 2, 1);
      order.printOrderSummary();
    } finally {
      System.setOut(originalOut);
    }
    String out = baos.toString();
    Assert.assertTrue(out.contains("Order Summary:"));
    Assert.assertTrue(out.contains("Green Tea"));
    Assert.assertTrue(out.contains(String.valueOf(Beverage.BASE_PRICE + 3 * Beverage.CONDIMENT_UNIT_PRICE)));
  }
}
