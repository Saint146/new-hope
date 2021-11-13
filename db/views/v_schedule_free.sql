create or replace view v_schedule_free as
select s.id,
       s.schedule_date,
       s.schedule_time,
       s.organisation_id,
       o.name as organisation_name,
       o.city_id,
       v.id as volunteer_id
  from schedule s
    join organisation o
      on o.id = s.organisation_id
    cross join volunteer v
  where s.volunteer_id is null
union all
select s.id,
       s.schedule_date,
       s.schedule_time,
       s.organisation_id,
       o.name as organisation_name,
       o.city_id,
       s.volunteer_id
  from schedule s
    join organisation o
      on o.id = s.organisation_id
    join volunteer v
      on v.id = s.volunteer_id;