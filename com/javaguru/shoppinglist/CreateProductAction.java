package com.javaguru.shoppinglist;

import java.math.BigDecimal;
import java.util.Scanner;

public class CreateProductAction implements Action {

    private static final String ACTION_NAME = "Create Product";

    private final ProductService productService;

    public CreateProductAction(ProductService productService) {

        this.productService = productService;
    }

    private ProductValidationService validationService = new ProductValidationService();

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
        System.out.println("Enter product discount");
        float dis = scanner.nextFloat();
        int discount = 0;
        if (dis % 1 == 0) {
            discount = (int) dis;
        } else {
            throw new ArithmeticException("Discount must be integer");
        }

        Product product = new Product();
        product.setName(name);
        product.setPrice(new BigDecimal(price));
        product.setDiscount(discount);
        product.setCategory(category);
        product.setDescription(description);

        if (validationService.validate(product)) {
            try {
                Long response = productService.create(product);
                System.out.println("Response: " + response);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } else {
            System.out.println("sorry");
        }
    }

    @Override
    public String toString() {

        return ACTION_NAME;
    }
}
