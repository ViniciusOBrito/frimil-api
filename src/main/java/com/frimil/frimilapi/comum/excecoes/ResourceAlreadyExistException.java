package com.frimil.frimilapi.comum.excecoes;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;

public class ResourceAlreadyExistException extends FrimilException {

    private final String detalhe;

    public ResourceAlreadyExistException(String detalhe){
        this.detalhe = detalhe;
    }

    @Override
    public ProblemDetail toProblemDetail(){
        var pb = ProblemDetail.forStatus(HttpStatus.CONFLICT);

        pb.setTitle("Recurso já existe!");
        pb.setDetail(detalhe);

        return pb;
    }

}
