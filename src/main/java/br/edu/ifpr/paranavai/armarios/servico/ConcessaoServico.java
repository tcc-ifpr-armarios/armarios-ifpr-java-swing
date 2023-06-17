package br.edu.ifpr.paranavai.armarios.servico;


import java.util.List;

import br.edu.ifpr.paranavai.armarios.dao.impl.ConcessaoDaoImpl;

import br.edu.ifpr.paranavai.armarios.excecoes.ConcessaoException;
import br.edu.ifpr.paranavai.armarios.modelo.Concessao;
import br.edu.ifpr.paranavai.armarios.utils.MensagemUtil;
import br.edu.ifpr.paranavai.armarios.dao.ConcessaoDao;

/**
 *
 * @author Allan Fernando O de Andrade
 */
public class ConcessaoServico {

    private static ConcessaoDao daoConcessao = new ConcessaoDaoImpl();

    public static List<Concessao> buscarTodos() {
        return daoConcessao.buscarTodos();
    }

    public static Concessao inserir(Concessao concessao) throws ConcessaoException {
        verificaCamposObrigatorios(concessao);
        verificaRestricoes(concessao);
        return daoConcessao.inserir(concessao);
    }

    public static List<Concessao> buscarTodosPorSiapeDoServidor(String siape) {
        return daoConcessao.buscarTodosPorSiapeDoServidor(siape);
    }

    public static List<Concessao> buscarTodosPorIdLocalizacao(Integer idLocalizacao) {
        return daoConcessao.buscarTodosPorIdLocalizacao(idLocalizacao);
    }

    public static List<Concessao> buscarAtivosPorLocalizacao(int idLocalizacao) {
        return daoConcessao.buscarAtivosPorIdLocalizacao(idLocalizacao);
    }

    public static Concessao finalizarConcessao(Concessao concessao) throws ConcessaoException {
        Concessao e = daoConcessao.buscarUnicoPorId(concessao.getId());
        if (e != null && e.getDataDevolucao() != null) {
            throw new ConcessaoException(MensagemUtil.EMPRESTIMO_JA_FINALIZADO);
        }

        concessao.setDataDevolucao();
        return daoConcessao.atualizar(concessao);
    }

    public static Concessao buscarAtivoPorSiapeDoServidor(String siape) {
        return daoConcessao.buscarAtivoPorSiapeDoServidor(siape);
    }

    public static Concessao buscarUnicoPorId(int identificador) {
        return daoConcessao.buscarUnicoPorId(identificador);
    }

    public static void excluir(Concessao concessao) throws ConcessaoException {
        Concessao e = daoConcessao.buscarUnicoPorId(concessao.getId());
        if (e == null) {
            throw new ConcessaoException(MensagemUtil.EMPRESTIMO_REMOVIDO);
        }
        daoConcessao.excluir(concessao);
    }
    public static Concessao atualizar(Concessao concessao) throws ConcessaoException {
        return daoConcessao.atualizar(concessao);
    }
    

    private static void verificaCamposObrigatorios(Concessao concessao) throws ConcessaoException {
        if (concessao.getServidor() == null || concessao.getServidor().getId() == 0) {
            throw new ConcessaoException(MensagemUtil.EMPRESTIMO_CAMPO_ESTUDANTE_OBRIGATORIO);
        }
        if (concessao.getArmario() == null || concessao.getArmario().getId() == 0) {
            throw new ConcessaoException(MensagemUtil.EMPRESTIMO_CAMPO_ARMARIO_OBRIGATORIO);
        }

    }

    private static void verificaRestricoes(Concessao concessao) throws ConcessaoException {
        Concessao e = daoConcessao.buscarAtivoPorSiapeDoServidor(concessao.getServidor().getSiape());
        if (e != null) {
            throw new ConcessaoException(MensagemUtil.EMPRESTIMO_ESTUDANTE_POSSUI_EMPRESTIMO_ATIVO);
        }

        e = daoConcessao.buscarAtivoPorIdArmario(concessao.getArmario().getId());
        if (e != null) {
            throw new ConcessaoException(MensagemUtil.EMPRESTIMO_ARMARIO_POSSUI_EMPRESTIMO_ATIVO);
        }
    }
}
