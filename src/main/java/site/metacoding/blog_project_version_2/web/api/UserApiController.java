package site.metacoding.blog_project_version_2.web.api;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import site.metacoding.blog_project_version_2.service.user.UserService;
import site.metacoding.blog_project_version_2.web.api.dto.ResponseDto;
import site.metacoding.blog_project_version_2.web.api.dto.user.JoinDto;

@RequiredArgsConstructor
@RestController
public class UserApiController {

    private final UserService userService;

    @PostMapping("/api/join")
    public ResponseDto<?> join(@RequestBody JoinDto joinDto) {
        userService.회원가입(joinDto);

        return new ResponseDto<>(1, "회원가입성공", null);
    }
}
