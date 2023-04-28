package br.edu.ifpr.paranavai.armarios.visao.curso;

import br.edu.ifpr.paranavai.armarios.controle.CursoControle;
import br.edu.ifpr.paranavai.armarios.modelo.Curso;
import br.edu.ifpr.paranavai.armarios.visao.tabela.acoes.AcoesEventoTabela;
import javax.swing.JTable;
import javax.swing.SwingUtilities;

/**
 *
 * @author Professor Marcelo Figueiredo Terenciani
 */
public class AcoesEventoTabelaCurso implements AcoesEventoTabela {

    @Override
    public void aoEditar(JTable tabela, int linha) {

        int identificador = (int) tabela.getModel().getValueAt(linha, 0);
        
        IndexCursoUI indexCursoUI = (IndexCursoUI) SwingUtilities.getWindowAncestor(tabela);
        
        Curso curso = CursoControle.buscarPorId(identificador);

        CriacaoEdicaoCursoUI form = new CriacaoEdicaoCursoUI(indexCursoUI, curso);

        form.setLocationRelativeTo(indexCursoUI);
        form.setVisible(true);
    }

    @Override
    public void aoExcluir(JTable tabela, int linha) {
        System.out.println(".aoExcluir()" + linha);
    }

    @Override
    public void aoVisualizar(JTable tabela, int linha) {
        System.out.println(".aoVisualizar()" + linha);
    }
}
