package br.edu.ifpr.paranavai.armarios.visao.tabela.acoes;

/**
 *
 * @author Professor Marcelo Figueiredo Terenciani
 */
public interface AcoesEventoTabela {

    public void aoEditar(int linha);

    public void aoExcluir(int linha);

    public void aoVisualizar(int linha);

}
