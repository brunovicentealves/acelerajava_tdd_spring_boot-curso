package com.curso.api_curso.service;

import com.curso.api_curso.domains.Curso;
import com.curso.api_curso.repository.CursoRepository;
import org.springframework.stereotype.Service;

@Service
public class CursoService {

    private CursoRepository cursoRepository;

    public CursoService(CursoRepository cursoRepository) {
        this.cursoRepository = cursoRepository;
    }

    public Curso salvar(Curso curso) {

        if(curso.getNomeCurso()== null){

            throw new NullPointerException();
        }
        if(curso.getDescricao()== null){

            throw new NullPointerException();
        }
        if(curso.getRequesitos()== null){

            throw new NullPointerException();
        }
        if(curso.getDescricao()== null){

            throw new NullPointerException();
        }

        return cursoRepository.save(curso);
    }
}
