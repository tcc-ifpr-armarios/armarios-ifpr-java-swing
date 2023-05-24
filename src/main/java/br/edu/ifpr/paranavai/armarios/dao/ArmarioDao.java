package br.edu.ifpr.paranavai.armarios.dao;

import br.edu.ifpr.paranavai.armarios.modelo.Armario;
import br.edu.ifpr.paranavai.armarios.modelo.Estudante;
import br.edu.ifpr.paranavai.armarios.modelo.Localizacao;
import java.util.List;

/**
 *
 * @author suporte
 */
public interface ArmarioDao {

    public List<Armario> buscarTodos();

    public List<Armario> buscarTodosAtivos();

    public Armario buscarPorId(Integer inteiro);

    public void atualizar(Armario armario);

    public void excluir(Armario armario);

    public void inserir(Armario armario);

    public List<Armario> buscarPorEstudante(Estudante estudante);

    public List<Armario> buscarPorLocalizacao(Localizacao localizacao);

    public Armario buscarArmarioPorLocalizacao(Localizacao localizacao, String numero);

    public List<Armario> buscarAtivoPorLocalizacao(Localizacao localizacao);
}
