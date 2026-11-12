use hanip_delivery11;

select
    *
from
    customers;

select
    *
from
    restaurants;


desc customers;


desc coupons;

select
    count(*)
from
    coupons
where
    max_discount is null;


select
    *
from
    coupons;

