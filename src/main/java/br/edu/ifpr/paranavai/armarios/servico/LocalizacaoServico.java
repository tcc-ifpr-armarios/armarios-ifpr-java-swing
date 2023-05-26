package br.edu.ifpr.paranavai.armarios.servico;

import br.edu.ifpr.paranavai.armarios.dao.LocalizacaoDao;
import br.edu.ifpr.paranavai.armarios.dao.impl.LocalizacaoImpl;
import br.edu.ifpr.paranavai.armarios.excecoes.LocalizacaoException;
import br.edu.ifpr.paranavai.armarios.modelo.Localizacao;

import java.util.List;

/**
 *
 * @author suporte
 */
public class LocalizacaoServico {

    private static LocalizacaoDao dao = new LocalizacaoImpl();

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
        return dao.inserir(localizacao);
    }

    public static Localizacao atualizar(Localizacao localizacao) throws LocalizacaoException {
        return dao.atualizar(localizacao);
    }

    public static void excluir(Localizacao localizacao) throws LocalizacaoException {
        dao.excluir(localizacao);
    }

    public static Localizacao buscarPorDescricaoExata(String descricao) {
        return dao.buscarPorDescricaoExata(descricao);
    }
}
