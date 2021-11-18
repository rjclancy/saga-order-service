CREATE DATABASE orderdb;
GRANT ALL PRIVILEGES ON DATABASE orderdb TO postgres;

CREATE TABLE orders (
    id SERIAL PRIMARY KEY,
    product_desc VARCHAR(2000) NOT NULL,
    quantity INT NOT NULL,
    total DOUBLE PRECISION NOT NULL,
    created TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

INSERT INTO orders(product_desc, quantity, total) values ('book A', 1, 12.50);
INSERT INTO orders(product_desc, quantity, total) values ('book B', 1, 13.60);
