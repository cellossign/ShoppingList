package com.javaguru.shoppinglist;

import java.util.HashMap;
import java.util.Map;

public class ProductInMemoryRepository {
    private Long TaskIdSeguence = 0L;
    private Map<Long, Product> products = new HashMap<>();
    public Product insert(Product product) {
        product.setId(TaskIdSeguence);
        products.put(TaskIdSeguence, product);
        TaskIdSeguence++;
        return product;
    }
    public Product findTaskById(Long id) {
        return products.get(id);
    }
}
