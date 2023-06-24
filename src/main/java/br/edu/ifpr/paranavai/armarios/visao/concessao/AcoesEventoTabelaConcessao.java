package br.edu.ifpr.paranavai.armarios.visao.concessao;


import br.edu.ifpr.paranavai.armarios.modelo.Concessao;
import br.edu.ifpr.paranavai.armarios.servico.ConcessaoServico;
import br.edu.ifpr.paranavai.armarios.utils.MensagemUtil;
import br.edu.ifpr.paranavai.armarios.visao.tabela.acoes.AcoesEventoTabela;
import java.awt.Container;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author Allan Fernando O de Andrade
 */
public class AcoesEventoTabelaConcessao implements AcoesEventoTabela {

    @Override
    public void aoEditar(JTable tabela, int linha) {
        int identificador = (int) tabela.getModel().getValueAt(linha, 0);

        IndexConcessaoPanelUI origem = getOrigem(tabela);

        Concessao concessao = ConcessaoServico.buscarUnicoPorId(identificador);

        JOptionPane.showConfirmDialog(origem, "Implementar Devolução do ID " + concessao);
    }

    @Override
    public void aoExcluir(JTable tabela, int linha) {
        int identificador = (int) tabela.getModel().getValueAt(linha, 0);

        IndexConcessaoPanelUI origem = getOrigem(tabela);

        Concessao concessao = ConcessaoServico.buscarUnicoPorId(identificador);

        String mensagem = MensagemUtil.ESTUDANTE_EXCLUSAO_CONFIRMACAO + " '" + concessao.getId() + "'?";

        int opcao = JOptionPane.showConfirmDialog(origem, mensagem, MensagemUtil.TITULO_ATENCAO, JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);

        if (opcao == 0) {
            try {
                ConcessaoServico.excluir(concessao);
                JOptionPane.showMessageDialog(origem, MensagemUtil.ESTUDANTE_EXCLUSAO_SUCESSO, MensagemUtil.TITULO_INFORMACAO, JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                origem.init();
            }
        }
    }

    @Override
    public void aoVisualizar(JTable tabela, int linha) {
        int identificador = (int) tabela.getModel().getValueAt(linha, 0);

        IndexConcessaoPanelUI origem = getOrigem(tabela);

        Concessao concessao = ConcessaoServico.buscarUnicoPorId(identificador);

        VisualizarConcessaoModalUI form = new VisualizarConcessaoModalUI(origem, concessao);

        form.setLocationRelativeTo(tabela);
        form.setVisible(true);
    }

    private IndexConcessaoPanelUI getOrigem(JTable tabela) {
        IndexConcessaoPanelUI origem = null;
        Container c = tabela.getParent();
        while (c != null) {
            if (c.getParent() instanceof IndexConcessaoPanelUI) {
                origem = (IndexConcessaoPanelUI) c.getParent();
                break;
            } else {
                c = c.getParent();
            }
        }
        return origem;
    }
}
