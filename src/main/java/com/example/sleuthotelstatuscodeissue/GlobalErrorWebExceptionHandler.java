package com.example.sleuthotelstatuscodeissue;

import java.nio.charset.StandardCharsets;

import reactor.core.publisher.Mono;

import org.springframework.core.annotation.Order;
import org.springframework.core.io.buffer.DataBufferFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebExceptionHandler;

@Component
@Order(-2)
public class GlobalErrorWebExceptionHandler implements
        WebExceptionHandler {


    @Override
    public Mono<Void> handle(ServerWebExchange serverWebExchange, Throwable throwable) {
        DataBufferFactory bufferFactory = serverWebExchange.getResponse().bufferFactory();
        if (throwable instanceof RuntimeException) {
            serverWebExchange.getResponse().setStatusCode(HttpStatus.I_AM_A_TEAPOT);
            return serverWebExchange.getResponse().writeWith(Mono.just(bufferFactory.wrap("I'm a teapot".getBytes(StandardCharsets.UTF_8))));
        }
        serverWebExchange.getResponse().setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR);
        return serverWebExchange.getResponse().writeWith(Mono.just(bufferFactory.wrap("Internal Server Error".getBytes(StandardCharsets.UTF_8))));
    }
}