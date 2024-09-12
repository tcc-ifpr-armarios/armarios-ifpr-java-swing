package br.edu.ifpr.paranavai.armarios.modelo;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

/**
 *
 * @author Allan Fernando O de Andrade
 */
@Entity
@Table(name = "tb_emprestimo")
public class Emprestimo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_emprestimo")
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_estudante", nullable = false)
    private Estudante estudante;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_armario", nullable = false)
    private Armario armario;

    @CreationTimestamp
    @Column(name = "data_emprestimo", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime dataEmprestimo = LocalDateTime.now();

    @Column(name = "data_devolucao")
    private LocalDateTime dataDevolucao = null;

    public Emprestimo() {
    }

    public Emprestimo(Estudante estudante, Armario armario, LocalDateTime dataDevolucao) {
        this.estudante = estudante;
        this.armario = armario;
        this.dataDevolucao = dataDevolucao;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Estudante getEstudante() {
        return estudante;
    }

    public void setEstudante(Estudante estudante) {
        this.estudante = estudante;
    }

    public Armario getArmario() {
        return armario;
    }

    public void setArmario(Armario armario) {
        this.armario = armario;
    }

    public LocalDateTime getDataEmprestimo() {
        return dataEmprestimo;
    }

    public void setDataEmprestimo(LocalDateTime dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    public LocalDateTime getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao() {
        this.dataDevolucao = LocalDateTime.now();
    }

}
