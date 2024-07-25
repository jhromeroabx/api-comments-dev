package com.demo.api_comments.handler;

import com.demo.api_comments.dtos.response.ErrorDTO;
import com.demo.api_comments.exception.IdNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice
public class GlobalHandler {

   @ExceptionHandler(IdNotFoundException.class)
   public ResponseEntity <ErrorDTO> handleIdNotFoundException(IdNotFoundException ex) {
      log.error("Id Not Found", ex);
      ErrorDTO error = ErrorDTO
              .builder()
              .message("Id Not Found")
              .code("ID_NOT_FOUND")
              .status(HttpStatus.NOT_FOUND.value())
              .build();
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
   }

   @ExceptionHandler(MissingServletRequestParameterException.class)
   public ResponseEntity <ErrorDTO> handleMissingParameter(MissingServletRequestParameterException ex) {
      log.error("Missing parameter", ex);
      ErrorDTO error = ErrorDTO
              .builder()
              .message("Required request parameter 'idProduct' is missing")
              .code("MISSING_PARAMETER")
              .status(HttpStatus.BAD_REQUEST.value())
              .build();
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
   }
}
