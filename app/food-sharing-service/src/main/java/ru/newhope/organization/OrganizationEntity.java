package ru.newhope.organization;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Data
@Table(name="/organization")
public class OrganizationEntity {
    @Id
    private Integer id;
    private String name;
    private String phone;
    private Integer cityId;
    private String cityName;
    private String address;
    private Date dateRegister;
    //private Date dateRegister;
}