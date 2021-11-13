drop table if exists acceptance_act;

create table if not exists acceptance_act
(
    id              int           not null comment 'ID' primary key auto_increment,
    acceptance_date date          not null comment 'Дата акта',
    organisation_id int           not null comment 'ID Организации',
    volunteer_id    int               null comment 'ID Волонтера',
  foreign key (organisation_id) references organisation(id),
  foreign key (volunteer_id) references volunteer(id)
) comment 'Акт получения';

insert into acceptance_act(acceptance_date, organisation_id, volunteer_id)
values(STR_TO_DATE('11/15/2021', '%m/%d/%Y'), 1, 1);

commit;