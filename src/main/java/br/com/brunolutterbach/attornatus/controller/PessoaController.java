package br.com.brunolutterbach.attornatus.controller;

import br.com.brunolutterbach.attornatus.model.pessoa.Pessoa;
import br.com.brunolutterbach.attornatus.model.pessoa.DadosAtualizacaoPessoa;
import br.com.brunolutterbach.attornatus.model.pessoa.DadosCadastroPessoa;
import br.com.brunolutterbach.attornatus.model.pessoa.DadosDetalhamentoPessoa;
import br.com.brunolutterbach.attornatus.model.pessoa.DadosDetalhamentoPessoaEndereco;
import br.com.brunolutterbach.attornatus.repository.PessoaRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/pessoas")
@AllArgsConstructor
public class PessoaController {

    final PessoaRepository pessoaRepository;

    @PostMapping()
    @Transactional
    public ResponseEntity<DadosDetalhamentoPessoaEndereco> cadastrarPessoa(@RequestBody @Valid DadosCadastroPessoa dados, UriComponentsBuilder uriBuilder) {
        var pessoa = new Pessoa(dados);
        pessoaRepository.save(pessoa);

        var uri = uriBuilder.path("/pessoas/{id}").buildAndExpand(pessoa.getId()).toUri();

        return ResponseEntity.created(uri).body(new DadosDetalhamentoPessoaEndereco(pessoa));
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<?> atualizarPessoa(@PathVariable Long id, @RequestBody DadosAtualizacaoPessoa dados) {
        var pessoa = pessoaRepository.getReferenceById(id);
        pessoa.atualizarInformacoes(dados);
        return ResponseEntity.ok(new DadosDetalhamentoPessoa(pessoa));
    }

    @GetMapping()
    public ResponseEntity<Page<DadosDetalhamentoPessoa>> listarPessoas(@PageableDefault(size = 5, sort = "id") Pageable pageable) {
        var pessoa = pessoaRepository.findAllWithPagination(pageable).map(DadosDetalhamentoPessoa::new);
        return ResponseEntity.ok(pessoa);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DadosDetalhamentoPessoa> consultarPessoa(@PathVariable Long id) {
        if (pessoaRepository.existsById(id)) {
            var pessoa = pessoaRepository.findById(id);
            return ResponseEntity.ok().body(new DadosDetalhamentoPessoa(pessoa));
        }
        throw new IllegalArgumentException("Pessoa de ID: " + id + " não encontrada");
    }

    @GetMapping("/enderecos")
    public ResponseEntity<Page<DadosDetalhamentoPessoaEndereco>> listarPessoasComEndereco(@PageableDefault(size = 5, sort = "id") Pageable pageable) {
        var pessoa = pessoaRepository.findAllWithPagination(pageable).map(DadosDetalhamentoPessoaEndereco::new);
        return ResponseEntity.ok(pessoa);
    }

    @GetMapping("/{id}/enderecos")
    public ResponseEntity<DadosDetalhamentoPessoaEndereco> consultarPessoaComEnderecos(@PathVariable Long id) {
        if (pessoaRepository.existsById(id)) {
            var pessoa = pessoaRepository.findById(id);
            return ResponseEntity.ok().body(new DadosDetalhamentoPessoaEndereco(pessoa));
        }
        throw new IllegalArgumentException("Pessoa de ID: " + id + " não encontrada");
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> deletarPessoa(@PathVariable Long id) {
        if (pessoaRepository.existsById(id)) {
            pessoaRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        throw new IllegalArgumentException("Pessoa de ID: " + id + " não encontrada");
    }

}


