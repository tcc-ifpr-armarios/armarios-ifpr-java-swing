package br.edu.ifpr.paranavai.armarios.dao.impl;

import br.edu.ifpr.paranavai.armarios.excecoes.EmprestimoException;
import br.edu.ifpr.paranavai.armarios.conexao.HibernateUtil;
import br.edu.ifpr.paranavai.armarios.modelo.Emprestimo;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.query.Query;
import br.edu.ifpr.paranavai.armarios.dao.EmprestimoDao;
import br.edu.ifpr.paranavai.armarios.utils.MensagemUtil;

/**
 *
 * @author suporte
 */
public class EmprestimoDaoImpl implements EmprestimoDao {

    private Session sessao;

    public EmprestimoDaoImpl() {
        this.sessao = HibernateUtil.getSession();
    }

    @Override
    public Emprestimo inserir(Emprestimo emprestimo) throws EmprestimoException {
        try {
            sessao.beginTransaction();
            sessao.persist(emprestimo);
            sessao.getTransaction().commit();
        } catch (Exception e) {
            throw new EmprestimoException(MensagemUtil.EMPRESTIMO_INSERCAO_ERRO_PADRAO);
        }
        return emprestimo;
    }

    @Override
    public List<Emprestimo> buscarTodos() {
        Query<Emprestimo> query = this.sessao.createQuery("from Emprestimo", Emprestimo.class);
        List<Emprestimo> emprestimo = query.getResultList();
        return emprestimo;
    }

    @Override
    public List<Emprestimo> buscarPorRaDoEstudante(String ra) {
        Query<Emprestimo> query = this.sessao.createQuery("from Emprestimo e where e.estudante.ra = :ra", Emprestimo.class);
        query.setParameter("ra", ra);
        List<Emprestimo> resultado = query.getResultList();
        return resultado;
    }

    @Override
    public List<Emprestimo> buscarPorIdLocalizacao(Integer idLocalizacao) {
        Query<Emprestimo> query = this.sessao.createQuery("from Emprestimo e where e.localizacao.id = :id", Emprestimo.class);
        query.setParameter("id", idLocalizacao);
        List<Emprestimo> resultado = query.getResultList();
        return resultado;
    }
}
