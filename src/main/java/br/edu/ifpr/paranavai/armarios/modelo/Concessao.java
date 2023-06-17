package br.edu.ifpr.paranavai.armarios.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import org.hibernate.annotations.CreationTimestamp;

/**
 *
 * @author Allan Fernando O de Andrade /
 */
@Entity
@Table(name = "tb_concessao")
public class Concessao {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_concessao")
    private Integer id;

    @Column(name = "descricao", length = 100)
    private String descricao;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_servidor", nullable = false)
    private Servidor servidor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_armario", nullable = false)
    Armario armario;

    @CreationTimestamp
    @Column(name = "data_concessao", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime dataConcessao = LocalDateTime.now();

    @Column(name = "data_devolucao")
    private LocalDateTime dataDevolucao = null;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Armario getArmario() {
        return armario;
    }

    public void setArmario(Armario armario) {
        this.armario = armario;
    }

    public LocalDateTime getDataConcessao() {
        return dataConcessao;
    }

    public void setDataConcessao(LocalDateTime dataConcessao) {
        this.dataConcessao = dataConcessao;
    }

    public LocalDateTime getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao() {
        this.dataDevolucao = LocalDateTime.now();
    }

    public Concessao() {

    }

    public Concessao(Servidor servidor, Armario armario, LocalDateTime dataDevolucao) {
        this.servidor = servidor;
        this.armario = armario;
        this.dataDevolucao = dataDevolucao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Servidor getServidor() {
        return servidor;
    }

    public void setServidor(Servidor servidor) {
        this.servidor = servidor;
    }

}
