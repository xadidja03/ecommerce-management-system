package com.company.springproject.service;

import com.company.springproject.dto.request.BrandDtoRequest;
import com.company.springproject.dto.request.BrandDtoResponse;
import com.company.springproject.dto.request.ProductDtoRequest;
import com.company.springproject.dto.response.ProductDtoResponse;
import com.company.springproject.dto.response.ResponseDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface BrandService {
    List<BrandDtoResponse> findAll();
    BrandDtoResponse findById(Long id);

    ResponseEntity<ResponseDto> create(BrandDtoRequest brandDtoRequest);

    ResponseEntity<ResponseDto> update(BrandDtoRequest brandDtoRequest);
}
