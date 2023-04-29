package br.edu.ifpr.paranavai.armarios.modelo;

import java.time.LocalDateTime;

import org.hibernate.annotations.ColumnTransformer;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import br.edu.ifpr.paranavai.armarios.utils.AutenticacaoUtil;
import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_pessoa", unique = true, nullable = false)
    private Integer id;

    @Column(name = "nome", unique = false, nullable = false, length = 100)
    private String nome;

    @Column(nullable = false)
    private String sobrenome;

    @Column(name = "email", unique = true, nullable = false, length = 100)
    private String email;

    @Column(name = "telefone", unique = true, nullable = false, length = 100)
    private String telefone;

    @ColumnTransformer(
            read = "senha",
            write = "SHA2(CONCAT('" + AutenticacaoUtil.CHAVE_PRIVADA + "', ?, '" + AutenticacaoUtil.CHAVE_PRIVADA + "'), 256)"
    )
    @Column(name = "senha", unique = false, nullable = false, length = 100)
    private String senha;

    @Basic
    @Column(name = "ativo", nullable = false, columnDefinition = "boolean default true")
    private boolean ativo = true;
    
    @CreationTimestamp
    @Column(name = "data_criacao", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime dataCriacao = LocalDateTime.now();

    @UpdateTimestamp
    @Column(name = "data_atualizacao", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    private LocalDateTime dataAtualizacao = LocalDateTime.now();
    
    public Pessoa() {
    }

    public Pessoa(String nome, String sobrenome, String email, String telefone, String senha, boolean ativo, LocalDateTime dataAtualizacao, LocalDateTime dataCriacao) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.email = email;
        this.telefone = telefone;
        this.senha = senha;
        this.ativo = ativo;
        this.dataAtualizacao = dataAtualizacao;
        this.dataCriacao = dataCriacao;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getNomeCompleto() {
        return nome + " " + sobrenome;
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

    public LocalDateTime getDataAtualizacao() {
        return dataAtualizacao;
    }

    public void setDataAtualizacao(LocalDateTime dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }
}
