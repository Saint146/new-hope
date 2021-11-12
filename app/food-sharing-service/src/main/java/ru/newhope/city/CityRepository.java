package ru.newhope.city;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CityRepository extends ru.newhope.core.Repository<CityEntity, String> {

    @Override
    List<CityEntity> findAll();
}
