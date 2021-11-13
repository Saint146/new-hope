package ru.newhope.productcategory;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductCategoryRepository extends ru.newhope.core.Repository<ProductCategoryEntity, String> {

    @Override
    List<ProductCategoryEntity> findAll();
}
