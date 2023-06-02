package br.edu.ifpr.paranavai.armarios.visao.armarios;

import br.edu.ifpr.paranavai.armarios.modelo.Armario;
import br.edu.ifpr.paranavai.armarios.servico.ArmarioServico;
import br.edu.ifpr.paranavai.armarios.utils.MensagemUtil;
import br.edu.ifpr.paranavai.armarios.visao.tabela.acoes.AcoesEventoTabela;
import java.awt.Container;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author Allan Fernando O de Andrade
 */
public class AcoesEventoTabelaArmario implements AcoesEventoTabela {

    @Override
    public void aoExcluir(JTable tabela, int linha) {
        int identificador = (int) tabela.getModel().getValueAt(linha, 0);

        IndexArmarioPanelUI origem = getOrigem(tabela);

        String mensagem = MensagemUtil.ARMARIO_EXCLUSAO_CONFIRMACAO + identificador + "?";
        int opcao = JOptionPane.showConfirmDialog(origem, mensagem, MensagemUtil.TITULO_ATENCAO, JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);

        if (opcao == 0) {
            try {
                Armario armario = ArmarioServico.buscarUnicoPorId(identificador);
                ArmarioServico.excluir(armario);
                JOptionPane.showMessageDialog(origem, MensagemUtil.ARMARIO_EXCLUSAO_SUCESSO, MensagemUtil.TITULO_INFORMACAO, JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                origem.init();
            }
        }
    }

    @Override
    public void aoEditar(JTable tabela, int linha) {
        int identificador = (int) tabela.getModel().getValueAt(linha, 0);

        IndexArmarioPanelUI origem = getOrigem(tabela);

        Armario armario = ArmarioServico.buscarUnicoPorId(identificador);

        CriacaoEdicaoArmarioUIModal form = new CriacaoEdicaoArmarioUIModal(origem, armario);

        form.setLocationRelativeTo(origem);
        form.setVisible(true);
    }

    @Override
    public void aoVisualizar(JTable tabela, int linha) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private IndexArmarioPanelUI getOrigem(JTable tabela) {
        IndexArmarioPanelUI origem = null;
        Container c = tabela.getParent();
        while (c != null) {
            if (c.getParent() instanceof IndexArmarioPanelUI) {
                origem = (IndexArmarioPanelUI) c.getParent();
                break;
            } else {
                c = c.getParent();
            }
        }
        return origem;
    }
}
