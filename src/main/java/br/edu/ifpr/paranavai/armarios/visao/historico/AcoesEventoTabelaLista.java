package br.edu.ifpr.paranavai.armarios.visao.historico;


import br.edu.ifpr.paranavai.armarios.modelo.Estudante;
import br.edu.ifpr.paranavai.armarios.servico.EstudanteServico;
import br.edu.ifpr.paranavai.armarios.utils.CarregarAluno;
import br.edu.ifpr.paranavai.armarios.visao.tabela.acoes.AcoesEventoTabela;
import javax.swing.JTable;

/**
 *
 * @author Allan Fernando O de Andrade
 */
public class AcoesEventoTabelaLista implements AcoesEventoTabela {

   

    @Override
    public void aoVisualizar(JTable tabela, int linha) {
        System.out.println(tabela.getValueAt(linha, 4));
        String identificador = (String) tabela.getValueAt(linha, 4);
        System.out.println(identificador);
        
        Estudante estudante = EstudanteServico.buscarPorRaUnico(identificador);
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CarregarAluno(estudante).setVisible(true);
            }
        });
        
    }

    @Override
    public void aoEditar(JTable tabela, int linha) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void aoExcluir(JTable tabela, int linha) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void aoExcluirArmario(JTable tabela, int linha, Integer idLocal) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
