package com.company.springproject.controller;
import com.company.springproject.dto.request.BrandDtoRequest;
import com.company.springproject.dto.request.BrandDtoResponse;
import com.company.springproject.dto.request.CategoryDtoRequest;
import com.company.springproject.dto.request.ProductDtoRequest;
import com.company.springproject.dto.response.CategoryDtoResponse;
import com.company.springproject.dto.response.ProductDtoResponse;
import com.company.springproject.dto.response.ResponseDto;
import com.company.springproject.service.BrandService;
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
@RequestMapping("/api/brands")
public class BrandController {
    private final BrandService brandService;
    @GetMapping("/show")
    public List<BrandDtoResponse> brandDtoResponses(){
        log.info("GET- /brands-> request none");
        var response=brandService.findAll();
        log.info("GET- /brands - response -> {}", response);
        return response;
    }
    @PostMapping("/register")
    public ResponseDto brands(@RequestBody BrandDtoRequest brandDtoRequest){
        log.info("POST- /brands -> request",brandDtoRequest);
        var response=brandService.create(brandDtoRequest);
        log.info("POST- /brands - response -> {}", brandDtoRequest
                , response);
        return response.getBody();
    }
    @GetMapping("/{id}")
    public BrandDtoResponse brandDtoResponse(@PathVariable Long id) {
        log.info("GET- /brands  -> request", id);
        var response=brandService.findById(id);
        log.info("GET- /brands  - response -> {}", id, response);
        return response;
    }
    @PutMapping("/update")
    public ResponseDto updateProduct(@Valid @RequestBody BrandDtoRequest brandDtoRequest) {
        log.info("PUT- /brands-> request: {}",brandDtoRequest);
        var response =brandService.update(brandDtoRequest);
        log.info("PUT- /brands- response -> {}", response);
        return response.getBody();
    }
    }
