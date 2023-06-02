package br.edu.ifpr.paranavai.armarios.servico;

import java.util.List;

import br.edu.ifpr.paranavai.armarios.dao.ArmarioDao;
import br.edu.ifpr.paranavai.armarios.dao.EmprestimoDao;
import br.edu.ifpr.paranavai.armarios.dao.impl.ArmarioDaoImpl;
import br.edu.ifpr.paranavai.armarios.dao.impl.EmprestimoDaoImpl;
import br.edu.ifpr.paranavai.armarios.excecoes.ArmarioException;
import br.edu.ifpr.paranavai.armarios.excecoes.CursoException;
import br.edu.ifpr.paranavai.armarios.modelo.Armario;
import br.edu.ifpr.paranavai.armarios.modelo.Emprestimo;
import br.edu.ifpr.paranavai.armarios.modelo.StatusArmario;
import br.edu.ifpr.paranavai.armarios.utils.MensagemUtil;

/**
 *
 * @author suporte
 */
public class ArmarioServico {

    private static ArmarioDao daoArmario = new ArmarioDaoImpl();

    public static List<Armario> buscarTodos() {
        return daoArmario.buscarTodos();
    }

    public static List<Armario> buscarPorStatus(StatusArmario status) {
        return daoArmario.buscarTodosPorStatus(status);
    }

    public static Armario buscarPorId(Integer id) {
        return daoArmario.buscarUnicoPorId(id);
    }

    public static Armario inserir(Armario armario) throws ArmarioException {
        verificaCamposObrigatorios(armario);

        //Verifica se já contem o número do armário com base na localização
        Armario a = daoArmario.buscarUnicoPorNumeroELocalizacao(armario.getLocalizacao().getId(), armario.getNumero());
        if (a != null) {
            throw new ArmarioException(MensagemUtil.ARMARIO_JA_CADASTRADO_NA_LOCALIZACAO);
        }

        return daoArmario.inserir(armario);
    }

    public static Armario atualizar(Armario armario) throws ArmarioException {
        verificaCamposObrigatorios(armario);

        //Verifica se já contem o número do armário com base na localização
        Armario a = daoArmario.buscarUnicoPorNumeroELocalizacaoComIdDiferente(armario.getLocalizacao().getId(), armario.getNumero(), armario.getId());
        if (a != null) {
            throw new ArmarioException(MensagemUtil.ARMARIO_JA_CADASTRADO_NA_LOCALIZACAO);
        }

        return daoArmario.atualizar(armario);
    }

    public static void excluir(Armario armario) throws ArmarioException {
        EmprestimoDao emprestimoDao = new EmprestimoDaoImpl();
        Armario a = daoArmario.buscarUnicoPorId(armario.getId());
        if (a == null) {
            throw new ArmarioException(MensagemUtil.ARMARIO_REMOVIDO);
        }
        
        List<Emprestimo> e = emprestimoDao.buscarPorIdArmario(armario.getId());
        if (!e.isEmpty()) {
            throw new ArmarioException(MensagemUtil.ARMARIO_VINCULADO_EMPRESTIMO);
        }
        
        daoArmario.excluir(armario);
    }

    public static List<Armario> buscarTodosPorIdLocalizacao(Integer idLocalizacao) {
        return daoArmario.buscarTodosPorIdLocalizacao(idLocalizacao);
    }

    public static Armario buscarArmarioPorNumeroELocalizacao(Integer idLocal, String numero) {
        return daoArmario.buscarUnicoPorNumeroELocalizacao(idLocal, numero);
    }

    public static List<Armario> buscarAtivoPorIdLocalizacao(Integer idLocalizacao) {
        return daoArmario.buscarAtivosPorIdLocalizacao(idLocalizacao);
    }

    private static void verificaCamposObrigatorios(Armario armario) throws ArmarioException {
        if (armario.getNumero() == null || armario.getNumero().isEmpty()) {
            throw new ArmarioException(MensagemUtil.ARMARIO_CAMPO_OBRIGATORIO);
        }
        if (armario.getLocalizacao() == null || armario.getLocalizacao().getId() == 0) {
            throw new ArmarioException(MensagemUtil.ARMARIO_CAMPO_OBRIGATORIO);
        }
        if (armario.getStatus() == null) {
            throw new ArmarioException(MensagemUtil.ARMARIO_CAMPO_OBRIGATORIO);
        }
    }
}
