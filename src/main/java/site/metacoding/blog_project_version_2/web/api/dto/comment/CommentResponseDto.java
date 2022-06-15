package site.metacoding.blog_project_version_2.web.api.dto.comment;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import site.metacoding.blog_project_version_2.domain.comment.Comment;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CommentResponseDto {

    private Comment comment;
    private boolean auth;
}
