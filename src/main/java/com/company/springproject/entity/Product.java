package com.company.springproject.entity;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.apache.commons.lang3.builder.ToStringExclude;

import javax.persistence.*;
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data

@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    Double price;
    Double weight;
    String description;
    @ToStringExclude
    @ManyToOne()
    Category category;
    @Embedded
    ProductDetail productDetail;
    @ManyToOne()
    Brand brand;
    @ManyToOne()
    Category categories;


}
