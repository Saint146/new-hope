set search_path to fs;

--Город
insert into city(id, name)
values(1, 'Москва');
insert into city(id, name)
values(2, 'Санкт Петербург');
insert into city(id, name)
values(3, 'Пермь');


--Статус набора продуктов
insert into Product_set_status(id, name)
values(1, 'Создан, ожидает назначения курьера');
insert into Product_set_status(id, name)
values(2, 'Курьер назначен');
insert into Product_set_status(id, name)
values(3, 'Получен курьером');
insert into Product_set_status(id, name)
values(4, 'Передан благополучателю');

--Тип получателя
insert into Receiver_type(id, name)
values(1, 'Физическое лицо');
insert into Receiver_type(id, name)
values(2, 'Юридическое лицо');


--Статус расписания
insert into Schedule_status(id, name)
values(1, 'Запланировано');
insert into Schedule_status(id, name)
values(2, 'Запланировано, подтверждено');

--Производитель
insert into producer (id, name, city_id, date_register, addres)
values(1, 'Пятёрочка', 3, '2010-05-12'::date, 'Докучаева, 30');
insert into producer (id, name, city_id, date_register, addres)
values(2, 'Семья', 3, '2018-10-01'::date, 'Революции, 14');

--Волонтёр
insert into volunteer (id, name, date_register, is_curator, is_admin)
values(1, 'Боярская Елизавета Михайловна', '2014-01-01'::date, 1, 0);
insert into volunteer (id, name, date_register, is_curator, is_admin)
values(2, 'Светлов Алексей Львович', '2017-10-05'::date, 0, 1);
insert into volunteer (id, name, date_register, is_curator, is_admin)
values(3, 'Арканов Сергей Юрьевич', '2018-07-05'::date, 0, 0);
insert into volunteer (id, name, date_register, is_curator, is_admin)
values(4, 'Малышева Анна Николаевна', '2019-08-14'::date, 0, 0);