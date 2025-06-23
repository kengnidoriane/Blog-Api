package com.blog.Api_Blog.services;


import com.blog.Api_Blog.DTO.request.CommentRequestDTO;
import com.blog.Api_Blog.DTO.response.CommentResponseDTO;
import com.blog.Api_Blog.exception.ResourceNotFoundException;
import com.blog.Api_Blog.model.Article;
import com.blog.Api_Blog.model.Comment;
import com.blog.Api_Blog.repository.ArticleRepository;
import com.blog.Api_Blog.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private ArticleRepository articleRepository;

    public CommentResponseDTO addComment(Long articleId, CommentRequestDTO commentRequestDTO) {

        Article article = articleRepository.findById(articleId)
                .orElseThrow(() -> new ResourceNotFoundException("Article not found with id" + articleId));

        Comment comment = new Comment();

        comment.setContent(commentRequestDTO.getContent());
        comment.setCreatedAt(LocalDateTime.now());
        comment.setArticle(article);

        Comment savedComment = commentRepository.save(comment);
        return mapToResponseDTO(savedComment);
    }

    private CommentResponseDTO mapToResponseDTO(Comment comment) {
        CommentResponseDTO dto = new CommentResponseDTO();
        dto.setId(comment.getId());
        dto.setContent(comment.getContent());
        dto.setCreatedAt(comment.getCreatedAt());

        return dto;
    }
}
