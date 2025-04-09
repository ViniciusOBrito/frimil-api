package com.frimil.frimilapi.comum.excecoes;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;

public class InvalidCredentialException extends FrimilException {

    public InvalidCredentialException(){
    }

    @Override
    public ProblemDetail toProblemDetail() {
        var pb = ProblemDetail.forStatus(HttpStatus.UNAUTHORIZED);

        pb.setTitle("Invalid Credentials");
        pb.setDetail("Invalid credentials, check your password and try again.");

        return pb;
    }
}
