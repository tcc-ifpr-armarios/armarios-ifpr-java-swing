/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifpr.paranavai.armarios.servico;

import br.edu.ifpr.paranavai.armarios.dao.HistoricoImpl;
import br.edu.ifpr.paranavai.armarios.modelo.Historico;
import java.util.List;
import br.edu.ifpr.paranavai.armarios.dao.HistoricoDao;

/**
 *
 * @author suporte
 */
public class HistoricoServico {
    
    private static HistoricoDao dao = new HistoricoImpl();
    
    public static List<Historico> buscarTodos(){
        return dao.buscarTodos();
    }
    
    public static void inserir(Historico historicoBiblioteca) {
        dao.inserir(historicoBiblioteca);
    }
    
    public static List<Historico> buscarPorAluno(String id) {
        return dao.buscarPorAluno(id);
    }
    
    public static List<Historico> buscarPorLocalizacao(Integer idLocal) {
        return dao.buscarPorLocalizacao(idLocal);
    }
}

