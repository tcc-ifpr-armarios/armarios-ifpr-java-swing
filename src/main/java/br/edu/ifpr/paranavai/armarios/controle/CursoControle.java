package br.edu.ifpr.paranavai.armarios.controle;

import br.edu.ifpr.paranavai.armarios.excecoes.CursoException;
import br.edu.ifpr.paranavai.armarios.modelo.Curso;
import br.edu.ifpr.paranavai.armarios.servico.CursoServico;
import java.util.List;

/**
 *
 * @author Professor Marcelo Figueiredo Terenciani
 */
public class CursoControle {

    public static List<Curso> listarTodosCursos() {
        return CursoServico.buscarTodos();
    }

    public static Curso inserir(Curso curso) throws CursoException {
        return CursoServico.inserir(curso);
    }

    public static Curso buscarPorId(int idCurso) {
        return CursoServico.buscarPorId(idCurso);
    }

    public static Curso atualizar(Curso curso) throws CursoException {
        return CursoServico.atualizar(curso);
    }

    public static void excluir(Curso curso) throws CursoException {
        CursoServico.excluir(curso);
    }
    
}
