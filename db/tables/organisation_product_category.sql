drop table if exists organisation_product_category;

create table organisation_product_category
(
    id                  int          not null comment 'ID'      primary key auto_increment,
    organisation_id     int          not null comment 'ID Организации',
    product_category_id int          not null comment 'ID Категории продуктов',
    foreign key (organisation_id) references organisation(id),
    foreign key (product_category_id) references product_category(id)
) comment 'Привязка организации к категориям';

insert into organisation_product_category (organisation_id, product_category_id) values
(1, 1);

commit;