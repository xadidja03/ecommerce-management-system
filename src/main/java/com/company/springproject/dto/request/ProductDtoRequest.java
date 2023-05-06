package com.company.springproject.dto.request;
import lombok.*;
import lombok.experimental.FieldDefaults;
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data


public class ProductDtoRequest {
    Long id;
    String name;
    Double price;
    Double weight;
    String description;

    brandId
}