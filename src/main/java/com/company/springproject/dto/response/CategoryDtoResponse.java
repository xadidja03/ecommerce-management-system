package com.company.springproject.dto.response;
import com.company.springproject.entity.Product;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CategoryDtoResponse {
    String name;
    List<Product> productList;
}
