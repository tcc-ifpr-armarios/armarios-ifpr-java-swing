package br.edu.ifpr.paranavai.armarios.visao.localizacao;

import br.edu.ifpr.paranavai.armarios.visao.tabela.acoes.AcoesEventoTabela;
import java.awt.Component;

import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JTable;

/**
 *
 * @author Professor Marcelo Figueiredo Terenciani
 */
public class EditorDasAcoesDaCelulaLocalizacao extends DefaultCellEditor {

    private AcoesEventoTabela evento;

    public EditorDasAcoesDaCelulaLocalizacao(AcoesEventoTabela evento) {
        super(new JCheckBox());
        this.evento = evento;
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        PainelAcoesLocalizacaoUI acoes = new PainelAcoesLocalizacaoUI();

        acoes.iniciarEventos(evento, table, row);
        acoes.setBackground(table.getSelectionBackground());

        return acoes;
    }
}
