package br.edu.ifpr.paranavai.armarios.visao.estudante;

import br.edu.ifpr.paranavai.armarios.controle.EstudanteControle;
import br.edu.ifpr.paranavai.armarios.modelo.Estudante;
import br.edu.ifpr.paranavai.armarios.utils.MensagemUtil;
import br.edu.ifpr.paranavai.armarios.visao.tabela.acoes.AcoesEventoTabela;
import java.awt.Container;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;

/**
 *
 * @author Professor Marcelo Figueiredo Terenciani
 */
public class AcoesEventoTabelaEstudante implements AcoesEventoTabela {

    @Override
    public void aoEditar(JTable tabela, int linha) {
        int identificador = (int) tabela.getModel().getValueAt(linha, 0);

        IndexEstudantePanelUI origem = getOrigem(tabela);
        
        Estudante curso = EstudanteControle.buscarPorId(identificador);

        CriacaoEdicaoEstudanteUIModal form = new CriacaoEdicaoEstudanteUIModal(origem, curso);

        form.setLocationRelativeTo(origem);
        form.setVisible(true);
    }

    
    @Override
    public void aoExcluir(JTable tabela, int linha) {
        int identificador = (int) tabela.getModel().getValueAt(linha, 0);

        IndexEstudantePanelUI origem = getOrigem(tabela);
        
        Estudante curso = EstudanteControle.buscarPorId(identificador);

        String mensagem = MensagemUtil.ESTUDANTE_EXCLUSAO_CONFIRMACAO + " '" + curso.getNome() + "'?";

        int opcao = JOptionPane.showConfirmDialog(origem, mensagem, MensagemUtil.TITULO_ATENCAO, JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);

        if (opcao == 0) {
            try {
                EstudanteControle.excluir(curso);
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

        IndexEstudantePanelUI origem = getOrigem(tabela);
        
        Estudante estudante = EstudanteControle.buscarPorId(identificador);

        VisualizarEstudanteModalUI form = new VisualizarEstudanteModalUI(origem, estudante);

        form.setLocationRelativeTo(tabela);
        form.setVisible(true);
    }
    
    private IndexEstudantePanelUI getOrigem(JTable tabela) {
        IndexEstudantePanelUI origem = null;
        Container c = tabela.getParent();
        while(c != null){
            if(c.getParent() instanceof IndexEstudantePanelUI){
                origem = (IndexEstudantePanelUI) c.getParent();
                break;
            }else
                c = c.getParent();
        }
        return origem;
    }
}