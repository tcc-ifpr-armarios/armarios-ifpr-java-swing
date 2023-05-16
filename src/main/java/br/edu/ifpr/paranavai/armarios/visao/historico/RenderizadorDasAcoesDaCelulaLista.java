package br.edu.ifpr.paranavai.armarios.visao.historico;



import br.edu.ifpr.paranavai.armarios.visao.localizacao.*;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Allan Fernando O de Andrade
 */
public class RenderizadorDasAcoesDaCelulaLista extends DefaultTableCellRenderer{

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component componente =  super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        
        PainelAcoesListaUI acoes = new PainelAcoesListaUI();
        
        if(isSelected == false && row % 2 == 0)
            acoes.setBackground(Color.white);
        else 
            acoes.setBackground(componente.getBackground());
        
        return acoes;
        
    }
    
}
