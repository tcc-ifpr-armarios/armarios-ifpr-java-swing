package br.edu.ifpr.paranavai.armarios.dao;

import java.util.List;

import br.edu.ifpr.paranavai.armarios.excecoes.ServidorException;
import br.edu.ifpr.paranavai.armarios.modelo.Servidor;

/**
 *
 * @author Allan Fernando O de Andrade
 */
public interface ServidorDao {

    public List<Servidor> buscarTodos();

    public Servidor buscarUnicoPorEmail(String email);

    public Servidor buscarUnicoPorEmailOuSiape(String emailemailOuSiape);

    public Servidor buscarUnicoPorId(Integer inteiro);

    public Servidor atualizar(Servidor servidor) throws ServidorException;

    public void excluir(Servidor servidor) throws ServidorException;

    public Servidor inserir(Servidor servidor) throws ServidorException;

}
