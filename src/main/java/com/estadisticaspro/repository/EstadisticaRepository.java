package com.estadisticaspro.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.estadisticaspro.model.Estadistica;

@Repository
public interface EstadisticaRepository extends JpaRepository<Estadistica, Long> {
    List<Estadistica> findByCategoria(String categoria);
}

