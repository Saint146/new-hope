drop table if exists product;

create table product
(
    id                  int          not null comment 'ID'      primary key auto_increment,
    name                varchar(100) not null comment 'Название',
    product_category_id int          not null comment 'Категория продукта',
    measurement_id      int          not null comment 'Единицы измерения',
    foreign key (product_category_id) references product_category(id),
    foreign key (measurement_id) references measurement(id)
) comment 'Продукты';

insert into product (name, product_category_id, measurement_id) values
('Хлеб дарницкий', 1, 1),
('Батон нарезной', 1, 1);

commit;