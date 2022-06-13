package site.metacoding.blog_project_version_2.web.api;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import site.metacoding.blog_project_version_2.domain.user.User;
import site.metacoding.blog_project_version_2.service.user.UserService;
import site.metacoding.blog_project_version_2.web.api.dto.ResponseDto;
import site.metacoding.blog_project_version_2.web.api.dto.user.JoinDto;
import site.metacoding.blog_project_version_2.web.api.dto.user.LoginDto;
import site.metacoding.blog_project_version_2.web.api.dto.user.UpdateDto;

@RequiredArgsConstructor
@RestController
public class UserApiController {

    private final UserService userService;
    private final HttpSession session;

    @PostMapping("/join")
    public ResponseDto<?> join(@RequestBody JoinDto joinDto) {
        userService.회원가입(joinDto);

        return new ResponseDto<>(1, "회원가입성공", null);
    }

    @PostMapping("/login")
    public ResponseDto<?> login(@RequestBody LoginDto loginDto, HttpServletResponse response) {
        User userEntity = userService.로그인(loginDto);

        if (userEntity == null) {
            return new ResponseDto<>(-1, "로그인 실패", null);
        }
        if (loginDto.getUsername().equals("on")) {
            response.addHeader("Set-Cookie", "remember=" + loginDto.getUsername() + ";path=/");
        }
        session.setAttribute("principal", userEntity);

        return new ResponseDto<>(1, "로그인성공", null);

    }

    @GetMapping("/logout")
    public ResponseDto<?> logout() {
        session.invalidate();
        return new ResponseDto<>(1, "로그아웃 성공", null);
    }

    @PutMapping("/s/api/user/{id}")
    public ResponseDto<?> update(@PathVariable Integer id, @RequestBody UpdateDto updateDto) {
        User userEntity = userService.회원정보수정(id, updateDto);
        session.setAttribute("principal", userEntity);
        return new ResponseDto<>(1, "수정 성공", null);
    }
}
