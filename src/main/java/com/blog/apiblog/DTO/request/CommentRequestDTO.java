package com.blog.api_Blog.DTO.request;


import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CommentRequestDTO {

    @NotBlank(message = "Comment content is required")
    private String content;
}
