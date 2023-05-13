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
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.util.Date;
@Entity
@Table(name = "tb_reserva")
public class Reserva {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_reserva", unique = true, nullable = false) 
    private Integer id;
    
    
    @ManyToOne(cascade=CascadeType.MERGE)
    private Estudante estudante; 
    
    @ManyToOne(cascade=CascadeType.MERGE)
    private Localizacao localizacao;
    
    @Column (name = "numero", nullable = false) 
    private int numero;
    
    @Basic
    @Column(name = "ativo", nullable = false)
    private boolean ativo;
    
   
    @Temporal(TemporalType.TIMESTAMP)
    
    @Column (name = "data_Hora_Emprestimo")
    private Date dataHoraEmprestimo;
    

    public Reserva() {
    }

    public Reserva( int numero, boolean ativo, Localizacao localizacao) {
        this.numero = numero;
        this.ativo = ativo;
        this.localizacao = localizacao;
        
    }

    public Reserva(Integer id, Estudante estudante, Localizacao localizacao, int numero, boolean ativo, Date dataHoraEmprestimo) {
        this.id = id;
        this.estudante = estudante;
        this.localizacao = localizacao;
        this.numero = numero;
        this.ativo = ativo;
        this.dataHoraEmprestimo = dataHoraEmprestimo;
    }

 
    

    public boolean isAtivo() {
        return ativo;
    }
    
    

   
    
    

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setEstudante(Estudante estudante) {
        this.estudante = estudante;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public void setDataHoraEmprestimo(Date dataHoraEmprestimo) {
        this.dataHoraEmprestimo = dataHoraEmprestimo;
    }

    
    

    public Date getDataHoraEmprestimo() {
        return dataHoraEmprestimo;
    }

    

    public Estudante getEstudante() {
        return estudante;
    }

    public Localizacao getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(Localizacao localizacao) {
        this.localizacao = localizacao;
    }

 

    
}
