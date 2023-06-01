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

    private static EmprestimoDao dao = new EmprestimoDaoImpl();

    public static List<Emprestimo> buscarTodos() {
        return dao.buscarTodos();
    }

    public static Emprestimo inserir(Emprestimo emprestimo) throws EmprestimoException {
        return dao.inserir(emprestimo);
    }

    public static List<Emprestimo> buscarPorRaDoEstudante(String ra) {
        return dao.buscarPorRaDoEstudante(ra);
    }

    public static List<Emprestimo> buscarPorIdLocalizacao(Integer idLocalizacao) {
        return dao.buscarPorIdLocalizacao(idLocalizacao);
    }

    public static List<Emprestimo> buscarAtivoPorLocalizacao(int idLocalizacao) {
        return dao.buscarTodos();
    }

    public static Emprestimo finalizarEmprestimo(Emprestimo emprestimo) throws EmprestimoException {
        // TODO: modificar o atributo do armario para liberado
        return dao.atualizar(emprestimo);
    }

    public static Emprestimo buscarEmprestimoAtivoPorRaDoEstudante(String ra) {
        return dao.buscarEmprestimoAtivoPorRaDoEstudante(ra);
    }

    public static Emprestimo buscarPorId(int identificador) {
        return dao.buscarPorId(identificador);
    }

    public static void excluir(Emprestimo emprestimo) throws EmprestimoException {
        dao.excluir(emprestimo);
    }
}
