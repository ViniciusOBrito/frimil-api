package com.frimil.frimilapi.cargo;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

import java.util.UUID;

@Data
@Entity
@Table(name = "TAB_CARGO")
public class Cargo implements GrantedAuthority {

    @Id
    @Column(name = "TCG_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column(name = "TCG_NOME")
    private String nome;

    public Cargo() {

    }

    @Override
    public String getAuthority() {
        return nome;
    }

    public Cargo(String nome){
        this.nome = nome;
    }
}
