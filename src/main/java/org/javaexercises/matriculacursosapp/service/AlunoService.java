package org.javaexercises.matriculacursosapp.service;

import org.javaexercises.matriculacursosapp.model.Aluno;
import org.javaexercises.matriculacursosapp.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    public AlunoService(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }

    @Cacheable(value="alunos", key="#id")
    public Optional<Aluno> getAlunoById(long id){
        return alunoRepository.findById(id);
    }

    @Cacheable(value="alunos")
    public List<Aluno> getAllAlunos(){
        return alunoRepository.findAll();
    }

    @CacheEvict(value="alunos", key="#id")
    public void deleteAluno(Aluno aluno){
        alunoRepository.delete(aluno);
    }

    public Aluno createAluno(Aluno aluno){
        return alunoRepository.save(aluno);
    }

    public Aluno updateAluno(Long id, Aluno aluno){
        Aluno alunoEncontrado = this.getAlunoById(id).orElseThrow(() -> new RuntimeException("Aluno não encontrado com o id: " + id));
        alunoEncontrado.setNome(aluno.getNome());
        alunoEncontrado.setEmail(aluno.getEmail());
        alunoEncontrado.setCursos(aluno.getCursos());
        return alunoRepository.save(aluno);
    }
}
