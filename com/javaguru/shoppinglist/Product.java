package com.javaguru.shoppinglist;

import java.math.BigDecimal;
import java.util.Objects;

public class Product {

    private Long id;
    private String name;
    private BigDecimal price;
    private String category;
    private int bargin;
    private String description;

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getBargin() {
        return bargin;
    }

    public void setBargin(int bargin) {
        this.bargin = bargin;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String des) {
        this.description = des;
//        this.des=description; -- tak neljzja ;)
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (o == null || getPrice().equals(new BigDecimal(0.0))) return false;
        if (o == null || getBargin() == 100) return false;
        if (o == null || getName().length() < 3 || getName().length() > 32) return false;
        Product product = (Product) o;
        return Objects.equals(id, product.id) &&
                Objects.equals(name, product.name) &&
                Objects.equals(price, product.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, price, category, bargin, description);

    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", category= " + category + ", bargin= " + bargin + "descpription: " + description +
                '}';
    }
}