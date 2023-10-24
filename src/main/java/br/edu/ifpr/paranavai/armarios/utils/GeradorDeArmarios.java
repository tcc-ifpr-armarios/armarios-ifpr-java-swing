package br.edu.ifpr.paranavai.armarios.utils;

import br.edu.ifpr.paranavai.armarios.excecoes.ArmarioException;
import br.edu.ifpr.paranavai.armarios.modelo.Armario;
import br.edu.ifpr.paranavai.armarios.modelo.Localizacao;
import br.edu.ifpr.paranavai.armarios.modelo.StatusArmario;
import br.edu.ifpr.paranavai.armarios.servico.ArmarioServico;
import br.edu.ifpr.paranavai.armarios.servico.LocalizacaoServico;

/**
 * This is the main class for your program.
 * Author: Allan Fernando
 */
public class GeradorDeArmarios {

    public static void main(String[] args) throws ArmarioException {
      

        
        for (int i = 0; i < 250; i++) {
            geraArmario("ARMARIO/IFTECH-" + i);
        }
    }

    public static void geraArmario(String nome) throws ArmarioException {
      
 // alterar pelo id da localização já cadastradaDF
        Localizacao local = LocalizacaoServico.buscarUnicoPorId(82);
 
        ArmarioServico armarioServ = new ArmarioServico();
        Armario armario = new Armario();
        armario.setLocalizacao(local);
        armario.setNumero(nome);
        armario.setStatus(StatusArmario.ATIVO);
       
        
        try {
            armarioServ.inserir(armario);
        } catch (ArmarioException e) {
            // Handle the exception properly here.
            e.printStackTrace();
        }
    }
}