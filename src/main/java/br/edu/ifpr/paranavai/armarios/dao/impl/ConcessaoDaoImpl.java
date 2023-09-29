package br.edu.ifpr.paranavai.armarios.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import br.edu.ifpr.paranavai.armarios.conexao.HibernateUtil;
import br.edu.ifpr.paranavai.armarios.excecoes.ConcessaoException;
import br.edu.ifpr.paranavai.armarios.modelo.Concessao;
import br.edu.ifpr.paranavai.armarios.utils.MensagemUtil;
import br.edu.ifpr.paranavai.armarios.dao.ConcessaoDao;

/**
 *
 * @author Allan Fernando O de Andrade
 */
public class ConcessaoDaoImpl implements ConcessaoDao {

    private Session sessao;

    public ConcessaoDaoImpl() {
        this.sessao = HibernateUtil.getSession();
    }

    @Override
    public Concessao inserir(Concessao concessao) throws ConcessaoException {
        try {
            sessao.beginTransaction();
            sessao.persist(concessao);
            sessao.getTransaction().commit();
        } catch (Exception e) {
            throw new ConcessaoException(MensagemUtil.EMPRESTIMO_INSERCAO_ERRO_PADRAO);
        }
        return concessao;
    }

    @Override
    public List<Concessao> buscarAtivosPorIdLocalizacao(Integer idLocalizacao) {
        Query<Concessao> query = this.sessao.createQuery(
                "from Concessao e where e.armario.localizacao.id = :id and e.dataDevolucao is null",
                Concessao.class);
        query.setParameter("id", idLocalizacao);
        List<Concessao> resultado = query.getResultList();
        return resultado;
    }

    @Override
    public List<Concessao> buscarTodos() {
        Query<Concessao> query = this.sessao.createQuery("from Concessao", Concessao.class);
        List<Concessao> concessao = query.getResultList();
        return concessao;
    }

    @Override
    public List<Concessao> buscarTodosPorSiapeDoServidor(String siape) {
        Query<Concessao> query = this.sessao.createQuery("from Concessao e where e.servidor.siape = :siape",
                Concessao.class);
        query.setParameter("siape", siape);
        List<Concessao> resultado = query.getResultList();
        return resultado;
    }

    @Override
    public List<Concessao> buscarTodosPorIdLocalizacao(Integer idLocalizacao) {
        Query<Concessao> query = this.sessao.createQuery("from Concessao e where e.localizacao.id = :id",
                Concessao.class);
        query.setParameter("id", idLocalizacao);
        List<Concessao> resultado = query.getResultList();
        return resultado;
    }

    @Override
    public Concessao atualizar(Concessao concessao) throws ConcessaoException {
        try {
            sessao.beginTransaction();
            sessao.merge(concessao);
            sessao.getTransaction().commit();
        } catch (Exception e) {
            throw new ConcessaoException(MensagemUtil.EMPRESTIMO_ATUALIZACAO_ERRO_PADRAO);
        }
        return concessao;
    }

    @Override
    public Concessao buscarAtivoPorSiapeDoServidor(String siape) {
        Query<Concessao> query = this.sessao.createQuery(
                "from Concessao e where e.servidor.siape = :siape and e.dataDevolucao IS NULL", Concessao.class);
        query.setParameter("siape", siape);
        Concessao resultado = (Concessao) query.uniqueResult();
        return resultado; 
    }

    @Override
    public List<Concessao> buscarTodosPorIdArmario(Integer idConcessao) {
        Query<Concessao> query = this.sessao.createQuery("from Concessao e where e.armario.id = :id",
                Concessao.class);
        query.setParameter("id", idConcessao);
        List<Concessao> resultado = query.getResultList();
        return resultado;
    }

    @Override
    public void excluir(Concessao concessao) throws ConcessaoException {
        try {
            sessao.beginTransaction();
            sessao.remove(concessao);
            sessao.getTransaction().commit();
        } catch (Exception e) {
            throw new ConcessaoException(MensagemUtil.EMPRESTIMO_EXCLUSAO_ERRO_PADRAO);
        }
    }

    @Override
    public Concessao buscarUnicoPorId(int identificador) {
        return this.sessao.find(Concessao.class, identificador);
    }

    @Override
    public Concessao buscarAtivoPorIdArmario(Integer idArmario) {
        Query<Concessao> query = this.sessao.createQuery(
                "from Concessao e where e.armario.id = :id and e.dataDevolucao is null", Concessao.class);
        query.setParameter("id", idArmario);
        Concessao resultado = (Concessao) query.uniqueResult();
        return resultado;
    }
    
        @Override
    public Long quantidadeConcessoesAtivas() {
        Query query = this.sessao.createQuery(
                "select count(*) from Concessao e where e.dataDevolucao is null", Long.class);
        return (Long) query.uniqueResult();
    }
}
