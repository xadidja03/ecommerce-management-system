package com.company.springproject.dto.request;
import com.company.springproject.entity.Category;
import com.company.springproject.entity.Product;
import lombok.*;
import lombok.experimental.FieldDefaults;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CategoryDtoRequest {

    Long id;
    String name;
    List<ProductDtoRequest> productList;
}
