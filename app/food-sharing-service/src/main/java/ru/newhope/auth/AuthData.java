package ru.newhope.auth;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class AuthData {
    private String phone;
    private String password;
}
