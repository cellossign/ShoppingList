package com.javaguru.shoppinglist;

import java.math.BigDecimal;
import java.util.Scanner;

public class CreateProductAction implements Action {

    private static final String ACTION_NAME = "Create Product";

    private final ProductService productService;

    public CreateProductAction(ProductService productService) {

        this.productService = productService;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
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

        if ((product.getPrice().equals(new BigDecimal(0.0))) ||
                (product.getPrice().compareTo(new BigDecimal(0.0)) < 0) || //cena menjshe nulja
                (product.getBargin() >= 100) ||
                (product.getBargin() <0) ||
                (product.getName().length() < 3) || (product.getName().length() > 32)) {

            System.out.println("Can't create that kind of product!");
        } else {
            try {
                Long response = productService.create(product);
                System.out.println("Response: " + response);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    @Override
    public String toString() {

        return ACTION_NAME;
    }
}
