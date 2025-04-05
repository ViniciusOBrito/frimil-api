package com.frimil.frimilapi.comum.excecoes.handle;

import com.frimil.frimilapi.comum.excecoes.FrimilException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(FrimilException.class)
    public ProblemDetail handleGestaoLucroException(FrimilException e) {
        return e.toProblemDetail();
    }


    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ProblemDetail handleMethodArgumentNotValidException(MethodArgumentNotValidException e){
        var fieldErros = e.getFieldErrors()
                .stream()
                .map(f -> new InvalidParams(f.getField(), f.getDefaultMessage()));

        var pb = ProblemDetail.forStatus(HttpStatus.BAD_REQUEST);

        pb.setTitle("Os parâmetros da requisição estão incorretos\n");
        pb.setProperty("campos inválidos", fieldErros);

        return pb;
    }
    private record InvalidParams(String name, String reason){}
}
