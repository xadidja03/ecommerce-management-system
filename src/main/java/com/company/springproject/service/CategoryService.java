package com.company.springproject.service;

import com.company.springproject.dto.request.CategoryDtoRequest;
import com.company.springproject.dto.response.CategoryDtoResponse;
import com.company.springproject.dto.response.ResponseDto;
import com.company.springproject.entity.Category;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CategoryService {
    List<CategoryDtoResponse> findAll();
    CategoryDtoResponse findById(Long id);
    ResponseEntity<ResponseDto> update(CategoryDtoRequest categoryDtoRequest);


    ResponseEntity<ResponseDto> create(CategoryDtoRequest categoryDtoRequest);
}
