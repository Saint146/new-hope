drop table if exists acceptance_act_row;

create table if not exists acceptance_act_row
(
    id                int           not null comment 'ID' primary key auto_increment,
    acceptance_act_id int           not null comment 'ID Акта получения',
    product_id        int           not null comment 'ID Продукта',
    amount            int           not null comment 'Количество/Штуки',
    price             numeric(10,2) not null comment 'Стоимость',
    expiration_date   date          not null comment 'Срок годности',
    note              varchar(4000)     null comment 'Примечание',
  foreign key (acceptance_act_id) references acceptance_act(id),
  foreign key (product_id) references product(id)
) comment 'Строки акта получения';

insert into acceptance_act_row(acceptance_act_id, product_id, amount, price, expiration_date, note) values
(1, 1, 1, 19.9, STR_TO_DATE('11/15/2021', '%m/%d/%Y'), 'Примечание к позиции 1'),
(1, 1, 1, 19.9, STR_TO_DATE('11/16/2021', '%m/%d/%Y'), 'Примечание к позиции 2'),
(1, 2, 3, 25.9, STR_TO_DATE('11/20/2021', '%m/%d/%Y'), 'Примечание к позиции 3');

commit;