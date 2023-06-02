package br.edu.ifpr.paranavai.armarios.modelo;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_servidor")
public class Servidor extends Pessoa {
    @Column
    private String siape;

    public Servidor() {
    }

    public Servidor(String nome, String sobrenome, String email, String telefone, String senha, boolean ativo,
            LocalDateTime dataAtualizacao, LocalDateTime dataCriacao, String siape) {
        super(nome, sobrenome, email, telefone, senha, ativo, dataAtualizacao, dataCriacao);
        this.siape = siape;
    }

    public String getSiape() {
        return siape;
    }

    public void setSiape(String siape) {
        this.siape = siape;
    }
}