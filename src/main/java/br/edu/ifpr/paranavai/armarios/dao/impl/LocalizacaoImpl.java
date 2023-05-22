/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifpr.paranavai.armarios.dao.impl;

import br.edu.ifpr.paranavai.armarios.conexao.HibernateUtil;
import br.edu.ifpr.paranavai.armarios.dao.LocalizacaoDao;
import br.edu.ifpr.paranavai.armarios.modelo.Localizacao;
import java.util.ArrayList;
import org.hibernate.Session;
import java.util.List;
import org.hibernate.query.Query;

public class LocalizacaoImpl implements LocalizacaoDao {

    private Session sessao;

    public LocalizacaoImpl() {
        this.sessao = HibernateUtil.getSession();
    }

    @Override
    public List<Localizacao> buscarTodos() {
        List<Localizacao> localizacoes = null;
        try {
            sessao.beginTransaction();
            localizacoes = (List<Localizacao>) this.sessao.createQuery("from Localizacao").list();
            sessao.getTransaction().commit();
            sessao.clear();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return localizacoes;
    }

    @Override
    public Localizacao buscarPorId(Integer id) {
        Localizacao localizacao = null;
        try {
            sessao.beginTransaction();
            localizacao = (Localizacao) sessao.get(Localizacao.class, id);
            sessao.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return localizacao;
    }

    @Override
    public void atualizar(Localizacao localizacao) {
        try {
            sessao.beginTransaction();
            sessao.update(localizacao);
            sessao.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void excluir(Localizacao localizacao) {
        try {
            sessao.beginTransaction();
            sessao.delete(localizacao);
            sessao.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void inserir(Localizacao localizacao) {
        try {
            sessao.beginTransaction();
            sessao.persist(localizacao);
            sessao.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
    @Override
    public List<Localizacao> buscarTodosAtivos(boolean ativo) {
        List<Localizacao> localizacoes = new ArrayList<>();
        try {
            sessao.beginTransaction();
            Query query =  this.sessao.createQuery("from Localizacao where ativo = : ativo");
            query.setParameter("ativo", ativo);
            localizacoes = (List<Localizacao>) query.list();
            sessao.getTransaction().commit();
            sessao.clear();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return localizacoes;
    }
    
    
    @Override
    public Localizacao buscarPorNomeExato(String descricao) {
        Query<Localizacao> query = this.sessao.createQuery("from Localizacao where descricao = :descricao", Localizacao.class);
        query.setParameter("descricao", descricao);
        Localizacao resultado = query.uniqueResult();
        return resultado;
    }
    
   
    
        
}
