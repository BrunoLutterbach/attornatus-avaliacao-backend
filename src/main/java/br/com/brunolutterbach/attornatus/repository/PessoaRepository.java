package br.com.brunolutterbach.attornatus.repository;

import br.com.brunolutterbach.attornatus.model.pessoa.Pessoa;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

    @Query("SELECT p FROM Pessoa p")
    Page<Pessoa> findAllWithPagination(Pageable pageable);
}
