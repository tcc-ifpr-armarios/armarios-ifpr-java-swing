package br.edu.ifpr.paranavai.armarios.servico;

import java.util.List;

import br.edu.ifpr.paranavai.armarios.dao.ArmarioDao;
import br.edu.ifpr.paranavai.armarios.dao.LocalizacaoDao;
import br.edu.ifpr.paranavai.armarios.dao.impl.ArmarioDaoImpl;
import br.edu.ifpr.paranavai.armarios.dao.impl.LocalizacaoDaoImpl;
import br.edu.ifpr.paranavai.armarios.excecoes.LocalizacaoException;
import br.edu.ifpr.paranavai.armarios.modelo.Armario;
import br.edu.ifpr.paranavai.armarios.modelo.Localizacao;
import br.edu.ifpr.paranavai.armarios.utils.MensagemUtil;

/**
 *
 * @author suporte
 */
public class LocalizacaoServico {

    private static LocalizacaoDao dao = new LocalizacaoDaoImpl();

    public static List<Localizacao> buscarTodos() {
        return dao.buscarTodos();
    }

    public static List<Localizacao> buscarTodosAtivos() {
        return dao.buscarTodosAtivos();
    }

    public static Localizacao buscarPorId(Integer id) {
        return dao.buscarPorId(id);
    }

    public static Localizacao inserir(Localizacao localizacao) throws LocalizacaoException {
        verificaCamposObrigatorios(localizacao);
        verificaDadosDuplicados(localizacao);

        return dao.inserir(localizacao);
    }

    public static Localizacao atualizar(Localizacao localizacao) throws LocalizacaoException {
        verificaCamposObrigatorios(localizacao);

        Localizacao l = dao.buscarPorDescricaoExataComIdDiferente(localizacao.getDescricao(), localizacao.getId());
        if (l != null)
            throw new LocalizacaoException(MensagemUtil.LOCALIZACAO_DESCRICAO_DUPLICADA);

        return dao.atualizar(localizacao);
    }

    public static void excluir(Localizacao localizacao) throws LocalizacaoException {
        verificaSeFoiRemovido(localizacao);
        verificaSeExistemVinculos(localizacao);
        dao.excluir(localizacao);
    }

    public static Localizacao buscarPorDescricaoExata(String descricao) {
        return dao.buscarPorDescricaoExata(descricao);
    }

    private static void verificaDadosDuplicados(Localizacao localizacao) throws LocalizacaoException {
        Localizacao l = dao.buscarPorDescricaoExata(localizacao.getDescricao());
        if (l != null) {
            throw new LocalizacaoException(MensagemUtil.LOCALIZACAO_DESCRICAO_DUPLICADA);
        }
    }

    private static void verificaCamposObrigatorios(Localizacao localizacao) throws LocalizacaoException {
        if (localizacao.getDescricao() == null || localizacao.getDescricao().isEmpty()) {
            throw new LocalizacaoException(MensagemUtil.CURSO_CAMPO_OBRIGATORIO);
        }
    }

    private static void verificaSeExistemVinculos(Localizacao localizacao) throws LocalizacaoException {
        ArmarioDao ArmarioDao = new ArmarioDaoImpl();
        List<Armario> a = ArmarioDao.buscarTodosPorIdLocalizacao(localizacao.getId());
        if (!a.isEmpty()) {
            throw new LocalizacaoException(MensagemUtil.LOCALIZACAO_VINCULADA_ARMARIO);
        }
    }

    private static void verificaSeFoiRemovido(Localizacao localizacao) throws LocalizacaoException {
        Localizacao l = dao.buscarPorId(localizacao.getId());
        if (l == null) {
            throw new LocalizacaoException(MensagemUtil.LOCALIZACAO_REMOVIDA);
        }
    }

}
