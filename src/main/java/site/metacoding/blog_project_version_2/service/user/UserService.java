package site.metacoding.blog_project_version_2.service.user;

import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import site.metacoding.blog_project_version_2.domain.user.User;
import site.metacoding.blog_project_version_2.domain.user.UserRepository;
import site.metacoding.blog_project_version_2.web.api.dto.user.JoinDto;
import site.metacoding.blog_project_version_2.web.api.dto.user.LoginDto;
import site.metacoding.blog_project_version_2.web.api.dto.user.UpdateDto;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public void 회원가입(JoinDto joinDto) {
        userRepository.save(joinDto.toEntity());
    }

    public User 로그인(LoginDto loginDto) {
        User userEntity = userRepository.mLogin(loginDto.getUsername(), loginDto.getPassword());
        return userEntity;
    }

    public User 회원정보(Integer id) {
        Optional<User> userOp = userRepository.findById(id);
        if (userOp.isPresent()) {
            return userOp.get();
        } else {
            throw new RuntimeException("id를 찾을 수 없습니다");
        }
    }

    @Transactional
    public void 회원정보수정(Integer id, UpdateDto updateDto) {
        Optional<User> userOp = userRepository.findById(id);
        if (userOp.isPresent()) {
            User userEntity = userOp.get();
            userEntity.setPassword(updateDto.getPassword());
            userEntity.setEmail(updateDto.getEmail());
            userEntity.setAddr(updateDto.getAddr());
        } else {
            throw new RuntimeException("아이디를 찾을 수 없습니다");
        }
    }
}
