package com.frimil.frimilapi.transportador;

import com.frimil.frimilapi.veiculo.Veiculo;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "TAB_TRANSPORTADOR")
public class Transportador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TPD_ID", nullable = false)
    private Long id;

    @Column(name = "TPD_TIPO_DOCUMENTO", nullable = false)
    private Long tipoDocumento;

    @Column(name = "TPD_DOCUMENTO", nullable = false)
    private Long documento;

    @Column(name = "TPD_NOME", nullable = false)
    private String nome;

    @Column(name = "TPD_NOME_FANTASIA")
    private String nomeFantasia;

    @Column(name = "TPD_ENDERECO")
    private String endereco;

    @Column(name = "TPD_TELEFONE")
    private Long telefone;

    @OneToMany(mappedBy = "transportador", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Veiculo> veiculos;

}