/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifpr.paranavai.armarios.dao;


import br.edu.ifpr.paranavai.armarios.conexao.HibernateUtil;
import br.edu.ifpr.paranavai.armarios.modelo.HistoricoSaguao;

import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author suporte
 */
public class HistoricoSaguaoImpl implements HistoricoSaguaoDao {
    
    
    
    private Session sessao;
    
    public HistoricoSaguaoImpl(){
        this.sessao = HibernateUtil.getSession();
    }
    
    
     @Override
    public void inserir(HistoricoSaguao historicoSaguao) {
        try {
            sessao.beginTransaction();
            sessao.persist(historicoSaguao);
            sessao.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
    @Override
    public List<HistoricoSaguao> buscarTodos() {
        List<HistoricoSaguao> reservas = null;
        try {
            sessao.beginTransaction();
            reservas = (List<HistoricoSaguao>) this.sessao.createQuery("from HistoricoSaguao").list();
            sessao.getTransaction().commit();
            sessao.clear();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return reservas;
    }
}
