package br.edu.ifpr.paranavai.armarios.dao;

import br.edu.ifpr.paranavai.armarios.modelo.Emprestimo;
import br.edu.ifpr.paranavai.armarios.modelo.Estudante;
import br.edu.ifpr.paranavai.armarios.modelo.Localizacao;
import java.util.List;

/**
 *
 * @author suporte
 */
public interface EmprestimoDao {

    public void inserir(Emprestimo emprestimo);

    public List<Emprestimo> buscarTodos();

    public List<Emprestimo> buscarPorEstudante(Estudante estudante);

    public List<Emprestimo> buscarPorLocalizacao(Localizacao localizacao);
}
