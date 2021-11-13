create or replace view v_volunteer_organisation as
select distinct
       v.id as volunteer_id,
       v.city_id,
       o.id,
       o.name as organisation_name
from volunteer v
  join schedule s
    on s.volunteer_id = v.id
  join organisation o
    on o.id = s.organisation_id;