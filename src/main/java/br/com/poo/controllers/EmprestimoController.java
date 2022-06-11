package br.com.poo.controllers;

import br.com.poo.models.Emprestimo;
import br.com.poo.models.Equipamento;
import br.com.poo.repositories.EmprestimoRepository;
import br.com.poo.repositories.EquipamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("emprestimo")
public class EmprestimoController {

    private final EmprestimoRepository emprestimoRepository;
    private final EquipamentoRepository equipamentoRepository;

    @Autowired
    public EmprestimoController(EmprestimoRepository emprestimoRepository, EquipamentoRepository equipamentoRepository) {
        this.emprestimoRepository = emprestimoRepository;
        this.equipamentoRepository = equipamentoRepository;
    }

    @PostMapping
    public ResponseEntity<?> add(@RequestBody Emprestimo emprestimo) {
        Equipamento equipamento = emprestimo.getEquipamento();
        if (!equipamento.estaEmprestado() && !emprestimo.verificaDevolucao()) {
            equipamento.setStatus("indisponivel");
            emprestimo.setEquipamento(equipamentoRepository.save(equipamento));
            return new ResponseEntity<>(emprestimoRepository.save(emprestimo), HttpStatus.OK);
        }
        else if (emprestimo.verificaDevolucao()) {
            equipamento.setStatus("disponivel");
            emprestimo.setEquipamento(equipamentoRepository.save(equipamento));
            return new ResponseEntity<>(emprestimoRepository.save(emprestimo), HttpStatus.OK);
        } else return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody Emprestimo emprestimo) {
        return new ResponseEntity<>(emprestimoRepository.save(emprestimo), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> getAll() {
        return new ResponseEntity<>(emprestimoRepository.findAll(), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        if (emprestimoRepository.existsById(id)) {
            emprestimoRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

}
