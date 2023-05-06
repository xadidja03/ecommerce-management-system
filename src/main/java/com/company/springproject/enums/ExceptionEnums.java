package com.company.springproject.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
@Getter
@RequiredArgsConstructor
public enum ExceptionEnums {
    CATEGORY_NOT_FOUND_EXCEPTION(HttpStatus.NOT_FOUND,"Category not found!"),
    PRODUCT_NOT_FOUND_EXCEPTION(HttpStatus.NOT_FOUND,"Product not found!"),
    BRAND_NOT_FOUND_EXCEPTION(HttpStatus.NOT_FOUND,"Brand not found!");
    private final HttpStatus status;
    private final String message;

}
