package br.edu.ifpr.paranavai.armarios.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import br.edu.ifpr.paranavai.armarios.conexao.HibernateUtil;
import br.edu.ifpr.paranavai.armarios.dao.CursoDao;
import br.edu.ifpr.paranavai.armarios.excecoes.CursoException;
import br.edu.ifpr.paranavai.armarios.modelo.Curso;
import br.edu.ifpr.paranavai.armarios.utils.MensagemUtil;

/**
 *
 * @author Professor Marcelo F. Terenciani
 */
public class CursoDaoImpl implements CursoDao {

    private Session sessao;

    public CursoDaoImpl() {
        this.sessao = HibernateUtil.getSession();
    }

    @Override
    public List<Curso> buscarTodos() {
        Query<Curso> query = this.sessao.createQuery("from Curso", Curso.class);
        List<Curso> resultado = query.getResultList();
        return resultado;
    }

    @Override
    public Curso buscarPorId(Integer id) {
        return this.sessao.find(Curso.class, id);
    }

    @Override
    public Curso atualizar(Curso curso) throws CursoException {
        try {
            sessao.beginTransaction();
            sessao.merge(curso);
            sessao.getTransaction().commit();
        } catch (Exception e) {
            throw new CursoException(MensagemUtil.CURSO_ERRO_PADRAO_DE_ATUALIZACAO);
        }
        return curso;
    }

    @Override
    public void excluir(Curso curso) throws CursoException {
        try {
            sessao.beginTransaction();
            sessao.remove(curso);
            sessao.getTransaction().commit();
        } catch (Exception e) {
            throw new CursoException(MensagemUtil.CURSO_ERRO_PADRAO_DE_EXCLUSAO);
        }
    }

    @Override
    public Curso inserir(Curso curso) throws CursoException {
        try {
            sessao.beginTransaction();
            sessao.persist(curso);
            sessao.getTransaction().commit();
        } catch (Exception e) {
            throw new CursoException(MensagemUtil.CURSO_ERRO_PADRAO_DE_INSERCAO);
        }
        return curso;
    }

    @Override
    public Curso buscarPorNomeExato(String nome) {
        Query<Curso> query = this.sessao.createQuery("from Curso where nome = :nome", Curso.class);
        query.setParameter("nome", nome);
        Curso resultado = query.uniqueResult();
        return resultado;
    }

}
