package br.edu.ifpr.paranavai.armarios.visao.historico;

import br.edu.ifpr.paranavai.armarios.modelo.Estudante;
import br.edu.ifpr.paranavai.armarios.servico.EstudanteServico;
import br.edu.ifpr.paranavai.armarios.visao.estudante.VisualizarEstudanteModalUI;
import br.edu.ifpr.paranavai.armarios.visao.tabela.acoes.AcoesEventoTabela;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.SwingUtilities;

/**
 *
 * @author Allan Fernando O de Andrade
 */
public class AcoesEventoTabelaLista implements AcoesEventoTabela {

    @Override
    public void aoVisualizar(JTable tabela, int linha) {
        String identificador = (String) tabela.getValueAt(linha, 4);

        Estudante estudante = EstudanteServico.buscarPorRa(identificador);

        JFrame parent = (JFrame) SwingUtilities.getWindowAncestor(tabela);

        VisualizarEstudanteModalUI form = new VisualizarEstudanteModalUI(parent, estudante);

        form.setVisible(true);

    }

    @Override
    public void aoEditar(JTable tabela, int linha) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void aoExcluir(JTable tabela, int linha) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
