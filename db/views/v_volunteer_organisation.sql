create or replace view v_volunteer_organization as
select distinct
       v.id as volunteer_id,
       v.city_id,
       o.id,
       o.name as organization_name
from volunteer v
  join schedule s
    on s.volunteer_id = v.id
  join organization o
    on o.id = s.organization_id;