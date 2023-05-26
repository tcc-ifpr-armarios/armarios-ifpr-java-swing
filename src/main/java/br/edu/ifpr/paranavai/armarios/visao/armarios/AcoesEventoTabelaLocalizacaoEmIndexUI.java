package br.edu.ifpr.paranavai.armarios.visao.armarios;

import br.edu.ifpr.paranavai.armarios.modelo.Emprestimo;

import br.edu.ifpr.paranavai.armarios.servico.EmprestimoServico;
import br.edu.ifpr.paranavai.armarios.visao.tabela.acoes.AcoesEventoTabela;
import java.util.List;
import javax.swing.JTable;
import javax.swing.SwingUtilities;

/**
 *
 * @author Professor Marcelo Figueiredo Terenciani
 */
public class AcoesEventoTabelaLocalizacaoEmIndexUI implements AcoesEventoTabela {

    @Override
    public void aoEditar(JTable tabela, int linha) {

        int identificador = (int) tabela.getModel().getValueAt(0, 0);

        IndexArmariosUI indexArmariosUI = (IndexArmariosUI) SwingUtilities.getWindowAncestor(tabela);

        List<Emprestimo> emprestimo = EmprestimoServico.buscarPorIdLocalizacao(identificador);

        //CriacaoEdicaoLocalizacaoEmArmariosUIModal form = new CriacaoEdicaoLocalizacaoEmArmariosUIModal(indexArmariosUI, localizacao, true);
        //form.setLocationRelativeTo(indexArmariosUI);
        //    form.setVisible(true);
    }

    @Override
    public void aoExcluir(JTable tabela, int linha) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void aoVisualizar(JTable tabela, int linha) {

        int identificador = (int) tabela.getValueAt(linha, 0);
        IndexArmariosUI indexArmariosUI = (IndexArmariosUI) SwingUtilities.getWindowAncestor(tabela);
        ListaArmariosUI armarios = new ListaArmariosUI(indexArmariosUI, identificador);
        armarios.setVisible(true);
        /*String passa =  String.valueOf(identificador);
        System.setProperty("localId", passa);
            java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ListaArmariosUI().setVisible(true);
                
            }

        });*/

    }
}
