package com.blog.apiblog.controller;


import com.blog.Api_Blog.DTO.request.ArticleRequestDTO;
import com.blog.Api_Blog.DTO.response.ArticleResponseDTO;
import com.blog.Api_Blog.services.ArticleService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/articles")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @PostMapping
    public ArticleResponseDTO createArticle(@Valid @RequestBody ArticleRequestDTO requestDTO) {
        return articleService.createArticle(requestDTO);
    }

    @GetMapping
    public List<ArticleResponseDTO> getAllArticles() {
        return articleService.getAllArticles();
    }

    @GetMapping("/{id}")
    public ArticleResponseDTO getArticleById(@PathVariable Long id){
        return articleService.getArticleById(id);
    }

    @PutMapping("/{id}")
    public ArticleResponseDTO updateArticle(@PathVariable Long id, @Valid @RequestBody ArticleRequestDTO requestDTO) {
        return articleService.updateArticle(id, requestDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteArticleById(@PathVariable Long id){
        articleService.deleteArticle(id);
    }
}
