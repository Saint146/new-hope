package ru.newhope.schedule;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Time;
import java.util.Date;

@Entity
@Data
@Table(name="v_schedule_all")
public class ScheduleEntity {
    @Id
    private Integer id;
    private Date scheduleDate;
    private Time scheduleTime;
    private Integer organizationId;
    private String organizationName;
    private Integer cityId;
    private Integer volunteerId;
}