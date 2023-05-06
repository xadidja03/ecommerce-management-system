package com.company.springproject.controller;
import com.company.springproject.dto.request.CategoryDtoRequest;
import com.company.springproject.dto.request.ProductDtoRequest;
import com.company.springproject.dto.response.CategoryDtoResponse;
import com.company.springproject.dto.response.ProductDtoResponse;
import com.company.springproject.dto.response.ResponseDto;
import com.company.springproject.service.CategoryService;
import com.company.springproject.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api/products")
public class ProductController {
    private final ProductService productService;
    @GetMapping("/show")
    public List<ProductDtoResponse> productDtoResponses(){
        log.info("GET- /products-> request none");
        var response=productService.findAll();
        log.info("GET- /products - response -> {}", response);
        return response;
    }
    @PostMapping("/register")
    public ResponseDto products(@RequestBody ProductDtoRequest productDtoRequest){
        log.info("GET- /products -> request",productDtoRequest);
        var response=productService.create(productDtoRequest);
        log.info("GET- /products - response -> {}", productDtoRequest
                , response);
        return response.getBody();
    }
    @GetMapping("/{id}")
    public ProductDtoResponse productDtoResponse(@PathVariable Long id) {
        log.info("GET- /products -> request", id);
        var response=productService.findById(id);
        log.info("GET- /products - response -> {}", id, response);
        return response;
    }

    @PutMapping("/update")
    public ResponseDto updateProduct(@Valid @RequestBody ProductDtoRequest productDtoRequest) {
        log.info("PUT- /products -> request: {}", productDtoRequest);
        var response = productService.update(productDtoRequest);
        log.info("PUT- /products - response -> {}", response);
        return response.getBody();
    }

}
