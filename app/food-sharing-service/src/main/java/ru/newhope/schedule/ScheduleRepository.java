package ru.newhope.schedule;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScheduleRepository extends ru.newhope.core.Repository<ScheduleEntity, String> {

    @Override
    List<ScheduleEntity> findAll();
}
