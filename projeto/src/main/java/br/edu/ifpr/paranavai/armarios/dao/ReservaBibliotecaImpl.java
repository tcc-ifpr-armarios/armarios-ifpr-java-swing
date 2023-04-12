/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifpr.paranavai.armarios.dao;

import br.edu.ifpr.paranavai.armarios.conexao.HibernateUtil;
import br.edu.ifpr.paranavai.armarios.modelo.Estudante;
import br.edu.ifpr.paranavai.armarios.modelo.ReservaBiblioteca;
import java.util.ArrayList;
import org.hibernate.Session;
import java.util.List;
import javax.persistence.EntityManager;
import org.hibernate.internal.AbstractSessionImpl;
import org.hibernate.internal.SessionImpl;
import org.hibernate.query.Query;

public class ReservaBibliotecaImpl implements ReservaBibliotecaDao {

    private Session sessao;

    public ReservaBibliotecaImpl() {
        this.sessao = HibernateUtil.getSession();
    }

    @Override
    public List<ReservaBiblioteca> buscarTodos() {
        List<ReservaBiblioteca> reservas = null;
        try {
            sessao.beginTransaction();
            reservas = (List<ReservaBiblioteca>) this.sessao.createQuery("from ReservaBiblioteca").list();
            sessao.getTransaction().commit();
            sessao.clear();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return reservas;
    }

    @Override
    public ReservaBiblioteca buscarPorId(Integer id) {
        ReservaBiblioteca reserva = null;
        try {
            sessao.beginTransaction();
            reserva = (ReservaBiblioteca) sessao.get(ReservaBiblioteca.class, id);
            sessao.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return reserva;
    }

    @Override
    public void atualizar(ReservaBiblioteca reservaBlioteca) {
        try {
            sessao.beginTransaction();
            sessao.update(reservaBlioteca);
            sessao.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void excluir(ReservaBiblioteca reservaBlioteca) {
        try {
            sessao.beginTransaction();
            sessao.delete(reservaBlioteca);
            sessao.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void inserir(ReservaBiblioteca reservaBlioteca) {
        try {
            sessao.beginTransaction();
            sessao.persist(reservaBlioteca);
            sessao.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
    @Override
    public List<ReservaBiblioteca> buscarTodosAtivos(boolean ativo) {
        List<ReservaBiblioteca> reservas = new ArrayList<>();
        try {
            sessao.beginTransaction();
            Query query =  this.sessao.createQuery("from ReservaBiblioteca where ativo = : ativo");
            query.setParameter("ativo", ativo);
            reservas = (List<ReservaBiblioteca>) query.list();
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
        Query query = sessao.createQuery("delete ReservaBiblioteca where numero = :numero");
        query.setParameter("numero", numero);
        int result = query.executeUpdate();
        sessao.getTransaction().commit(); 
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
    
    @Override
    public List<ReservaBiblioteca> buscarPorAluno(Integer estudante_id_pessoa) {
        List<ReservaBiblioteca> reservas = new ArrayList<>();
        try {
            sessao.beginTransaction();
            Query query =  this.sessao.createQuery("from ReservaBiblioteca where estudante_id_pessoa = : estudante_id_pessoa ");
            query.setParameter("estudante_id_pessoa", estudante_id_pessoa);
            
            reservas = (List<ReservaBiblioteca>) query.list();
            sessao.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return reservas;
    }
    
        
}
    
    

