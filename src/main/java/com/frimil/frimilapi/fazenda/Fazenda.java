package com.frimil.frimilapi.fazenda;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.frimil.frimilapi.pecuarista.Pecuarista;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "TAB_FAZENDA")
public class Fazenda {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "FZD_ID")
    private Long id;

    @Column(name = "FZD_NOME")
    private String nome;

    @Column(name = "FZD_MUNICIPIO")
    private String municipio;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "PCT_ID")
    private Pecuarista pecuarista;


    public Fazenda() {}

    public Fazenda(Fazenda fazenda) {
        this.id = fazenda.id;
        this.nome = fazenda.getNome();
        this.municipio = fazenda.getMunicipio();
        this.pecuarista = fazenda.getPecuarista();
    }
}
