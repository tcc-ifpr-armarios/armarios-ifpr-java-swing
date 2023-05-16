package br.edu.ifpr.paranavai.armarios.visao.historico;



import br.edu.ifpr.paranavai.armarios.visao.tabela.acoes.AcoesEventoTabela;
import java.awt.Component;

import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JTable;


/**
 *
 * @author Allan Fernando O de Andrade
 */
public class EditorDasAcoesDaCelulaHistoricoUI extends DefaultCellEditor{

    private AcoesEventoTabela evento;
    private IndexHistoricoUI indexHistoricoUI;
    public EditorDasAcoesDaCelulaHistoricoUI(AcoesEventoTabela evento, IndexHistoricoUI indexHistoricoUI) {
        super(new JCheckBox());
        this.indexHistoricoUI = indexHistoricoUI;
        this.evento = evento;
    }
    
    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        PainelAcoesHistoricoUI acoes = new PainelAcoesHistoricoUI();

        acoes.iniciarEventos(indexHistoricoUI, evento, table, row);
        acoes.setBackground(table.getSelectionBackground());
        
        return acoes;
    }
}
