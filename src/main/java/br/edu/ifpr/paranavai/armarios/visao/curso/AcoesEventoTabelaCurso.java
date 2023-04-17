package br.edu.ifpr.paranavai.armarios.visao.curso;

import br.edu.ifpr.paranavai.armarios.visao.tabela.acoes.AcoesEventoTabela;

/**
 *
 * @author Professor Marcelo Figueiredo Terenciani
 */
public class AcoesEventoTabelaCurso implements AcoesEventoTabela {

    @Override
    public void aoEditar(int linha) {
        System.out.println(".aoEditar()" + linha);
    }

    @Override
    public void aoExcluir(int linha) {
        System.out.println(".aoExcluir()" + linha);
    }

    @Override
    public void aoVisualizar(int linha) {
        System.out.println(".aoVisualizar()" + linha);
    }
}
