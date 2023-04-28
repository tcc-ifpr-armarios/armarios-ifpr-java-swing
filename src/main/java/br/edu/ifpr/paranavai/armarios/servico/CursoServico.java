package br.edu.ifpr.paranavai.armarios.servico;

import br.edu.ifpr.paranavai.armarios.dao.CursoDao;
import br.edu.ifpr.paranavai.armarios.dao.impl.CursoDaoImpl;
import br.edu.ifpr.paranavai.armarios.excecoes.CursoException;
import br.edu.ifpr.paranavai.armarios.modelo.Curso;
import br.edu.ifpr.paranavai.armarios.utils.MensagemUtil;
import java.util.List;

/**
 *
 * @author Professor Marcelo F. Terenciani
 */
public class CursoServico {

    private static CursoDao dao = new CursoDaoImpl();

    public static Curso inserir(Curso curso) throws CursoException {
        if (curso.getNome() == null || curso.getNome().isEmpty()) {
            throw new CursoException(MensagemUtil.CURSO_CAMPO_OBRIGATORIO);
        }

        Curso c = dao.buscarPorNomeExato(curso.getNome());
        if (c != null) {
            throw new CursoException(MensagemUtil.CURSO_NOME_DUPLICADO);
        }

        return dao.inserir(curso);
    }

    public static void excluir(Curso curso) throws CursoException {
        Curso c = dao.buscarPorId(curso.getId());
        if (c == null) {
            throw new CursoException(MensagemUtil.CURSO_REMOVIDO);
        }
        dao.excluir(curso);
    }

    public static List<Curso> buscarTodos() {
        return dao.buscarTodos();
    }

    public static Curso buscarPorId(Integer id) {
        return dao.buscarPorId(id);
    }

    public static Curso buscarPorNomeExato(String nome) {
        return dao.buscarPorNomeExato(nome);
    }

    public static Curso atualizar(Curso curso) throws CursoException {
        if (curso.getNome() == null || curso.getNome().isEmpty())
            throw new CursoException(MensagemUtil.CURSO_CAMPO_OBRIGATORIO);

        Curso c = dao.buscarPorNomeExatoComIdDiferente(curso.getNome(), curso.getId());
        if (c != null)
            throw new CursoException(MensagemUtil.CURSO_NOME_DUPLICADO);
        
        return dao.atualizar(curso);
    }

}
