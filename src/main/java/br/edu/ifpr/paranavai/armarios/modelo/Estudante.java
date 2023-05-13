package br.edu.ifpr.paranavai.armarios.modelo;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "tb_estudante")
public class Estudante extends Pessoa implements Serializable {

    @Column
    private String ra;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "estudante")
    /**@JoinColumn(name = "id_reserva")**/
    private List<Reserva> reservasB;
    
    
    
    
    /**
     * @param ra * @OneToMany(cascade = CascadeType.ALL, mappedBy = "estudante")
     * @param nome
     * @param email
     * @param dataCriacao
     * @param senha
     * @param ativo
     * @param dataAtualizacao
     * @param telefone
    @JoinColumn(name = "reserva_id")
    public ReservaBiblioteca reservaB;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "estudante")
    @JoinColumn(name = "reserva_id")
    public ReservaSaguao reservaS;**/

    
    public Estudante(String ra, String nome, String email, String telefone, String senha, boolean ativo, Date dataAtualizacao, Date dataCriacao) {
        super(nome, email, telefone, senha, ativo, dataAtualizacao, dataCriacao);
        this.ra = ra;
        
    }

    public Estudante() {
    }

    public String getRa() {
        return ra;
    }

    public void setRa(String ra) {
        this.ra = ra;
    }

    public void setReservasB(List<Reserva> reservasB) {
        this.reservasB = reservasB;
    }

    public List<Reserva> getReservasB() {
        return reservasB;
    }

    
}
