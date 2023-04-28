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
@Table(name = "tb_reserva_biblioteca")
public class ReservaBiblioteca {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_reserva", unique = true, nullable = false) 
    private Integer id;
    
    
    @ManyToOne(cascade=CascadeType.MERGE)
    private Estudante estudante; 
    
    @Column (name = "numero", unique = true, nullable = false) 
    private int numero;
    
    @Basic
    @Column(name = "ativo", nullable = false)
    private boolean ativo;
    
   
    @Temporal(TemporalType.TIMESTAMP)
    
    @Column (name = "data_Hora_Emprestimo")
    private Date dataHoraEmprestimo;
    

    public ReservaBiblioteca() {
    }

    public ReservaBiblioteca( int numero, boolean ativo) {
        this.numero = numero;
        this.ativo = ativo;
        
    }

    public ReservaBiblioteca(Integer id, Estudante estudante, int numero, boolean ativo, Date data_Hora_Devolucao, Date dataHoraEmprestimo) {
        this.id = id;
        this.estudante = estudante;
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

    
}
