/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifpr.paranavai.armarios.servico;

import br.edu.ifpr.paranavai.armarios.dao.impl.HistoricoImpl;
import br.edu.ifpr.paranavai.armarios.modelo.Emprestimo;
import java.util.List;
import br.edu.ifpr.paranavai.armarios.dao.EmprestimoDao;

/**
 *
 * @author suporte
 */
public class HistoricoServico {
    
    private static EmprestimoDao dao = new HistoricoImpl();
    
    public static List<Emprestimo> buscarTodos(){
        return dao.buscarTodos();
    }
    
    public static void inserir(Emprestimo historicoBiblioteca) {
        dao.inserir(historicoBiblioteca);
    }
    
    public static List<Emprestimo> buscarPorAluno(String id) {
        return dao.buscarPorAluno(id);
    }
    
    public static List<Emprestimo> buscarPorLocalizacao(Integer idLocal) {
        return dao.buscarPorLocalizacao(idLocal);
    }
}

