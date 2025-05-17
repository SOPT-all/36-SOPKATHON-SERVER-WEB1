package sopt.web1.restaruant.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sopt.web1.restaruant.dto.StoreResDto;
import sopt.web1.restaruant.service.RestaurantService;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class RestaurantController {

    private final RestaurantService restaurantService;

    @GetMapping("/pick/restaurant/{restaurantId}")
    public ResponseEntity<StoreResDto> getDetails(
            @PathVariable final Long restaurantId
    ){
        return ResponseEntity.ok(restaurantService.getDetails(restaurantId));
    }
}
