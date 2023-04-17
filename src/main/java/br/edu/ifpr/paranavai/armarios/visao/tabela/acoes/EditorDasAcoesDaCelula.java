package br.edu.ifpr.paranavai.armarios.visao.tabela.acoes;

import java.awt.Component;
import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JTable;

/**
 *
 * @author Professor Marcelo Figueiredo Terenciani
 */
public class EditorDasAcoesDaCelula extends DefaultCellEditor{

    private AcoesEventoTabela evento;
    
    public EditorDasAcoesDaCelula(AcoesEventoTabela evento) {
        super(new JCheckBox());
        this.evento = evento;
    }
    
    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        PanelAcoes acoes = new PanelAcoes();
        acoes.iniciarEventos(evento, row);
        acoes.setBackground(table.getSelectionBackground());
        return acoes;
    }
}
