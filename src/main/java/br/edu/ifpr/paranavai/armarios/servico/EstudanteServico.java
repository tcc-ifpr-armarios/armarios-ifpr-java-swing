package br.edu.ifpr.paranavai.armarios.servico;

import br.edu.ifpr.paranavai.armarios.dao.EstudanteDao;
import br.edu.ifpr.paranavai.armarios.dao.impl.EstudanteDaoImpl;
import br.edu.ifpr.paranavai.armarios.excecoes.EstudanteException;
import br.edu.ifpr.paranavai.armarios.modelo.Estudante;
import br.edu.ifpr.paranavai.armarios.utils.MensagemUtil;
import br.edu.ifpr.paranavai.armarios.utils.OperacaoUtil;

import java.util.List;
import javax.swing.JOptionPane;

public class EstudanteServico {

    private static EstudanteDao dao = new EstudanteDaoImpl();

    public static List<Estudante> buscarTodos() {
        return dao.buscarTodos();
    }

    public static Estudante buscarPorId(Integer id) {
        return dao.buscarPorId(id);
    }

    public static Estudante inserir(Estudante estudante) throws EstudanteException {
        verificaCamposObrigatorios(estudante);
        validaCamposRegex(estudante);
        
        Estudante e = dao.buscarPorRa(estudante.getRa());
        if (e != null)
            throw new EstudanteException(MensagemUtil.ESTUDANTE_RA_DUPLICADO);

        return dao.inserir(estudante);
    }

    public static Estudante atualizar(Estudante estudante) throws EstudanteException {
        verificaCamposObrigatorios(estudante);
        validaCamposRegex(estudante);

        Estudante e = dao.buscarPorRaComIdDiferente(estudante.getRa(), estudante.getId());
        if (e != null)
            throw new EstudanteException(MensagemUtil.ESTUDANTE_RA_DUPLICADO);

        return dao.atualizar(estudante);
    }

    public static void excluir(Estudante estudante) throws EstudanteException {
        Estudante c = dao.buscarPorId(estudante.getId());
        if (c == null) {
            throw new EstudanteException(MensagemUtil.ESTUDANTE_REMOVIDO);
        }
        dao.excluir(estudante);
    }

    public static List<Estudante> buscarPorNome(String nome) {
        return dao.buscarPorNome(nome);
    }

    public static Estudante buscarPorRa(String ra) {
        return dao.buscarPorRa(ra);
    }

    public static Estudante buscarPorEmail(String email) {
        return dao.buscarPorEmail(email);
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
        System.out.println("Senha" + estudante.getSenha());
        if (estudante.getCurso() == null || estudante.getCurso().getId() == 0) {
            throw new EstudanteException(MensagemUtil.ESTUDANTE_CAMPO_OBRIGATORIO);
        }
        if (estudante.getTelefone() == null || estudante.getTelefone().isEmpty()) {
            throw new EstudanteException(MensagemUtil.ESTUDANTE_CAMPO_OBRIGATORIO);
        }
    }

    private static void validaCamposRegex(Estudante estudante) throws EstudanteException {
        
        if (!OperacaoUtil.ehEmailValido(estudante.getEmail())){
            throw new EstudanteException(MensagemUtil.EMAIL_INVALIDO);
        }
        if(!OperacaoUtil.ehTelefoneValido(estudante.getTelefone())){
            throw new EstudanteException(MensagemUtil.TELEFONE_INVALIDO);
        }
    }
}