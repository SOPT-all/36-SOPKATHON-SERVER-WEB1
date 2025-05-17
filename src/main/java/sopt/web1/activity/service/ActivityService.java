package sopt.web1.activity.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sopt.web1.activity.controller.dto.BestDto;
import sopt.web1.activity.domain.ActivityEntity;
import sopt.web1.activity.repository.ActivityRepository;
import sopt.web1.code.ErrorCode;
import sopt.web1.exception.NotFoundCategoryException;
import sopt.web1.restaruant.repository.RestaurantRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ActivityService {

    private final ActivityRepository activityRepository;
    private final RestaurantRepository restaurantRepository;

    public BestDto getBest(
            final String category
    ) {
        List<BestDto.BestItems> bestItems;
        List<BestDto> bestList;
        switch (category) {
            case "food":
                bestItems = restaurantRepository.findTop3ByOrderByLikesDesc()
                        .stream()
                        .map(r -> new BestDto.BestItems(
                                r.getName(),
                                r.getImage_url(),
                                r.getIntroduction()
                        )).toList();
                break;
            case "activity":

                bestItems = activityRepository.findTop10ByOrderByLikesDesc()
                        .stream()
                        .map(a -> new BestDto.BestItems(
                                a.getName(),
                                a.getImageUrl(),
                                a.getIntroduction()
                        )).toList();
                break;
            default :
                throw new NotFoundCategoryException(ErrorCode.INVALID_INPUT_VALUE);
    }
        return BestDto.builder().bestList(bestItems).build();
    }
}
