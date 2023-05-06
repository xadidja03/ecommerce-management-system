package com.company.springproject.entity;
import lombok.*;
import lombok.experimental.FieldDefaults;
import javax.persistence.*;
import java.util.List;
@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    String description;
    @OneToMany(cascade = CascadeType.PERSIST,mappedBy = "categories")
    List<Product> productList;
}