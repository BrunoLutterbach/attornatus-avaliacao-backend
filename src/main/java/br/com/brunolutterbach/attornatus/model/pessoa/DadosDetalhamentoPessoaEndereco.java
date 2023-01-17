package br.com.brunolutterbach.attornatus.model.pessoa;

import br.com.brunolutterbach.attornatus.model.endereco.DadosDetalhamentoEndereco;
import br.com.brunolutterbach.attornatus.model.endereco.DadosEndereco;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public record DadosDetalhamentoPessoaEndereco(
        Long id,
        String nome,
        @JsonFormat(pattern = "dd/MM/yyyy")
        LocalDate dataNascimento,
        List<DadosDetalhamentoEndereco> enderecos) {
    public DadosDetalhamentoPessoaEndereco(Pessoa pessoa) {
        this(pessoa.getId(), pessoa.getNome(),pessoa.getDataNascimento(), pessoa.getEnderecos().stream()
                .map(DadosDetalhamentoEndereco::new).toList());
    }

    public DadosDetalhamentoPessoaEndereco(Optional<Pessoa> pessoa) {
        this(pessoa.get().getId(), pessoa.get().getNome(),pessoa.get().getDataNascimento(), pessoa.get().getEnderecos().stream()
                .map(DadosDetalhamentoEndereco::new).toList());
    }
}

