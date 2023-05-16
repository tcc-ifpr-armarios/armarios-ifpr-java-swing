package br.edu.ifpr.paranavai.armarios.visao.ocupados;


import br.edu.ifpr.paranavai.armarios.visao.tabela.acoes.AcoesEventoTabela;
import javax.swing.JTable;
import javax.swing.SwingUtilities;

/**
 *
 * @author Allan Fernando O de Andrade
 */
public class AcoesEventoTabelaOcupados implements AcoesEventoTabela {

   

    @Override
    public void aoVisualizar(JTable tabela, int linha) {
        int identificador = (int) tabela.getValueAt(linha, 0);
        IndexOcupadosUI indexOcupadosUI = (IndexOcupadosUI) SwingUtilities.getWindowAncestor(tabela);
        ListaOcupadosUI armarios = new ListaOcupadosUI(indexOcupadosUI, identificador);
        armarios.setVisible(true);
        
        /*String passa =  String.valueOf(identificador);
        System.setProperty("localIdHistorico", passa);
            java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ListaOcupadosUI().setVisible(true);
                
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

    @Override
    public void aoExcluirArmario(JTable tabela, int linha, Integer idLocal) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
