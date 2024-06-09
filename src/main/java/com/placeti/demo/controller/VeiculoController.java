package com.placeti.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.placeti.demo.model.Veiculo;
import com.placeti.demo.service.VeiculoService;

import java.util.List;

@RestController
@RequestMapping("/veiculo")
public class VeiculoController {

    @Autowired
    private VeiculoService veiculoService;

    @GetMapping
    public List<Veiculo> listarTodos() {
        return veiculoService.listarTodos();
    }

    @GetMapping("/{id}")
    public Veiculo buscarPorId(@PathVariable Long id) {
        return veiculoService.buscaPorId(id);
    }

    @PostMapping
    public Veiculo salvarVeiculo(@RequestBody Veiculo veiculo) {
        return veiculoService.salvarVeiculo(veiculo);
    }

    @PutMapping("/{id}")
    public Veiculo atualizarVeiculo(@PathVariable Long id, @RequestBody Veiculo veiculo) {
        return veiculoService.atualizarVeiculo(id, veiculo);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteVeiculo(@PathVariable Long id) {
        veiculoService.deleteVeiculo(id);
    }
}
