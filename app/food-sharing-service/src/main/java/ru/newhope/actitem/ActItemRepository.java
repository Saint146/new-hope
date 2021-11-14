package ru.newhope.actitem;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActItemRepository extends ru.newhope.core.Repository<ActItemEntity, String> {

    @Override
    List<ActItemEntity> findAll();
}
