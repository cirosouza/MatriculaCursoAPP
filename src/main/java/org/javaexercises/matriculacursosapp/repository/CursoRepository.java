package org.javaexercises.matriculacursosapp.repository;

import org.javaexercises.matriculacursosapp.model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Long> {
    List<Curso> findByAlunoId(Long alunoId);
}
