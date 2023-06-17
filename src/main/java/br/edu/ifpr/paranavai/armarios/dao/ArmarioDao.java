package br.edu.ifpr.paranavai.armarios.dao;

import java.util.List;

import br.edu.ifpr.paranavai.armarios.excecoes.ArmarioException;
import br.edu.ifpr.paranavai.armarios.modelo.Armario;
import br.edu.ifpr.paranavai.armarios.modelo.StatusArmario;

/**
 *
 * @author Allan Fernando O de Andrade
 */
public interface ArmarioDao {

    public Armario atualizar(Armario armario) throws ArmarioException;

    public List<Armario> buscarAtivosPorIdLocalizacao(Integer idLocalizacao);

    public List<Armario> buscarTodos();

    public List<Armario> buscarTodosPorIdLocalizacao(Integer idLocalizacao);

    public List<Armario> buscarTodosPorStatus(StatusArmario status);

    public Armario buscarUnicoPorId(Integer inteiro);

    public Armario buscarUnicoPorNumeroELocalizacao(Integer idLocalizacao, String numero);

    public Armario buscarUnicoPorNumeroELocalizacaoComIdDiferente(Integer idLocalizacao, String numero,
            Integer idArmario);

    public void excluir(Armario armario) throws ArmarioException;

    public Armario inserir(Armario armario) throws ArmarioException;
    
     public List<Armario> buscarPorStatusIdLocalizacao(Integer idLocalizacao, StatusArmario status);
}
