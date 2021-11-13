package ru.newhope.acceptact;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AcceptActRepository extends ru.newhope.core.Repository<AcceptActEntity, String> {

    @Override
    List<AcceptActEntity> findAll();
}
