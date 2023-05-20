package br.edu.ifpr.paranavai.armarios.visao.historico;

import br.edu.ifpr.paranavai.armarios.visao.tabela.acoes.AcoesEventoTabela;
import javax.swing.JTable;
import javax.swing.SwingUtilities;

/**
 *
 * @author Allan Fernando O de Andrade
 */
public class AcoesEventoTabelaHistorico implements AcoesEventoTabela {

    @Override
    public void aoVisualizar(JTable tabela, int linha) {
        int identificador = (int) tabela.getValueAt(linha, 0);
        System.out.println(identificador);
        IndexHistoricoUI indexHistoricoUI = (IndexHistoricoUI) SwingUtilities.getWindowAncestor(tabela);
        ListaHistoricoUI historicos = new ListaHistoricoUI(indexHistoricoUI, identificador);
        historicos.setVisible(true);
        /* String passa =  String.valueOf(identificador);
        System.setProperty("localIdHistorico", passa);
            java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ListaHistoricoUI().setVisible(true);
                
            }

        });*/

    }

    @Override
    public void aoEditar(JTable tabela, int linha) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void aoExcluir(JTable tabela, int linha) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
