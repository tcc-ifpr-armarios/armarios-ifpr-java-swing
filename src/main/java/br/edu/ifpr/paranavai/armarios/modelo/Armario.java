package br.edu.ifpr.paranavai.armarios.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_armario")
public class Armario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_armario")
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_localizacao", nullable = false)
    private Localizacao localizacao;

    @Column(name = "numero", nullable = false)
    private String numero;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false, length = 32, columnDefinition = "varchar(32) default 'ATIVO'")
    private StatusArmario status = StatusArmario.ATIVO;

    public Armario() {
    }

    public Armario(Localizacao localizacao, String numero, StatusArmario status) {
        this.localizacao = localizacao;
        this.numero = numero;
        this.status = status;
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

    public StatusArmario getStatus() {
        return status;
    }

    public void setStatus(StatusArmario status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return numero + " - " + localizacao.getDescricao();
    }
}
