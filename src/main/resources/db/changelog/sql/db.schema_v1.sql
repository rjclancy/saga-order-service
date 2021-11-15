CREATE TABLE orders (
    id SERIAL PRIMARY KEY,
    customer_id VARCHAR(20) NOT NULL
);

CREATE SEQUENCE orders_seq increment BY 1 start 1 OWNED BY orders.id;