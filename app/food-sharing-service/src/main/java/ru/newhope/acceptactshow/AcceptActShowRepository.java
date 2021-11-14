package ru.newhope.acceptactshow;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AcceptActShowRepository extends ru.newhope.core.Repository<AcceptActShowEntity, Integer> {

    @Override
    List<AcceptActShowEntity> findAll();
}
