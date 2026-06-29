CREATE TABLE booking
(
    id             BIGINT      NOT NULL AUTO_INCREMENT,
    customer_id    BIGINT      NOT NULL,
    room_id        BIGINT      NOT NULL,
    check_in_date  DATE        NOT NULL,
    check_out_date DATE        NOT NULL,
    booking_status VARCHAR(50) NOT NULL,
    hold_expiry    DATETIME(6),

    PRIMARY KEY (id),

    CONSTRAINT fk_booking_customer
        FOREIGN KEY (customer_id)
            REFERENCES customer (id),

    CONSTRAINT fk_booking_room
        FOREIGN KEY (room_id)
            REFERENCES room (id),

    INDEX          idx_booking_customer (customer_id),
    INDEX          idx_booking_room (room_id),
    INDEX          idx_booking_customer_checkin(customer_id, check_in_date),
    INDEX          idx_booking_room_dates(room_id, check_in_date, check_out_date),
    INDEX          idx_booking_hold(booking_status, hold_expiry)
);