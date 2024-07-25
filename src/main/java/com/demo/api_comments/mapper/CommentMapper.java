package com.demo.api_comments.mapper;

import com.demo.api_comments.dtos.response.ResponseListCommentsDTO;
import com.demo.api_comments.model.CommentModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CommentMapper {

   @Mapping(source = "idComment", target = "idComment")
   @Mapping(source = "comment", target = "comment")
   @Mapping(source = "commentBy", target = "commentBy")
   ResponseListCommentsDTO toResponseCommentDTO(CommentModel commentModel);
}
