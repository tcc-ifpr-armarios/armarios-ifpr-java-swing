package br.edu.ifpr.paranavai.armarios.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "tb_bibliotecario")
public class Bibliotecario extends Pessoa{
    @Column
    private String siape;

    public Bibliotecario() {
    }

    public Bibliotecario(String nome, String sobrenome, String email, String telefone, String senha, boolean ativo, LocalDateTime dataAtualizacao, LocalDateTime dataCriacao, String siape) {
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