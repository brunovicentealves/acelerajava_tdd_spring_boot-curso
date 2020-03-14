package com.curso.api_curso.repository;

import com.curso.api_curso.domains.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepository extends JpaRepository<Aluno, Integer> {
}
