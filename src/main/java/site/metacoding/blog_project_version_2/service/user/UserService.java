package site.metacoding.blog_project_version_2.service.user;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import site.metacoding.blog_project_version_2.domain.user.UserRepository;
import site.metacoding.blog_project_version_2.web.api.dto.user.JoinDto;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public void 회원가입(JoinDto joinDto) {
        userRepository.save(joinDto.toEntity());
    }
}
