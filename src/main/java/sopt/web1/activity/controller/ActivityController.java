package sopt.web1.activity.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import sopt.web1.activity.controller.dto.BestDto;
import sopt.web1.activity.service.ActivityService;

import java.util.List;
import org.springframework.web.bind.annotation.PathVariable;
import sopt.web1.activity.dto.ActResDto;


@RestController
@RequestMapping("/api")
@RequiredArgsConstructor

public class ActivityController {

    private final ActivityService activityService;

    @GetMapping("/best")
    public ResponseEntity<BestDto> best(
            @RequestParam final String category
    ){
        return ResponseEntity.ok(activityService.getBest(category));
    }

    @GetMapping("/pick/activity/{activityId}")
    public ResponseEntity<ActResDto> getDetails(
            @PathVariable final Long activityId
    ){
        return ResponseEntity.ok(activityService.getDetails(activityId));
    }
}
