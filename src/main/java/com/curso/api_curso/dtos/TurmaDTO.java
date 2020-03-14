package com.curso.api_curso.dtos;

import com.curso.api_curso.domains.Curso;
import com.curso.api_curso.domains.Matricula;

import javax.persistence.*;
import java.util.List;

public class TurmaDTO {


    private long idCurso;
    private String dataInicio;
    private String datafinal;

    private List<Long> idAlunoss;

    public TurmaDTO(long idCurso, String dataInicio, String datafinal, List<Long> idAlunoss) {
        this.idCurso = idCurso;
        this.dataInicio = dataInicio;
        this.datafinal = datafinal;
        this.idAlunoss = idAlunoss;
    }

    public long getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(long idCurso) {
        this.idCurso = idCurso;
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

    public List<Long> getIdAlunoss() {
        return idAlunoss;
    }

    public void setIdAlunoss(List<Long> idAlunoss) {
        this.idAlunoss = idAlunoss;
    }
}
