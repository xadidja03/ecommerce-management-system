package com.company.springproject.controller;

import com.company.springproject.dto.request.CategoryDtoRequest;
import com.company.springproject.dto.request.ProductDtoRequest;
import com.company.springproject.dto.response.CategoryDtoResponse;
import com.company.springproject.dto.response.ResponseDto;
import com.company.springproject.service.CategoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/categories")
@RequiredArgsConstructor
@Slf4j
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping("/show" +
            "")
    public ResponseEntity<List<CategoryDtoResponse>> getAllCategories() {
        log.info("GET /api/categories -> request none");
        List<CategoryDtoResponse> response = categoryService.findAll();
        log.info("GET /api/categories -> response {}", response);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryDtoResponse> getCategoryById(@PathVariable Long id) {
        log.info("GET /api/categories/{} -> request", id);
        CategoryDtoResponse response = categoryService.findById(id);
        log.info("GET /api/categories/{} -> response {}", id, response);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/register")
    public ResponseEntity<ResponseDto> createCategory(@RequestBody @Valid CategoryDtoRequest categoryDtoRequest) {
        log.info("POST /api/categories -> request {}", categoryDtoRequest);
        ResponseDto response = categoryService.create(categoryDtoRequest).getBody();
        log.info("POST /api/categories -> response {}", response);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
    @PutMapping("/update")
    public ResponseDto updateProduct(@Valid @RequestBody CategoryDtoRequest categoryDtoRequest) {
        log.info("PUT- /categories -> request: {}",categoryDtoRequest);
        var response = categoryService.update(categoryDtoRequest);
        log.info("PUT- /categories- response -> {}", response);
        return response.getBody();
    }
}
