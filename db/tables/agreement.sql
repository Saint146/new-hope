drop table if exists agreement;

create table agreement
(
    id                int           not null comment 'ID'      primary key auto_increment,
    organisation_id   int           not null comment 'ID организации',
    num               varchar(100)  not null comment 'Номер договора',
    sign_date         date          not null comment 'Дата подписания договора',
    accordance        varchar(4000) not null comment 'Основание действия (Родительный падеж)',
    representor       varchar(4000) not null comment 'Представитель (Именительный падеж)',
    representor_gen   varchar(4000) not null comment 'Представитель (Родительный падеж)',
    is_current        int           not null comment 'Является действующим' default 1,
    foreign key (organisation_id) references organisation(id)
) comment 'Договор с организацией';

insert into agreement (organisation_id, num, sign_date, accordance, representor, representor_gen) values
(1, '12/88', STR_TO_DATE('12/31/2020', '%m/%d/%Y'), 'Устава №2 от 01.01.2021', 'Иванов Иван Иванович', 'Иванова Ивана Ивановича');

commit;