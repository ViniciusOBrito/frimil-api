package com.frimil.frimilapi.veiculo;

import com.frimil.frimilapi.transportador.Transportador;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "TAB_VEICULO")
public class Veiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "VCL_ID", nullable = false)
    private Long id;

    @Column(name = "VCL_VEICULO", nullable = false)
    private String veiculo;

    @Column(name = "VCL_PLACA", nullable = false, length = 20)
    private String placa;

    @Column(name = "VCL_CAPACIDADE", nullable = false)
    private Long capacidade;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "VCL_TRANSPORTADOR_ID")
    private Transportador transportador;

}