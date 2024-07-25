package com.demo.api_comments.dtos.response;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResponseListCommentsDTO implements Serializable {

   private Integer idComment;
   private String comment;
   private String commentBy;
}
