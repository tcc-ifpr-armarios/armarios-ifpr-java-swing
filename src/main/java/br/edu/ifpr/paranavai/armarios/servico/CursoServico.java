package br.edu.ifpr.paranavai.armarios.servico;

import br.edu.ifpr.paranavai.armarios.dao.CursoDao;
import br.edu.ifpr.paranavai.armarios.dao.EstudanteDao;
import br.edu.ifpr.paranavai.armarios.dao.impl.CursoDaoImpl;
import br.edu.ifpr.paranavai.armarios.dao.impl.EstudanteDaoImpl;
import br.edu.ifpr.paranavai.armarios.excecoes.CursoException;
import br.edu.ifpr.paranavai.armarios.modelo.Curso;
import br.edu.ifpr.paranavai.armarios.modelo.Estudante;
import br.edu.ifpr.paranavai.armarios.utils.MensagemUtil;
import java.util.List;

/**
 *
 * @author Professor Marcelo F. Terenciani
 */
public class CursoServico {

    private static CursoDao daoCurso = new CursoDaoImpl();

    public static Curso inserir(Curso curso) throws CursoException {
        if (curso.getNome() == null || curso.getNome().isEmpty()) {
            throw new CursoException(MensagemUtil.CURSO_CAMPO_OBRIGATORIO);
        }

        Curso c = daoCurso.buscarUnicoPorNomeExato(curso.getNome());
        if (c != null) {
            throw new CursoException(MensagemUtil.CURSO_NOME_DUPLICADO);
        }

        return daoCurso.inserir(curso);
    }

    public static void excluir(Curso curso) throws CursoException {
        Curso c = daoCurso.buscarUnicoPorId(curso.getId());
        if (c == null) {
            throw new CursoException(MensagemUtil.CURSO_REMOVIDO);
        }

        EstudanteDao estudanteDao = new EstudanteDaoImpl();
        List<Estudante> e = estudanteDao.buscarTodosPorIdCurso(curso.getId());
        if (!e.isEmpty()) {
            throw new CursoException(MensagemUtil.CURSO_VINCULADO_ESTUDANTE);
        }

        daoCurso.excluir(curso);
    }

    public static List<Curso> buscarTodos() {
        return daoCurso.buscarTodos();
    }

    public static Curso buscarPorId(Integer id) {
        return daoCurso.buscarUnicoPorId(id);
    }

    public static Curso buscarPorNomeExato(String nome) {
        return daoCurso.buscarUnicoPorNomeExato(nome);
    }

    public static Curso atualizar(Curso curso) throws CursoException {
        if (curso.getNome() == null || curso.getNome().isEmpty())
            throw new CursoException(MensagemUtil.CURSO_CAMPO_OBRIGATORIO);

        Curso c = daoCurso.buscarUnicoPorNomeExatoComIdDiferente(curso.getNome(), curso.getId());
        if (c != null)
            throw new CursoException(MensagemUtil.CURSO_NOME_DUPLICADO);

        return daoCurso.atualizar(curso);
    }

    public static List<Curso> buscarTodosAtivos() {
        return daoCurso.buscarTodosAtivos();
    }
}