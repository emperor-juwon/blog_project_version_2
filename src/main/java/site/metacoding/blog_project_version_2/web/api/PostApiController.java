package site.metacoding.blog_project_version_2.web.api;

import javax.servlet.http.HttpSession;

import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import site.metacoding.blog_project_version_2.domain.post.Post;
import site.metacoding.blog_project_version_2.domain.user.User;
import site.metacoding.blog_project_version_2.service.post.PostService;
import site.metacoding.blog_project_version_2.web.api.dto.ResponseDto;
import site.metacoding.blog_project_version_2.web.api.dto.post.DetailResponseDto;
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
        System.out.println(writeDto);

        postService.글쓰기(post);

        return new ResponseDto<>(1, "성공", null);
    }

    @GetMapping("/api/post")
    public ResponseDto<?> list(Integer page) {
        Page<Post> posts = postService.글목록(page);
        return new ResponseDto<>(1, "성공", posts);
    }

    @GetMapping("/api/post/{id}")
    public ResponseDto<?> detail(@PathVariable Integer id) {
        Post postEntity = postService.글상세보기(id);
        User principal = (User) session.getAttribute("principal");
        boolean auth = false;

        if (principal != null) {

            if (principal.getId() == postEntity.getUser().getId()) {
                auth = true;
            }
        }
        DetailResponseDto detailResponseDto = new DetailResponseDto(postEntity, auth);
        return new ResponseDto<>(1, "성공", detailResponseDto);
    }

    @DeleteMapping("/s/api/post/{id}")
    public ResponseDto<?> deleteById(@PathVariable Integer id) {
        postService.글삭제하기(id);
        return new ResponseDto<>(1, "삭제 성공", null);
    }
}
