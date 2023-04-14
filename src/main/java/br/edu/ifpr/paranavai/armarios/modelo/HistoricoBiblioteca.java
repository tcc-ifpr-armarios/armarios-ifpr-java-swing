/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifpr.paranavai.armarios.modelo;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author suporte
 */
@Entity
@Table(name = "tb_historico_biblioteca")
public class HistoricoBiblioteca {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_reserva", unique = true, nullable = false) 
    private Integer id;
    
    @Column (name = "numero", nullable = false) 
    private int numero;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column (name = "dataHoraDevolucao")
    private Date data_Hora_Devolucao;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column (name = "data_Hora_Emprestimo")
    private Date dataHoraEmprestimo;
    
    @Column
    private String ra;

    public HistoricoBiblioteca() {
    }

    public HistoricoBiblioteca(Integer id, int numero, Date data_Hora_Devolucao, Date dataHoraEmprestimo, String ra) {
        this.id = id;
        this.numero = numero;
        this.data_Hora_Devolucao = data_Hora_Devolucao;
        this.dataHoraEmprestimo = dataHoraEmprestimo;
        this.ra = ra;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Date getData_Hora_Devolucao() {
        return data_Hora_Devolucao;
    }

    public void setData_Hora_Devolucao(Date data_Hora_Devolucao) {
        this.data_Hora_Devolucao = data_Hora_Devolucao;
    }

    public Date getDataHoraEmprestimo() {
        return dataHoraEmprestimo;
    }

    public void setDataHoraEmprestimo(Date dataHoraEmprestimo) {
        this.dataHoraEmprestimo = dataHoraEmprestimo;
    }

    public String getRa() {
        return ra;
    }

    public void setRa(String ra) {
        this.ra = ra;
    }
    
    
}
