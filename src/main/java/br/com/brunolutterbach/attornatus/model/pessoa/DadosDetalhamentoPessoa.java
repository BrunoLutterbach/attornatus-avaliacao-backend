package br.com.brunolutterbach.attornatus.model.pessoa;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;
import java.util.Optional;

public record DadosDetalhamentoPessoa(
        Long id,
        @JsonFormat(pattern = "dd/MM/yyyy")
        String nome,
        LocalDate dataNascimento) {
    public DadosDetalhamentoPessoa(Optional<Pessoa> pessoa) {
        this(pessoa.get().getId(), pessoa.get().getNome(), pessoa.get().getDataNascimento());
    }

    public DadosDetalhamentoPessoa(Pessoa pessoa) {
        this(pessoa.getId(), pessoa.getNome(), pessoa.getDataNascimento());
    }
}
