package ru.newhope.auth;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@NoArgsConstructor
@Entity
@Data
@Table(name = "volunteer")
public class AuthEntity {
    @Id
    private Integer id;
    private String name;
    private String phone;
    private String session;
    private String passwordHash;
}
