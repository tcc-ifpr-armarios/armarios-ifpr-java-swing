/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifpr.paranavai.armarios.dao.impl;

import br.edu.ifpr.paranavai.armarios.conexao.HibernateUtil;
import br.edu.ifpr.paranavai.armarios.dao.HistoricoDao;
import br.edu.ifpr.paranavai.armarios.modelo.Emprestimo;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.query.Query;

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
    public void inserir(Emprestimo historico) {
        try {
            sessao.beginTransaction();
            sessao.persist(historico);
            sessao.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
    @Override
    public List<Emprestimo> buscarTodos() {
        List<Emprestimo> reservas = null;
        try {
            sessao.beginTransaction();
            reservas = (List<Emprestimo>) this.sessao.createQuery("from Historico").list();
            sessao.getTransaction().commit();
            sessao.clear();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return reservas;
    }
    
    @Override
    public List<Emprestimo> buscarPorAluno(String raAluno) {
        List<Emprestimo> reservas = new ArrayList<>();
        try {
            sessao.beginTransaction();
            Query query =  this.sessao.createQuery("from Historico where ra = :ra");
            query.setParameter("ra", raAluno);
            
            reservas = (List<Emprestimo>) query.list();
            sessao.getTransaction().commit();
            sessao.clear();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return reservas;
    }
    
     @Override
    public List<Emprestimo> buscarPorLocalizacao(Integer idLocal) {
        List<Emprestimo> reservas = new ArrayList<>();
        try {
            sessao.beginTransaction();
            Query query =  this.sessao.createQuery("from Historico where localId = :localizacao_id");
            query.setParameter("localizacao_id", idLocal);
            
            reservas = (List<Emprestimo>) query.list();
            sessao.getTransaction().commit();
            sessao.clear();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return reservas;
    }
}
