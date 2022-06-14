package site.metacoding.blog_project_version_2.web.api;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import site.metacoding.blog_project_version_2.domain.post.Post;
import site.metacoding.blog_project_version_2.domain.user.User;
import site.metacoding.blog_project_version_2.service.post.PostService;
import site.metacoding.blog_project_version_2.web.api.dto.ResponseDto;
import site.metacoding.blog_project_version_2.web.api.dto.post.WriteDto;

@RequiredArgsConstructor
@RestController
public class PostApiController {

    private final PostService postService;
    private final HttpSession session;

    @PostMapping("/s/post")
    public ResponseDto<?> write(@RequestBody WriteDto writeDto) {

        User principal = (User) session.getAttribute("principal");
        Post post = writeDto.toEntity(principal);

        postService.글쓰기(post);
        return new ResponseDto<>(1, "성공", null);
    }
}
