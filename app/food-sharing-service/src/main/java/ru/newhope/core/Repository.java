package ru.newhope.core;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;


@NoRepositoryBean
public interface Repository<ENTITY, TYPEID> extends JpaRepository<ENTITY, TYPEID> {

}
