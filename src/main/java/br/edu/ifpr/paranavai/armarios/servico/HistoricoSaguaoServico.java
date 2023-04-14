/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifpr.paranavai.armarios.servico;

import br.edu.ifpr.paranavai.armarios.dao.HistoricoSaguaoDao;
import br.edu.ifpr.paranavai.armarios.dao.HistoricoSaguaoImpl;
import br.edu.ifpr.paranavai.armarios.modelo.HistoricoSaguao;
import java.util.List;

/**
 *
 * @author suporte
 */
public class HistoricoSaguaoServico {
    private static HistoricoSaguaoDao dao = new HistoricoSaguaoImpl();
    
    public static List<HistoricoSaguao> buscarTodos(){
        return dao.buscarTodos();
    }
    
    public static void inserir(HistoricoSaguao historicoSaguao) {
        dao.inserir(historicoSaguao);
    }
}
