package com.javaguru.shoppinglist;

import java.math.BigDecimal;

public class ProductValidationService {
    boolean isValidated=true;
        public boolean validate (Product product){

        if ((product.getPrice().compareTo(new BigDecimal(0.0)) < 0) ||
                (product.getPrice().equals(new BigDecimal(0.0)))) {
            isValidated= false;
            throw new ArithmeticException("Please enter valid price");
        }
        if ((product.getDiscount() >= 100)
                || (product.getDiscount() < 0)) {
            isValidated= false;
            throw new ArithmeticException("Please eneter valid discount");
        }
        if ((product.getName().length() < 3) ||
                (product.getName().length() > 32)) {
            isValidated= false;
            throw new ArithmeticException("Please enter valid name");
        }
        return isValidated;
    }
}
