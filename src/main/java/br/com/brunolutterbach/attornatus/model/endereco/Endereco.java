package br.com.brunolutterbach.attornatus.model.endereco;

import br.com.brunolutterbach.attornatus.model.pessoa.Pessoa;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "enderecos")
@Entity(name = "Endereco")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String logradouro;
    private String cep;
    private String numero;
    private String cidade;
    private Boolean principal = false;
    @ManyToOne
    @JoinColumn(name = "pessoa_id")
    private Pessoa pessoa;


    public Endereco(DadosEndereco endereco) {
        this.logradouro = endereco.logradouro();
        this.cep = endereco.cep();
        this.numero = endereco.numero();
        this.cidade = endereco.cidade();
    }

    public Endereco(DadosCadastroEndereco dados) {
        this.logradouro = dados.logradouro();
        this.cep = dados.cep();
        this.numero = dados.numero();
        this.cidade = dados.cidade();
    }

    public Endereco(DadosCadastroEndereco dados, Pessoa pessoa) {
        this.logradouro = dados.logradouro();
        this.cep = dados.cep();
        this.numero = dados.numero();
        this.cidade = dados.cidade();
        this.pessoa = pessoa;
    }

    public void atualizarInformacoes(DadosCadastroEndereco dados) {
        if (dados.logradouro() != null) {
            this.logradouro = dados.logradouro();
        } else if (dados.cep() != null) {
            this.cep = dados.cep();
        } else if (dados.numero() != null) {
            this.numero = dados.numero();
        } else if (dados.cidade() != null) {
            this.cidade = dados.cidade();
        }
    }

    public void tornarEnderecoPrincipal() {
        this.principal = true;
    }
}
