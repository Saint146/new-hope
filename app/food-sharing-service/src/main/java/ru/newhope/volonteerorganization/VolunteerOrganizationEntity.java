package ru.newhope.volonteerorganization;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Data
@Table(name="v_volunteer_organization")
public class VolunteerOrganizationEntity {
    @Id
    private Integer id;
    private String organizationName;
    private Integer cityId;
    private Integer volunteerId;
}