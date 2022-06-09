package site.metacoding.blog_project_version_2.web;

import org.springframework.stereotype.Controller;

import lombok.RequiredArgsConstructor;
import site.metacoding.blog_project_version_2.service.user.UserService;

@RequiredArgsConstructor
@Controller
public class UserController {

    private UserService userService;
}
