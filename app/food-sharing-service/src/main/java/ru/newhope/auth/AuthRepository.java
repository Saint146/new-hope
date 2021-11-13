package ru.newhope.auth;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthRepository extends ru.newhope.core.Repository<AuthEntity, AuthData> {

    @Override
    List<AuthEntity> findAll();

    AuthEntity getByPhoneAndPasswordHash(String phone, String PasswordHash);
}
