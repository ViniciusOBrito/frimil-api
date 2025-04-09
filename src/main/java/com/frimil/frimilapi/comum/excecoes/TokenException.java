package com.frimil.frimilapi.comum.excecoes;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;

public class TokenException extends FrimilException {
    private final String detail;

    public TokenException(String detail){
        this.detail = detail;
    }

    @Override
    public ProblemDetail toProblemDetail() {
        var pb = ProblemDetail.forStatus(HttpStatus.INTERNAL_SERVER_ERROR);

        pb.setTitle("Error token");
        pb.setDetail(detail);

        return pb;
    }
}
