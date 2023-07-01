package br.edu.ifpr.paranavai.armarios.visao.emprestimo;

import br.edu.ifpr.paranavai.armarios.excecoes.ArmarioException;
import br.edu.ifpr.paranavai.armarios.excecoes.EmprestimoException;
import br.edu.ifpr.paranavai.armarios.modelo.Armario;
import br.edu.ifpr.paranavai.armarios.modelo.Emprestimo;
import br.edu.ifpr.paranavai.armarios.modelo.StatusArmario;
import br.edu.ifpr.paranavai.armarios.servico.ArmarioServico;
import br.edu.ifpr.paranavai.armarios.servico.EmprestimoServico;
import br.edu.ifpr.paranavai.armarios.utils.MensagemUtil;
import br.edu.ifpr.paranavai.armarios.visao.tabela.acoes.AcoesEventoTabela;
import java.awt.Container;
import java.util.logging.Level;
import java.util.logging.Logger;
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
        Armario armario = emprestimo.getArmario();
        if(emprestimo.getDataDevolucao() == null){
        int opcao = JOptionPane.showConfirmDialog(origem, MensagemUtil.EMPRESTIMO_CONFIRMA_DEVOLUCAO_SERVIDOR + emprestimo.getArmario().getNumero() + "?");
        if(opcao == 0){
            emprestimo.setDataDevolucao();
            armario.setStatus(StatusArmario.ATIVO);
            try {
                EmprestimoServico.atualizar(emprestimo);
            } catch (EmprestimoException ex) {
                Logger.getLogger(AcoesEventoTabelaEmprestimo.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                ArmarioServico.atualizar(armario);
                
            } catch (ArmarioException ex) {
                Logger.getLogger(AcoesEventoTabelaEmprestimo.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        } else {
            JOptionPane.showMessageDialog(origem, MensagemUtil.EMPRESTIMO_JA_FINALIZADO);
        }
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
