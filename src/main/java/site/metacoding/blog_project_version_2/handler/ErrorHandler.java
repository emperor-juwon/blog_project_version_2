package site.metacoding.blog_project_version_2.handler;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import site.metacoding.blog_project_version_2.web.api.dto.ResponseDto;

@RestControllerAdvice
public class ErrorHandler {

    @ExceptionHandler(value = RuntimeException.class)
    public ResponseDto<?> error1(RuntimeException e) {
        return new ResponseDto<>(-1, "실패", e.getMessage());
    }
}
