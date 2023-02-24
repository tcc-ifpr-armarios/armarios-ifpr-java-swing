/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.edu.ifpr.paranavai.armarios.dao;

import br.edu.ifpr.paranavai.armarios.modelo.ReservaBiblioteca;
import java.util.List;

/**
 *
 * @author suporte
 */
public interface ReservaBibliotecaDao {
    public List<ReservaBiblioteca> buscarTodos();
    
    public List<ReservaBiblioteca> buscarTodosAtivos(boolean ativo);

    public ReservaBiblioteca buscarPorId(Integer inteiro);

    public void atualizar(ReservaBiblioteca reservaBlioteca);

    public void excluir(ReservaBiblioteca reservaBlioteca);

    public void inserir(ReservaBiblioteca reservaBlioteca);
    
    public void apagaPorNumero(Integer numero);
    
    public List<ReservaBiblioteca> buscarPorAluno(Integer id);
    
}

