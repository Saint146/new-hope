package ru.newhope.transferact;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransferActRepository extends ru.newhope.core.Repository<TransferActEntity, String> {

    @Override
    List<TransferActEntity> findAll();
}
