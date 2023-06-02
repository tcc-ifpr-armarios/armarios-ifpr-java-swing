package br.edu.ifpr.paranavai.armarios.servico;

import br.edu.ifpr.paranavai.armarios.dao.impl.EmprestimoDaoImpl;
import br.edu.ifpr.paranavai.armarios.modelo.Emprestimo;
import java.util.List;
import br.edu.ifpr.paranavai.armarios.dao.EmprestimoDao;
import br.edu.ifpr.paranavai.armarios.excecoes.EmprestimoException;

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
        return daoEmprestimo.inserir(emprestimo);
    }

    public static List<Emprestimo> buscarPorRaDoEstudante(String ra) {
        return daoEmprestimo.buscarPorRaDoEstudante(ra);
    }

    public static List<Emprestimo> buscarPorIdLocalizacao(Integer idLocalizacao) {
        return daoEmprestimo.buscarPorIdLocalizacao(idLocalizacao);
    }

    public static List<Emprestimo> buscarAtivoPorLocalizacao(int idLocalizacao) {
        return daoEmprestimo.buscarTodos();
    }

    public static Emprestimo finalizarEmprestimo(Emprestimo emprestimo) throws EmprestimoException {
        // TODO: modificar o atributo do armario para liberado
        return daoEmprestimo.atualizar(emprestimo);
    }

    public static Emprestimo buscarEmprestimoAtivoPorRaDoEstudante(String ra) {
        return daoEmprestimo.buscarEmprestimoAtivoPorRaDoEstudante(ra);
    }

    public static Emprestimo buscarPorId(int identificador) {
        return daoEmprestimo.buscarPorId(identificador);
    }

    public static void excluir(Emprestimo emprestimo) throws EmprestimoException {
        daoEmprestimo.excluir(emprestimo);
    }
}
