drop table if exists volunteer;

create table if not exists volunteer
(
    id            int           not null comment 'ID' primary key auto_increment,
    name          varchar(4000) not null comment 'Фамилия Имя Отчество (Именительный падеж)',
    name_gen      varchar(4000) not null comment 'Фамилия Имя Отчество (Родительный падеж)',
    phone         varchar(15)   not null comment 'Телефон',
    city_id       int           not null comment 'Город',
    address       varchar(4000) not null comment 'Адрес',
    password_hash varchar(32)   not null comment 'Хэш пароля',
    session       varchar(36)       null comment 'Сессия пользователя',
    date_register date          not null comment 'Дата регистрации',
    is_curator    int           not null comment 'Флаг куратора (1/0)' default 0,
    is_admin      int           not null comment 'Флаг администратора (1/0)'  default 0,
    is_locked     int           not null comment 'Флаг Блокировки (1/0)'  default 0,
  foreign key (city_id) references city(id)
) comment 'Волонтеры';

insert into volunteer(name, name_gen, phone, city_id, address, password_hash, date_register, is_curator, is_admin, is_locked)
values('Миша', 'Мише', '123', 2, 'Студенческая 13', 'DJ37DJ28DJ83JD83', sysdate(), 0, 1, 0);

insert into volunteer(name, name_gen, phone, city_id, address, password_hash, date_register, is_curator, is_admin, is_locked)
values('Алексей', 'Алексею', '3223', 2, 'Студенческая 15', 'DJ37DJ28DJ83JD84', sysdate(), 0, 1, 0);

insert into volunteer(name, name_gen, phone, city_id, address, password_hash, date_register, is_curator, is_admin, is_locked)
values('Александр', 'Александру', '3423', 2, 'Студенческая 53', 'DJ37DJ28DJ83JD85', sysdate(), 0, 1, 0);

insert into volunteer(name, name_gen, phone, city_id, address, password_hash, date_register, is_curator, is_admin, is_locked)
values('Антон', 'Антону', '43232', 2, 'Ленина 1', 'DJ37DJ28DJ83JD86', sysdate(), 0, 1, 0);

insert into volunteer(name, name_gen, phone, city_id, address, password_hash, date_register, is_curator, is_admin, is_locked)
values('Илья', 'Илье', '454', 2, 'Ленина 1', 'DJ37DJ28DJ83JD86', sysdate(), 0, 1, 0);

commit;