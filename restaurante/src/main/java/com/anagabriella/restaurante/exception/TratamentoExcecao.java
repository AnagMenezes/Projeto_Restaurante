package com.anagabriella.restaurante.exception;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class TratamentoExcecao {

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Map<String, String>> tratarIllegalArgumentException(
            IllegalArgumentException e) {

        Map<String, String> resposta = new HashMap<>();

        resposta.put("erro", e.getMessage());

        return ResponseEntity.badRequest().body(resposta);
    }
}