package ru.newhope.acceptact;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name="accept_act")
public class AcceptActEntity {
    @Id
    private Integer id;
    private String name;
}
