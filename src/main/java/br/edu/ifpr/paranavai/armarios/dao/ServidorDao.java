package br.edu.ifpr.paranavai.armarios.dao;

import br.edu.ifpr.paranavai.armarios.excecoes.ServidorException;
import br.edu.ifpr.paranavai.armarios.modelo.Servidor;
import java.util.List;

/**
 *
 * @author Allan Fernando O de Andrade
 */
public interface ServidorDao {

    public List<Servidor> buscarTodos();

    public Servidor buscarPorId(Integer inteiro);

    public Servidor atualizar(Servidor servidor) throws ServidorException;

    public void excluir(Servidor servidor) throws ServidorException;

    public Servidor inserir(Servidor servidor) throws ServidorException;

    public Servidor buscarPorEmail(String email);

    public Servidor buscarPorEmailOuSiape(String emailemailOuSiape);
}
