package com.company.springproject.repository;

import com.company.springproject.entity.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandRepository extends  JpaRepository<Brand,Long> {
}
