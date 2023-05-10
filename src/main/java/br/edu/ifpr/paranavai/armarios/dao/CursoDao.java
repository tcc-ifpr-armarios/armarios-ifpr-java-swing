package br.edu.ifpr.paranavai.armarios.dao;

import br.edu.ifpr.paranavai.armarios.excecoes.CursoException;
import br.edu.ifpr.paranavai.armarios.modelo.Curso;

import java.util.List;

/**
 *
 * @author Professor Marcelo F. Terenciani
 */
public interface CursoDao {
    public List<Curso> buscarTodos();

    public Curso buscarPorId(Integer idCurso);

    public Curso buscarPorNomeExato(String nome);

    public Curso buscarPorNomeExatoComIdDiferente(String nome, Integer idCurso);

    public Curso atualizar(Curso curso) throws CursoException;

    public void excluir(Curso curso) throws CursoException;

    public Curso inserir(Curso curso) throws CursoException;

    public List<Curso> buscarTodosAtivos();
}
