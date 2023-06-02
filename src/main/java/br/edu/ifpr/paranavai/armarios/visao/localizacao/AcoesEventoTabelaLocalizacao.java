package br.edu.ifpr.paranavai.armarios.visao.localizacao;

import br.edu.ifpr.paranavai.armarios.modelo.Localizacao;
import br.edu.ifpr.paranavai.armarios.servico.LocalizacaoServico;
import br.edu.ifpr.paranavai.armarios.utils.MensagemUtil;
import br.edu.ifpr.paranavai.armarios.visao.tabela.acoes.AcoesEventoTabela;
import java.awt.Container;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author Professor Marcelo Figueiredo Terenciani
 */
public class AcoesEventoTabelaLocalizacao implements AcoesEventoTabela {

    @Override
    public void aoEditar(JTable tabela, int linha) {

        int identificador = (int) tabela.getModel().getValueAt(linha, 0);

        IndexLocalizacaoPanelUI origem = getOrigem(tabela);

        Localizacao localizacao = LocalizacaoServico.buscarUnicoPorId(identificador);

        CriacaoEdicaoLocalizacaoUIModal form = new CriacaoEdicaoLocalizacaoUIModal(origem, localizacao);

        form.setLocationRelativeTo(origem);
        form.setVisible(true);
    }

    @Override
    public void aoExcluir(JTable tabela, int linha) {
        int identificador = (int) tabela.getModel().getValueAt(linha, 0);

        IndexLocalizacaoPanelUI origem = getOrigem(tabela);

        Localizacao localizacao = LocalizacaoServico.buscarUnicoPorId(identificador);

        String mensagem = MensagemUtil.LOCALIZACAO_EXCLUSAO_CONFIRMACAO + " '" + localizacao.getDescricao() + "'?";

        int opcao = JOptionPane.showConfirmDialog(origem, mensagem, MensagemUtil.TITULO_ATENCAO, JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);

        if (opcao == 0) {
            try {
                LocalizacaoServico.excluir(localizacao);
                JOptionPane.showMessageDialog(origem, MensagemUtil.LOCALIZACAO_EXCLUSAO_SUCESSO, MensagemUtil.TITULO_INFORMACAO, JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                origem.init();
            }
        }
    }

    @Override
    public void aoVisualizar(JTable tabela, int linha) {
        // Operação não necessária, pois há pouca informação.

    }
    
    private IndexLocalizacaoPanelUI getOrigem(JTable tabela) {
        IndexLocalizacaoPanelUI origem = null;
        Container c = tabela.getParent();
        while(c != null){
            if(c.getParent() instanceof IndexLocalizacaoPanelUI){
                origem = (IndexLocalizacaoPanelUI) c.getParent();
                break;
            }else
                c = c.getParent();
        }
        return origem;
    }
}
