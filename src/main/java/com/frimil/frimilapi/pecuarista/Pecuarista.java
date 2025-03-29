package com.frimil.frimilapi.pecuarista;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "TAB_PECUARISTA")
public class Pecuarista {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PCT_ID")
    private Long id;

    @Column(name = "PCT_SEQUENCIAL")
    private Long sequencial;

    @Column(name = "PCT_TIPO_DOCUMENTO")
    private Long tipoDocumento;

    @Column(name = "PCT_DOCUMENTO")
    private String documento;

    @Column(name = "PCT_NOME")
    private String nome;

    @Column(name = "PCT_NOME_FANTASIA")
    private String nomeFantasia;

    @Column(name = "PCT_INSCRICAO_ESTADUAL")
    private String inscricaoEstadual;

    @Column(name = "PCT_ENDERECO")
    private String endereco;

    @Column(name = "PCT_TELEFONE")
    private String telefone;

    @Column(name = "PCT_RG")
    private String rg;

}
