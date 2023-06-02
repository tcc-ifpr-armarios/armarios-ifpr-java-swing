package br.edu.ifpr.paranavai.armarios.modelo;

import java.io.Serializable;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_estudante")
public class Estudante extends Pessoa implements Serializable {

    @Column(name = "ra", unique = true, nullable = false, length = 100)
    private String ra;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_curso", nullable = false)
    private Curso curso;

    public Estudante() {
    }

    public Estudante(String ra, Curso curso, String nome, String sobrenome, String email, String telefone, String senha,
            boolean ativo, LocalDateTime dataAtualizacao, LocalDateTime dataCriacao) {
        super(nome, sobrenome, email, telefone, senha, ativo, dataAtualizacao, dataCriacao);
        this.ra = ra;
        this.curso = curso;
    }

    public String getRa() {
        return ra;
    }

    public void setRa(String ra) {
        this.ra = ra;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }
}
