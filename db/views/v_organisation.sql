create or replace view v_organisation as
select o.id,
       o.name,
       o.phone,
       o.city_id,
       c.name as city_name,
       o.address,
       o.date_register,
       a.id as agreement_id,
       a.num as agreement_num,
       a.sign_date,
       a.accordance,
       a.representor,
       a.representor_gen,
       a.is_current
from organisation o
  join city c
    on c.id = o.city_id
  join agreement a
    on a.organisation_id = o.id
   and a.is_current = 1
