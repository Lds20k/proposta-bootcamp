package br.com.zup.bootcamp.client.advice;

import feign.FeignException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class FeignHandlerAdvice {

    @ExceptionHandler(FeignException.class)
    public ResponseEntity<?> feignException(FeignException exception){
        Map<String, String> response = new HashMap<>();
        if (exception.status() >= 400 || exception.status() <= 500)
            response.put("message", "external server error");
        else
            response.put("message", "undefined external server error");

        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(response);
    }
}
