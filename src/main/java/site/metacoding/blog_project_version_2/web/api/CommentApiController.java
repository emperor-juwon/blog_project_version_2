package site.metacoding.blog_project_version_2.web.api;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import site.metacoding.blog_project_version_2.domain.user.User;
import site.metacoding.blog_project_version_2.service.comment.CommentService;
import site.metacoding.blog_project_version_2.web.api.dto.ResponseDto;

@RequiredArgsConstructor
@RestController
public class CommentApiController {

    private final CommentService commentService;
    private final HttpSession session;

    @DeleteMapping("/s/api/comment/{id}")
    public ResponseDto<?> deleteById(@PathVariable Integer id) {

        // 세션의 id와 comment의 userId와 비교
        User principal = (User) session.getAttribute("principal");

        commentService.댓글삭제(id, principal);
        return new ResponseDto<>(1, "성공", null);
    }
}
