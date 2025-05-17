package sopt.web1.home.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import sopt.web1.activity.controller.dto.BestResDto;
import sopt.web1.home.controller.dto.PickResDto;
import sopt.web1.home.servcie.HomeService;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class HomeController {

    private final HomeService homeService;

    @GetMapping("/pick")
    public ResponseEntity<PickResDto> pick(
            @RequestParam final int bundleId
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