package site.metacoding.blog_project_version_2.service.post;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import site.metacoding.blog_project_version_2.domain.post.PostRepository;

@RequiredArgsConstructor
@Service
public class PostService {

    private PostRepository postRepository;
}
