package br.com.brunolutterbach.attornatus.model.pessoa;

import br.com.brunolutterbach.attornatus.model.endereco.Endereco;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Table(name = "pessoas")
@Entity(name = "Pessoa")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private LocalDate dataNascimento;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "pessoa_id")
    private List<Endereco> enderecos;

    public Pessoa(DadosCadastroPessoa dados) {
        this.nome = dados.nome();
        this.dataNascimento = dados.dataNascimento();
        if (dados.enderecos() != null) {
            this.enderecos = new ArrayList<>();
            dados.enderecos().forEach(endereco -> this.enderecos.add(new Endereco(endereco)));
            this.enderecos.get(0).setPrincipal(true);  // Primeiro endereço no JSON é setado como principal
        } else {
            this.enderecos = new ArrayList<>();
        }
    }

    public void atualizarInformacoes(DadosAtualizacaoPessoa dados) {
        if (dados.nome() != null) {
            this.nome = dados.nome();
        }
        if (dados.dataNascimento() != null) {
            this.dataNascimento = dados.dataNascimento();
        }
    }
}
