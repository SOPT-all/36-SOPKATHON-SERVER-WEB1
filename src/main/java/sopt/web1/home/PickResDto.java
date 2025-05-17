package sopt.web1.home;

import lombok.Builder;
import java.util.List;

@Builder
public record PickResDto(
        List<RestaurantDto> restaurants,
        List<ActivityDto> activities
) {
    @Builder
    public record RestaurantDto(
            String restName,
            String restImageUrl,
            String restIntroduction
    ){ }

    @Builder
    public record ActivityDto(
            String actName,
            String actImageUrl,
            String actIntroduction
    ){ }
}