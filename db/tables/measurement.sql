drop table if exists measurement;

create table measurement
(
    id   int          not null comment 'ID'      primary key auto_increment,
    name varchar(100) not null comment 'Название'
) comment 'Единицы измерения';

insert into measurement (name) values
('шт'),
('килограммы');

commit;