/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifpr.paranavai.armarios.controle;

import br.edu.ifpr.paranavai.armarios.servico.LoginServico;

/**
 *
 * @author Aluno
 */
public class LoginControlador {

    public static String verificaAdm(String email, String senha) {
        return LoginServico.verificaAdm(email,senha);
    }
    
    public static String verificaAluno(String email, String senha) {
        return LoginServico.verificaAluno(email,senha);
    }
}
