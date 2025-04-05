package com.frimil.frimilapi.comum.excecoes;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;

public class ResourceNotFoundException extends FrimilException {

    private final String detalhe;

    public ResourceNotFoundException(String detail){
        this.detalhe = detail;
    }


    @Override
    public ProblemDetail toProblemDetail(){
        var pb = ProblemDetail.forStatus(HttpStatus.NOT_FOUND);

        pb.setTitle("Recurso não encontrado!");
        pb.setDetail(detalhe);

        return pb;
    }
}
