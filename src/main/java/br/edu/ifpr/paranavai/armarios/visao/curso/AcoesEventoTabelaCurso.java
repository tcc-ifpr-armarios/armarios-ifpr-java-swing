package br.edu.ifpr.paranavai.armarios.visao.curso;

import br.edu.ifpr.paranavai.armarios.controle.CursoControle;
import br.edu.ifpr.paranavai.armarios.excecoes.CursoException;
import br.edu.ifpr.paranavai.armarios.modelo.Curso;
import br.edu.ifpr.paranavai.armarios.servico.CursoServico;
import br.edu.ifpr.paranavai.armarios.utils.MensagemUtil;
import br.edu.ifpr.paranavai.armarios.visao.tabela.acoes.AcoesEventoTabela;
import java.awt.Container;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author Professor Marcelo Figueiredo Terenciani
 */
public class AcoesEventoTabelaCurso implements AcoesEventoTabela {

    @Override
    public void aoEditar(JTable tabela, int linha) {

        int identificador = (int) tabela.getModel().getValueAt(linha, 0);

        IndexCursoPanelUI origem = getOrigem(tabela);

        Curso curso = CursoServico.buscarPorId(identificador);

        CriacaoEdicaoCursoUIModal form = new CriacaoEdicaoCursoUIModal(origem, curso);

        form.setLocationRelativeTo(origem);
        form.setVisible(true);
    }

    @Override
    public void aoExcluir(JTable tabela, int linha) {
        int identificador = (int) tabela.getModel().getValueAt(linha, 0);

        IndexCursoPanelUI origem = getOrigem(tabela);

        Curso curso = CursoServico.buscarPorId(identificador);

        String mensagem = MensagemUtil.CURSO_EXCLUSAO_CONFIRMACAO + " '" + curso.getNome() + "'?";

        int opcao = JOptionPane.showConfirmDialog(origem, mensagem, MensagemUtil.TITULO_ATENCAO, JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);

        if (opcao == 0) {
            try {
                CursoControle.excluir(curso);
                JOptionPane.showMessageDialog(origem, MensagemUtil.CURSO_EXCLUSAO_SUCESSO, MensagemUtil.TITULO_INFORMACAO, JOptionPane.INFORMATION_MESSAGE);
            } catch (CursoException e) {
                JOptionPane.showMessageDialog(origem, e.getMessage(), MensagemUtil.TITULO_ERRO_FATAL, JOptionPane.ERROR_MESSAGE);
            } finally {
                origem.init();
            }
        }
    }

    @Override
    public void aoVisualizar(JTable tabela, int linha) {
        // Operação não necessária, pois há pouca informação.
    }

    private IndexCursoPanelUI getOrigem(JTable tabela) {
        IndexCursoPanelUI origem = null;
        Container c = tabela.getParent();
        while (c != null) {
            if (c.getParent() instanceof IndexCursoPanelUI) {
                origem = (IndexCursoPanelUI) c.getParent();
                break;
            } else {
                c = c.getParent();
            }
        }
        return origem;
    }
}
