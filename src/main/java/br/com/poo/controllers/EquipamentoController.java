package br.com.poo.controllers;

import br.com.poo.models.Equipamento;
import br.com.poo.repositories.EquipamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("equipamento")
public class EquipamentoController {

    private final EquipamentoRepository equipamentoRepository;

    @Autowired
    public EquipamentoController(EquipamentoRepository equipamentoRepository) {
        this.equipamentoRepository = equipamentoRepository;
    }

    @PostMapping
    public ResponseEntity<?> add(@RequestBody Equipamento equipamento) {
        return new ResponseEntity<>(equipamentoRepository.save(equipamento), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> getAll() {
        return new ResponseEntity<>(equipamentoRepository.findAll(), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        if (!equipamentoRepository.existsById(id)) {
            equipamentoRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
