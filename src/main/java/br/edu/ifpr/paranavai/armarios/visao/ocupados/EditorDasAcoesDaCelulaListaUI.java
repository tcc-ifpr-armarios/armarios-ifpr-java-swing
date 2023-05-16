package br.edu.ifpr.paranavai.armarios.visao.ocupados;


import br.edu.ifpr.paranavai.armarios.visao.historico.*;
import br.edu.ifpr.paranavai.armarios.visao.localizacao.*;
import br.edu.ifpr.paranavai.armarios.visao.tabela.acoes.AcoesEventoTabela;
import java.awt.Component;

import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JTable;


/**
 *
 * @author Allan Fernando O de Andrade
 */
public class EditorDasAcoesDaCelulaListaUI extends DefaultCellEditor{

    private AcoesEventoTabela evento;
    private ListaOcupadosUI listaHistoricoUI;
    public EditorDasAcoesDaCelulaListaUI(AcoesEventoTabela evento, ListaOcupadosUI listaHistoricoUI) {
        super(new JCheckBox());
        this.listaHistoricoUI = listaHistoricoUI;
        this.evento = evento;
    }
    
    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        PainelAcoesListaUI acoes = new PainelAcoesListaUI();

        acoes.iniciarEventos(listaHistoricoUI, evento, table, row);
        acoes.setBackground(table.getSelectionBackground());
        
        return acoes;
    }
}
