package com.placeti.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.placeti.demo.model.Contrato;
import com.placeti.demo.service.ContratoService;

import java.util.List;

@RestController
@RequestMapping("/contrato")
public class ContratoController {

    @Autowired
    private ContratoService contratoService;

    @GetMapping
    public List<Contrato> listarTodos() {
        return contratoService.listarTodos();
    }

    @GetMapping("/{id}")
    public Contrato buscarPorId(@PathVariable Long id) {
        return contratoService.buscaPorId(id);
    }

    @PostMapping
    public Contrato salvarContrato(@RequestBody Contrato contrato) {
        return contratoService.salvarContrato(contrato);
    }

    @PutMapping("/{id}")
    public Contrato atualizarContrato(@PathVariable Long id, @RequestBody Contrato contrato) {
        return contratoService.atualizarContrato(id, contrato);
    }

    @PostMapping("/{id}/adicionar-veiculo/{veiculoId}")
    public Contrato adicionarVeiculo(@PathVariable Long id, @PathVariable Long veiculoId) {
        return contratoService.adicionarVeiculo(id, veiculoId);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteContrato(@PathVariable Long id) {
        contratoService.deleteContrato(id);
    }
}
