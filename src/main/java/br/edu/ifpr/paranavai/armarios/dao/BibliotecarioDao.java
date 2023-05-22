package br.edu.ifpr.paranavai.armarios.dao;

import br.edu.ifpr.paranavai.armarios.excecoes.BibliotecarioException;
import br.edu.ifpr.paranavai.armarios.modelo.Bibliotecario;
import java.util.List;

/**
 *
 * @author Allan Fernando O de Andrade
 */
public interface BibliotecarioDao {

    public List<Bibliotecario> buscarTodos();

    public Bibliotecario buscarPorId(Integer inteiro);

    public Bibliotecario atualizar(Bibliotecario bibliotecario) throws BibliotecarioException;

    public void excluir(Bibliotecario bibliotecario) throws BibliotecarioException;

    public Bibliotecario inserir(Bibliotecario bibliotecario) throws BibliotecarioException;

    public Bibliotecario buscarPorEmail(String email);

    public Bibliotecario buscarPorEmailOuSiape(String emailemailOuSiape);
}
