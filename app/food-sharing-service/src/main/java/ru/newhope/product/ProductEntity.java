package ru.newhope.product;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name="v_product")
public class ProductEntity {
    @Id
    private Integer id;
    private String name;
    private Integer productCategoryId;
    private String productCategoryName;
    private Integer measurementId;
    private String measurementName;
}
