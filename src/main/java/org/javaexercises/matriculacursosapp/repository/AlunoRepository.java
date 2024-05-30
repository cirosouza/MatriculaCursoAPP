package org.javaexercises.matriculacursosapp.repository;

import org.javaexercises.matriculacursosapp.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long> {
}
