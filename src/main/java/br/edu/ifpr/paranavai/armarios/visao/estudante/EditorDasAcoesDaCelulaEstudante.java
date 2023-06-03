package br.edu.ifpr.paranavai.armarios.visao.estudante;

import java.awt.Component;

import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JTable;

import br.edu.ifpr.paranavai.armarios.visao.tabela.acoes.AcoesEventoTabela;
import br.edu.ifpr.paranavai.armarios.visao.tabela.acoes.PainelAcoesUI;

/**
 *
 * @author Professor Marcelo Figueiredo Terenciani
 */
public class EditorDasAcoesDaCelulaEstudante extends DefaultCellEditor {

    private AcoesEventoTabela evento;

    public EditorDasAcoesDaCelulaEstudante(AcoesEventoTabela evento) {
        super(new JCheckBox());
        this.evento = evento;
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        PainelAcoesUI acoes = new PainelAcoesUI(true, true, true);

        acoes.iniciarEventos(evento, table, row);
        acoes.setBackground(table.getSelectionBackground());

        return acoes;
    }
}
