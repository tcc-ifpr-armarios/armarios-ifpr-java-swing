package br.edu.ifpr.paranavai.armarios.visao.ocupados;


import br.edu.ifpr.paranavai.armarios.visao.historico.*;
import br.edu.ifpr.paranavai.armarios.visao.localizacao.*;
import br.edu.ifpr.paranavai.armarios.visao.tabela.acoes.AcoesEventoTabela;
import java.awt.Component;

import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JTable;


/**
 *
 * @author Allan Fernando O de Andrade
 */
public class EditorDasAcoesDaCelulaOcupadosUI extends DefaultCellEditor{

    private AcoesEventoTabela evento;
    private IndexOcupadosUI indexHistoricoUI;
    public EditorDasAcoesDaCelulaOcupadosUI(AcoesEventoTabela evento, IndexOcupadosUI indexHistoricoUI) {
        super(new JCheckBox());
        this.indexHistoricoUI = indexHistoricoUI;
        this.evento = evento;
    }
    
    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        PainelAcoesOcupadosUI acoes = new PainelAcoesOcupadosUI();

        acoes.iniciarEventos(indexHistoricoUI, evento, table, row);
        acoes.setBackground(table.getSelectionBackground());
        
        return acoes;
    }
}
