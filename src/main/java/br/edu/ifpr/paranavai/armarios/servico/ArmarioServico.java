package br.edu.ifpr.paranavai.armarios.servico;

import java.util.List;

import br.edu.ifpr.paranavai.armarios.dao.ArmarioDao;
import br.edu.ifpr.paranavai.armarios.dao.impl.ArmarioDaoImpl;
import br.edu.ifpr.paranavai.armarios.excecoes.ArmarioException;
import br.edu.ifpr.paranavai.armarios.modelo.Armario;
import br.edu.ifpr.paranavai.armarios.modelo.StatusArmario;
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

    public static List<Armario> buscarPorStatus(StatusArmario status) {
        return dao.buscarPorStatus(status);
    }

    public static Armario buscarPorId(Integer id) {
        return dao.buscarPorId(id);
    }

    public static Armario inserir(Armario armario) throws ArmarioException {
        verificaCamposObrigatorios(armario);

        //Verifica se já contem o número do armário com base na localização
        Armario a = dao.buscarArmarioPorNumeroELocalizacao(armario.getLocalizacao().getId(), armario.getNumero());
        if (a != null) {
            throw new ArmarioException(MensagemUtil.ARMARIO_JA_CADASTRADO_NA_LOCALIZACAO);
        }

        return dao.inserir(armario);
    }

    public static Armario atualizar(Armario armario) throws ArmarioException {
        verificaCamposObrigatorios(armario);

        //Verifica se já contem o número do armário com base na localização
        Armario a = dao.buscarArmarioPorNumeroELocalizacaoComIdDiferente(armario.getLocalizacao().getId(), armario.getNumero(), armario.getId());
        if (a != null) {
            throw new ArmarioException(MensagemUtil.ARMARIO_JA_CADASTRADO_NA_LOCALIZACAO);
        }

        return dao.atualizar(armario);
    }

    public static void excluir(Armario armario) throws ArmarioException {
        Armario a = dao.buscarPorId(armario.getId());
        if (a == null) {
            throw new ArmarioException(MensagemUtil.ARMARIO_REMOVIDO);
        }
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

    private static void verificaCamposObrigatorios(Armario armario) throws ArmarioException {
        if (armario.getNumero() == null || armario.getNumero().isEmpty()) {
            throw new ArmarioException(MensagemUtil.ARMARIO_CAMPO_OBRIGATORIO);
        }
        if (armario.getLocalizacao() == null || armario.getLocalizacao().getId() == 0) {
            throw new ArmarioException(MensagemUtil.ARMARIO_CAMPO_OBRIGATORIO);
        }
    }
}
