/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifpr.paranavai.armarios.dao;

import br.edu.ifpr.paranavai.armarios.conexao.HibernateUtil;
import br.edu.ifpr.paranavai.armarios.modelo.Bibliotecario;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.query.Query;

/**
 *
 * @author suporte
 */
public class BibliotecarioDaoImpl implements BibliotecarioDao {
    private Session sessao;

    public BibliotecarioDaoImpl() {
        this.sessao = HibernateUtil.getSession();
    }

    /**
     *
     * @return
     */
    @Override
    public List<Bibliotecario> buscarTodos() {
        List<Bibliotecario> bibliotecarios = null;
        try {
            sessao.beginTransaction();
            bibliotecarios = (List<Bibliotecario>) this.sessao.createQuery("from Bibliotecario").list();
            sessao.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bibliotecarios;
    }

    /**
     *
     * @param id
     * @return
     */
    @Override
    public Bibliotecario buscarPorId(Integer id) {
        Bibliotecario bibliotecario = null;
        try {
            sessao.beginTransaction();
            bibliotecario = (Bibliotecario) sessao.get(Bibliotecario.class, id);
            sessao.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bibliotecario;
    }

    @Override
    public void inserir(Bibliotecario bibliotecario) {
        try {
            sessao.beginTransaction();
            sessao.persist(bibliotecario);
            sessao.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void atualizar(Bibliotecario bibliotecario) {
        try {
            sessao.beginTransaction();
            sessao.update(bibliotecario);
            sessao.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void excluir(Bibliotecario bibliotecario) {
        try {
            sessao.beginTransaction();
            sessao.delete(bibliotecario);
            sessao.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public Bibliotecario buscarPorEmail(String email) {
        
        Bibliotecario bibliotecarios = new Bibliotecario();
        try {
            sessao.beginTransaction();
            
            Query query = this.sessao.createQuery("from Bibliotecario where email = :email");
            query.setParameter("email", email);
            bibliotecarios = (Bibliotecario) query.getSingleResult();
            sessao.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bibliotecarios;
    }
}
