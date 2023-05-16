package br.edu.ifpr.paranavai.armarios.visao.curso;

import br.edu.ifpr.paranavai.armarios.controle.CursoControle;
import br.edu.ifpr.paranavai.armarios.modelo.Curso;
import br.edu.ifpr.paranavai.armarios.utils.MensagemUtil;
import br.edu.ifpr.paranavai.armarios.visao.tabela.acoes.AcoesEventoTabela;
import javax.swing.JOptionPane;
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

        CriacaoEdicaoCursoUIModal form = new CriacaoEdicaoCursoUIModal(indexCursoUI, curso, true);

        form.setLocationRelativeTo(indexCursoUI);
        form.setVisible(true);
    }

    @Override
    public void aoExcluir(JTable tabela, int linha) {
        int identificador = (int) tabela.getModel().getValueAt(linha, 0);

        IndexCursoUI indexCursoUI = (IndexCursoUI) SwingUtilities.getWindowAncestor(tabela);

        Curso curso = CursoControle.buscarPorId(identificador);

        String mensagem = MensagemUtil.CURSO_EXCLUSAO_CONFIRMACAO + " '" + curso.getNome() + "'?";

        int opcao = JOptionPane.showConfirmDialog(indexCursoUI, mensagem, MensagemUtil.TITULO_ATENCAO, JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);

        if (opcao == 0) {
            try {
                CursoControle.excluir(curso);
                JOptionPane.showMessageDialog(indexCursoUI, MensagemUtil.CURSO_EXCLUSAO_SUCESSO, MensagemUtil.TITULO_INFORMACAO, JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                indexCursoUI.init();
            }
        }
    }

    @Override
    public void aoVisualizar(JTable tabela, int linha) {
        int identificador = (int) tabela.getModel().getValueAt(linha, 0);

        IndexCursoUI indexCursoUI = (IndexCursoUI) SwingUtilities.getWindowAncestor(tabela);

        Curso curso = CursoControle.buscarPorId(identificador);
        
        CriacaoEdicaoCursoUIModal form = new CriacaoEdicaoCursoUIModal(indexCursoUI, curso, false);

        form.setLocationRelativeTo(indexCursoUI);
        form.setVisible(true);
        
    }

    @Override
    public void aoExcluirArmario(JTable tabela, int linha, Integer idLocal) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
