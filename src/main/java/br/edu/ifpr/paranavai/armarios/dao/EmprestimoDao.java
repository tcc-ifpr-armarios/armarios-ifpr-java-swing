package br.edu.ifpr.paranavai.armarios.dao;

import br.edu.ifpr.paranavai.armarios.modelo.Emprestimo;
import br.edu.ifpr.paranavai.armarios.excecoes.EmprestimoException;
import java.util.List;

/**
 *
 * @author suporte
 */
public interface EmprestimoDao {

    public Emprestimo inserir(Emprestimo emprestimo) throws EmprestimoException;

    public Emprestimo atualizar(Emprestimo emprestimo) throws EmprestimoException;
    
    public Emprestimo buscarEmprestimoAtivoPorRaDoEstudante(String ra);
    
    public List<Emprestimo> buscarTodos();

    public List<Emprestimo> buscarPorRaDoEstudante(String ra);

    public List<Emprestimo> buscarPorIdLocalizacao(Integer id_localizacao);
}
