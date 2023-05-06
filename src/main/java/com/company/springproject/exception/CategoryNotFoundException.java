package com.company.springproject.exception;

import com.company.springproject.enums.ExceptionEnums;

public class CategoryNotFoundException extends RuntimeException {
    public CategoryNotFoundException() {
        super(ExceptionEnums.CATEGORY_NOT_FOUND_EXCEPTION.getMessage());

    }
}
