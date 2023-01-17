package br.com.brunolutterbach.attornatus.repository;

import br.com.brunolutterbach.attornatus.model.endereco.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
    boolean existsByIdAndPrincipal(Long id, boolean principal);
}

