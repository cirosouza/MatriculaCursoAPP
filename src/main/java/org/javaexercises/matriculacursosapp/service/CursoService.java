package org.javaexercises.matriculacursosapp.service;

import org.javaexercises.matriculacursosapp.model.Aluno;
import org.javaexercises.matriculacursosapp.model.Curso;
import org.javaexercises.matriculacursosapp.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CursoService {

    @Autowired
    private CursoRepository cursoRepository;
    @Autowired
    private AlunoService alunoService;

    public CursoService(CursoRepository cursoRepository, AlunoService alunoService) {
        this.cursoRepository = cursoRepository;
        this.alunoService = alunoService;
    }

    @Cacheable(value="cursos", key="#id")
    public Optional<Curso> findCursoById(Long id) {
        return cursoRepository.findById(id);
    }

    @Cacheable(value="cursos")
    public List<Curso> getAllCursos(){
        return cursoRepository.findAll();
    }


    public List<Curso> findByAlunoId(Long id){
        return cursoRepository.findByAlunoId(id);
    }

    @CacheEvict(value="cursos", key="#id")
    public void deleteCurso(Curso curso) {
        cursoRepository.delete(curso);
    }

    public void addCursoAluno(Long alunoId, Curso curso) {
        alunoService.getAlunoById(alunoId).map(aluno -> {
            curso.setAluno(aluno);
            return cursoRepository.save(curso);
        }).orElseThrow(() -> new RuntimeException("Aluno nao encontrado com id: " + alunoId ));
    }

    @CacheEvict(value="cursos", key="#id")
    public Curso updateCurso(Long id, Curso curso) {
        Curso cursoEncontrado = this.findCursoById(id).orElseThrow(() -> new RuntimeException("Curso não encontrado com o id: " + id));
        cursoEncontrado.setDenominacao(curso.getDenominacao());
        cursoEncontrado.setCargaHoraria(curso.getCargaHoraria());
        cursoEncontrado.setAluno(curso.getAluno());

        return cursoRepository.save(cursoEncontrado);
    }
}
