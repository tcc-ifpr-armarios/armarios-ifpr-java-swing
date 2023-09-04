package br.edu.ifpr.paranavai.armarios.visao.emprestimo;

import br.edu.ifpr.paranavai.armarios.visao.tabela.acoes.AcoesEventoTabelaEmprestimosConcessoes;
import br.edu.ifpr.paranavai.armarios.visao.tabela.acoes.PainelAcoesEmprestimosConcessoesUI;
import java.awt.Component;

import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JTable;

/**
 *
 * @author Professor Marcelo Figueiredo Terenciani
 */
public class EditorDasAcoesDaCelulaTabelaEmprestimo extends DefaultCellEditor {

    private AcoesEventoTabelaEmprestimosConcessoes evento;

    public EditorDasAcoesDaCelulaTabelaEmprestimo(AcoesEventoTabelaEmprestimosConcessoes evento) {
        super(new JCheckBox());
        this.evento = evento;
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        PainelAcoesEmprestimosConcessoesUI acoes = new PainelAcoesEmprestimosConcessoesUI(true, true, true);

        acoes.iniciarEventos(evento, table, row);
        acoes.setBackground(table.getSelectionBackground());

        return acoes;
    }
}
