/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifpr.paranavai.armarios.servico;


import br.edu.ifpr.paranavai.armarios.dao.ReservaSaguaoDao;
import br.edu.ifpr.paranavai.armarios.dao.ReservaSaguaoImpl;

import br.edu.ifpr.paranavai.armarios.modelo.ReservaSaguao;
import java.util.List;

/**
 *
 * @author suporte
 */
public class ReservaSaguaoServico {
    private static ReservaSaguaoDao dao = new ReservaSaguaoImpl();
    
    public static List<ReservaSaguao> buscarTodosAtivos(boolean ativo) {
        return dao.buscarTodosAtivos(ativo);
    }

    public static List<ReservaSaguao> buscarTodos() {
        return dao.buscarTodos();
    }

    public static ReservaSaguao buscarPorId(Integer id) {
        return dao.buscarPorId(id);
    }

    public static void inserir(ReservaSaguao reserva) {
        dao.inserir(reserva);
    }

    public static void atualizar(ReservaSaguao reserva) {
        dao.atualizar(reserva);
    }

    public static void excluir(ReservaSaguao reserva) {
        dao.excluir(reserva);
    }
    public static void apagaPorNumero(Integer numero){
         dao.apagaPorNumero(numero);
    }
    
    public static List<ReservaSaguao> buscarPorAluno(Integer id) {
        return dao.buscarPorAluno(id);
    }
}
