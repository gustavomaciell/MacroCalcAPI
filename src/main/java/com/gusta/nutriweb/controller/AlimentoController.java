package com.gusta.nutriweb.controller;


import com.gusta.nutriweb.model.AlimentoModel;
import com.gusta.nutriweb.service.AlimentoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/alimentos")
public class AlimentoController {

    private final AlimentoService alimentoService;

    public AlimentoController(AlimentoService alimentoService) {
        this.alimentoService = alimentoService;
    }

    @GetMapping("/listar")
    public List<AlimentoModel> listarAlimentos() {
        return alimentoService.alimentosTacoCSV("/alimento.csv");
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<AlimentoModel> buscarPorId(@PathVariable Long id) {
        return alimentoService.buscarAlimentosPorId(id);
    }

}