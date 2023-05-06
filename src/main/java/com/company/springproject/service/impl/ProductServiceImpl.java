package com.company.springproject.service.impl;
import com.company.springproject.dto.request.ProductDtoRequest;
import com.company.springproject.dto.response.ProductDtoResponse;
import com.company.springproject.dto.response.ResponseDto;
import com.company.springproject.entity.Product;
import com.company.springproject.exception.CategoryNotFoundException;
import com.company.springproject.repository.ProductRepository;
import com.company.springproject.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor

public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;

    @Override
    public ResponseEntity<ResponseDto> create(ProductDtoRequest productDtoRequest) {
        Product product=modelMapper.map(productDtoRequest,Product.class);
        productRepository.save(product);
        return ResponseEntity.ok(new ResponseDto("Product created successfully!"));
    }
    @Override
    public List<ProductDtoResponse> findAll() {
            return productRepository.findAll().stream()
                    .map(product -> modelMapper.map(product, ProductDtoResponse.class))
                    .collect(Collectors.toList());
    }

    @Override
    public ProductDtoResponse findById(Long id) {
        return modelMapper.map(productRepository.findById(id).orElseThrow(CategoryNotFoundException::new),
                ProductDtoResponse.class);
    }

    @Override
    public ResponseEntity<ResponseDto> update(ProductDtoRequest productDtoRequest) {
        Product existingProduct = productRepository.findById(productDtoRequest.getId())
                .orElseThrow(CategoryNotFoundException::new);
        modelMapper.map(productDtoRequest, existingProduct);
        productRepository.save(existingProduct);
        return ResponseEntity.ok(new ResponseDto("Product updated successfully!"));
    }




}