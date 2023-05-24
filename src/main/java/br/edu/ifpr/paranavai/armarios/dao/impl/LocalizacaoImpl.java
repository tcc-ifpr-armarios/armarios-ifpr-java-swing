package br.edu.ifpr.paranavai.armarios.dao.impl;

import br.edu.ifpr.paranavai.armarios.conexao.HibernateUtil;
import br.edu.ifpr.paranavai.armarios.dao.LocalizacaoDao;
import br.edu.ifpr.paranavai.armarios.excecoes.LocalizacaoException;
import br.edu.ifpr.paranavai.armarios.modelo.Localizacao;
import br.edu.ifpr.paranavai.armarios.utils.MensagemUtil;
import org.hibernate.Session;
import java.util.List;
import org.hibernate.query.Query;

public class LocalizacaoImpl implements LocalizacaoDao {

    private Session sessao;

    public LocalizacaoImpl() {
        this.sessao = HibernateUtil.getSession();
    }

    @Override
    public List<Localizacao> buscarTodos() {
        Query<Localizacao> query = this.sessao.createQuery("from Localizacao", Localizacao.class);
        List<Localizacao> localizacoes = query.getResultList();
        return localizacoes;
    }

    @Override
    public Localizacao buscarPorId(Integer idLocalizacao) {
        return this.sessao.find(Localizacao.class, idLocalizacao);
    }

    @Override
    public Localizacao atualizar(Localizacao localizacao) throws LocalizacaoException {
        try {
            sessao.beginTransaction();
            sessao.merge(localizacao);
            sessao.getTransaction().commit();
        } catch (Exception e) {
            throw new LocalizacaoException(MensagemUtil.LOCALIZACAO_ATUALIZACAO_ERRO_PADRAO);
        }
        return localizacao;
    }

    @Override
    public void excluir(Localizacao localizacao) throws LocalizacaoException {
        try {
            sessao.beginTransaction();
            sessao.remove(localizacao);
            sessao.getTransaction().commit();
        } catch (Exception e) {
            throw new LocalizacaoException(MensagemUtil.LOCALIZACAO_EXCLUSAO_ERRO_PADRAO);
        }
    }

    @Override
    public Localizacao inserir(Localizacao localizacao) throws LocalizacaoException {
        try {
            sessao.beginTransaction();
            sessao.persist(localizacao);
            sessao.getTransaction().commit();
        } catch (Exception e) {
            throw new LocalizacaoException(MensagemUtil.LOCALIZACAO_INSERCAO_ERRO_PADRAO);
        }
        return localizacao;
    }

    @Override
    public List<Localizacao> buscarTodosAtivos() {
        Query<Localizacao> query = this.sessao.createQuery("from Localizacao e where ativo = :ativo", Localizacao.class);
        query.setParameter("ativo", true);
        List<Localizacao> resultado = query.getResultList();
        return resultado;
    }

    @Override
    public Localizacao buscarPorDescricaoExata(String descricao) {
        Query<Localizacao> query = this.sessao.createQuery("from Localizacao where descricao = :descricao", Localizacao.class);
        query.setParameter("descricao", descricao);
        Localizacao resultado = query.uniqueResult();
        return resultado;
    }
}
