package br.edu.ifpr.paranavai.armarios.dao;

import br.edu.ifpr.paranavai.armarios.excecoes.LocalizacaoException;
import br.edu.ifpr.paranavai.armarios.modelo.Localizacao;
import java.util.List;

/**
 *
 * @author suporte
 */
public interface LocalizacaoDao {

    public List<Localizacao> buscarTodos();

    public List<Localizacao> buscarTodosAtivos();

    public Localizacao buscarPorId(Integer inteiro);

    public Localizacao atualizar(Localizacao localizacao) throws LocalizacaoException;

    public void excluir(Localizacao localizacao) throws LocalizacaoException;

    public Localizacao inserir(Localizacao localizacao) throws LocalizacaoException;

    public Localizacao buscarPorDescricaoExata(String descricao);
}
