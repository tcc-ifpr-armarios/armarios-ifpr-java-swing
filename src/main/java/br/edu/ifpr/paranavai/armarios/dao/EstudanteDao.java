package br.edu.ifpr.paranavai.armarios.dao;

import java.util.List;

import br.edu.ifpr.paranavai.armarios.excecoes.EstudanteException;
import br.edu.ifpr.paranavai.armarios.modelo.Estudante;

public interface EstudanteDao {

    public List<Estudante> buscarTodos();

    public Estudante buscarPorId(Integer inteiro);    
    
    public List<Estudante> buscarPorNome (String nomee);
    
    public List<Estudante> buscarPorRa (String ra);
    
    public Estudante buscarPorEmail (String email);

    public Estudante buscarPorTelefone (String telefone);

    public Estudante atualizar(Estudante estudante);

    public void excluir(Estudante estudante)  throws EstudanteException;

    public Estudante inserir(Estudante estudante);
}
