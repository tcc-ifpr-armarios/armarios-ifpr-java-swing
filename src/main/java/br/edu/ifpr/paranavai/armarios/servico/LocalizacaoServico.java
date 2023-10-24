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
 * @author Allan Fernando Oliveira de Andrade
 */
public class LocalizacaoServico {

    private static LocalizacaoDao daoLocalizacao = new LocalizacaoDaoImpl();

    public static List<Localizacao> buscarTodos() {
        return daoLocalizacao.buscarTodos();
    }

    public static List<Localizacao> buscarAtivos() {
        return daoLocalizacao.buscarAtivos();
    }

    public static Localizacao buscarUnicoPorId(Integer id) {
        return daoLocalizacao.buscarUnicoPorId(id);
    }

    public static Localizacao inserir(Localizacao localizacao) throws LocalizacaoException {
        verificaCamposObrigatorios(localizacao);
        verificaDadosDuplicados(localizacao);

        return daoLocalizacao.inserir(localizacao);
    }

    public static Localizacao atualizar(Localizacao localizacao) throws LocalizacaoException {
        verificaCamposObrigatorios(localizacao);

        Localizacao l = daoLocalizacao.buscarUnicoPorDescricaoExataComIdDiferente(localizacao.getDescricao(),
                localizacao.getId());
        if (l != null)
            throw new LocalizacaoException(MensagemUtil.LOCALIZACAO_DESCRICAO_DUPLICADA);

        return daoLocalizacao.atualizar(localizacao);
    }

    public static void excluir(Localizacao localizacao) throws LocalizacaoException {
        verificaSeFoiRemovido(localizacao);
        verificaSeExistemVinculos(localizacao);
        daoLocalizacao.excluir(localizacao);
    }

    public static Localizacao buscarUnicoPorDescricaoExata(String descricao) {
        return daoLocalizacao.buscarUnicoPorDescricaoExata(descricao);
    }

    private static void verificaDadosDuplicados(Localizacao localizacao) throws LocalizacaoException {
        Localizacao l = daoLocalizacao.buscarUnicoPorDescricaoExata(localizacao.getDescricao());
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
        Localizacao l = daoLocalizacao.buscarUnicoPorId(localizacao.getId());
        if (l == null) {
            throw new LocalizacaoException(MensagemUtil.LOCALIZACAO_REMOVIDA);
        }
    }

}
