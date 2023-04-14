/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.edu.ifpr.paranavai.armarios.dao;


import br.edu.ifpr.paranavai.armarios.modelo.ReservaSaguao;
import java.util.List;

/**
 *
 * @author suporte
 */
public interface ReservaSaguaoDao {
    public List<ReservaSaguao> buscarTodos();

    public List<ReservaSaguao> buscarTodosAtivos(boolean ativo);
    
    public ReservaSaguao buscarPorId(Integer inteiro);
    
    public void atualizar(ReservaSaguao reservaSaguao);

    public void excluir(ReservaSaguao reservaSaguao);

    public void inserir(ReservaSaguao reservaSaguao);
    
    public void apagaPorNumero(Integer numero);
    
    public List<ReservaSaguao> buscarPorAluno(Integer id);
}

