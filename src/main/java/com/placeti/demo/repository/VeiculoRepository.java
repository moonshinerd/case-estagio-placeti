package com.placeti.demo.repository;

import com.placeti.demo.model.Veiculo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VeiculoRepository extends CrudRepository<Veiculo, Long> {

}
