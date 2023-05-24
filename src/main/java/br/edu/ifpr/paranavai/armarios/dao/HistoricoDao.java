/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.edu.ifpr.paranavai.armarios.dao;

import br.edu.ifpr.paranavai.armarios.modelo.Emprestimo;
import java.util.List;

/**
 *
 * @author suporte
 */
public interface HistoricoDao {

    public void inserir(Emprestimo historico);

    public List<Emprestimo> buscarTodos();
    
    public List<Emprestimo> buscarPorAluno(String raAluno);
    
    public List<Emprestimo> buscarPorLocalizacao(Integer idLocal);
}
