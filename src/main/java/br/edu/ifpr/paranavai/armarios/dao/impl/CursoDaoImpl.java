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
    public Curso buscarPorId(Integer idCurso) {
        return this.sessao.find(Curso.class, idCurso);
    }

    @Override
    public Curso atualizar(Curso curso) throws CursoException {
        try {
            sessao.beginTransaction();
            sessao.merge(curso);
            sessao.getTransaction().commit();
        } catch (Exception e) {
            throw new CursoException(MensagemUtil.CURSO_ATUALIZACAO_ERRO_PADRAO);
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
            throw new CursoException(MensagemUtil.CURSO_EXCLUSAO_ERRO_PADRAO);
        }
    }

    @Override
    public Curso inserir(Curso curso) throws CursoException {
        try {
            sessao.beginTransaction();
            sessao.persist(curso);
            sessao.getTransaction().commit();
        } catch (Exception e) {
            throw new CursoException(MensagemUtil.CURSO_INSERCAO_ERRO_PADRAO);
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

    @Override
    public Curso buscarPorNomeExatoComIdDiferente(String nome, Integer idCurso) {
        Query<Curso> query = this.sessao.createQuery("from Curso where nome = :nome and id != :id", Curso.class);
        query.setParameter("nome", nome);
        query.setParameter("id", idCurso);
        Curso resultado = query.uniqueResult();
        return resultado;
    }

    @Override
    public List<Curso> buscarTodosAtivos() {
        Query<Curso> query = this.sessao.createQuery("from Curso where ativo = :ativo", Curso.class);
        query.setParameter("ativo", true);
        List<Curso> resultado = query.getResultList();
        return resultado;
    }
}