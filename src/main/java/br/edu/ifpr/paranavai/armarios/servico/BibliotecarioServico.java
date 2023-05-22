package br.edu.ifpr.paranavai.armarios.servico;

import br.edu.ifpr.paranavai.armarios.dao.BibliotecarioDao;
import br.edu.ifpr.paranavai.armarios.dao.impl.BibliotecarioDaoImpl;
import br.edu.ifpr.paranavai.armarios.excecoes.BibliotecarioException;
import br.edu.ifpr.paranavai.armarios.modelo.Bibliotecario;
import java.util.List;

/**
 *
 * @author Allan Fernando O de Andrade
 */
public class BibliotecarioServico {

    private static BibliotecarioDao dao = new BibliotecarioDaoImpl();

    public static List<Bibliotecario> buscarTodos() {
        return dao.buscarTodos();
    }

    public static Bibliotecario buscarPorId(Integer id) {
        return dao.buscarPorId(id);
    }

    public static void inserir(Bibliotecario bibliotecario) throws BibliotecarioException {
        dao.inserir(bibliotecario);
    }

    public static void atualizar(Bibliotecario bibliotecario) throws BibliotecarioException {
        dao.atualizar(bibliotecario);
    }

    public static void excluir(Bibliotecario bibliotecario) throws BibliotecarioException {
        dao.excluir(bibliotecario);
    }

    public static Bibliotecario buscarPorEmail(String email) {
        return dao.buscarPorEmail(email);
    }

    public static Bibliotecario buscarPorEmailOuSiape(String emailemailOuSiape) {
        return dao.buscarPorEmailOuSiape(emailemailOuSiape);
    }
}