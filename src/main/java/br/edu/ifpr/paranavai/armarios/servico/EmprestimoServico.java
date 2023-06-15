package br.edu.ifpr.paranavai.armarios.servico;

import java.time.LocalDateTime;
import java.util.List;

import br.edu.ifpr.paranavai.armarios.dao.EmprestimoDao;
import br.edu.ifpr.paranavai.armarios.dao.impl.EmprestimoDaoImpl;
import br.edu.ifpr.paranavai.armarios.excecoes.ArmarioException;
import br.edu.ifpr.paranavai.armarios.excecoes.CursoException;
import br.edu.ifpr.paranavai.armarios.excecoes.EmprestimoException;
import br.edu.ifpr.paranavai.armarios.modelo.Armario;
import br.edu.ifpr.paranavai.armarios.modelo.Curso;
import br.edu.ifpr.paranavai.armarios.modelo.Emprestimo;
import br.edu.ifpr.paranavai.armarios.utils.MensagemUtil;

/**
 *
 * @author suporte
 */
public class EmprestimoServico {

    private static EmprestimoDao daoEmprestimo = new EmprestimoDaoImpl();

    public static List<Emprestimo> buscarTodos() {
        return daoEmprestimo.buscarTodos();
    }

    public static Emprestimo inserir(Emprestimo emprestimo) throws EmprestimoException {
        verificaCamposObrigatorios(emprestimo);
        verificaRestricoes(emprestimo);
        return daoEmprestimo.inserir(emprestimo);
    }

    public static List<Emprestimo> buscarTodosPorRaDoEstudante(String ra) {
        return daoEmprestimo.buscarTodosPorRaDoEstudante(ra);
    }

    public static List<Emprestimo> buscarTodosPorIdLocalizacao(Integer idLocalizacao) {
        return daoEmprestimo.buscarTodosPorIdLocalizacao(idLocalizacao);
    }

    public static List<Emprestimo> buscarAtivosPorLocalizacao(int idLocalizacao) {
        return daoEmprestimo.buscarAtivosPorIdLocalizacao(idLocalizacao);
    }

    public static Emprestimo finalizarEmprestimo(Emprestimo emprestimo) throws EmprestimoException {
        Emprestimo e = daoEmprestimo.buscarUnicoPorId(emprestimo.getId());
        if (e != null && e.getDataDevolucao() != null) {
            throw new EmprestimoException(MensagemUtil.EMPRESTIMO_JA_FINALIZADO);
        }

        emprestimo.setDataDevolucao(LocalDateTime.now());
        return daoEmprestimo.atualizar(emprestimo);
    }

    public static Emprestimo buscarAtivoPorRaDoEstudante(String ra) {
        return daoEmprestimo.buscarAtivoPorRaDoEstudante(ra);
    }

    public static Emprestimo buscarUnicoPorId(int identificador) {
        return daoEmprestimo.buscarUnicoPorId(identificador);
    }

    public static void excluir(Emprestimo emprestimo) throws EmprestimoException {
        Emprestimo e = daoEmprestimo.buscarUnicoPorId(emprestimo.getId());
        if (e == null) {
            throw new EmprestimoException(MensagemUtil.EMPRESTIMO_REMOVIDO);
        }
        daoEmprestimo.excluir(emprestimo);
    }

    private static void verificaCamposObrigatorios(Emprestimo emprestimo) throws EmprestimoException {
        if (emprestimo.getEstudante() == null || emprestimo.getEstudante().getId() == 0) {
            throw new EmprestimoException(MensagemUtil.EMPRESTIMO_CAMPO_ESTUDANTE_OBRIGATORIO);
        }
        if (emprestimo.getArmario() == null || emprestimo.getArmario().getId() == 0) {
            throw new EmprestimoException(MensagemUtil.EMPRESTIMO_CAMPO_ARMARIO_OBRIGATORIO);
        }

    }

    private static void verificaRestricoes(Emprestimo emprestimo) throws EmprestimoException {
        Emprestimo e = daoEmprestimo.buscarAtivoPorRaDoEstudante(emprestimo.getEstudante().getRa());
        if (e != null) {
            throw new EmprestimoException(MensagemUtil.EMPRESTIMO_ESTUDANTE_POSSUI_EMPRESTIMO_ATIVO);
        }
    }
}
