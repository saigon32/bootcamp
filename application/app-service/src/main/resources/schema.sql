--mysql
CREATE TABLE IF NOT EXISTS bootcamp.bootcamp (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    description VARCHAR(90) NOT NULL,
    UNIQUE (name)
);
--postgres
CREATE TABLE IF NOT EXISTS bootcamp.bootcamp (
    id SERIAL PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    description VARCHAR(90) NOT NULL,
    UNIQUE (name)
);