package br.com.poo.repositories;

import br.com.poo.models.Equipamento;
import br.com.poo.models.Professor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EquipamentoRepository extends CrudRepository<Equipamento, Long> {
}
