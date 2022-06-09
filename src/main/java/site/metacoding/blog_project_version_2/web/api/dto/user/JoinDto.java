package site.metacoding.blog_project_version_2.web.api.dto.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import site.metacoding.blog_project_version_2.domain.user.User;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JoinDto {

    private String username;
    private String password;
    private String email;
    private String addr;

    public User toEntity() {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);
        user.setAddr(addr);
        return user;
    }
}
