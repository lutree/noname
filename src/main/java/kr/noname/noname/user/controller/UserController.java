package kr.noname.noname.user.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import kr.noname.noname.user.entity.UserInfo;
import kr.noname.noname.user.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@Tag(name = "예제 API", description = "Swagger 테스트용 API")
@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("test")
    public UserInfo findByLoginId() throws Exception {
        String loginId = "noname";
        return userService.findByLoginId(loginId);
    }
}
