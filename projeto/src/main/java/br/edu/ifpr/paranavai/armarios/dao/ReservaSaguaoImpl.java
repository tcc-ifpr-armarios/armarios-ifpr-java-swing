/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifpr.paranavai.armarios.dao;

import br.edu.ifpr.paranavai.armarios.conexao.HibernateUtil;

import br.edu.ifpr.paranavai.armarios.modelo.ReservaSaguao;
import java.util.ArrayList;
import org.hibernate.Session;
import java.util.List;
import org.hibernate.query.Query;

public class ReservaSaguaoImpl implements ReservaSaguaoDao {

    private Session sessao;

    public ReservaSaguaoImpl() {
        this.sessao = HibernateUtil.getSession();
    }

    @Override
    public List<ReservaSaguao> buscarTodos() {
        List<ReservaSaguao> reservas = null;
        try {
            sessao.beginTransaction();
            reservas = (List<ReservaSaguao>) this.sessao.createQuery("from ReservaSaguao").list();
            sessao.getTransaction().commit();
            sessao.clear();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return reservas;
    }

    @Override
    public ReservaSaguao buscarPorId(Integer id) {
        ReservaSaguao reserva = null;
        try {
            sessao.beginTransaction();
            reserva = (ReservaSaguao) sessao.get(ReservaSaguao.class, id);
            sessao.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return reserva;
    }

    @Override
    public void atualizar(ReservaSaguao reservaSaguao) {
        try {
            sessao.beginTransaction();
            sessao.update(reservaSaguao);
            sessao.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void excluir(ReservaSaguao reservaSaguao) {
        try {
            sessao.beginTransaction();
            sessao.delete(reservaSaguao);
            sessao.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void inserir(ReservaSaguao reservaSaguao) {
        try {
            sessao.beginTransaction();
            sessao.persist(reservaSaguao);
            sessao.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public List<ReservaSaguao> buscarTodosAtivos(boolean ativo) {
        List<ReservaSaguao> reservas = new ArrayList<>();
        try {
            sessao.beginTransaction();
            Query query =  this.sessao.createQuery("from ReservaSaguao where ativo = : ativo");
            query.setParameter("ativo", ativo);
            reservas = (List<ReservaSaguao>) query.list();
            sessao.getTransaction().commit();
            sessao.clear();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return reservas;
    }
    
    
     @Override
    public void apagaPorNumero(Integer numero) {
        
        try {
        sessao.beginTransaction();
        Query query = sessao.createQuery("delete ReservaSaguao where numero = :numero");
        query.setParameter("numero", numero);
        int result = query.executeUpdate();
        sessao.getTransaction().commit(); 
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
    @Override
    public List<ReservaSaguao> buscarPorAluno(Integer estudante_id_pessoa) {
        List<ReservaSaguao> reservas = new ArrayList<>();
        try {
            sessao.beginTransaction();
            Query query =  this.sessao.createQuery("from ReservaSaguao where estudante_id_pessoa = : estudante_id_pessoa");
            query.setParameter("estudante_id_pessoa", estudante_id_pessoa);
            
            reservas = (List<ReservaSaguao>) query.list();
            sessao.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return reservas;
    }

}
