package br.edu.ifpr.paranavai.armarios.visao.servidor;

import br.edu.ifpr.paranavai.armarios.modelo.Servidor;
import br.edu.ifpr.paranavai.armarios.servico.ServidorServico;
import br.edu.ifpr.paranavai.armarios.utils.MensagemUtil;
import br.edu.ifpr.paranavai.armarios.visao.tabela.acoes.AcoesEventoTabela;
import java.awt.Container;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author Professor Marcelo Figueiredo Terenciani
 */
public class AcoesEventoTabelaServidor implements AcoesEventoTabela {

    @Override
    public void aoEditar(JTable tabela, int linha) {
        int identificador = (int) tabela.getModel().getValueAt(linha, 0);

        IndexServidorPanelUI origem = getOrigem(tabela);
        
        Servidor servidor = ServidorServico.buscarUnicoPorId(identificador);

        CriacaoEdicaoServidorUIModal form = new CriacaoEdicaoServidorUIModal(origem, servidor);

        form.setLocationRelativeTo(origem);
        form.setVisible(true);
    }

    
    @Override
    public void aoExcluir(JTable tabela, int linha) {
        int identificador = (int) tabela.getModel().getValueAt(linha, 0);

        IndexServidorPanelUI origem = getOrigem(tabela);
        
        Servidor servidor = ServidorServico.buscarUnicoPorId(identificador);

        String mensagem = MensagemUtil.SERVIDOR_EXCLUSAO_CONFIRMACAO + " '" + servidor.getNome() + "'?";

        int opcao = JOptionPane.showConfirmDialog(origem, mensagem, MensagemUtil.TITULO_ATENCAO, JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);

        if (opcao == 0) {
            try {
                ServidorServico.excluir(servidor);
                JOptionPane.showMessageDialog(origem, MensagemUtil.SERVIDOR_EXCLUSAO_SUCESSO, MensagemUtil.TITULO_INFORMACAO, JOptionPane.INFORMATION_MESSAGE);
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

        IndexServidorPanelUI origem = getOrigem(tabela);
        
        Servidor servidor = ServidorServico.buscarUnicoPorId(identificador);

        VisualizarServidorModalUI form = new VisualizarServidorModalUI(origem, servidor);

        form.setLocationRelativeTo(tabela);
        form.setVisible(true);
    }
    
    private IndexServidorPanelUI getOrigem(JTable tabela) {
        IndexServidorPanelUI origem = null;
        Container c = tabela.getParent();
        while(c != null){
            if(c.getParent() instanceof IndexServidorPanelUI){
                origem = (IndexServidorPanelUI) c.getParent();
                break;
            }else
                c = c.getParent();
        }
        return origem;
    }
}
