package br.edu.ifpr.paranavai.armarios.modelo;



import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.Type;
@Entity
@Table(name = "tb_reserva_saguao")
public class ReservaSaguao {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_reserva", unique = true, nullable = false) 
    private Integer id;
    
    
    @ManyToOne(cascade=CascadeType.MERGE)
    private Estudante estudante; 
    
    @Column (name = "numero", unique = true, nullable = false) 
    private int numero;
    
    @Type(type="true_false")
    @Column(name = "ativo", nullable = false)
    private boolean ativo;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column (name = "dataHoraDevolucao")
    private Date data_Hora_Devolucao;
    @Temporal(TemporalType.TIMESTAMP)
    
    @Column (name = "data_Hora_Emprestimo")
    private Date dataHoraEmprestimo;
    

    public ReservaSaguao() {
    }

    public ReservaSaguao( int numero, boolean ativo) {
        this.numero = numero;
        this.ativo = ativo;
        
    }

    public ReservaSaguao(Integer id, Estudante estudante, int numero, boolean ativo, Date data_Hora_Devolucao, Date dataHoraEmprestimo) {
        this.id = id;
        this.estudante = estudante;
        this.numero = numero;
        this.ativo = ativo;
        this.data_Hora_Devolucao = data_Hora_Devolucao;
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

    public void setData_Hora_Devolucao(Date data_Hora_Devolucao) {
        this.data_Hora_Devolucao = data_Hora_Devolucao;
    }

    public Date getDataHoraEmprestimo() {
        return dataHoraEmprestimo;
    }

    public Date getData_Hora_Devolucao() {
        return data_Hora_Devolucao;
    }

    public Estudante getEstudante() {
        return estudante;
    }
    

    


    

    
    
   

    
    
    
    
}
