package com.placeti.demo.service;

import com.placeti.demo.model.Contrato;
import com.placeti.demo.model.Veiculo;
import com.placeti.demo.repository.VeiculoRepository;
import com.placeti.demo.repository.ContratoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VeiculoService {

    @Autowired
    private VeiculoRepository veiculoRepository;

    @Autowired
    private ContratoRepository contratoRepository;

    public List<Veiculo> listarTodos() {
        return (List<Veiculo>) veiculoRepository.findAll();
    }

    public Veiculo salvarVeiculo(Veiculo veiculo) {
        if (veiculo.getContrato() != null && veiculo.getContrato().getId() != null) {
            Contrato contrato = contratoRepository.findById(veiculo.getContrato().getId()).orElse(null);
            veiculo.setContrato(contrato);
        }
        return veiculoRepository.save(veiculo);
    }

    public Veiculo atualizarVeiculo(Long id, Veiculo veiculo) {
        Veiculo veiculoExistente = veiculoRepository.findById(id).orElse(null);
        if (veiculoExistente != null) {
            // Atualizar apenas os campos fornecidos na requisição
            if (veiculo.getGravame() != null) {
                veiculoExistente.setGravame(veiculo.getGravame());
            }
            if (veiculo.getRenavam() != null) {
                veiculoExistente.setRenavam(veiculo.getRenavam());
            }
            if (veiculo.getPlaca() != null) {
                veiculoExistente.setPlaca(veiculo.getPlaca());
            }
            if (veiculo.getChassi() != null) {
                veiculoExistente.setChassi(veiculo.getChassi());
            }
            if (veiculo.getContrato() != null && veiculo.getContrato().getId() != null) {
                Contrato contrato = contratoRepository.findById(veiculo.getContrato().getId()).orElse(null);
                veiculoExistente.setContrato(contrato);
            }

            return veiculoRepository.save(veiculoExistente);
        } else {
            return veiculoRepository.save(veiculo);
        }
    }

    public Veiculo buscaPorId(Long id) {
        return veiculoRepository.findById(id).orElse(null);
    }

    public void deleteVeiculo(Long id) {
        veiculoRepository.deleteById(id);
    }
}
