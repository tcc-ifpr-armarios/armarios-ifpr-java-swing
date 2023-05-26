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
public class EditorDasAcoesDaCelulaArmarioEmArmariosUI extends DefaultCellEditor {

    private AcoesEventoTabela evento;
    private ListaArmariosUI listaArmariosUI;
    private int idLocal;

    public EditorDasAcoesDaCelulaArmarioEmArmariosUI(AcoesEventoTabela evento, ListaArmariosUI listaArmariosUI, Integer idLocal) {
        super(new JCheckBox());
        this.idLocal = idLocal;
        this.listaArmariosUI = listaArmariosUI;
        this.listaArmariosUI.getLocalId();
        this.evento = evento;

    }

    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        PainelAcoesEmprestimoEmArmariosUI acoes = new PainelAcoesEmprestimoEmArmariosUI();

        acoes.iniciarEventos(listaArmariosUI, evento, table, row, idLocal);
        acoes.setBackground(table.getSelectionBackground());

        return acoes;
    }
}
