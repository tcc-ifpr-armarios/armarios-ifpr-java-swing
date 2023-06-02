package br.edu.ifpr.paranavai.armarios.servico;

import java.util.List;

import br.edu.ifpr.paranavai.armarios.dao.EmprestimoDao;
import br.edu.ifpr.paranavai.armarios.dao.EstudanteDao;
import br.edu.ifpr.paranavai.armarios.dao.impl.EmprestimoDaoImpl;
import br.edu.ifpr.paranavai.armarios.dao.impl.EstudanteDaoImpl;
import br.edu.ifpr.paranavai.armarios.excecoes.EstudanteException;
import br.edu.ifpr.paranavai.armarios.modelo.Emprestimo;
import br.edu.ifpr.paranavai.armarios.modelo.Estudante;
import br.edu.ifpr.paranavai.armarios.utils.MensagemUtil;
import br.edu.ifpr.paranavai.armarios.utils.OperacaoUtil;

public class EstudanteServico {

    private static EstudanteDao daoEstudante = new EstudanteDaoImpl();

    public static List<Estudante> buscarTodos() {
        return daoEstudante.buscarTodos();
    }

    public static Estudante buscarUnicoPorId(Integer id) {
        return daoEstudante.buscarUnicoPorId(id);
    }

    public static Estudante inserir(Estudante estudante) throws EstudanteException {
        verificaCamposObrigatorios(estudante);
        validaCamposRegex(estudante);

        Estudante e = daoEstudante.buscarUnicoPorRa(estudante.getRa());
        if (e != null) {
            throw new EstudanteException(MensagemUtil.ESTUDANTE_RA_DUPLICADO);
        }

        return daoEstudante.inserir(estudante);
    }

    public static Estudante atualizar(Estudante estudante) throws EstudanteException {
        verificaCamposObrigatorios(estudante);
        validaCamposRegex(estudante);

        Estudante e = daoEstudante.buscarUnicoPorRaComIdDiferente(estudante.getRa(), estudante.getId());
        if (e != null) {
            throw new EstudanteException(MensagemUtil.ESTUDANTE_RA_DUPLICADO);
        }

        return daoEstudante.atualizar(estudante);
    }

    public static void excluir(Estudante estudante) throws EstudanteException {
        EmprestimoDao emprestimoDao = new EmprestimoDaoImpl();
        Estudante c = daoEstudante.buscarUnicoPorId(estudante.getId());
        if (c == null) {
            throw new EstudanteException(MensagemUtil.ESTUDANTE_REMOVIDO);
        }

        List<Emprestimo> e = emprestimoDao.buscarTodosPorRaDoEstudante(estudante.getRa());
        if (!e.isEmpty()) {
            throw new EstudanteException(MensagemUtil.ESTUDANTE_VINCULADO_EMPRESTIMO);
        }
        daoEstudante.excluir(estudante);
    }

    public static List<Estudante> buscarTodosPorNome(String nome) {
        return daoEstudante.buscarTodosPorNome(nome);
    }

    public static Estudante buscarUnicoPorRa(String ra) {
        return daoEstudante.buscarUnicoPorRa(ra);
    }

    public static Estudante buscarUnicoPorEmail(String email) {
        return daoEstudante.buscarUnicoPorEmail(email);
    }

    private static void verificaCamposObrigatorios(Estudante estudante) throws EstudanteException {
        if (estudante.getNome() == null || estudante.getNome().isEmpty()) {
            throw new EstudanteException(MensagemUtil.ESTUDANTE_CAMPO_OBRIGATORIO);
        }
        if (estudante.getSobrenome() == null || estudante.getSobrenome().isEmpty()) {
            throw new EstudanteException(MensagemUtil.ESTUDANTE_CAMPO_OBRIGATORIO);
        }
        if (estudante.getRa() == null || estudante.getRa().isEmpty()) {
            throw new EstudanteException(MensagemUtil.ESTUDANTE_CAMPO_OBRIGATORIO);
        }
        if (estudante.getEmail() == null || estudante.getEmail().isEmpty()) {
            throw new EstudanteException(MensagemUtil.ESTUDANTE_CAMPO_OBRIGATORIO);
        }
        if (estudante.getSenha() == null || estudante.getSenha().isEmpty()) {
            throw new EstudanteException(MensagemUtil.ESTUDANTE_CAMPO_OBRIGATORIO);
        }
        if (estudante.getCurso() == null || estudante.getCurso().getId() == 0) {
            throw new EstudanteException(MensagemUtil.ESTUDANTE_CAMPO_OBRIGATORIO);
        }
        if (estudante.getTelefone() == null || estudante.getTelefone().isEmpty()) {
            throw new EstudanteException(MensagemUtil.ESTUDANTE_CAMPO_OBRIGATORIO);
        }
    }

    private static void validaCamposRegex(Estudante estudante) throws EstudanteException {

        if (!OperacaoUtil.ehTelefoneValido(estudante.getTelefone())) {
            throw new EstudanteException(MensagemUtil.VALIDACAO_TELEFONE_INVALIDO);
        }
        if (!OperacaoUtil.ehEmailValido(estudante.getEmail())) {
            throw new EstudanteException(MensagemUtil.VALIDACAO_EMAIL_INVALIDO);
        }
    }

    static List<Estudante> buscarAtivos() {
        return daoEstudante.buscarAtivos();
    }
}
