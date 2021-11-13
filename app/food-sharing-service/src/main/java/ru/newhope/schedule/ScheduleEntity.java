package ru.newhope.schedule;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name="v_schedule_all")
public class ScheduleEntity {
    @Id
    private Integer id;
    private String scheduleDate;
    private String scheduleTime;
    private Integer organisationId;
    private String organisationName;
    private Integer cityId;
    private Integer volunteerId;
}