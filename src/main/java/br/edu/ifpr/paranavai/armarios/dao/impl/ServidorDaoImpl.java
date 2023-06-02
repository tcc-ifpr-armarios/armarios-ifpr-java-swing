package br.edu.ifpr.paranavai.armarios.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import br.edu.ifpr.paranavai.armarios.conexao.HibernateUtil;
import br.edu.ifpr.paranavai.armarios.dao.ServidorDao;
import br.edu.ifpr.paranavai.armarios.excecoes.ServidorException;
import br.edu.ifpr.paranavai.armarios.modelo.Servidor;
import br.edu.ifpr.paranavai.armarios.utils.MensagemUtil;

/**
 *
 * @author Allan Fernando O de Andrade
 */
public class ServidorDaoImpl implements ServidorDao {

    private Session sessao;

    public ServidorDaoImpl() {
        this.sessao = HibernateUtil.getSession();
    }

    @Override
    public List<Servidor> buscarTodos() {
        Query<Servidor> query = this.sessao.createQuery("from Servidor", Servidor.class);
        List<Servidor> servidors = query.getResultList();
        return servidors;
    }

    @Override
    public Servidor buscarUnicoPorId(Integer idServidor) {
        return this.sessao.find(Servidor.class, idServidor);
    }

    @Override
    public Servidor inserir(Servidor servidor) throws ServidorException {
        try {
            sessao.beginTransaction();
            sessao.persist(servidor);
            sessao.getTransaction().commit();
        } catch (Exception e) {
            throw new ServidorException(MensagemUtil.SERVIDOR_INSERCAO_ERRO_PADRAO);
        }
        return servidor;
    }

    @Override
    public Servidor atualizar(Servidor servidor) throws ServidorException {
        try {
            sessao.beginTransaction();
            sessao.merge(servidor);
            sessao.getTransaction().commit();
        } catch (Exception e) {
            throw new ServidorException(MensagemUtil.SERVIDOR_ATUALIZACAO_ERRO_PADRAO);
        }
        return servidor;
    }

    @Override
    public void excluir(Servidor servidor) throws ServidorException {
        try {
            sessao.beginTransaction();
            sessao.remove(servidor);
            sessao.getTransaction().commit();
        } catch (Exception e) {
            throw new ServidorException(MensagemUtil.SERVIDOR_EXCLUSAO_ERRO_PADRAO);
        }
    }

    @Override
    public Servidor buscarUnicoPorEmail(String email) {
        Query<Servidor> query = this.sessao.createQuery("from Servidor where email = :email", Servidor.class);
        query.setParameter("email", email);
        Servidor servidor = (Servidor) query.uniqueResult();
        return servidor;
    }

    @Override
    public Servidor buscarUnicoPorEmailOuSiape(String emailOuSiape) {
        Query<Servidor> query = this.sessao.createQuery("from Servidor where email = :email or siape = :siape",
                Servidor.class);
        query.setParameter("email", emailOuSiape);
        query.setParameter("siape", emailOuSiape);
        Servidor servidor = (Servidor) query.uniqueResult();
        return servidor;
    }
}
