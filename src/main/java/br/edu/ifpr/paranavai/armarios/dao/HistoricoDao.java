/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.edu.ifpr.paranavai.armarios.dao;

import br.edu.ifpr.paranavai.armarios.modelo.Historico;
import java.util.List;

/**
 *
 * @author suporte
 */
public interface HistoricoDao {

    public void inserir(Historico historico);

    public List<Historico> buscarTodos();
    
    public List<Historico> buscarPorAluno(String raAluno);
    
    public List<Historico> buscarPorLocalizacao(Integer idLocal);
}
