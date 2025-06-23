package com.blog.Api_Blog.controller;


import com.blog.Api_Blog.DTO.request.CommentRequestDTO;
import com.blog.Api_Blog.DTO.response.CommentResponseDTO;
import com.blog.Api_Blog.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/articles/{articleId}/comments")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @PostMapping
    public CommentResponseDTO addComment(@PathVariable Long articleId, @RequestBody CommentRequestDTO commentRequestDTO){
        return commentService.addComment(articleId, commentRequestDTO);
    }
}
