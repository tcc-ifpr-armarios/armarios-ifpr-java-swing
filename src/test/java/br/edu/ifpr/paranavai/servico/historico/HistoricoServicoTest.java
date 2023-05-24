/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifpr.paranavai.servico.historico;

import br.edu.ifpr.paranavai.armarios.modelo.Estudante;
import br.edu.ifpr.paranavai.armarios.modelo.Emprestimo;
import br.edu.ifpr.paranavai.armarios.servico.EstudanteServico;
import br.edu.ifpr.paranavai.armarios.servico.HistoricoServico;
import java.util.List;

/**
 *
 * @author Allan Fernando O de Andrade
 */
public class HistoricoServicoTest {
    public static void main(String[] args) {
    List<Emprestimo> reservas = HistoricoServico.buscarPorLocalizacao(1);
         for(Emprestimo reserva : reservas){
            System.out.println(reserva.getNumero());
            
        }
    }/*
    public static void main(String[] args) {
    Estudante estudante = EstudanteServico.buscarPorRaUnico("101010");
        System.out.println(estudante.getNome());
            
            }*/
}
