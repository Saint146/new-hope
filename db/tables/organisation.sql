drop table if exists organisation;

create table if not exists organisation
(
    id            int           not null comment 'ID' primary key auto_increment,
    name          varchar(4000) not null comment 'Наименование организации',
    phone         varchar(15)       null comment 'Телефон',
    city_id       int           not null comment 'Город',
    address       varchar(4000) not null comment 'Адрес',
    date_register date          not null comment 'Дата регистрации',
  foreign key (city_id) references city(id)
) comment 'Организации';

insert into organisation(name, phone, city_id, address, date_register)
values('Отдадим хлеб', '890912312312', 2, 'Студенческая 1', sysdate());

commit;