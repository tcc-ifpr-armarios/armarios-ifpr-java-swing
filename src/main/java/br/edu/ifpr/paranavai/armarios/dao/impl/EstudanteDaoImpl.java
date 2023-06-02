package br.edu.ifpr.paranavai.armarios.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import br.edu.ifpr.paranavai.armarios.conexao.HibernateUtil;
import br.edu.ifpr.paranavai.armarios.dao.EstudanteDao;
import br.edu.ifpr.paranavai.armarios.excecoes.EstudanteException;
import br.edu.ifpr.paranavai.armarios.modelo.Estudante;
import br.edu.ifpr.paranavai.armarios.utils.MensagemUtil;

public class EstudanteDaoImpl implements EstudanteDao {

    private Session sessao = null;

    public EstudanteDaoImpl() {
        this.sessao = HibernateUtil.getSession();
    }

    @Override
    public List<Estudante> buscarAtivos() {
        Query<Estudante> query = this.sessao.createQuery("from Estudante where ativo = :ativo", Estudante.class);
        query.setParameter("ativo", true);
        List<Estudante> estudantes = query.getResultList();
        return estudantes;
    }

    @Override
    public List<Estudante> buscarTodos() {
        Query<Estudante> query = this.sessao.createQuery("from Estudante", Estudante.class);
        List<Estudante> estudantes = query.getResultList();
        return estudantes;
    }

    @Override
    public Estudante buscarUnicoPorId(Integer idEstudante) {
        return this.sessao.find(Estudante.class, idEstudante);
    }

    @Override
    public Estudante inserir(Estudante estudante) throws EstudanteException {
        try {
            sessao.beginTransaction();
            sessao.persist(estudante);
            sessao.getTransaction().commit();
        } catch (Exception e) {
            throw new EstudanteException(MensagemUtil.ESTUDANTE_INSERCAO_ERRO_PADRAO);
        }
        return estudante;
    }

    @Override
    public Estudante atualizar(Estudante estudante) throws EstudanteException {
        try {
            sessao.beginTransaction();
            sessao.merge(estudante);
            sessao.getTransaction().commit();
        } catch (Exception e) {
            throw new EstudanteException(MensagemUtil.ESTUDANTE_ATUALIZACAO_ERRO_PADRAO);
        }
        return estudante;
    }

    @Override
    public void excluir(Estudante estudante) throws EstudanteException {
        try {
            sessao.beginTransaction();
            sessao.remove(estudante);
            sessao.getTransaction().commit();
        } catch (Exception e) {
            throw new EstudanteException(MensagemUtil.ESTUDANTE_EXCLUSAO_ERRO_PADRAO);
        }
    }

    @Override
    public List<Estudante> buscarTodosPorNome(String nome) {
        Query<Estudante> query = this.sessao.createQuery("from Estudante where nome = :nome", Estudante.class);
        List<Estudante> estudantes = query.getResultList();
        return estudantes;
    }

    @Override
    public Estudante buscarUnicoPorRa(String ra) {
        Query<Estudante> query = this.sessao.createQuery("from Estudante where ra = :ra", Estudante.class);
        query.setParameter("ra", ra);
        Estudante estudante = (Estudante) query.uniqueResult();
        return estudante;
    }

    @Override
    public Estudante buscarUnicoPorEmail(String email) {
        Query<Estudante> query = this.sessao.createQuery("from Estudante where email = :email", Estudante.class);
        query.setParameter("email", email);
        Estudante estudante = (Estudante) query.uniqueResult();
        return estudante;
    }

    @Override
    public Estudante buscarUnicoPorRaComIdDiferente(String ra, Integer idEstudante) {
        Query<Estudante> query = this.sessao.createQuery("from Estudante where ra = :ra and id != :id",
                Estudante.class);
        query.setParameter("ra", ra);
        query.setParameter("id", idEstudante);
        Estudante resultado = (Estudante) query.uniqueResult();
        return resultado;
    }

    @Override
    public List<Estudante> buscarTodosPorIdCurso(Integer idCurso) {
        Query<Estudante> query = this.sessao.createQuery("from Estudante e where e.curso.id = :id", Estudante.class);
        query.setParameter("id", idCurso);
        List<Estudante> resultado = query.getResultList();
        return resultado;
    }
}