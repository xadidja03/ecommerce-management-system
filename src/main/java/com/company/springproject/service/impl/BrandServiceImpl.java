package com.company.springproject.service.impl;
import com.company.springproject.dto.request.BrandDtoRequest;
import com.company.springproject.dto.request.BrandDtoResponse;
import com.company.springproject.dto.request.CategoryDtoRequest;
import com.company.springproject.dto.request.ProductDtoRequest;
import com.company.springproject.dto.response.CategoryDtoResponse;
import com.company.springproject.dto.response.ProductDtoResponse;
import com.company.springproject.dto.response.ResponseDto;
import com.company.springproject.entity.Brand;
import com.company.springproject.entity.Category;
import com.company.springproject.entity.Product;
import com.company.springproject.exception.BrandNotFoundException;
import com.company.springproject.exception.CategoryNotFoundException;
import com.company.springproject.repository.BrandRepository;
import com.company.springproject.repository.CategoryRepository;
import com.company.springproject.service.BrandService;
import com.company.springproject.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;
@Service
@RequiredArgsConstructor
public class BrandServiceImpl implements BrandService {
    private final BrandRepository brandRepository;
    private final ModelMapper modelMapper;


    @Override
    public List<BrandDtoResponse> findAll() {
        return brandRepository.findAll().stream()
                .map(brand -> modelMapper.map(brand, BrandDtoResponse.class))
                .collect(Collectors.toList());

    }

    @Override
    public BrandDtoResponse findById(Long id) {
        return modelMapper.map(brandRepository.findById(id).orElseThrow(BrandNotFoundException::new),
                BrandDtoResponse.class);
    }

    @Override
    public ResponseEntity<ResponseDto> create(BrandDtoRequest brandDtoRequest) {
        Brand brand = modelMapper.map(brandDtoRequest, Brand.class);
        brandRepository.save(brand);
        return ResponseEntity.ok(new ResponseDto("Brand created successfully!"));
    }


    @Override
    public ResponseEntity<ResponseDto> update(BrandDtoRequest brandDtoRequest) {
        Brand existingBrand = brandRepository.findById(brandDtoRequest.getId())
                .orElseThrow(BrandNotFoundException::new);
        modelMapper.map(brandDtoRequest, existingBrand);
        brandRepository.save(existingBrand);
        return ResponseEntity.ok(new ResponseDto("Brand updated successfully!"));
    }
}



