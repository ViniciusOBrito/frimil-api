package com.frimil.frimilapi.comum.excecoes;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;

public class InvalidDataException extends FrimilException {

    private final String detalhe;

    public InvalidDataException(String detalhe){
        this.detalhe = detalhe;
    }

    @Override
    public ProblemDetail toProblemDetail() {
        var pb = ProblemDetail.forStatus(HttpStatus.BAD_REQUEST);

        pb.setTitle("Invalid data");
        pb.setDetail(detalhe);

        return pb;
    }
}
