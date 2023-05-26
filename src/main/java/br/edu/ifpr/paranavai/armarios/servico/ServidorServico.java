package br.edu.ifpr.paranavai.armarios.servico;

import br.edu.ifpr.paranavai.armarios.dao.impl.ServidorDaoImpl;
import br.edu.ifpr.paranavai.armarios.excecoes.ServidorException;
import br.edu.ifpr.paranavai.armarios.modelo.Servidor;
import java.util.List;
import br.edu.ifpr.paranavai.armarios.dao.ServidorDao;

/**
 *
 * @author Allan Fernando O de Andrade
 */
public class ServidorServico {

    private static ServidorDao dao = new ServidorDaoImpl();

    public static List<Servidor> buscarTodos() {
        return dao.buscarTodos();
    }

    public static Servidor buscarPorId(Integer id) {
        return dao.buscarPorId(id);
    }

    public static void inserir(Servidor servidor) throws ServidorException {
        dao.inserir(servidor);
    }

    public static void atualizar(Servidor servidor) throws ServidorException {
        dao.atualizar(servidor);
    }

    public static void excluir(Servidor servidor) throws ServidorException {
        dao.excluir(servidor);
    }

    public static Servidor buscarPorEmail(String email) {
        return dao.buscarPorEmail(email);
    }

    public static Servidor buscarPorEmailOuSiape(String emailemailOuSiape) {
        return dao.buscarPorEmailOuSiape(emailemailOuSiape);
    }
}