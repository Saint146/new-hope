package ru.newhope.city;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name="city")
public class CityEntity {
    @Id
    private Integer id;
    private String name;
}
