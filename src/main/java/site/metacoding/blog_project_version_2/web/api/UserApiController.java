package site.metacoding.blog_project_version_2.web.api;

import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import site.metacoding.blog_project_version_2.service.user.UserService;

@RequiredArgsConstructor
@RestController
public class UserApiController {

    private final UserService userService;
}
