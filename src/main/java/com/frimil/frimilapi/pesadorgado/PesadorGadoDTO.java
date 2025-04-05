package com.frimil.frimilapi.pesadorgado;

public record PesadorGadoDTO(
        Long id,
        Long tipoDocumento,
        String documento,
        String nome,
        String nomeFantasia,
        String endereco,
        String telefone,
        String email
) {

    public PesadorGadoDTO(PesadorGado pesadorGado){
        this(
                pesadorGado.getId(),
                pesadorGado.getTipoDocumento(),
                pesadorGado.getDocumento(),
                pesadorGado.getNome(),
                pesadorGado.getNomeFantasia(),
                pesadorGado.getEndereco(),
                pesadorGado.getTelefone(),
                pesadorGado.getEmail()
        );
    }
}
