package sopt.web1.home.servcie;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sopt.web1.activity.controller.dto.BestResDto;
import sopt.web1.activity.domain.ActivityEntity;
import sopt.web1.activity.repository.ActivityRepository;
import sopt.web1.common.code.ErrorCode;
import sopt.web1.exception.NotFoundCategoryException;
import sopt.web1.home.controller.dto.PickResDto;
import sopt.web1.restaruant.domain.RestaurantEntity;
import sopt.web1.restaruant.repository.RestaurantRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HomeService {

    private final RestaurantRepository restaurantRepository;
    private final ActivityRepository activityRepository;

    public PickResDto getBundle(
            final int bundleId
    ) {

        // 번들 id 에 해당하는 Entity 찾아오기
        List<RestaurantEntity> restaurantEntity = restaurantRepository.findByBundleId(bundleId);
        List<ActivityEntity> activityEntity = activityRepository.findByBundleId(bundleId);

        List<PickResDto.RestaurantDto> restaurantItems = restaurantEntity.stream()
                .map(r -> PickResDto.RestaurantDto.builder()
                        .restName(r.getName())
                        .restImageUrl(r.getImage_url())
                        .restIntroduction(r.getIntroduction())
                        .build())
                .toList();

        List<PickResDto.ActivityDto> activityItems = activityEntity.stream()
                .map(a -> PickResDto.ActivityDto.builder()
                        .actName(a.getName())
                        .actImageUrl(a.getImageUrl())
                        .actIntroduction(a.getIntroduction())
                        .build())
                .toList();

        activityRepository.findByBundleId(bundleId);
        restaurantRepository.findByBundleId(bundleId);

        return PickResDto.builder()
                .restaurants(restaurantItems)
                .activities(activityItems)
                .build();
    }

    public BestResDto getBest(
            final String category
    ) {
        List<BestResDto.BestItems> bestItems;
        List<BestResDto> bestList;
        switch (category) {
            case "food":
                bestItems = restaurantRepository.findTop3ByOrderByLikeCountDesc()
                        .stream()
                        .map(r -> new BestResDto.BestItems(
                                r.getName(),
                                r.getImage_url(),
                                r.getIntroduction()
                        )).toList();
                break;
            case "activity":

                bestItems = activityRepository.findTop10ByOrderByLikesDesc()
                        .stream()
                        .map(a -> new BestResDto.BestItems(
                                a.getName(),
                                a.getImageUrl(),
                                a.getIntroduction()
                        )).toList();
                break;
            default :
                throw new NotFoundCategoryException(ErrorCode.INVALID_INPUT_VALUE);
        }
        return BestResDto.builder().bestList(bestItems).build();
    }
}