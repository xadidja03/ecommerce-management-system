package com.company.springproject.handler;

import com.company.springproject.dto.response.ExceptionResponse;
import com.company.springproject.enums.ExceptionEnums;
import com.company.springproject.exception.CategoryNotFoundException;
import com.company.springproject.exception.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import java.time.LocalDateTime;
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler({CategoryNotFoundException.class, ProductNotFoundException.class})
    public ExceptionResponse handle(){
        return ExceptionResponse.builder()
                .localDateTime(LocalDateTime.now())
                .message(ExceptionEnums.CATEGORY_NOT_FOUND_EXCEPTION.getMessage())
                .message(ExceptionEnums.PRODUCT_NOT_FOUND_EXCEPTION.getMessage())
                .message(ExceptionEnums.BRAND_NOT_FOUND_EXCEPTION.getMessage())
                .build();

    }
}
