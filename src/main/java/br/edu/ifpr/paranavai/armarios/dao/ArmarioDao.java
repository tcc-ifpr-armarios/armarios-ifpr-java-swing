package br.edu.ifpr.paranavai.armarios.dao;

import java.util.List;

import br.edu.ifpr.paranavai.armarios.excecoes.ArmarioException;
import br.edu.ifpr.paranavai.armarios.modelo.Armario;
import br.edu.ifpr.paranavai.armarios.modelo.StatusArmario;

/**
 *
 * @author suporte
 */
public interface ArmarioDao {

    public List<Armario> buscarTodos();

    public List<Armario> buscarPorStatus(StatusArmario status);

    public Armario buscarPorId(Integer inteiro);

    public Armario atualizar(Armario armario) throws ArmarioException;

    public void excluir(Armario armario) throws ArmarioException;

    public Armario inserir(Armario armario) throws ArmarioException;

    public List<Armario> buscarTodosPorIdLocalizacao(Integer idLocalizacao);

    public List<Armario> buscarAtivoPorIdLocalizacao(Integer idLocalizacao);

    public Armario buscarArmarioPorNumeroELocalizacao(Integer idLocalizacao, String numero);

    public Armario buscarArmarioPorNumeroELocalizacaoComIdDiferente(Integer idLocalizacao, String numero, Integer idArmario);
}
