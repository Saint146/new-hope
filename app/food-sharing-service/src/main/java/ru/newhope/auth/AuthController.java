package ru.newhope.auth;

import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.newhope.volunteer.VolunteerRepository;
import org.apache.commons.codec.digest.DigestUtils;


import java.util.UUID;

@AllArgsConstructor
@RestController
@Api(value = "Авторизация")
public class AuthController {

    @Autowired
    AuthRepository authRepository;

    @Autowired
    VolunteerRepository volunteerRepository;

    @PostMapping(path="/auth", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity setVolunteer(@RequestBody AuthData newAuthData) {

        String md5Hex = DigestUtils.md5Hex(newAuthData.getPassword()).toUpperCase();

        //Проверка регистрации, поиск в БД по тел. + hash пароля
        try {
            AuthData authData = new AuthData(newAuthData.getPhone(), md5Hex);
            AuthEntity authEntity = authRepository.getByPhoneAndPasswordHash(authData.getPhone(), md5Hex);

            UUID uuid = UUID.randomUUID();
            authEntity.setSession(uuid.toString());
            authRepository.save(authEntity);

            return new ResponseEntity<>(authEntity, HttpStatus.CREATED);
        } catch (Exception ex) {
            AuthEntity authError = new AuthEntity();
            authError.setId(-1);
            return new ResponseEntity<>(authError, HttpStatus.CREATED);
        }
    }
}