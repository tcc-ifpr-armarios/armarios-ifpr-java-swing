package br.edu.ifpr.paranavai.armarios.dao;

import java.util.List;

import br.edu.ifpr.paranavai.armarios.excecoes.EmprestimoException;
import br.edu.ifpr.paranavai.armarios.modelo.Emprestimo;

/**
 *
 * @author suporte
 */
public interface EmprestimoDao {

    public Emprestimo atualizar(Emprestimo emprestimo) throws EmprestimoException;

    public Emprestimo buscarAtivoPorRaDoEstudante(String ra);

    public Emprestimo buscarAtivoPorIdArmario(Integer idArmario);

    public List<Emprestimo> buscarAtivosPorIdLocalizacao(Integer idLocalizacao);

    public List<Emprestimo> buscarTodos();

    public List<Emprestimo> buscarTodosPorIdLocalizacao(Integer idLocalizacao);

    public List<Emprestimo> buscarTodosPorRaDoEstudante(String ra);

    public List<Emprestimo> buscarTodosPorIdArmario(Integer idArmario);

    public Emprestimo buscarUnicoPorId(int identificador);

    public void excluir(Emprestimo emprestimo) throws EmprestimoException;

    public Emprestimo inserir(Emprestimo emprestimo) throws EmprestimoException;

}
