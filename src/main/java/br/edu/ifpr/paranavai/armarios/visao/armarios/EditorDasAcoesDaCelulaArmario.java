package br.edu.ifpr.paranavai.armarios.visao.armarios;

import br.edu.ifpr.paranavai.armarios.visao.tabela.acoes.AcoesEventoTabela;
import br.edu.ifpr.paranavai.armarios.visao.tabela.acoes.PainelAcoesUI;
import java.awt.Component;

import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JTable;

/**
 *
 * @author Professor Marcelo Figueiredo Terenciani
 */
public class EditorDasAcoesDaCelulaArmario extends DefaultCellEditor {

    private AcoesEventoTabela evento;

    public EditorDasAcoesDaCelulaArmario(AcoesEventoTabela evento) {
        super(new JCheckBox());
        this.evento = evento;
    }

    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        PainelAcoesUI acoes = new PainelAcoesUI(false, true, true);

        acoes.iniciarEventos(evento, table, row);
        acoes.setBackground(table.getSelectionBackground());

        return acoes;
    }
}
