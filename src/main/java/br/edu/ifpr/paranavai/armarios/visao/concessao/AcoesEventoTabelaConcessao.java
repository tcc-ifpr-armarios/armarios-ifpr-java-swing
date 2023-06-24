package br.edu.ifpr.paranavai.armarios.visao.emprestimo;

import br.edu.ifpr.paranavai.armarios.modelo.Emprestimo;
import br.edu.ifpr.paranavai.armarios.servico.EmprestimoServico;
import br.edu.ifpr.paranavai.armarios.utils.MensagemUtil;
import br.edu.ifpr.paranavai.armarios.visao.tabela.acoes.AcoesEventoTabela;
import java.awt.Container;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author Professor Marcelo Figueiredo Terenciani
 */
public class AcoesEventoTabelaEmprestimo implements AcoesEventoTabela {

    @Override
    public void aoEditar(JTable tabela, int linha) {
        int identificador = (int) tabela.getModel().getValueAt(linha, 0);

        IndexEmprestimoPanelUI origem = getOrigem(tabela);

        Emprestimo emprestimo = EmprestimoServico.buscarUnicoPorId(identificador);

        JOptionPane.showConfirmDialog(origem, "Implementar Devolução do ID " + emprestimo);
    }

    @Override
    public void aoExcluir(JTable tabela, int linha) {
        int identificador = (int) tabela.getModel().getValueAt(linha, 0);

        IndexEmprestimoPanelUI origem = getOrigem(tabela);

        Emprestimo emprestimo = EmprestimoServico.buscarUnicoPorId(identificador);

        String mensagem = MensagemUtil.ESTUDANTE_EXCLUSAO_CONFIRMACAO + " '" + emprestimo.getId() + "'?";

        int opcao = JOptionPane.showConfirmDialog(origem, mensagem, MensagemUtil.TITULO_ATENCAO, JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);

        if (opcao == 0) {
            try {
                EmprestimoServico.excluir(emprestimo);
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

        IndexEmprestimoPanelUI origem = getOrigem(tabela);

        Emprestimo emprestimo = EmprestimoServico.buscarUnicoPorId(identificador);

        VisualizarEmprestimoModalUI form = new VisualizarEmprestimoModalUI(origem, emprestimo);

        form.setLocationRelativeTo(tabela);
        form.setVisible(true);
    }

    private IndexEmprestimoPanelUI getOrigem(JTable tabela) {
        IndexEmprestimoPanelUI origem = null;
        Container c = tabela.getParent();
        while (c != null) {
            if (c.getParent() instanceof IndexEmprestimoPanelUI) {
                origem = (IndexEmprestimoPanelUI) c.getParent();
                break;
            } else {
                c = c.getParent();
            }
        }
        return origem;
    }
}
