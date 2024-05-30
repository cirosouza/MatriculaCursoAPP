package org.javaexercises.matriculacursosapp.controller;

import org.javaexercises.matriculacursosapp.model.Curso;
import org.javaexercises.matriculacursosapp.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cursos")
public class CursoController {

    @Autowired
    private CursoService cursoService;

    public CursoController(CursoService cursoService) {
        this.cursoService = cursoService;
    }

    @GetMapping("")
    public List<Curso> getAllCursos(){
        return cursoService.getAllCursos();
    }

    @GetMapping("/{id}")
    public Curso getCursoById(@PathVariable Long id){
        return cursoService.findCursoById(id).orElseThrow(() -> new RuntimeException("Aluno não encontrado " + id));
    }

    @PostMapping("/aluno/{alunoId}")
    public ResponseEntity<?> addCursoAluno(@PathVariable Long alunoId, @RequestBody Curso curso){
        cursoService.addCursoAluno(alunoId, curso);

        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public Curso updateCurso(@PathVariable Long id, @RequestBody Curso curso){
        return cursoService.updateCurso(id, curso);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCurso(@PathVariable Long id){
        Curso curso = cursoService.findCursoById(id).orElseThrow(() -> new RuntimeException("Aluno não encontrado " + id));

        cursoService.deleteCurso(curso);

        return ResponseEntity.ok().build();
    }

    @GetMapping("/aluno/{alunoId}")
    public ResponseEntity<?> getAllCursosAluno(@PathVariable Long alunoId){
        List<Curso> cursos = cursoService.findByAlunoId(alunoId);
        if(cursos.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(cursos);
    }

}
