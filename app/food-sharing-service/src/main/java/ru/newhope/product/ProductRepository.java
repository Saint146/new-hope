package ru.newhope.product;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends ru.newhope.core.Repository<ProductEntity, String> {

    @Override
    List<ProductEntity> findAll();
}
