package br.edu.ifpr.paranavai.armarios.dao;

import br.edu.ifpr.paranavai.armarios.excecoes.ArmarioException;
import br.edu.ifpr.paranavai.armarios.modelo.Armario;
import java.util.List;

/**
 *
 * @author suporte
 */
public interface ArmarioDao {

    public List<Armario> buscarTodos();

    public List<Armario> buscarTodosAtivos();

    public Armario buscarPorId(Integer inteiro);

    public Armario atualizar(Armario armario) throws ArmarioException;

    public void excluir(Armario armario) throws ArmarioException;

    public Armario inserir(Armario armario) throws ArmarioException;

    public List<Armario> buscarTodosPorIdLocalizacao(Integer idLocalizacao);

    public List<Armario> buscarAtivoPorIdLocalizacao(Integer idLocalizacao);
}
