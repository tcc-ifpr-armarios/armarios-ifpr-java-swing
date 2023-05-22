package br.edu.ifpr.paranavai.armarios.servico;

import br.edu.ifpr.paranavai.armarios.excecoes.LoginException;
import br.edu.ifpr.paranavai.armarios.modelo.Bibliotecario;
import br.edu.ifpr.paranavai.armarios.modelo.Estudante;
import br.edu.ifpr.paranavai.armarios.utils.AutenticacaoUtil;
import br.edu.ifpr.paranavai.armarios.utils.MensagemUtil;

/**
 *
 * @author prof Marcelo Figueiredo Terenciani
 * @author Allan Fernando O de Andrade
 */
public class LoginServico {

    public static Bibliotecario verificaAdm(String emailOuSiape, String senha) throws LoginException {
        String senhaCriptografada = AutenticacaoUtil.converteSenhaParaSha256Hex(senha);

        Bibliotecario bibliotecario = BibliotecarioServico.buscarPorEmailOuSiape(emailOuSiape);
        if (bibliotecario == null) {
            throw new LoginException(MensagemUtil.LOGIN_CADASTRO_INEXISTENTE);
        } else if (!bibliotecario.getSenha().equals(senhaCriptografada)) {
            throw new LoginException(MensagemUtil.LOGIN_SENHA_INCORRETA);
        }
        return bibliotecario;
    }

    public static Estudante verificaEstudante(String ra, String senha) throws LoginException {
        String senhaCriptografada = AutenticacaoUtil.converteSenhaParaSha256Hex(senha);
        Estudante estudante = EstudanteServico.buscarPorRa(ra);

        if (estudante == null) {
            throw new LoginException(MensagemUtil.LOGIN_CADASTRO_INEXISTENTE);
        } else if (!estudante.getSenha().equals(senhaCriptografada)) {
            throw new LoginException(MensagemUtil.LOGIN_SENHA_INCORRETA);
        }
        return estudante;
    }
}
