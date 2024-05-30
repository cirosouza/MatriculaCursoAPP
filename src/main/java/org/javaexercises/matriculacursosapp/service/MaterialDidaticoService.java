package org.javaexercises.matriculacursosapp.service;

import org.javaexercises.matriculacursosapp.model.MaterialDidatico;
import org.javaexercises.matriculacursosapp.repository.MaterialDidaticoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaterialDidaticoService {

    @Autowired
    private MaterialDidaticoRepository materialDidaticoRepository;

    public MaterialDidaticoService(MaterialDidaticoRepository materialDidaticoRepository) {
        this.materialDidaticoRepository = materialDidaticoRepository;
    }

    public List<MaterialDidatico> findAll() {
        return materialDidaticoRepository.findAll();
    }

    public MaterialDidatico findById(String id) {
        return materialDidaticoRepository.findById(id).orElseThrow(() -> new RuntimeException("Material Didatico não encontrado com o id: " + id));
    }

    public MaterialDidatico createMaterialDidatico(MaterialDidatico materialDidatico) {
        return materialDidaticoRepository.save(materialDidatico);
    }

    public void updateMaterialDidatico(String id, MaterialDidatico materialDidatico) {
        materialDidaticoRepository.findById(id)
                .map(materialDidaticoEncontrado ->
                    materialDidaticoRepository.save(materialDidatico))
                .orElseThrow(() -> new RuntimeException("Material Didatico não encontrado com o id: " + id));
    }

    public void deleteMaterialDidatico(String id) {
        MaterialDidatico materialDidaticoEncontrado = materialDidaticoRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Material Didatico não encontrado com o id: " + id));

        materialDidaticoRepository.delete(materialDidaticoEncontrado);
    }
}
