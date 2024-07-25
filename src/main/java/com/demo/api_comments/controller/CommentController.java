package com.demo.api_comments.controller;

import com.demo.api_comments.dtos.response.ResponseCommentDTO;
import com.demo.api_comments.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class CommentController {

   private final CommentService commentService;

   @GetMapping("/comments")
   public ResponseCommentDTO getCommentById(@RequestParam(value = "idProduct") Integer idProduct) {
      return commentService.getCommentById(idProduct);
   }
}
