CREATE TABLE loads (
    id SERIAL PRIMARY KEY,
    loading_point VARCHAR(255) NOT NULL,
    unloading_point VARCHAR(255) NOT NULL,
    product_type VARCHAR(100) NOT NULL,
    truck_type VARCHAR(100) NOT NULL,
    no_of_trucks INTEGER NOT NULL,
    weight INTEGER NOT NULL,
    comment TEXT,
    shipper_id VARCHAR(255) NOT NULL,
    date VARCHAR(20) NOT NULL
);
