package com.company.springproject.dto.request;
import com.company.springproject.entity.Product;
import lombok.*;
import lombok.experimental.FieldDefaults;
import java.util.List;
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
public class BrandDtoRequest {

    Long id;
    String name;
    String description;
    List<ProductDtoRequest> productList;

}
