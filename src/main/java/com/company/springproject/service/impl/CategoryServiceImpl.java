package com.company.springproject.service.impl;
import com.company.springproject.dto.request.CategoryDtoRequest;
import com.company.springproject.dto.request.ProductDtoRequest;
import com.company.springproject.dto.response.CategoryDtoResponse;
import com.company.springproject.dto.response.ResponseDto;
import com.company.springproject.entity.Category;
import com.company.springproject.entity.Product;
import com.company.springproject.exception.CategoryNotFoundException;
import com.company.springproject.repository.CategoryRepository;
import com.company.springproject.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;
@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

     private  final CategoryRepository categoryRepository;
     private final ModelMapper modelMapper;
    @Override
    public ResponseEntity<ResponseDto> create(CategoryDtoRequest categoryDtoRequest) {
        Category category=modelMapper.map(categoryDtoRequest,Category.class);
        categoryRepository.save(category);
        return ResponseEntity.ok(new ResponseDto("Category created successfully!"));
    }
    @Override
    public List<CategoryDtoResponse> findAll() {
            return categoryRepository.findAll().stream()
                .map(category -> modelMapper.map(category, CategoryDtoResponse.class))
                .collect(Collectors.toList());
    }

    @Override
    public CategoryDtoResponse findById(Long id) {
        return modelMapper.map(categoryRepository.findById(id).orElseThrow(CategoryNotFoundException::new),
                CategoryDtoResponse.class);

    }

    public ResponseEntity<ResponseDto> update(CategoryDtoRequest categoryDtoRequest) {
        Category existingCategory = categoryRepository.findById(categoryDtoRequest.getId())
                .orElseThrow(CategoryNotFoundException::new);
        modelMapper.map(categoryDtoRequest, existingCategory);
        categoryRepository.save(existingCategory);
        return ResponseEntity.ok(new ResponseDto("Category updated successfully!"));
    }


    }



