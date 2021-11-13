package ru.newhope.volonteerorganization;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VolunteerOrganizationRepository extends ru.newhope.core.Repository<VolunteerOrganizationEntity, String> {

    @Override
    List<VolunteerOrganizationEntity> findAll();

    List<VolunteerOrganizationEntity> getByVolunteerId(Integer volunteerId);
}
