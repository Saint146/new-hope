package ru.newhope.productcategory;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name="product_category")
public class ProductCategoryEntity {
    @Id
    private Integer id;
    private String name;
}
