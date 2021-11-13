drop table if exists schedule;

create table if not exists schedule
(
    id              int           not null comment 'ID' primary key auto_increment,
    schedule_date   date          not null comment 'Дата расписания',
    schedule_time   time          not null comment 'Время события',
    organisation_id int           not null comment 'ID Организации',
    volunteer_id    int               null comment 'ID Волонтера',
  foreign key (organisation_id) references organisation(id),
  foreign key (volunteer_id) references volunteer(id)
) comment 'Расписание';

insert into schedule(schedule_date, schedule_time, organisation_id, volunteer_id)
values(STR_TO_DATE('11/15/2021', '%m/%d/%Y'), STR_TO_DATE('19:15', '%H:%i'), 1, 1);

insert into schedule(schedule_date, schedule_time, organisation_id, volunteer_id)
values(STR_TO_DATE('11/16/2021', '%m/%d/%Y'), STR_TO_DATE('19:45', '%T'), 1, null);

commit;