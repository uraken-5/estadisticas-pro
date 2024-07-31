package com.estadisticaspro.service;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.estadisticaspro.exception.ResourceNotFoundException;
import com.estadisticaspro.model.Estadistica;
import com.estadisticaspro.repository.EstadisticaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class EstadisticaService {

    @Autowired
    private EstadisticaRepository estadisticaRepository;
    
    private static final Logger logger = LoggerFactory.getLogger(EstadisticaService.class);

    public void registrarProductoCreado(String categoria) {
        List<Estadistica> estadisticas = estadisticaRepository.findByCategoria(categoria);

        if (estadisticas == null || estadisticas.isEmpty()) {
            Estadistica nuevaEstadistica = new Estadistica();
            nuevaEstadistica.setCategoria(categoria);
            nuevaEstadistica.setProductosCreados(1L);
            estadisticaRepository.save(nuevaEstadistica);
            logger.info("Statics created : {}", nuevaEstadistica.getCategoria());
        } else {
            Estadistica estadistica = estadisticas.get(0);
            estadistica.setProductosCreados(estadistica.getProductosCreados() + 1);
            estadisticaRepository.save(estadistica);
        }
    }


    public List<Estadistica> obtenerEstadisticas(String categoria) {
        
    	List<Estadistica> estadisticaList = new ArrayList<>();
    	estadisticaList = estadisticaRepository.findByCategoria(categoria);
    	if (estadisticaList.isEmpty()) {
            throw new ResourceNotFoundException("No statistics found for category: " + categoria);
        }
        return estadisticaRepository.findByCategoria(categoria); // Suponiendo que uses JPA
    }

}
