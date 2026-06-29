CREATE TABLE customer
(
    id      BIGINT       NOT NULL AUTO_INCREMENT,
    name    VARCHAR(255) NOT NULL,
    email   VARCHAR(255) NOT NULL,
    phone   VARCHAR(50)  NOT NULL,
    address VARCHAR(500),
    member  BOOLEAN      NOT NULL DEFAULT FALSE,

    PRIMARY KEY (id),
    CONSTRAINT uk_customer_email UNIQUE (email),
    CONSTRAINT uk_customer_phone UNIQUE (phone)
);