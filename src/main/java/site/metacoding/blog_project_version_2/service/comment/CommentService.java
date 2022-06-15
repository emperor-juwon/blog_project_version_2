package site.metacoding.blog_project_version_2.service.comment;

import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import site.metacoding.blog_project_version_2.domain.comment.Comment;
import site.metacoding.blog_project_version_2.domain.comment.CommentRepository;
import site.metacoding.blog_project_version_2.domain.post.Post;
import site.metacoding.blog_project_version_2.domain.user.User;

@RequiredArgsConstructor
@Service
public class CommentService {

    private final CommentRepository commentRepository;

    @Transactional
    public void 댓글쓰기(Comment comment, Integer postId) {
        Post post = new Post();
        post.setId(postId);
        comment.setPost(post);
        commentRepository.save(comment);
    }

    @Transactional
    public void 댓글삭제(Integer id, User principal) {
        Optional<Comment> commentOp = commentRepository.findById(id);

        if (commentOp.isPresent()) {
            Comment commentEntity = commentOp.get();

            if (principal.getId() != commentEntity.getUser().getId()) {
                throw new RuntimeException("권한이 없습니다");
            }
        } else {
            throw new RuntimeException("해당 댓글이 없습니다");
        }

        commentRepository.deleteById(id);
    }
}
