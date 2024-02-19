package com.example.mortgage.config;

import com.example.mortgage.exceptions.NotFoundException;
import com.example.mortgage.view.responseDto.ErrorHandlingDto;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ExceptionHandler(IllegalArgumentException.class)
  ErrorHandlingDto handleIllegalArgumentException(
      IllegalArgumentException e, HttpServletRequest httpServletRequest) {
    return new ErrorHandlingDto(e.getMessage(), httpServletRequest.getRequestURI());
  }

  @ExceptionHandler(NotFoundException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  ErrorHandlingDto handleNotFoundException(
      NotFoundException e, HttpServletRequest httpServletRequest) {
    return new ErrorHandlingDto(e.getMessage(), httpServletRequest.getRequestURI());
  }
}
