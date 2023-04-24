 package br.edu.ifpr.paranavai.armarios.modelo;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.util.Date;
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)

public abstract class Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_pessoa", unique = true, nullable = false) 
    private Integer id;
    
    @Column(name = "nome", unique = false, nullable = false, length = 100)
    private String nome;
    @Column(name = "email", unique = true, nullable = false, length = 100)
    private String email;
    @Column(name = "telefone", unique = true, nullable = false, length = 100)
    private String telefone;
    @Column(name = "senha", unique = false, nullable = false, length = 100)
    private String senha;
    @Basic
    @Column(name = "ativo", nullable = false)
    private boolean ativo;
    
    @Column(name = "data_atualizacao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataAtualizacao;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "data_criacao")
    private Date dataCriacao;

    public Pessoa() {
    }

    
    
    public Pessoa(String nome, String email, String telefone, String senha, boolean ativo, Date dataAtualizacao, Date dataCriacao) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.senha = senha;
        this.ativo = ativo;
        this.dataAtualizacao = dataAtualizacao;
        this.dataCriacao = dataCriacao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public Date getDataAtualizacao() {
        return dataAtualizacao;
    }

    public void setDataAtualizacao(Date dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }
    
   

    public String alteraSenha(String senha){
        this.senha = senha;
        return "Senha alterada com sucesso!";
    }

    public Integer getId() {
        return id;
    }
    
    
     
}
