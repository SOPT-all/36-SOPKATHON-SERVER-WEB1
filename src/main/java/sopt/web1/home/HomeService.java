package sopt.web1.home;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sopt.web1.activity.domain.ActivityEntity;
import sopt.web1.activity.repository.ActivityRepository;
import sopt.web1.restaruant.domain.RestaurantEntity;
import sopt.web1.restaruant.repository.RestaurantRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HomeService {

    private final RestaurantRepository restaurantrepository;
    private final ActivityRepository activityRepository;

    public PickResDto getBundle(
            final int bundleId
    ) {

        // 번들 id 에 해당하는 Entity 찾아오기
        List<RestaurantEntity> restaurantEntity = restaurantrepository.findByBundleId(bundleId);
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
        restaurantrepository.findByBundleId(bundleId);

        return PickResDto.builder()
                .restaurants(restaurantItems)
                .activities(activityItems)
                .build();
    }
}


