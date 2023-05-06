package com.company.springproject.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;
import javax.persistence.*;
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data


public class ProductDtoResponse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    Double price;
    Double weight;
    String description;
}