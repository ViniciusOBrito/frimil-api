package com.frimil.frimilapi.pecuarista;

public record PecuaristaDTO(
        Long id,
        Long sequencial,
        Long tipoDocumento,
        String documento,
        String nome,
        String nomeFantasia,
        String inscricaoEstadual,
        String endereco,
        String telefone,
        String rg
) {

    public PecuaristaDTO(Pecuarista pecuarista) {
        this(
                pecuarista.getId(),
                pecuarista.getSequencial(),
                pecuarista.getTipoDocumento(),
                pecuarista.getDocumento(),
                pecuarista.getNome(),
                pecuarista.getNomeFantasia(),
                pecuarista.getInscricaoEstadual(),
                pecuarista.getEndereco(),
                pecuarista.getTelefone(),
                pecuarista.getRg()
        );
    }
}
