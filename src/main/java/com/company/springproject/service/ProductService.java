package com.company.springproject.service;
import com.company.springproject.dto.request.ProductDtoRequest;
import com.company.springproject.dto.response.ProductDtoResponse;
import com.company.springproject.dto.response.ResponseDto;
import org.springframework.http.ResponseEntity;
import java.util.List;
public interface ProductService {

    List<ProductDtoResponse> findAll();
    ProductDtoResponse findById(Long id);

    ResponseEntity<ResponseDto> create(ProductDtoRequest productDtoRequest);

    ResponseEntity<ResponseDto> update(ProductDtoRequest productDtoRequest);
}
