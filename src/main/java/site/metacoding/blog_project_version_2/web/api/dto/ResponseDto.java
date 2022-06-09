package site.metacoding.blog_project_version_2.web.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseDto<T> {

    private Integer code;
    private String msg;
    private T data;
}
