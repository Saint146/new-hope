package ru.newhope.volunteer;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
import java.util.UUID;

@Entity
@Data
@Table(name = "v_volunteer")
public class VolunteerEntity {
    @Id
    private Integer id;
    private String name;
    private String phone;
    private String address;
    private Integer cityId;
    private String cityName;
    private Date dateRegister;
    private Integer isCurator;
    private Integer isAdmin;
    private Integer isLocked;
}
