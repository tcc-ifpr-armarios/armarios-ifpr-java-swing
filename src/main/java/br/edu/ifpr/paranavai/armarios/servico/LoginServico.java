package br.edu.ifpr.paranavai.armarios.servico;

import br.edu.ifpr.paranavai.armarios.excecoes.LoginException;
import br.edu.ifpr.paranavai.armarios.modelo.Servidor;
import br.edu.ifpr.paranavai.armarios.modelo.Estudante;
import br.edu.ifpr.paranavai.armarios.utils.AutenticacaoUtil;
import br.edu.ifpr.paranavai.armarios.utils.MensagemUtil;

/**
 *
 * @author prof Marcelo Figueiredo Terenciani
 * @author Allan Fernando O de Andrade
 */
public class LoginServico {

    public static Servidor verificaAdm(String emailOuSiape, String senha) throws LoginException {
        String senhaCriptografada = AutenticacaoUtil.converteSenhaParaSha256Hex(senha);

        Servidor servidor = ServidorServico.buscarPorEmailOuSiape(emailOuSiape);
        if (servidor == null) {
            throw new LoginException(MensagemUtil.LOGIN_CADASTRO_INEXISTENTE);
        } else if (!servidor.getSenha().equals(senhaCriptografada)) {
            throw new LoginException(MensagemUtil.LOGIN_SENHA_INCORRETA);
        }
        return servidor;
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
