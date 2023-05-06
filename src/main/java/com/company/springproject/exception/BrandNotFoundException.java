package com.company.springproject.exception;

import com.company.springproject.enums.ExceptionEnums;

public class BrandNotFoundException extends RuntimeException {
    public BrandNotFoundException() {
        super(ExceptionEnums.BRAND_NOT_FOUND_EXCEPTION.getMessage());

}}
