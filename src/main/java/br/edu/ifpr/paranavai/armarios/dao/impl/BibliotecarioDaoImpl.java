package br.edu.ifpr.paranavai.armarios.dao.impl;

import br.edu.ifpr.paranavai.armarios.conexao.HibernateUtil;
import br.edu.ifpr.paranavai.armarios.dao.BibliotecarioDao;
import br.edu.ifpr.paranavai.armarios.excecoes.BibliotecarioException;
import br.edu.ifpr.paranavai.armarios.modelo.Bibliotecario;
import br.edu.ifpr.paranavai.armarios.utils.MensagemUtil;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.query.Query;

/**
 *
 * @author Allan Fernando O de Andrade
 */
public class BibliotecarioDaoImpl implements BibliotecarioDao {

    private Session sessao;

    public BibliotecarioDaoImpl() {
        this.sessao = HibernateUtil.getSession();
    }

    @Override
    public List<Bibliotecario> buscarTodos() {
        Query<Bibliotecario> query = this.sessao.createQuery("from Bibliotecario", Bibliotecario.class);
        List<Bibliotecario> bibliotecarios = query.getResultList();
        return bibliotecarios;
    }

    @Override
    public Bibliotecario buscarPorId(Integer idBibliotecario) {
        return this.sessao.find(Bibliotecario.class, idBibliotecario);
    }

    @Override
    public Bibliotecario inserir(Bibliotecario bibliotecario) throws BibliotecarioException {
        try {
            sessao.beginTransaction();
            sessao.persist(bibliotecario);
            sessao.getTransaction().commit();
        } catch (Exception e) {
            throw new BibliotecarioException(MensagemUtil.BIBLIOTECARIO_INSERCAO_ERRO_PADRAO);
        }
        return bibliotecario;
    }

    @Override
    public Bibliotecario atualizar(Bibliotecario bibliotecario) throws BibliotecarioException {
        try {
            sessao.beginTransaction();
            sessao.merge(bibliotecario);
            sessao.getTransaction().commit();
        } catch (Exception e) {
            throw new BibliotecarioException(MensagemUtil.BIBLIOTECARIO_ATUALIZACAO_ERRO_PADRAO);
        }
        return bibliotecario;
    }

    @Override
    public void excluir(Bibliotecario bibliotecario) throws BibliotecarioException {
        try {
            sessao.beginTransaction();
            sessao.remove(bibliotecario);
            sessao.getTransaction().commit();
        } catch (Exception e) {
            throw new BibliotecarioException(MensagemUtil.BIBLIOTECARIO_EXCLUSAO_ERRO_PADRAO);
        }
    }

    @Override
    public Bibliotecario buscarPorEmail(String email) {
        Query<Bibliotecario> query = this.sessao.createQuery("from Bibliotecario where email = :email", Bibliotecario.class);
        query.setParameter("email", email);
        Bibliotecario bibliotecario = query.uniqueResult();
        return bibliotecario;
    }

    @Override
    public Bibliotecario buscarPorEmailOuSiape(String emailOuSiape) {
        Query<Bibliotecario> query = this.sessao.createQuery("from Bibliotecario where email = :email or siape = :siape", Bibliotecario.class);
        query.setParameter("email", emailOuSiape);
        query.setParameter("siape", emailOuSiape);
        Bibliotecario bibliotecario = query.uniqueResult();
        return bibliotecario;
    }
}
