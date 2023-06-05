package br.edu.ifpr.paranavai.armarios.visao.historico;

import br.edu.ifpr.paranavai.armarios.visao.tabela.acoes.AcoesEventoTabela;
import br.edu.ifpr.paranavai.armarios.visao.tabela.acoes.PainelAcoesUI;
import java.awt.Component;

import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JTable;

/**
 *
 * @author Allan Fernando O de Andrade
 */
public class EditorDasAcoesDaCelulaHistoricoUI extends DefaultCellEditor {

    private AcoesEventoTabela evento;

    public EditorDasAcoesDaCelulaHistoricoUI(AcoesEventoTabela evento) {
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
