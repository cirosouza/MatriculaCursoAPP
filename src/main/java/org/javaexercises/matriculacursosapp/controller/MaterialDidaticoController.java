package org.javaexercises.matriculacursosapp.controller;

import org.javaexercises.matriculacursosapp.model.MaterialDidatico;
import org.javaexercises.matriculacursosapp.service.MaterialDidaticoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/materialdidatico")
public class MaterialDidaticoController {

    @Autowired
    private MaterialDidaticoService materialDidaticoService;

    public MaterialDidaticoController(MaterialDidaticoService materialDidaticoService) {
        this.materialDidaticoService = materialDidaticoService;
    }

    @GetMapping("")
    public List<MaterialDidatico> getAllMaterialDidatico() {
        return materialDidaticoService.findAll();
    }

    @GetMapping("/{id}")
    public MaterialDidatico getMaterialDidaticoById(@PathVariable String id) {
        return materialDidaticoService.findById(id);
    }

    @PostMapping
    public MaterialDidatico createAluno(@RequestBody MaterialDidatico materialDidatico){
        return materialDidaticoService.createMaterialDidatico(materialDidatico);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateAluno(@PathVariable String id, @RequestBody MaterialDidatico materialDidatico){
        materialDidaticoService.updateMaterialDidatico(id,materialDidatico);

        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAluno(@PathVariable String id){
        materialDidaticoService.deleteMaterialDidatico(id);

        return ResponseEntity.ok().build();
    }
}
