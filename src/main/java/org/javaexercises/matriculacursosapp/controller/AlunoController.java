package org.javaexercises.matriculacursosapp.controller;

import org.javaexercises.matriculacursosapp.model.Aluno;
import org.javaexercises.matriculacursosapp.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.javaexercises.matriculacursosapp.repository.AlunoRepository;

import java.util.List;

@RestController
@RequestMapping("/api/alunos")
public class AlunoController {

    @Autowired
    private AlunoService alunoService;

    public AlunoController(AlunoService alunoService) {
        this.alunoService = alunoService;
    }

    @GetMapping("/{id}")
    public Aluno getAlunoById(@PathVariable long id){
        return alunoService.getAlunoById(id).orElseThrow(() -> new RuntimeException("Aluno não encontrado " + id));
    }

    @GetMapping("")
    public List<Aluno> getAllAlunos(){
        return alunoService.getAllAlunos();
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAluno(@PathVariable long id){
        Aluno aluno = alunoService.getAlunoById(id).orElseThrow(() -> new RuntimeException("Aluno não encontrado " + id));

        alunoService.deleteAluno(aluno);

        return ResponseEntity.ok().build();
    }

    @PostMapping
    public Aluno createAluno(@RequestBody Aluno aluno){
        return alunoService.createAluno(aluno);
    }

    @PutMapping("/{id}")
    public Aluno updateAluno(@PathVariable Long id,@RequestBody Aluno aluno){
        return alunoService.updateAluno(id,aluno);
    }

}

