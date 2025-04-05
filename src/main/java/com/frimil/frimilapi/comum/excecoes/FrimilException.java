package com.frimil.frimilapi.comum.excecoes;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;

public class FrimilException extends RuntimeException {

    public ProblemDetail toProblemDetail(){
        var pb = ProblemDetail.forStatus(HttpStatus.INTERNAL_SERVER_ERROR);
        pb.setTitle("Frimil-api internal server error");

        return pb;
    }
}
