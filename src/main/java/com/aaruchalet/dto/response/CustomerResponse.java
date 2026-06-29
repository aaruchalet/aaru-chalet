package com.aaruchalet.dto.response;

public record CustomerResponse(
        Long id,
        String name,
        String email,
        String phone,
        String address,
        Boolean member
) {
}