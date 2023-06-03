package br.edu.ifpr.paranavai.armarios.visao.ocupados;

import java.awt.Component;

import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JTable;

import br.edu.ifpr.paranavai.armarios.visao.tabela.acoes.AcoesEventoTabela;
import br.edu.ifpr.paranavai.armarios.visao.tabela.acoes.PainelAcoesUI;

/**
 *
 * @author Allan Fernando O de Andrade
 */
public class EditorDasAcoesDaCelulaListaUI extends DefaultCellEditor {

    private AcoesEventoTabela evento;

    public EditorDasAcoesDaCelulaListaUI(AcoesEventoTabela evento) {
        super(new JCheckBox());
        this.evento = evento;
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        PainelAcoesUI acoes = new PainelAcoesUI(true, false, false);

        acoes.iniciarEventos(evento, table, row);
        acoes.setBackground(table.getSelectionBackground());

        return acoes;
    }
}
