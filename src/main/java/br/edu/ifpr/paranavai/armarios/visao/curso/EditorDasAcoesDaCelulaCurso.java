package br.edu.ifpr.paranavai.armarios.visao.curso;

import br.edu.ifpr.paranavai.armarios.visao.tabela.acoes.AcoesEventoTabela;
import java.awt.Component;

import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JTable;


/**
 *
 * @author Professor Marcelo Figueiredo Terenciani
 */
public class EditorDasAcoesDaCelulaCurso extends DefaultCellEditor{

    private AcoesEventoTabela evento;
    private IndexCursoUI indexCursoUI;
    public EditorDasAcoesDaCelulaCurso(AcoesEventoTabela evento, IndexCursoUI indexCursoUI) {
        super(new JCheckBox());
        this.indexCursoUI = indexCursoUI;
        this.evento = evento;
    }
    
    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        PainelAcoesCursoUI acoes = new PainelAcoesCursoUI();

        acoes.iniciarEventos(indexCursoUI, evento, table, row);
        acoes.setBackground(table.getSelectionBackground());
        
        return acoes;
    }
}
