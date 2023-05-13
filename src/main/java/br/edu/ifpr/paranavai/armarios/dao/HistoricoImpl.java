/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifpr.paranavai.armarios.dao;

import br.edu.ifpr.paranavai.armarios.conexao.HibernateUtil;
import br.edu.ifpr.paranavai.armarios.modelo.Historico;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author suporte
 */
public class HistoricoImpl implements HistoricoDao {
    
    private Session sessao;
    
    public HistoricoImpl(){
        this.sessao = HibernateUtil.getSession();
    }
    
    
     @Override
    public void inserir(Historico historico) {
        try {
            sessao.beginTransaction();
            sessao.persist(historico);
            sessao.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
    @Override
    public List<Historico> buscarTodos() {
        List<Historico> reservas = null;
        try {
            sessao.beginTransaction();
            reservas = (List<Historico>) this.sessao.createQuery("from Historico").list();
            sessao.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return reservas;
    }
}
