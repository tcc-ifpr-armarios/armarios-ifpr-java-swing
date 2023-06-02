package br.edu.ifpr.paranavai.armarios.servico;

import java.util.List;

import br.edu.ifpr.paranavai.armarios.dao.ServidorDao;
import br.edu.ifpr.paranavai.armarios.dao.impl.ServidorDaoImpl;
import br.edu.ifpr.paranavai.armarios.excecoes.ServidorException;
import br.edu.ifpr.paranavai.armarios.modelo.Servidor;

/**
 *
 * @author Allan Fernando O de Andrade
 */
public class ServidorServico {

    private static ServidorDao daoServidor = new ServidorDaoImpl();

    public static List<Servidor> buscarTodos() {
        return daoServidor.buscarTodos();
    }

    public static Servidor buscarUnicoPorId(Integer id) {
        return daoServidor.buscarUnicoPorId(id);
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

    public static Servidor buscarUnicoPorEmail(String email) {
        return daoServidor.buscarUnicoPorEmail(email);
    }

    public static Servidor buscarUnicoPorEmailOuSiape(String emailemailOuSiape) {
        return daoServidor.buscarUnicoPorEmailOuSiape(emailemailOuSiape);
    }
}