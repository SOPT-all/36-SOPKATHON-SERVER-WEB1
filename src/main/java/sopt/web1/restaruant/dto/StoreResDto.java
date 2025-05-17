package sopt.web1.restaruant.dto;

import lombok.Builder;

@Builder
public record StoreResDto(
        String name,
        String imageUrl,
        String address,
        String phone,
        String time,
        String category,
        String introduction
) {
}