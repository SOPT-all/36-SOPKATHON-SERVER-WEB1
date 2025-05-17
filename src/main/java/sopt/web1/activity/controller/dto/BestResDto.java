package sopt.web1.activity.controller.dto;

import lombok.Builder;

import java.util.List;

@Builder
public record BestResDto(
        List<BestItems> bestList
) {
    @Builder
    public record BestItems(
            String name,
            String imageUrl,
            String introduction
    ){}
}
