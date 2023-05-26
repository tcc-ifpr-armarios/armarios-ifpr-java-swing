package br.edu.ifpr.paranavai.armarios.visao.armarios;

import br.edu.ifpr.paranavai.armarios.visao.tabela.acoes.AcoesEventoTabela;
import java.awt.Component;

import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JTable;

/**
 *
 * @author Professor Marcelo Figueiredo Terenciani
 */
public class EditorDasAcoesDaCelulaLocalizacaoEmIndexUI extends DefaultCellEditor {

    private AcoesEventoTabela evento;
    private IndexArmariosUI indexArmariosUI;

    public EditorDasAcoesDaCelulaLocalizacaoEmIndexUI(AcoesEventoTabela evento, IndexArmariosUI indexArmariosUI) {
        super(new JCheckBox());
        this.indexArmariosUI = indexArmariosUI;
        this.evento = evento;
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        PainelAcoesLocalizacaoEmIndexUI acoes = new PainelAcoesLocalizacaoEmIndexUI();

        acoes.iniciarEventos(indexArmariosUI, evento, table, row);
        acoes.setBackground(table.getSelectionBackground());

        return acoes;
    }
}
