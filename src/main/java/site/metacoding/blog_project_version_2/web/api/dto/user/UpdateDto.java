package site.metacoding.blog_project_version_2.web.api.dto.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UpdateDto {

    private String password;
    private String email;
    private String addr;
}
