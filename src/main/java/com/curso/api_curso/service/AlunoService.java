package com.curso.api_curso.service;

import com.curso.api_curso.domains.Aluno;
import com.curso.api_curso.repository.AlunoRepository;

public class AlunoService {

    AlunoRepository alunoRepository;

//    public AlunoService() {
//    }

    public AlunoService(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }


    public Aluno salvar(Aluno aluno) {
        if(aluno.getNome() == null) {
            throw new NullPointerException();
        }
        if(aluno.getCpf()== null) {
            throw new NullPointerException();
        }
        if(aluno.getDataNascimento() == null) {
            throw new NullPointerException();
        }
        if(aluno.getTelefone() == null) {
            throw new NullPointerException();
        }
        return alunoRepository.save(aluno);
    }
}
