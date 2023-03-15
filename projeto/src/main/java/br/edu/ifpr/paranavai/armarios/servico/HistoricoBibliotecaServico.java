/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifpr.paranavai.armarios.servico;

import br.edu.ifpr.paranavai.armarios.dao.HistoricoBibliotecaDao;
import br.edu.ifpr.paranavai.armarios.dao.HistoricoBibliotecaImpl;
import br.edu.ifpr.paranavai.armarios.modelo.HistoricoBiblioteca;
import java.util.List;

/**
 *
 * @author suporte
 */
public class HistoricoBibliotecaServico {
    
    private static HistoricoBibliotecaDao dao = new HistoricoBibliotecaImpl();
    
    public static List<HistoricoBiblioteca> buscarTodos(){
        return dao.buscarTodos();
    }
    
    public static void inserir(HistoricoBiblioteca historicoBiblioteca) {
        dao.inserir(historicoBiblioteca);
    }
}

