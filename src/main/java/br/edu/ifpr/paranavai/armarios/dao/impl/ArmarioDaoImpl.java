package br.edu.ifpr.paranavai.armarios.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import br.edu.ifpr.paranavai.armarios.conexao.HibernateUtil;
import br.edu.ifpr.paranavai.armarios.dao.ArmarioDao;
import br.edu.ifpr.paranavai.armarios.excecoes.ArmarioException;
import br.edu.ifpr.paranavai.armarios.modelo.Armario;
import br.edu.ifpr.paranavai.armarios.modelo.StatusArmario;
import br.edu.ifpr.paranavai.armarios.utils.MensagemUtil;

public class ArmarioDaoImpl implements ArmarioDao {

    private Session sessao;

    public ArmarioDaoImpl() {
        this.sessao = HibernateUtil.getSession();
    }

    @Override
    public List<Armario> buscarTodos() {
        Query<Armario> query = this.sessao.createQuery("from Armario", Armario.class);
        List<Armario> armarios = query.getResultList();
        return armarios;
    }

    @Override
    public Armario buscarUnicoPorId(Integer idArmario) {
        return this.sessao.find(Armario.class, idArmario);
    }

    @Override
    public Armario atualizar(Armario armario) throws ArmarioException {
        try {
            sessao.beginTransaction();
            sessao.merge(armario);
            sessao.getTransaction().commit();
        } catch (Exception e) {
            throw new ArmarioException(MensagemUtil.ARMARIO_ATUALIZACAO_ERRO_PADRAO);
        }
        return armario;
    }

    @Override
    public void excluir(Armario armario) throws ArmarioException {
        try {
            sessao.beginTransaction();
            sessao.remove(armario);
            sessao.getTransaction().commit();
        } catch (Exception e) {
            throw new ArmarioException(MensagemUtil.ARMARIO_EXCLUSAO_ERRO_PADRAO);
        }
    }

    @Override
    public Armario inserir(Armario armario) throws ArmarioException {
        try {
            sessao.beginTransaction();
            sessao.persist(armario);
            sessao.getTransaction().commit();
            
        } catch (Exception e) {
            throw new ArmarioException(MensagemUtil.ARMARIO_INSERCAO_ERRO_PADRAO);
        }
        return armario;
    }

    @Override
    public List<Armario> buscarTodosPorStatus(StatusArmario status) {
        Query<Armario> query = this.sessao.createQuery("from Armario e where status = :status", Armario.class);
        query.setParameter("status", status);
        List<Armario> resultado = query.getResultList();
        return resultado;
    }

    @Override
    public List<Armario> buscarTodosPorIdLocalizacao(Integer idLocalizacao) {
        Query<Armario> query = this.sessao.createQuery("from Armario a where a.localizacao.id = :id", Armario.class);
        query.setParameter("id", idLocalizacao);
        List<Armario> resultado = query.getResultList();
        return resultado;

    }

    @Override
    public List<Armario> buscarAtivosPorIdLocalizacao(Integer idLocalizacao) {
        Query<Armario> query = this.sessao
                .createQuery("from Armario a where a.localizacao.id = :id and a.status = :status", Armario.class);
        query.setParameter("id", idLocalizacao);
        query.setParameter("status", StatusArmario.ATIVO);
        List<Armario> resultado = query.getResultList();
        return resultado;
    }
    
    @Override
    public List<Armario> buscarPorStatusIdLocalizacao(Integer idLocalizacao, StatusArmario status) {
        Query<Armario> query = this.sessao
                .createQuery("from Armario a where a.localizacao.id = :id and a.status = :status", Armario.class);
        query.setParameter("id", idLocalizacao);
        query.setParameter("status", status);
        List<Armario> resultado = query.getResultList();
        return resultado;
    }

    @Override
    public Armario buscarUnicoPorNumeroELocalizacao(Integer idLocalizacao, String numero) {
        Query<Armario> query = this.sessao
                .createQuery("from Armario a where a.localizacao.id = :id and a.numero = :numero", Armario.class);

        query.setParameter("id", idLocalizacao);
        query.setParameter("numero", numero);
        Armario resultado = (Armario) query.uniqueResult();
        return resultado;
    }

    @Override
    public Armario buscarUnicoPorNumeroELocalizacaoComIdDiferente(Integer idLocalizacao, String numero,
            Integer idArmario) {
        Query<Armario> query = this.sessao.createQuery(
                "from Armario a where a.localizacao.id = :idLocalizacao and a.numero = :numero and a.id != :idArmario",
                Armario.class);

        query.setParameter("idLocalizacao", idLocalizacao);
        query.setParameter("numero", numero);
        query.setParameter("idArmario", idArmario);
        Armario resultado = (Armario) query.uniqueResult();
        return resultado;
    }

    @Override
    public Long quantidadeArmariosLivres() {
        Query query = this.sessao.createQuery(
                "select count(*) from Armario a where a.status = :status", Long.class);
        query.setParameter("status", StatusArmario.ATIVO);
        return (Long) query.uniqueResult();
    }

}
