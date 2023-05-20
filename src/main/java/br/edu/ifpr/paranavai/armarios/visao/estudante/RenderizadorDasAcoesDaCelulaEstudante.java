package br.edu.ifpr.paranavai.armarios.visao.estudante;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Professor Marcelo Figueiredo Terenciani
 */
public class RenderizadorDasAcoesDaCelulaEstudante extends DefaultTableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component componente = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        PainelAcoesEstudanteUI acoes = new PainelAcoesEstudanteUI();

        if (isSelected == false && row % 2 == 0) {
            acoes.setBackground(Color.white);
        } else {
            acoes.setBackground(componente.getBackground());
        }

        return acoes;

    }

}
