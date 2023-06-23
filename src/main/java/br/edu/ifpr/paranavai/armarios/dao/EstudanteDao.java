package br.edu.ifpr.paranavai.armarios.dao;

import java.util.List;

import br.edu.ifpr.paranavai.armarios.excecoes.EstudanteException;
import br.edu.ifpr.paranavai.armarios.modelo.Estudante;

public interface EstudanteDao {

    public Estudante atualizar(Estudante estudante) throws EstudanteException;

    public List<Estudante> buscarAtivos();

    public List<Estudante> buscarTodos();

    public List<Estudante> buscarTodosPorIdCurso(Integer idCurso);

    public List<Estudante> buscarTodosPorNome(String nome);

    public Estudante buscarUnicoPorEmail(String email);

    public Estudante buscarUnicoPorId(Integer inteiro);

    public Estudante buscarUnicoPorRa(String ra);

    public Estudante buscarUnicoPorRaComIdDiferente(String ra, Integer id);

    public void excluir(Estudante estudante) throws EstudanteException;

    public Estudante inserir(Estudante estudante) throws EstudanteException;

    public List<Estudante> buscarEstudantesPorRa(String ra);

    public Long quantidadeEstudantesAtivos();
}
