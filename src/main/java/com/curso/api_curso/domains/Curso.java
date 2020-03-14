package com.curso.api_curso.domains;

import javax.persistence.*;
import java.util.List;
@Entity
@Table(name = "curso")
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCurso;
    private String nomeCurso;
    private String descricao;
    private  String requesitos;
    private String modalidade;

    @OneToMany(mappedBy = "curso")
    private List<Turma> turmaList;

    public Curso() {
    }

    public Curso( String nomeCurso, String descricao, String requesitos, String modalidade) {

        this.nomeCurso = nomeCurso;
        this.descricao = descricao;
        this.requesitos = requesitos;
        this.modalidade = modalidade;

    }



    public int getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(int idCurso) {
        this.idCurso = idCurso;
    }

    public String getNomeCurso() {
        return nomeCurso;
    }

    public void setNomeCurso(String nomeCurso) {
        this.nomeCurso = nomeCurso;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getRequesitos() {
        return requesitos;
    }

    public void setRequesitos(String requesitos) {
        this.requesitos = requesitos;
    }

    public String getModalidade() {
        return modalidade;
    }

    public void setModalidade(String modalidade) {
        this.modalidade = modalidade;
    }

    public List<Turma> getTurmaList() {
        return turmaList;
    }

    public void setTurmaList(List<Turma> turmaList) {
        this.turmaList = turmaList;
    }
}
