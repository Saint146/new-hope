package ru.newhope.volunteer;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Data
@Table(name = "volunteer")
public class VolunteerEntity {
    @Id
    private Integer id;
    private String name;
    private Date dateRegister;
    private Integer isCurator;
    private Integer isAdmin;
}
