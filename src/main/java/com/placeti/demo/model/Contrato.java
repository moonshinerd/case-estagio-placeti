package com.placeti.demo.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name= "Contrato")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Contrato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome_devedor;

    private LocalDate data_nascimento_devedor;

    private String num_reg_eletronico;

    @OneToMany(mappedBy = "contrato", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Veiculo> veiculos;

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome_devedor() {
        return nome_devedor;
    }

    public void setNome_devedor(String nome_devedor) {
        this.nome_devedor = nome_devedor;
    }

    public LocalDate getData_nascimento_devedor() {
        return data_nascimento_devedor;
    }

    public void setData_nascimento_devedor(LocalDate data_nascimento_devedor) {
        this.data_nascimento_devedor = data_nascimento_devedor;
    }

    public String getNum_reg_eletronico() {
        return num_reg_eletronico;
    }

    public void setNum_reg_eletronico(String num_reg_eletronico) {
        this.num_reg_eletronico = num_reg_eletronico;
    }

    public List<Veiculo> getVeiculos() {
        return veiculos;
    }

    public void setVeiculos(List<Veiculo> veiculos) {
        this.veiculos = veiculos;
    }
}
