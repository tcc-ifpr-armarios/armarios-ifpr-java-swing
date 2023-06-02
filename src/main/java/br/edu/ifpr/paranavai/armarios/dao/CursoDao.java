package br.edu.ifpr.paranavai.armarios.dao;

import java.util.List;

import br.edu.ifpr.paranavai.armarios.excecoes.CursoException;
import br.edu.ifpr.paranavai.armarios.modelo.Curso;

/**
 *
 * @author Professor Marcelo F. Terenciani
 */
public interface CursoDao {

    public Curso atualizar(Curso curso) throws CursoException;

    public List<Curso> buscarTodos();

    public List<Curso> buscarTodosAtivos();

    public Curso buscarUnicoPorId(Integer idCurso);

    public Curso buscarUnicoPorNomeExato(String nome);

    public Curso buscarUnicoPorNomeExatoComIdDiferente(String nome, Integer idCurso);

    public void excluir(Curso curso) throws CursoException;

    public Curso inserir(Curso curso) throws CursoException;

}
