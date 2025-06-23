package com.blog.Api_Blog.DTO.response;


import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CommentResponseDTO {

    private Long id;
    private String content;
    private LocalDateTime createdAt;
}
