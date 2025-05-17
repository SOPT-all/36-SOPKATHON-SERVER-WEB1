package sopt.web1.home;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import sopt.web1.response.ResponseDto;

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
}