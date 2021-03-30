package com.example.sleuthotelstatuscodeissue;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public final ResponseEntity<?> handleRuntimeException(Exception e, ServerHttpRequest request) {
        return ResponseEntity.status(HttpStatus.I_AM_A_TEAPOT).build();
    }


}
