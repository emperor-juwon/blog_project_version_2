package site.metacoding.blog_project_version_2.web;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import lombok.RequiredArgsConstructor;
import site.metacoding.blog_project_version_2.domain.comment.Comment;
import site.metacoding.blog_project_version_2.domain.post.Post;
import site.metacoding.blog_project_version_2.domain.user.User;
import site.metacoding.blog_project_version_2.service.post.PostService;
import site.metacoding.blog_project_version_2.web.api.dto.comment.CommentResponseDto;

@RequiredArgsConstructor
@Controller
public class PostController {

    private final PostService postService;
    private final HttpSession session;

    @GetMapping({ "/", "/post" })
    public String main() {
        return "post/list";
    }

    @GetMapping("/s/post/writeForm")
    public String writeForm() {
        return "post/writeForm";
    }

    @GetMapping("/post/{id}")
    public String detail(@PathVariable Integer id, Model model) {
        Post postEntity = postService.글상세보기(id);
        User principal = (User) session.getAttribute("principal");

        if (principal != null) {
            // 권한 확인해서 view로 값을 넘김.
            if (principal.getId() == postEntity.getUser().getId()) { // 권한 있음
                model.addAttribute("pageOwner", true);
            } else {
                model.addAttribute("pageOwner", false);
            }
        }

        List<CommentResponseDto> comments = new ArrayList<>();

        for (Comment comment : postEntity.getComments()) {
            CommentResponseDto dto = new CommentResponseDto();
            dto.setComment(comment);

            if (principal != null) {
                if (principal.getId() == comment.getUser().getId()) {
                    dto.setAuth(true); // or false
                } else {
                    dto.setAuth(false); // or false
                }
            } else {
                dto.setAuth(false); // or false
            }

            comments.add(dto);
        }

        model.addAttribute("comments", comments);
        model.addAttribute("postId", id);
        return "post/detail";
    }

    @GetMapping("/s/post/{id}/updateForm")
    public String updateForm(@PathVariable Integer id, Model model) {
        Post postEntity = postService.글상세보기(id);

        model.addAttribute("post", postEntity);
        return "post/updateForm";
    }
}
