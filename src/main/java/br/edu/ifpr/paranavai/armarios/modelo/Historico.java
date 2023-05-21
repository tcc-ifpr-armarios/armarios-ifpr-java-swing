/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifpr.paranavai.armarios.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.util.Date;

/**
 *
 * @author suporte
 */
@Entity
@Table(name = "tb_historico")
public class Historico {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_reserva", unique = true, nullable = false) 
    private Integer id;
   
    @Column (name = "numero", nullable = false) 
    private int numero;
    
    @Column (name = "localizacao_id", nullable = false )  
    private int localId;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column (name = "data_hora_devolucao")
    private Date dataHoraDevolucao;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column (name = "data_hora_emprestimo")
    private Date dataHoraEmprestimo;
    
    @Column
    private String ra;

    public Historico() {
    }

    public Historico(Integer id, int numero, int localId, Date data_Hora_Devolucao, Date dataHoraEmprestimo, String ra) {
        this.id = id;
        this.numero = numero;
        this.localId = localId;
        this.dataHoraDevolucao = data_Hora_Devolucao;
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

    public Date getDataHoraDevolucao() {
        return dataHoraDevolucao;
    }

    public void setDataHoraDevolucao(Date dataHoraDevolucao) {
        this.dataHoraDevolucao = dataHoraDevolucao;
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

    public int getLocalId() {
        return localId;
    }

    public void setLocalId(int localId) {
        this.localId = localId;
    }
}
