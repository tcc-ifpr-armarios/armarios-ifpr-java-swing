package br.edu.ifpr.paranavai.armarios.dao.impl;

import br.edu.ifpr.paranavai.armarios.conexao.HibernateUtil;
import br.edu.ifpr.paranavai.armarios.dao.CursoDao;
import br.edu.ifpr.paranavai.armarios.excecoes.CursoException;
import br.edu.ifpr.paranavai.armarios.modelo.Curso;
import br.edu.ifpr.paranavai.armarios.utils.MensagemUtil;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.OptimisticLockException;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.exception.ConstraintViolationException;
import org.hibernate.query.Query;

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
        } catch (EntityNotFoundException e) {
            throw new CursoException(MensagemUtil.CURSO_NAO_ENCONTRADO);
        } catch (OptimisticLockException e) {
            throw new CursoException(MensagemUtil.CURSO_ATUALIZADO_OU_REMOVIDO);
        }
    }

    @Override
    public Curso inserir(Curso curso) throws CursoException {
        try {
            sessao.beginTransaction();
            sessao.persist(curso);
            sessao.getTransaction().commit();
        } catch (ConstraintViolationException e) {
            throw new CursoException(MensagemUtil.CURSO_NOME_DUPLICADO);
        } catch (Exception e) {
            throw new CursoException(MensagemUtil.CURSO_ERRO_PADRAO_DE_INSERCAO);
        }
        return curso;
    }

}
