package com.javaguru.shoppinglist;

import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

public class ConsoleUI {

    private final List<Action> actions;
    public ConsoleUI(List<Action> actions) {
        this.actions = actions;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        int response = 0;

        System.out.println("Enter product name:");
        String name = scanner.nextLine();
        System.out.println("Enter product price: ");
        String price = scanner.nextLine();
        System.out.println("Enter product category");
        String category = scanner.nextLine();
        System.out.println("Enter product description");
        String description = scanner.nextLine();
        System.out.println("Enter product bargin");
        int bargin = scanner.nextInt();

        Product product = new Product();
        product.setName(name);
        product.setPrice(new BigDecimal(price));
        product.setBargin(bargin);
        product.setCategory(category);
        product.setDescription(description);

        ////////

        while (response >= 0) {
            printMenu();
            try {
                response = scanner.nextInt();
                actions.get(response).execute();
            } catch (Exception e) {
                System.out.println("Error! Please try again.");
            }
        }
    }

    private void printMenu() {
        for (int i = 0; i < actions.size(); i++) {
            System.out.println(i + ". " + actions.get(i));
        }
    }
}
