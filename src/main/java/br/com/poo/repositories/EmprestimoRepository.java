package br.com.poo.repositories;

import br.com.poo.models.Emprestimo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmprestimoRepository extends CrudRepository<Emprestimo, Long> {
}
