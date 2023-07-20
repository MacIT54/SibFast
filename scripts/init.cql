CREATE KEYSPACE delivery_ks	
WITH replication = {'class':'SimpleStrategy', 'replication_factor' : 1};

USE delivery_ks;

CREATE TABLE products (
id UUID,
name text,	
shop_name text,		
address text,	
price float,
weight int,
description text,
PRIMARY KEY (id)
);				
	
CREATE INDEX IF NOT EXISTS ON products (name);
CREATE INDEX IF NOT EXISTS ON products (shop_name);

Insert into delivery_ks.products(id, name, shop_name, address, price, weight, description) values (uuid(), 'Хлеб', 'Achan', 'ZHELEZNODOROZHNY', 100.00, 300, 'Самый вкусный хлеб');


CREATE TABLE purchases (
order_id uuid,
destination text,	
condition text,
weight int,	
shop_name text,
user_id text,		
product_id text,
product_name text,
address text,
quantity int,
price float,
description text,
PRIMARY KEY (order_id, product_id)
);

CREATE INDEX IF NOT EXISTS ON purchases (product_id);
CREATE INDEX IF NOT EXISTS ON purchases (destination);
CREATE INDEX IF NOT EXISTS ON purchases (condition);
CREATE INDEX IF NOT EXISTS ON purchases (weight);
CREATE INDEX IF NOT EXISTS ON purchases (address);
CREATE INDEX IF NOT EXISTS ON purchases (user_id);	

CREATE TABLE users (
username text,
password text,
full_name text,
phone_number text,
personal_score float,
promo_codes list<text>,
roles set<text>,
PRIMARY KEY (username)
);


CREATE TABLE couriers (
login text,
password text,
full_name text,
phone_number text,
district text,
PRIMARY KEY (login)
);				

CREATE INDEX IF NOT EXISTS ON couriers (district);



CREATE TABLE drivers (
login text,
password text,
full_name text,
phone_number text,
district text,		
is_available boolean,
PRIMARY KEY (login)
);

CREATE INDEX IF NOT EXISTS ON couriers (district);
CREATE INDEX IF NOT EXISTS ON couriers (is_available);
