/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifpr.paranavai.armarios.servico;

import br.edu.ifpr.paranavai.armarios.modelo.Bibliotecario;
import br.edu.ifpr.paranavai.armarios.modelo.Estudante;
import br.edu.ifpr.paranavai.armarios.modelo.Login;

/**
 *
 *
 *
 * @author Aluno
 */
public class LoginServico {

    public static String verificaAdm(String email, String senha) {
        String retorno = null;

        Bibliotecario login = BibliotecarioServico.buscarPorEmail(email);

        if (login == null) {
            return "Cadastro não encontrado. Tente novamente!";
        } else {
            if (login.getNome() == null) {
                return "Cadastro não encontrado. Tente novamente!";
            } else if (login.getSenha().equals(senha)) {
                retorno = "Sucesso no login!";

            } else {
                retorno = "Senha inválida!";
            }

            return retorno;
        }
    }

    public static String verificaAluno(String email, String senha) {
        Login logado = new Login();
        Estudante log = EstudanteServico.buscarPorEmail(email);
        if (log == null) {
            return "Cadastro não encontrado. Tente novamente!";
        } else {
            if (log.getNome() == null) {
                return "Cadastro não encontrado. Tente novamente!";
            } else {
                if (log.getSenha().equals(senha)) {
                    logado.setEstudante(log);
                    if (ReservaServico.buscarPorAlunoUnico(log.getId()) != null) {
                    // Aqui chamamos a tela de devolução
                    return "Sucesso no login!";
                    } else {
                    //Tela de emprestimo
                    return "Sucesso no login!!";
                    }
            }
            return "Senha inválida!";
        }
        
    }
}
}
