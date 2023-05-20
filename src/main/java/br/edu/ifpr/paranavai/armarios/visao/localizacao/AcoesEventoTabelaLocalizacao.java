package br.edu.ifpr.paranavai.armarios.visao.localizacao;

import br.edu.ifpr.paranavai.armarios.modelo.Localizacao;
import br.edu.ifpr.paranavai.armarios.servico.LocalizacaoServico;
import br.edu.ifpr.paranavai.armarios.utils.MensagemUtil;
import br.edu.ifpr.paranavai.armarios.visao.tabela.acoes.AcoesEventoTabela;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;

/**
 *
 * @author Professor Marcelo Figueiredo Terenciani
 */
public class AcoesEventoTabelaLocalizacao implements AcoesEventoTabela {

    @Override
    public void aoEditar(JTable tabela, int linha) {

        int identificador = (int) tabela.getModel().getValueAt(linha, 0);

        IndexLocalizacaoUI indexLocalizacaoUI = (IndexLocalizacaoUI) SwingUtilities.getWindowAncestor(tabela);

        Localizacao localizacao = LocalizacaoServico.buscarPorId(identificador);

        CriacaoEdicaoLocalizacaoUIModal form = new CriacaoEdicaoLocalizacaoUIModal(indexLocalizacaoUI, localizacao, true);

        form.setLocationRelativeTo(indexLocalizacaoUI);
        form.setVisible(true);
    }

    @Override
    public void aoExcluir(JTable tabela, int linha) {
        int identificador = (int) tabela.getModel().getValueAt(linha, 0);

        IndexLocalizacaoUI indexLocalizacaoUI = (IndexLocalizacaoUI) SwingUtilities.getWindowAncestor(tabela);

        Localizacao localizacao = LocalizacaoServico.buscarPorId(identificador);

        String mensagem = MensagemUtil.LOCALIZACAO_EXCLUSAO_CONFIRMACAO + " '" + localizacao.getDescricao() + "'?";

        int opcao = JOptionPane.showConfirmDialog(indexLocalizacaoUI, mensagem, MensagemUtil.TITULO_ATENCAO, JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);

        if (opcao == 0) {
            try {
                LocalizacaoServico.excluir(localizacao);
                JOptionPane.showMessageDialog(indexLocalizacaoUI, MensagemUtil.LOCALIZACAO_EXCLUSAO_SUCESSO, MensagemUtil.TITULO_INFORMACAO, JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                indexLocalizacaoUI.init();
            }
        }
    }

    @Override
    public void aoVisualizar(JTable tabela, int linha) {
        int identificador = (int) tabela.getModel().getValueAt(linha, 0);

        IndexLocalizacaoUI indexLocalizacaoUI = (IndexLocalizacaoUI) SwingUtilities.getWindowAncestor(tabela);

        Localizacao localizacao = LocalizacaoServico.buscarPorId(identificador);

        CriacaoEdicaoLocalizacaoUIModal form = new CriacaoEdicaoLocalizacaoUIModal(indexLocalizacaoUI, localizacao, false);

        form.setLocationRelativeTo(indexLocalizacaoUI);
        form.setVisible(true);

    }
}
