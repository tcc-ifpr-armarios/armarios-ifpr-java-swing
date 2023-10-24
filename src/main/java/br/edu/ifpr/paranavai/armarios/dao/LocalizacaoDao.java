package br.edu.ifpr.paranavai.armarios.dao;

import java.util.List;

import br.edu.ifpr.paranavai.armarios.excecoes.LocalizacaoException;
import br.edu.ifpr.paranavai.armarios.modelo.Localizacao;

/**
 *
 * @author Allan Fernando Oliveira de Andrade
 */
public interface LocalizacaoDao {

    public Localizacao atualizar(Localizacao localizacao) throws LocalizacaoException;

    public List<Localizacao> buscarAtivos();

    public List<Localizacao> buscarTodos();

    public Localizacao buscarUnicoPorId(Integer idLocalizacao);

    public Localizacao buscarUnicoPorDescricaoExata(String descricao);

    public Localizacao buscarUnicoPorDescricaoExataComIdDiferente(String descricao, Integer idLocalizacao);

    public void excluir(Localizacao localizacao) throws LocalizacaoException;

    public Localizacao inserir(Localizacao localizacao) throws LocalizacaoException;
}
