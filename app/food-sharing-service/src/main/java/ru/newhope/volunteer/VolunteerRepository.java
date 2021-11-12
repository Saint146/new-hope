package ru.newhope.volunteer;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VolunteerRepository extends ru.newhope.core.Repository<VolunteerEntity, String> {

    @Override
    List<VolunteerEntity> findAll();
}
