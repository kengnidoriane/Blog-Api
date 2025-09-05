package com.blog.Api_Blog.services;


import com.blog.Api_Blog.DTO.request.ArticleRequestDTO;
import com.blog.Api_Blog.DTO.response.ArticleResponseDTO;
import com.blog.Api_Blog.DTO.response.CommentResponseDTO;
import com.blog.Api_Blog.exception.ResourceNotFoundException;
import com.blog.Api_Blog.model.Article;
import com.blog.Api_Blog.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ArticleService {

    @Autowired
    private ArticleRepository articleRepository;

    public ArticleResponseDTO createArticle(ArticleRequestDTO requestDTO) {
        Article article = new Article();
        article.setTitle(requestDTO.getTitle());
        article.setContent(requestDTO.getContent());
        article.setPublishedAt(LocalDateTime.now());

        Article saved = articleRepository.save(article);
        return mapToResponseDTO(saved);
    }

    public List<ArticleResponseDTO> getAllArticles() {
        return articleRepository.findAll().stream().map(this::mapToResponseDTO).collect(Collectors.toList());
    }

    public ArticleResponseDTO updateArticle(Long id,  ArticleRequestDTO requestDTO) {

        Article article = articleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Article not found with id: " + id));

        article.setTitle(requestDTO.getTitle());
        article.setContent(requestDTO.getContent());

        Article updated = articleRepository.save(article);
        return mapToResponseDTO(updated);
    }

    public ArticleResponseDTO getArticleById(Long id) {
        Article article = articleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Article not found with id: " + id));
        return mapToResponseDTO(article);
    }


    public void deleteArticle(Long id) {
        Article article = articleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Article not found with id" + id));
        articleRepository.delete(article);
    }


    private ArticleResponseDTO mapToResponseDTO(Article article) {
        ArticleResponseDTO dto = new ArticleResponseDTO();
        dto.setId(article.getId());
        dto.setTitle(article.getTitle());
        dto.setContent(article.getContent());
        dto.setPublishedAt(article.getPublishedAt());

        dto.setComments(
                article.getComments().stream().map(comment -> {
                    CommentResponseDTO commentDTO = new CommentResponseDTO();
                    commentDTO.setId(comment.getId());
                    commentDTO.setContent(comment.getContent());
                    commentDTO.setCreatedAt(comment.getCreatedAt());
                    return commentDTO;
                }).collect(Collectors.toList())
        );
        return dto;
    }
}
