package com.blog.Api_Blog.DTO.response;


import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class ArticleResponseDTO {
    private Long id;
    private String title;
    private String content;
    private LocalDateTime publishedAt;
    private List<CommentResponseDTO> comments;
}
