package com.estadisticaspro.contorller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.estadisticaspro.model.Estadistica;
import com.estadisticaspro.service.EstadisticaService;

@RestController
@RequestMapping("/api/estadisticas")
public class EstadisticaController {

    @Autowired
    private EstadisticaService estadisticaService;

    @PostMapping("/registrar")
    public ResponseEntity<Void> registrarProducto(@RequestParam String categoria) {
        estadisticaService.registrarProductoCreado(categoria);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<Estadistica>> obtenerEstadisticas(@RequestParam String categoria) {
        List<Estadistica> estadisticas = estadisticaService.obtenerEstadisticas(categoria);
        return ResponseEntity.ok(estadisticas);
    }

}
