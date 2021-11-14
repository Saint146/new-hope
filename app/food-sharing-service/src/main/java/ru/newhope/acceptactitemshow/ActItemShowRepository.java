package ru.newhope.acceptactitemshow;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActItemShowRepository extends ru.newhope.core.Repository<ActItemShowEntity, Integer> {

    @Override
    List<ActItemShowEntity> findAll();
}
