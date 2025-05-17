package sopt.web1.activity.controller.dto;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder
public record BestDto (
        List<BestItems> bestList
) {
    @Builder
    public record BestItems(
            String name,
            String imageUrl,
            String introduction
    ){}
}
