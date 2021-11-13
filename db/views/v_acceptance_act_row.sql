create or replace view v_acceptance_act_row as
select aar.id,
       aar.acceptance_act_id,
       aar.product_id,
       p.name as product_name,
       m.name as measurement_name,
       aar.amount,
       aar.price,
       aar.expiration_date,
       aar.note
  from acceptance_act_row aar
     join product p
       on aar.product_id = p.id
     join measurement m
       on m.id = p.measurement_id
