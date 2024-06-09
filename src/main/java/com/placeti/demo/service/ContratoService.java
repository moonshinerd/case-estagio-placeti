package com.placeti.demo.service;

import com.placeti.demo.model.Veiculo;
import com.placeti.demo.repository.ContratoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.placeti.demo.model.Contrato;

import java.util.List;

@Service
public class ContratoService {

    @Autowired
    private ContratoRepository contratoRepository;

    public List<Contrato> listarTodos() {
        return (List<Contrato>) contratoRepository.findAll();
    }

    public Contrato salvarContrato(Contrato contrato) {
        for (Veiculo veiculo : contrato.getVeiculos()) {
            veiculo.setContrato(contrato);
        }
        return contratoRepository.save(contrato);
    }

    public Contrato atualizarContrato(Long id, Contrato contrato) {
        Contrato contratoExistente = contratoRepository.findById(id).orElse(null);
        if (contratoExistente != null) {
            // Atualizar apenas os campos fornecidos na requisição
            if (contrato.getNome_devedor() != null) {
                contratoExistente.setNome_devedor(contrato.getNome_devedor());
            }
            if (contrato.getData_nascimento_devedor() != null) {
                contratoExistente.setData_nascimento_devedor(contrato.getData_nascimento_devedor());
            }
            if (contrato.getNum_reg_eletronico() != null) {
                contratoExistente.setNum_reg_eletronico(contrato.getNum_reg_eletronico());
            }
            if (contrato.getVeiculos() != null && !contrato.getVeiculos().isEmpty()) {
                // Remover os veículos existentes e adicionar os novos
                contratoExistente.getVeiculos().clear();
                for (Veiculo veiculo : contrato.getVeiculos()) {
                    veiculo.setContrato(contratoExistente);
                    contratoExistente.getVeiculos().add(veiculo);
                }
            }

            return contratoRepository.save(contratoExistente);
        } else {
            // Se não existir, cria um novo contrato
            for (Veiculo veiculo : contrato.getVeiculos()) {
                veiculo.setContrato(contrato);
            }
            return contratoRepository.save(contrato);
        }
    }

    public Contrato buscaPorId(Long id) {
        return contratoRepository.findById(id).orElse(null);
    }

    public void deleteContrato(Long id) {
        contratoRepository.deleteById(id);
    }
}
