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
        // TODO: modificar o atributo do armario para liberado
        return daoEmprestimo.atualizar(emprestimo);
    }

    public static Emprestimo buscarAtivoPorRaDoEstudante(String ra) {
        return daoEmprestimo.buscarAtivoPorRaDoEstudante(ra);
    }

    public static Emprestimo buscarUnicoPorId(int identificador) {
        return daoEmprestimo.buscarUnicoPorId(identificador);
    }

    public static void excluir(Emprestimo emprestimo) throws EmprestimoException {
        daoEmprestimo.excluir(emprestimo);
    }
}
