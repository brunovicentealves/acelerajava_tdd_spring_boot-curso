package com.curso.api_curso.domains;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "turma")
public class Turma {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idturma;

    @ManyToOne
    @JoinColumn(name = "id_curso", nullable = false)
    private Curso curso;
    private String dataInicio;
    private String datafinal;

    @OneToMany(mappedBy = "turma")
    private List<Matricula> matriculaList;

    public Turma() {
    }

    public Turma( String dataInicio, String datafinal,Curso curso) {

        this.dataInicio = dataInicio;
        this.datafinal = datafinal;
        this.curso = curso;

    }

    public int getIdturma() {
        return idturma;
    }

    public void setIdturma(int idturma) {
        this.idturma = idturma;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public String getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(String dataInicio) {
        this.dataInicio = dataInicio;
    }

    public String getDatafinal() {
        return datafinal;
    }

    public void setDatafinal(String datafinal) {
        this.datafinal = datafinal;
    }

    public List<Matricula> getMatriculaList() {
        return matriculaList;
    }

    public void setMatriculaList(List<Matricula> matriculaList) {
        this.matriculaList = matriculaList;
    }



}
