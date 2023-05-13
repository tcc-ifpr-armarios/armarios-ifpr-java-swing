/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ifpr.paranavai.servico.reservas;

import br.edu.ifpr.paranavai.armarios.modelo.Reserva;
import br.edu.ifpr.paranavai.armarios.servico.ReservaServico;
import java.util.List;

/**
 *
 * @author Allan Fernando O de Andrade
 */
public class ReservasServicoTest {
    
    
     public static void main(String[] args) {
    // Retorna armarios de cada localização
   /*
        List<ReservaBiblioteca> reservas = ReservaBibliotecaServico.buscarPorLocalizacao(2);
       
        for(ReservaBiblioteca reserva : reservas){
            System.out.println(reserva.getNumero());
            
        }
        
    }
     

        List<ReservaBiblioteca> reservas = ReservaBibliotecaServico.buscarPorAluno(1);
       
        for(ReservaBiblioteca reserva : reservas){
            System.out.println(reserva.getNumero());
            
        }
       */
        Reserva reservas = ReservaServico.buscarNumeroPorLocalizacao(1, 4);
         System.out.println(reservas.getNumero());
    

     }}
