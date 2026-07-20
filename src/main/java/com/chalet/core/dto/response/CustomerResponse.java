package com.chalet.core.dto.response;

public record CustomerResponse(
        Long id,
        String name,
        String email,
        String phone,
        String address,
        Boolean member
) {
}