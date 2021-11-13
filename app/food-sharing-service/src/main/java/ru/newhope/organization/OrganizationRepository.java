package ru.newhope.organization;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrganizationRepository extends ru.newhope.core.Repository<OrganizationEntity, String> {

    @Override
    List<OrganizationEntity> findAll();
}
