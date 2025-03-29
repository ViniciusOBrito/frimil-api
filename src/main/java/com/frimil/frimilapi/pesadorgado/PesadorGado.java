package com.frimil.frimilapi.pesadorgado;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "TAB_PESADOR_GADO")
public class PesadorGado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PDG_ID", nullable = false)
    private Long id;

    @Column(name = "PDG_TIPO_DOCUMENTO", nullable = false)
    private Long tipoDocumento;

    @Column(name = "PDG_DOCUMENTO", nullable = false)
    private String documento;

    @Column(name = "PDG_NOME", nullable = false)
    private String nome;

    @Column(name = "PDG_NOME_FANTASIA")
    private String nomeFantasia;

    @Column(name = "PDG_ENDERECO")
    private String endereco;

    @Column(name = "PDG_TELEFONE")
    private String telefone;

    @Column(name = "PDG_EMAIL")
    private String email;
}