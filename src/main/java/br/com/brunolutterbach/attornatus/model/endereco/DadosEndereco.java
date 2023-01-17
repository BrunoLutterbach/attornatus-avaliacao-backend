package br.com.brunolutterbach.attornatus.model.endereco;

import jakarta.validation.constraints.NotBlank;

public record DadosEndereco(
        @NotBlank
        String logradouro,
        @NotBlank
        String cep,
        @NotBlank
        String numero,
        @NotBlank
        String cidade,
        Boolean principal
) {

    public DadosEndereco(Endereco endereco) {
        this(endereco.getLogradouro(), endereco.getCep(), endereco.getNumero(), endereco.getCidade(), endereco.getPrincipal());
    }
}

