package com.curso.api_curso.service;

import com.curso.api_curso.domains.Curso;
import com.curso.api_curso.domains.Turma;
import com.curso.api_curso.repository.TurmaRepository;


public class TurmaService {

    private TurmaRepository turmaRepository;

    public TurmaService(TurmaRepository turmaRepository) {
        this.turmaRepository = turmaRepository;
    }

    public Turma salvar(Turma turma) {

        if(turma.getDataInicio()== null){

            throw  new NullPointerException();
        }

        if(turma.getDatafinal()== null){

            throw  new NullPointerException();
        }


        return turmaRepository.save(turma);
    }
}
