package br.edu.ifpr.paranavai.armarios.dao;

import java.util.List;

import br.edu.ifpr.paranavai.armarios.excecoes.ConcessaoException;
import br.edu.ifpr.paranavai.armarios.modelo.Concessao;

/**
 *
 * @author Allan Fernando O de Andrade
 */
public interface ConcessaoDao {

    public Concessao atualizar(Concessao concessao) throws ConcessaoException;

    public Concessao buscarAtivoPorSiapeDoServidor(String ra);

    public Concessao buscarAtivoPorIdArmario(Integer idArmario);

    public List<Concessao> buscarAtivosPorIdLocalizacao(Integer idLocalizacao);

    public List<Concessao> buscarTodos();

    public List<Concessao> buscarTodosPorIdLocalizacao(Integer idLocalizacao);

    public List<Concessao> buscarTodosPorSiapeDoServidor(String siape);

    public List<Concessao> buscarTodosPorIdArmario(Integer idArmario);

    public Concessao buscarUnicoPorId(int identificador);

    public void excluir(Concessao concessao) throws ConcessaoException;

    public Concessao inserir(Concessao concessao) throws ConcessaoException;

    public Long quantidadeConcessoesAtivas();

 
}
