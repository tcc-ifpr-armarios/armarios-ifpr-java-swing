package br.edu.ifpr.paranavai.armarios.dao;

import br.edu.ifpr.paranavai.armarios.conexao.HibernateUtil;
import br.edu.ifpr.paranavai.armarios.modelo.Localizacao;
import java.util.List;
import org.hibernate.Session;

public class LocalizacaoDaoImpl implements LocalizacaoDao {

    private Session sessao;

    public LocalizacaoDaoImpl() {
        this.sessao = HibernateUtil.getSession();
    }

    @Override
    public List<Localizacao> buscarTodos() {
        List<Localizacao> localizacoes = null;
        try {
            sessao.beginTransaction();
            localizacoes = (List<Localizacao>) this.sessao.createQuery("from Localizacao").list();
            sessao.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return localizacoes;
    }

 
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
}