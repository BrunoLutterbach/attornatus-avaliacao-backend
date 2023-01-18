package br.com.brunolutterbach.attornatus.model.pessoa;

import br.com.brunolutterbach.attornatus.model.endereco.DadosEndereco;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.List;

public record DadosCadastroPessoa(
        @NotBlank
        String nome,
        @NotNull(message = "Data de nascimento não pode ser vazia")
        @JsonFormat(pattern = "dd/MM/yyyy")
        LocalDate dataNascimento,
        @Valid
        List<DadosEndereco> enderecos) {
}

