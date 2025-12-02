/*
 * Name: Javier Esteban de Celis
 * Date: 12/01/2025
 * File Name: Main.java
 * Description: Console user interface for the beverage machine.
 *              Updated for Assignment #6 to use Builder pattern.
 * Assignment #: 6
 * Course CS665
 */

import java.util.Scanner;
import machine.BeverageOrder;
import machine.BeverageOrderBuilder;
import types.BeverageTypes;

public class Main {
  private static final Scanner scanner = new Scanner(System.in);

  /**
   * Main method that runs the beverage machine console interface.
   * Displays a menu, allows users to select beverages and condiments,
   * processes orders, and handles multiple orders in a session.
   * 
   * @param args command line arguments (not used)
   */
  public static void main(String[] args) {
    System.out.println("=== Welcome to the Beverage Machine ===");
    System.out.println();

    boolean continueOrdering = true;
    while (continueOrdering) {
      try {
        displayMenu();
        
        // Get beverage selection
        BeverageTypes selectedBeverage = getBeverageSelection();
        if (selectedBeverage == null) {
          System.out.println("Invalid selection. Please try again.");
          continue;
        }

        // Get condiment preferences
        int milkUnits = getCondimentUnits("milk");
        int sugarUnits = getCondimentUnits("sugar");

        BeverageOrder order = new BeverageOrderBuilder()
            .beverageType(selectedBeverage)
            .withMilk(milkUnits)
            .withSugar(sugarUnits)
            .build();
        
        System.out.println();
        order.printOrderSummary();
        System.out.println();

        continueOrdering = askToContinue();

      } catch (Exception e) {
        System.out.println("An error occurred: " + e.getMessage());
        System.out.println("Please try again.");
        System.out.println();
      }
    }

    System.out.println("Thank you for using the Beverage Machine. Have a great day!");
    scanner.close();
  }

  /**
   * Displays the available beverages menu with pricing information.
   * Shows all six beverage options with their base price and condiment pricing details.
   */
  private static void displayMenu() {
    System.out.println("Available Beverages:");
    System.out.println("1. Espresso - $2.00");
    System.out.println("2. Americano - $2.00");
    System.out.println("3. Latte Macchiato - $2.00");
    System.out.println("4. Black Tea - $2.00");
    System.out.println("5. Green Tea - $2.00");
    System.out.println("6. Yellow Tea - $2.00");
    System.out.println();
    System.out.println("Note: Each condiment unit adds $0.50 to the price.");
    System.out.println("Maximum 3 units per condiment type.");
    System.out.println();
  }

  /**
   * Prompts the user to select a beverage from the menu.
   * Validates the input and returns the corresponding BeverageTypes enum value.
   * 
   * @return the selected BeverageTypes enum value, or null if invalid input
   */
  private static BeverageTypes getBeverageSelection() {
    System.out.print("Please select a beverage (1-6): ");
    String input = scanner.nextLine().trim();
    
    try {
      int choice = Integer.parseInt(input);
      switch (choice) {
        case 1: return BeverageTypes.ESPRESSO;
        case 2: return BeverageTypes.AMERICANO;
        case 3: return BeverageTypes.LATTE_MACCHIATO;
        case 4: return BeverageTypes.BLACK_TEA;
        case 5: return BeverageTypes.GREEN_TEA;
        case 6: return BeverageTypes.YELLOW_TEA;
        default: return null;
      }
    } catch (NumberFormatException e) {
      return null;
    }
  }

  /**
   * Prompts the user to specify the number of condiment units for a given condiment type.
   * Validates that the input is a valid integer between 0 and 3 (inclusive).
   * 
   * @param condimentType the type of condiment (e.g., "milk", "sugar")
   * @return the number of condiment units (0-3)
   */
  private static int getCondimentUnits(String condimentType) {
    while (true) {
      System.out.print("How many units of " + condimentType + " would you like? (0-3): ");
      String input = scanner.nextLine().trim();
      
      try {
        int units = Integer.parseInt(input);
        if (units >= 0 && units <= 3) {
          return units;
        } else {
          System.out.println("Please enter a number between 0 and 3.");
          System.out.println();
        }
      } catch (NumberFormatException e) {
        System.out.println("Please enter a valid number.");
      }
    }
  }

  /**
   * Asks the user if they want to place another order.
   * 
   * @return true if the user wants to continue, false if they want to exit
   */
  private static boolean askToContinue() {
    while (true) {
      System.out.print("Would you like to place another order? (y/n): ");
      String input = scanner.nextLine().trim().toLowerCase();
      
      if (input.equals("y") || input.equals("yes")) {
        System.out.println();
        return true;
      } else {
        return false;
      }
    }
  }
}