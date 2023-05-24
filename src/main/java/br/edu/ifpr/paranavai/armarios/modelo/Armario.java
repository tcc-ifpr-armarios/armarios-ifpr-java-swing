package br.edu.ifpr.paranavai.armarios.modelo;

import jakarta.persistence.Basic;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_armario")
public class Armario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_armario")
    private Integer id;

    @ManyToOne(cascade = CascadeType.MERGE)
    private Localizacao localizacao;

    @Column(name = "numero", nullable = false)
    private String numero;

    @Basic
    @Column(name = "ativo", nullable = false)
    private boolean ativo;

    public Armario() {
    }

    public Armario(Localizacao localizacao, String numero, boolean ativo) {
        this.numero = numero;
        this.ativo = ativo;
        this.localizacao = localizacao;

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Localizacao getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(Localizacao localizacao) {
        this.localizacao = localizacao;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
}