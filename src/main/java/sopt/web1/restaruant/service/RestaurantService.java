package sopt.web1.restaruant.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sopt.web1.code.ErrorCode;
import sopt.web1.exception.NotFoundException;
import sopt.web1.restaruant.domain.RestaurantEntity;
import sopt.web1.restaruant.dto.StoreResDto;
import sopt.web1.restaruant.repository.RestaurantRepository;

@Service
@RequiredArgsConstructor
public class RestaurantService {

    private final RestaurantRepository restaurantRepository;

    public StoreResDto getDetails(
            final long restaurantId
    ){
        RestaurantEntity r = restaurantRepository.findById(restaurantId)
                .orElseThrow(()->new NotFoundException(ErrorCode.NOT_FOUND_ENTITY));
        return StoreResDto.builder()
                .name(r.getName())
                .imageUrl(r.getImage_url())
                .address(r.getAddress())
                .phone(r.getPhone())
                .time(r.getTime())
                .category(r.getCategory())
                .introduction(r.getIntroduction())
                .build();
    }
}
