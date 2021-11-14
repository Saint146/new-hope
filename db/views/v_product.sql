create or replace view v_product as
select p.id,
       p.name,
       p.product_category_id,
       pc.name as product_category_name,
       p.measurement_id,
       m.name as measurement_name       
from product p
  join measurement m
    on m.id = p.measurement_id
  join product_category pc 
    on pc.id = p.product_category_id;