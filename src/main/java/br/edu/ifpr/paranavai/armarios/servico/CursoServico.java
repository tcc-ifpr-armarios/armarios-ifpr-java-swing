package br.edu.ifpr.paranavai.armarios.servico;

import br.edu.ifpr.paranavai.armarios.dao.CursoDao;
import br.edu.ifpr.paranavai.armarios.dao.impl.CursoDaoImpl;
import br.edu.ifpr.paranavai.armarios.excecoes.CursoException;
import br.edu.ifpr.paranavai.armarios.modelo.Curso;
import java.util.List;

/**
 *
 * @author Professor Marcelo F. Terenciani
 */
public class CursoServico {
    private static CursoDao dao = new CursoDaoImpl();
    public static Curso inserir(Curso curso) throws CursoException{
        return dao.inserir(curso);
    }    

    public static void excluir(Curso curso) throws CursoException {
        dao.excluir(curso);
    }

    public static List<Curso> buscarTodos() {
        return dao.buscarTodos();
    }

    public static Curso buscarPorId(Integer id) {
        return dao.buscarPorId(id);
    }
}
