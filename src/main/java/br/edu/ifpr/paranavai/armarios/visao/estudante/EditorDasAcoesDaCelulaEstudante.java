package br.edu.ifpr.paranavai.armarios.visao.estudante;

import br.edu.ifpr.paranavai.armarios.visao.tabela.acoes.AcoesEventoTabela;
import java.awt.Component;

import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JTable;

/**
 *
 * @author Professor Marcelo Figueiredo Terenciani
 */
public class EditorDasAcoesDaCelulaEstudante extends DefaultCellEditor {

    private AcoesEventoTabela evento;
    private IndexEstudanteUI indexEstudanteUI;

    public EditorDasAcoesDaCelulaEstudante(AcoesEventoTabela evento, IndexEstudanteUI indexEstudanteUI) {
        super(new JCheckBox());
        this.indexEstudanteUI = indexEstudanteUI;
        this.evento = evento;
    }
    
    public EditorDasAcoesDaCelulaEstudante(AcoesEventoTabela evento, IndexEstudantePanelUI indexEstudantePanelUI) {
        super(new JCheckBox());
        this.evento = evento;
    }


    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        PainelAcoesEstudanteUI acoes = new PainelAcoesEstudanteUI();

        acoes.iniciarEventos(indexEstudanteUI, evento, table, row);
        acoes.setBackground(table.getSelectionBackground());

        return acoes;
    }
}
