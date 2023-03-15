/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.edu.ifpr.paranavai.armarios.dao;

import br.edu.ifpr.paranavai.armarios.modelo.HistoricoBiblioteca;
import java.util.List;

/**
 *
 * @author suporte
 */
public interface HistoricoBibliotecaDao {

    public void inserir(HistoricoBiblioteca historico);

    public List<HistoricoBiblioteca> buscarTodos();
}
