create or replace view v_acceptance_act as
select aa.id,
       aa.acceptance_date,
       aa.organisation_id,
       o.city_id,
       o.name as organisation_name,
       aa.volunteer_id,
       v.name as volunteer_name
from acceptance_act aa
  join organisation o
    on o.id = aa.organisation_id
  join volunteer v
    on v.id = aa.volunteer_id