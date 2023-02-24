package br.edu.ifpr.paranavai.armarios.dao;

import java.util.List;
import br.edu.ifpr.paranavai.armarios.modelo.Estudante;

public interface EstudanteDao {

    public List<Estudante> buscarTodos();

    public Estudante buscarPorId(Integer inteiro);

    public void atualizar(Estudante estudante);

    public void excluir(Estudante estudante);

    public void inserir(Estudante estudante);
    
    public List<Estudante> buscarPorNome (String nomee);
    
    public List<Estudante> buscarPorRa (String ra);
    
    public Estudante buscarPorEmail (String email);
}
