/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifpr.paranavai.armarios.servico;

import br.edu.ifpr.paranavai.armarios.dao.ReservaBibliotecaDao;
import br.edu.ifpr.paranavai.armarios.dao.ReservaBibliotecaImpl;
import br.edu.ifpr.paranavai.armarios.modelo.ReservaBiblioteca;
import java.util.List;

/**
 *
 * @author suporte
 */
public class ReservaBibliotecaServico {
    private static ReservaBibliotecaDao dao = new ReservaBibliotecaImpl();

    public static List<ReservaBiblioteca> buscarTodos() {
        return dao.buscarTodos();
    }
    
    public static List<ReservaBiblioteca> buscarTodosAtivos(boolean ativo) {
        return dao.buscarTodosAtivos(ativo);
    }

    public static ReservaBiblioteca buscarPorId(Integer id) {
        return dao.buscarPorId(id);
    }

    public static void inserir(ReservaBiblioteca reserva) {
        dao.inserir(reserva);
    }

    public static void atualizar(ReservaBiblioteca reserva) {
        dao.atualizar(reserva);
    }

    public static void excluir(ReservaBiblioteca reserva) {
        dao.excluir(reserva);
    }
    
    public static void apagaPorNumero(Integer numero){
         dao.apagaPorNumero(numero);
    }
    
    public static List<ReservaBiblioteca> buscarPorAluno(Integer id) {
        return dao.buscarPorAluno(id);
    }
}
