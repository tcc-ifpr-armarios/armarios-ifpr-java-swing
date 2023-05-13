package br.edu.ifpr.paranavai.armarios.visao.armarios;


import br.edu.ifpr.paranavai.armarios.visao.localizacao.*;
import br.edu.ifpr.paranavai.armarios.visao.tabela.acoes.AcoesEventoTabela;
import java.awt.Component;

import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JTable;


/**
 *
 * @author Professor Marcelo Figueiredo Terenciani
 */
public class EditorDasAcoesDaCelulaReservaEmArmariosUI extends DefaultCellEditor{

    private AcoesEventoTabela evento;
    private ListaArmariosUI listaArmariosUI;
    public EditorDasAcoesDaCelulaReservaEmArmariosUI(AcoesEventoTabela evento, ListaArmariosUI listaArmariosUI) {
        super(new JCheckBox());
        this.listaArmariosUI = listaArmariosUI;
        this.evento = evento;
    }
    
    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        PainelAcoesReservasEmArmariosUI acoes = new PainelAcoesReservasEmArmariosUI();

        acoes.iniciarEventos(listaArmariosUI, evento, table, row);
        acoes.setBackground(table.getSelectionBackground());
        
        return acoes;
    }
}
