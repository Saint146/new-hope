drop table if exists city;

create table city
(
    id   int          not null comment 'ID'      primary key auto_increment,
    name varchar(100) not null comment 'Название'
) comment 'Город';

insert into city (name) values
('Москва'),
('Пермь'),
('Санкт-Петербург');

commit;