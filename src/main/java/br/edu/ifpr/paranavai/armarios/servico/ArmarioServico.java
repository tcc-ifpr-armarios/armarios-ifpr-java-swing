package br.edu.ifpr.paranavai.armarios.servico;

import br.edu.ifpr.paranavai.armarios.dao.impl.ArmarioDaoImpl;
import br.edu.ifpr.paranavai.armarios.excecoes.ArmarioException;
import br.edu.ifpr.paranavai.armarios.modelo.Armario;
import java.util.List;
import br.edu.ifpr.paranavai.armarios.dao.ArmarioDao;
import br.edu.ifpr.paranavai.armarios.utils.MensagemUtil;

/**
 *
 * @author suporte
 */
public class ArmarioServico {

    private static ArmarioDao dao = new ArmarioDaoImpl();

    public static List<Armario> buscarTodos() {
        return dao.buscarTodos();
    }

    public static List<Armario> buscarTodosAtivos() {
        return dao.buscarTodosAtivos();
    }

    public static Armario buscarPorId(Integer id) {
        return dao.buscarPorId(id);
    }

    public static Armario inserir(Armario armario) throws ArmarioException {
        //Verifica se já contem o número do armário com base na localização
        Armario c = dao.buscarArmarioPorNumeroELocalizacao(armario.getLocalizacao().getId(), armario.getNumero());
        if (c != null) {
            throw new ArmarioException(MensagemUtil.ARMARIO_JA_CADASTRADO_NA_LOCALIZACAO);
        }

        return dao.inserir(armario);
    }

    public static Armario atualizar(Armario armario) throws ArmarioException {
        return dao.atualizar(armario);
    }

    public static void excluir(Armario armario) throws ArmarioException {
        dao.excluir(armario);
    }

    public static List<Armario> buscarTodosPorIdLocalizacao(Integer idLocalizacao) {
        return dao.buscarTodosPorIdLocalizacao(idLocalizacao);
    }

    public static Armario buscarArmarioPorNumeroELocalizacao(Integer idLocal, String numero) {
        return dao.buscarArmarioPorNumeroELocalizacao(idLocal, numero);
    }

    public static List<Armario> buscarAtivoPorIdLocalizacao(Integer idLocalizacao) {
        return dao.buscarAtivoPorIdLocalizacao(idLocalizacao);
    }
}
