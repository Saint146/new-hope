drop table if exists transferee;

create table if not exists transferee
(
    id            int           not null comment 'ID' primary key auto_increment,
    name          varchar(4000) not null comment 'Фамилия Имя Отчество (Именительный падеж)',
    phone         varchar(15)   not null comment 'Телефон',
    city_id       int           not null comment 'Город',
    address       varchar(4000) not null comment 'Адрес',
    accordance    varchar(4000) not null comment 'Основание действия (Родительный падеж)',
  foreign key (city_id) references city(id)
) comment 'Получатель';

insert into transferee(name, phone, city_id, address, accordance)
values('Сергей', '89512323232', 2, 'Студенческая 12', 'полная или частичная утрата способности либо возможности осуществлять самообслуживание');

commit;