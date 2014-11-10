select c.name, count(co.customer_id) as all_checkouts
from customer c left outer join 
checkout co
on c.id = co.customer_id
group by co.customer_id;

select j.name, count(j.customer_id) as active_checkouts
from 
(select c.name, co.customer_id, co.current
from customer c left outer join 
(select customer_id, current from checkout where current = true) co
on c.id = co.customer_id) j
group by j.customer_id;




