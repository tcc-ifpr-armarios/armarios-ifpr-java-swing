/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifpr.paranavai.armarios.servico;

import br.edu.ifpr.paranavai.armarios.dao.ReservaImpl;
import br.edu.ifpr.paranavai.armarios.excecoes.ArmarioException;
import br.edu.ifpr.paranavai.armarios.modelo.Reserva;
import br.edu.ifpr.paranavai.armarios.utils.MensagemUtil;
import java.util.List;
import br.edu.ifpr.paranavai.armarios.dao.ReservaDao;

/**
 *
 * @author suporte
 */
public class ReservaServico {
    private static ReservaDao dao = new ReservaImpl();

    public static List<Reserva> buscarTodos() {
        return dao.buscarTodos();
    }
    
    public static List<Reserva> buscarTodosAtivos(boolean ativo) {
        return dao.buscarTodosAtivos(ativo);
    }

    public static Reserva buscarPorId(Integer id) {
        return dao.buscarPorId(id);
    }

   // public static void inserir(ReservaBiblioteca reserva) {
   //     dao.inserir(reserva);
   // }
    
    
    public static String inserir(Reserva reserva) throws ArmarioException {
        //Verifica se já contem o número do armário com base na localização
        Reserva c = dao.buscarNumeroPorLocalizacao(reserva.getLocalizacao().getId(), reserva.getNumero());
        if (c != null) {
            return "Número de armário já cadastrado";

            
            
        } else

        dao.inserir(reserva);
    return "Armário cadastrado com sucesso";
    }

    public static void atualizar(Reserva reserva) {
        dao.atualizar(reserva);
    }

    public static void excluir(Reserva reserva) {
        dao.excluir(reserva);
    }
    
    public static void apagaPorNumero(Integer numero){
         dao.apagaPorNumero(numero);
    }
    
    public static List<Reserva> buscarPorAluno(Integer id) {
        return dao.buscarPorAluno(id);
    }
    
    public static List<Reserva> buscarPorLocalizacao(Integer id) {
        return dao.buscarPorLocalizacao(id);
    }
    
    public static Reserva buscarNumeroPorLocalizacao(Integer idLocal, Integer numero) {
        return dao.buscarNumeroPorLocalizacao(idLocal, numero);
    }
    
     public static List<Reserva> buscarAtivoPorLocalizacao(Integer idLocal, boolean estado) {
        return dao.buscarAtivoPorLocalizacao(idLocal, estado);
    }
     
     public static void apagaPorNumeroNaLocalizacao(Integer numero, Integer idLocal) {
        dao.apagaPorNumeroNaLocalizacao(numero, idLocal);
     }
}
