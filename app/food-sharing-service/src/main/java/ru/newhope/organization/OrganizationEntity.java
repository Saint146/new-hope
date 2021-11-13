package ru.newhope.organization;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Data
@Table(name="v_organization")
public class OrganizationEntity {
    @Id
    private Integer id;
    private String name;
    private String phone;
    private Integer cityId;
    private String cityName;
    private String address;
    private Date dateRegister;
    private String agreementId;
    private String agreementNum;
    private Date signDate;
    private String accordance;
    private String representor;
    private String representorGen;
    private Integer isCurrent;
}