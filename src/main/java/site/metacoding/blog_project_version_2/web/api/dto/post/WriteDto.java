package site.metacoding.blog_project_version_2.web.api.dto.post;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import site.metacoding.blog_project_version_2.domain.post.Post;
import site.metacoding.blog_project_version_2.domain.user.User;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class WriteDto {

    private String title;
    private String content;

    public Post toEntity(User principal) {
        Post post = new Post();
        post.setTitle(title);
        post.setContent(content);
        post.setUser(principal);
        post.setPageCount(0);
        return post;
    }
}
