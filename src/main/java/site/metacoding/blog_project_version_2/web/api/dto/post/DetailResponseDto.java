package site.metacoding.blog_project_version_2.web.api.dto.post;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import site.metacoding.blog_project_version_2.domain.post.Post;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DetailResponseDto {

    private Post post;
    private boolean auth;
}
