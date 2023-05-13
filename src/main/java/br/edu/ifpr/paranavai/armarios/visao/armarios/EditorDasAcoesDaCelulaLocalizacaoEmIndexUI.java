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
public class EditorDasAcoesDaCelulaLocalizacao extends DefaultCellEditor{

    private AcoesEventoTabela evento;
    private IndexLocalizacaoUI indexLocalizacaoUI;
    public EditorDasAcoesDaCelulaLocalizacao(AcoesEventoTabela evento, IndexLocalizacaoUI indexLocalizacaoUI) {
        super(new JCheckBox());
        this.indexLocalizacaoUI = indexLocalizacaoUI;
        this.evento = evento;
    }
    
    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        PainelAcoesLocalizacaoUI acoes = new PainelAcoesLocalizacaoUI();

        acoes.iniciarEventos(indexLocalizacaoUI, evento, table, row);
        acoes.setBackground(table.getSelectionBackground());
        
        return acoes;
    }
}
