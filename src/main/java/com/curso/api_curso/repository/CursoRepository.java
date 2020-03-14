package com.curso.api_curso.repository;

import com.curso.api_curso.domains.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CursoRepository extends JpaRepository<Curso , Integer> {

}
