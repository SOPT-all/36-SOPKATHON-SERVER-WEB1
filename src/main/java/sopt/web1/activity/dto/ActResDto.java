package sopt.web1.activity.dto;

import lombok.Builder;

@Builder
public record ActResDto (
    String name,
    String imageUrl,
    String address,
    String phone,
    String time,
    String description,
    String introduction
){
}