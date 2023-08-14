/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifpr.paranavai.servico;

import br.edu.ifpr.paranavai.armarios.utils.AutenticacaoUtil;

/**
 *
 * @author Allan Fernando
 */
public class EncriptTest {
   

  public static void main(String args[]) {
        String texto = "123456";
        System.out.println(AutenticacaoUtil.converteSenhaParaSha256Hex(texto));
    }
}
