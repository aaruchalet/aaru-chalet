CREATE TABLE room_type
(
    id              BIGINT AUTO_INCREMENT PRIMARY KEY,
    type_name       VARCHAR(50)    NOT NULL UNIQUE,
    price_per_night DECIMAL(10, 2) NOT NULL
);

INSERT INTO room_type (type_name, price_per_night)
VALUES ('ECONOMY', 2000.00),
       ('STANDARD', 2500.00),
       ('SUPERIOR', 3000.00);

CREATE TABLE room
(
    id           BIGINT AUTO_INCREMENT PRIMARY KEY,
    room_number  VARCHAR(20) NOT NULL UNIQUE,
    room_type_id BIGINT      NOT NULL,
    room_status  VARCHAR(30) NOT NULL,

    CONSTRAINT fk_room_room_type
        FOREIGN KEY (room_type_id)
            REFERENCES room_type (id),

    INDEX        idx_room_type (room_type_id),
    INDEX        idx_room_status (room_status),
    INDEX        idx_room_type_status (room_type_id, room_status)
);

INSERT INTO room (room_number, room_type_id, room_status)
VALUES ('101', 1, 'AVAILABLE'),
       ('102', 1, 'AVAILABLE'),
       ('103', 1, 'AVAILABLE'),

       ('201', 2, 'AVAILABLE'),
       ('202', 2, 'AVAILABLE'),
       ('203', 2, 'AVAILABLE'),

       ('301', 3, 'AVAILABLE'),
       ('302', 3, 'AVAILABLE'),
       ('303', 3, 'AVAILABLE');