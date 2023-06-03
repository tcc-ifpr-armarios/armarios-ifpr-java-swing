package br.edu.ifpr.paranavai.armarios.visao.curso;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

import br.edu.ifpr.paranavai.armarios.visao.tabela.acoes.PainelAcoesUI;

/**
 *
 * @author Professor Marcelo Figueiredo Terenciani
 */
public class RenderizadorDasAcoesDaCelulaCurso extends DefaultTableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
            int row, int column) {
        Component componente = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        PainelAcoesUI acoes = new PainelAcoesUI(false, true, true);

        if (isSelected == false && row % 2 == 0) {
            acoes.setBackground(Color.white);
        } else {
            acoes.setBackground(componente.getBackground());
        }

        return acoes;

    }

}
