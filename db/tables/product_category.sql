drop table if exists product_category;

create table product_category
(
    id   int          not null comment 'ID'      primary key auto_increment,
    name varchar(100) not null comment 'Название'
) comment 'Категории продуктов';

insert into product_category (name) values
('Хлеб'),
('Фрукты'),
('Овощи'),
('Молокопродукты'),
('Консервы'),
('Напитки');

commit;