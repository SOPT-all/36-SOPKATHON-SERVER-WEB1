package sopt.web1.home.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sopt.web1.activity.controller.dto.BestResDto;
import sopt.web1.home.controller.dto.PickResDto;
import sopt.web1.home.servcie.HomeService;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class HomeController {

    private final HomeService homeService;

    @GetMapping("/pick/{bundleId}")
    public ResponseEntity<PickResDto> pick(
            @PathVariable final int bundleId
    ){
        return ResponseEntity.ok(homeService.getBundle(bundleId));
    }

    @GetMapping("/best")
    public ResponseEntity<BestResDto> best(
            @RequestParam final String category
    ){
        return ResponseEntity.ok(homeService.getBest(category));
    }
}