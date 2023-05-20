package br.edu.ifpr.paranavai.armarios.visao.tabela.acoes;

import javax.swing.JTable;

/**
 *
 * @author Professor Marcelo Figueiredo Terenciani
 */
public interface AcoesEventoTabela {

    public void aoEditar(JTable tabela, int linha);

    public void aoExcluir(JTable tabela, int linha);

    public void aoVisualizar(JTable tabela, int linha);

}
