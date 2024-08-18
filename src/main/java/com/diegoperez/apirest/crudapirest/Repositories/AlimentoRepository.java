package com.diegoperez.apirest.crudapirest.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.diegoperez.apirest.crudapirest.Entities.Alimento;

public interface AlimentoRepository extends JpaRepository<Alimento, Integer> {

}
