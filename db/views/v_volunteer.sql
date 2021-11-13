create or replace view v_volunteer as
select v.id,
       v.name,
       v.phone,
       v.city_id,
       c.name as city_name,
       v.address,
       v.password_hash,
       v.session,
       v.date_register,
       v.is_curator,
       v.is_admin,
       v.is_locked
from volunteer v
  join city c
    on v.city_id = c.id