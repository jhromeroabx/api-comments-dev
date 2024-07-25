package com.demo.api_comments.service;

import com.demo.api_comments.dtos.response.ResponseCommentDTO;
import com.demo.api_comments.exception.IdNotFoundException;
import com.demo.api_comments.mapper.CommentMapper;
import com.demo.api_comments.model.CommentModel;
import com.demo.api_comments.repository.CommentRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommentService {

   private final CommentRepository commentRepository;
   private final CommentMapper commentMapper;

   public ResponseCommentDTO getCommentById(Integer idProduct) {

      if (Boolean.FALSE.equals(commentRepository.existsByIdProduct(idProduct))) {
         throw new IdNotFoundException("The comment with the ID: " + idProduct + " does not exist.");
      }
      List <CommentModel> comments = commentRepository.findAllByIdProduct(idProduct);
      return ResponseCommentDTO.builder()
                               .comments(comments.stream().map(commentMapper::toResponseCommentDTO).toList())
                               .build();
   }
}
