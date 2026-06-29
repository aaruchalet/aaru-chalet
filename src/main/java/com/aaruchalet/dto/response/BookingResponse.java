package com.aaruchalet.dto.response;

import com.aaruchalet.enums.BookingStatus;
import java.time.LocalDate;

public record BookingResponse(
        Long id,
        Long customerId,
        Long roomId,
        LocalDate checkInDate,
        LocalDate checkOutDate,
        BookingStatus bookingStatus
) {
}
