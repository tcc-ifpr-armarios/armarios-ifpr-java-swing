package br.edu.ifpr.paranavai.armarios.dao;


import br.edu.ifpr.paranavai.armarios.modelo.Bibliotecario;
import java.util.List;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

/**
 *
 * @author suporte
 */
public interface BibliotecarioDao {
    public List<Bibliotecario> buscarTodos();

    public Bibliotecario buscarPorId(Integer inteiro);

    public void atualizar(Bibliotecario bibliotecario);

    public void excluir(Bibliotecario bibliotecario);

    public void inserir(Bibliotecario bibliotecario);
    
    public Bibliotecario buscarPorEmail(String email);
}
