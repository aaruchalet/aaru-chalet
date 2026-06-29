package com.aaruchalet.dto.response;

import java.math.BigDecimal;

public record RoomTypeResponse(
        Long id,
        String typeName,
        BigDecimal pricePerNight
) {
}
