package com.company.springproject.exception;

import com.company.springproject.enums.ExceptionEnums;

public class ProductNotFoundException extends RuntimeException{
    public ProductNotFoundException(String message) {
        super(ExceptionEnums.PRODUCT_NOT_FOUND_EXCEPTION.getMessage());
    }
}
