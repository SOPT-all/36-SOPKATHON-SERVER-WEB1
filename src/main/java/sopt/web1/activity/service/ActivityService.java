package sopt.web1.activity.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import sopt.web1.activity.domain.ActivityEntity;
import sopt.web1.activity.repository.ActivityRepository;
import sopt.web1.common.code.ErrorCode;


import sopt.web1.activity.controller.dto.ActResDto;
import sopt.web1.exception.NotFoundException;


@Service
@RequiredArgsConstructor
public class ActivityService {

    private final ActivityRepository activityRepository;
  
    public ActResDto getDetails(
            final long restaurantId
    ){
        ActivityEntity a = activityRepository.findById(restaurantId)
                .orElseThrow(()->new NotFoundException(ErrorCode.NOT_FOUND_ENTITY));
        return ActResDto.builder()
                .name(a.getName())
                .imageUrl(a.getImageUrl())
                .address(a.getAddress())
                .phone(a.getPhone())
                .time(a.getTime())
                .description(a.getDescription())
                .introduction(a.getIntroduction())
                .build();
    }
}
