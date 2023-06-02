package br.edu.ifpr.paranavai.armarios.visao.historico;

import br.edu.ifpr.paranavai.armarios.modelo.Estudante;
import br.edu.ifpr.paranavai.armarios.servico.EstudanteServico;
import br.edu.ifpr.paranavai.armarios.visao.estudante.IndexEstudantePanelUI;
import br.edu.ifpr.paranavai.armarios.visao.estudante.VisualizarEstudanteModalUI;
import br.edu.ifpr.paranavai.armarios.visao.tabela.acoes.AcoesEventoTabela;
import java.awt.Container;
import javax.swing.JTable;

/**
 *
 * @author Allan Fernando O de Andrade
 */
public class AcoesEventoTabelaLista implements AcoesEventoTabela {

    @Override
    public void aoVisualizar(JTable tabela, int linha) {
        String identificador = (String) tabela.getValueAt(linha, 4);

        Estudante estudante = EstudanteServico.buscarUnicoPorRa(identificador);
        
        IndexEstudantePanelUI origem = getOrigem(tabela);

        VisualizarEstudanteModalUI form = new VisualizarEstudanteModalUI(origem, estudante);

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
    
    private IndexEstudantePanelUI getOrigem(JTable tabela) {
        IndexEstudantePanelUI origem = null;
        Container c = tabela.getParent();
        while (c != null) {
            if (c.getParent() instanceof IndexEstudantePanelUI) {
                origem = (IndexEstudantePanelUI) c.getParent();
                break;
            } else {
                c = c.getParent();
            }
        }
        return origem;
    }
}
