package com.curso.api_curso.domains;

import javax.persistence.*;

@Entity
@Table(name = "matricula")
public class Matricula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idMAtricula;

    @ManyToOne
    @JoinColumn(name = "id_turma")
    private Turma turma;
    @ManyToOne
    @JoinColumn(name = "id_aluno")
    private Aluno aluno;

    public Matricula() {
    }

    public Matricula(int idMAtricula, Turma turma, Aluno aluno) {
        this.idMAtricula = idMAtricula;
        this.turma = turma;
        this.aluno = aluno;
    }

    public int getIdMAtricula() {
        return idMAtricula;
    }

    public void setIdMAtricula(int idMAtricula) {
        this.idMAtricula = idMAtricula;
    }

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }
}
