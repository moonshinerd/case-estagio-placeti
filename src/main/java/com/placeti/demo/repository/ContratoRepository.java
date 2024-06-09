package com.placeti.demo.repository;

import com.placeti.demo.model.Contrato;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContratoRepository extends CrudRepository<Contrato, Long> {
}
