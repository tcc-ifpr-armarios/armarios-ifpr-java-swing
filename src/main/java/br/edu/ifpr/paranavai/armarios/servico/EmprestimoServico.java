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

    public static Emprestimo inserir(Emprestimo historicoBiblioteca) throws EmprestimoException {
        return dao.inserir(historicoBiblioteca);
    }

    public static List<Emprestimo> buscarPorRaDoEstudante(String ra) {
        return dao.buscarPorRaDoEstudante(ra);
    }

    public static List<Emprestimo> buscarPorIdLocalizacao(Integer idLocalizacao) {
        return dao.buscarPorIdLocalizacao(idLocalizacao);
    }
}
