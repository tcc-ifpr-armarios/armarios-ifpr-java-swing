/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.edu.ifpr.paranavai.armarios.dao;
import java.util.List;
import br.edu.ifpr.paranavai.armarios.modelo.HistoricoSaguao;


/**
 *
 * @author suporte
 */
public interface HistoricoSaguaoDao {
    
    public void inserir(HistoricoSaguao historico);
    
    public List<HistoricoSaguao> buscarTodos();
    
}
