package br.edu.ifpr.paranavai.armarios.servico;

import br.edu.ifpr.paranavai.armarios.dao.EmprestimoDao;
import java.util.List;

import br.edu.ifpr.paranavai.armarios.dao.EstudanteDao;
import br.edu.ifpr.paranavai.armarios.dao.impl.EmprestimoDaoImpl;
import br.edu.ifpr.paranavai.armarios.dao.impl.EstudanteDaoImpl;
import br.edu.ifpr.paranavai.armarios.excecoes.ArmarioException;
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

    public static Estudante buscarPorId(Integer id) {
        return daoEstudante.buscarPorId(id);
    }

    public static Estudante inserir(Estudante estudante) throws EstudanteException {
        verificaCamposObrigatorios(estudante);
        validaCamposRegex(estudante);

        Estudante e = daoEstudante.buscarPorRa(estudante.getRa());
        if (e != null) {
            throw new EstudanteException(MensagemUtil.ESTUDANTE_RA_DUPLICADO);
        }

        return daoEstudante.inserir(estudante);
    }

    public static Estudante atualizar(Estudante estudante) throws EstudanteException {
        verificaCamposObrigatorios(estudante);
        validaCamposRegex(estudante);

        Estudante e = daoEstudante.buscarPorRaComIdDiferente(estudante.getRa(), estudante.getId());
        if (e != null) {
            throw new EstudanteException(MensagemUtil.ESTUDANTE_RA_DUPLICADO);
        }

        return daoEstudante.atualizar(estudante);
    }

    public static void excluir(Estudante estudante) throws EstudanteException {
        EmprestimoDao emprestimoDao = new EmprestimoDaoImpl();
        Estudante c = daoEstudante.buscarPorId(estudante.getId());
        if (c == null) {
            throw new EstudanteException(MensagemUtil.ESTUDANTE_REMOVIDO);
        }
        
        List<Emprestimo> e = emprestimoDao.buscarTodosPorRaDoEstudante(estudante.getRa());
        if (!e.isEmpty()) {
            throw new EstudanteException(MensagemUtil.ESTUDANTE_VINCULADO_EMPRESTIMO);
        }
        daoEstudante.excluir(estudante);
    }

    public static List<Estudante> buscarPorNome(String nome) {
        return daoEstudante.buscarPorNome(nome);
    }

    public static Estudante buscarPorRa(String ra) {
        return daoEstudante.buscarPorRa(ra);
    }

    public static Estudante buscarPorEmail(String email) {
        return daoEstudante.buscarPorEmail(email);
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
            throw new EstudanteException(MensagemUtil.TELEFONE_INVALIDO);
        }
        if (!OperacaoUtil.ehEmailValido(estudante.getEmail())) {
            throw new EstudanteException(MensagemUtil.EMAIL_INVALIDO);
        }
    }

    static List<Estudante> buscarAtivos() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
