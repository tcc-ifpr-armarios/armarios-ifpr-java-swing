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

    private static ServidorDao daoServidor = new ServidorDaoImpl();

    public static List<Servidor> buscarTodos() {
        return daoServidor.buscarTodos();
    }

    public static Servidor buscarPorId(Integer id) {
        return daoServidor.buscarPorId(id);
    }

    public static void inserir(Servidor servidor) throws ServidorException {
        daoServidor.inserir(servidor);
    }

    public static void atualizar(Servidor servidor) throws ServidorException {
        daoServidor.atualizar(servidor);
    }

    public static void excluir(Servidor servidor) throws ServidorException {
        daoServidor.excluir(servidor);
    }

    public static Servidor buscarPorEmail(String email) {
        return daoServidor.buscarPorEmail(email);
    }

    public static Servidor buscarPorEmailOuSiape(String emailemailOuSiape) {
        return daoServidor.buscarPorEmailOuSiape(emailemailOuSiape);
    }
}