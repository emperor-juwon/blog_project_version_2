package site.metacoding.blog_project_version_2.web.api;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import site.metacoding.blog_project_version_2.domain.user.User;
import site.metacoding.blog_project_version_2.service.user.UserService;
import site.metacoding.blog_project_version_2.web.api.dto.ResponseDto;
import site.metacoding.blog_project_version_2.web.api.dto.user.JoinDto;
import site.metacoding.blog_project_version_2.web.api.dto.user.LoginDto;

@RequiredArgsConstructor
@RestController
public class UserApiController {

    private final UserService userService;
    private final HttpSession session;

    @PostMapping("/api/join")
    public ResponseDto<?> join(@RequestBody JoinDto joinDto) {
        userService.회원가입(joinDto);

        return new ResponseDto<>(1, "회원가입성공", null);
    }

    @PostMapping("/api/login")
    public ResponseDto<?> login(@RequestBody LoginDto loginDto) {
        User userEntity = userService.로그인(loginDto);

        if (userEntity != null) {
            return new ResponseDto<>(1, "로그인 성공", null);
        }
        session.setAttribute("principal", userEntity);

        return new ResponseDto<>(-1, "로그인성공", null);

    }
}
