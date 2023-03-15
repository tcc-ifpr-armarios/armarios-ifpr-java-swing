/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifpr.teste.servico;

import br.edu.ifpr.paranavai.armarios.modelo.Bibliotecario;
import br.edu.ifpr.paranavai.armarios.modelo.Estudante;
import br.edu.ifpr.paranavai.armarios.modelo.HistoricoSaguao;

import br.edu.ifpr.paranavai.armarios.modelo.ReservaBiblioteca;
import br.edu.ifpr.paranavai.armarios.modelo.ReservaSaguao;
import br.edu.ifpr.paranavai.armarios.servico.BibliotecarioServico;
import br.edu.ifpr.paranavai.armarios.servico.EstudanteServico;
import br.edu.ifpr.paranavai.armarios.servico.HistoricoSaguaoServico;

import br.edu.ifpr.paranavai.armarios.servico.ReservaBibliotecaServico;
import br.edu.ifpr.paranavai.armarios.servico.ReservaSaguaoServico;

import java.util.ArrayList;

import java.util.Date;
import java.util.List;

public class ServicoTeste {

    public static void main(String[] args) {
        /**
         * Localizacao local = new Localizacao("allan");
         * //LocalizacaoServico.inserir(local);
         *
         * Localizacao local1 = new Localizacao( "marcao");
         * //LocalizacaoServico.inserir(local1);
         * LocalizacaoServico.buscarTodos();
         *
         * Estudante aluno = new Estudante();
         *
         * aluno.setNome("diego"); aluno.setEmail("diegogon@gmail.com");
         * aluno.setRa("20202212115"); aluno.setSenha("123456");
         * aluno.setTelefone("21212212");          *
         *
         * List<Localizacao> localizacoes = LocalizacaoServico.buscarTodos();
         * for (Localizacao localizacao : localizacoes) {
         * System.out.println(localizacao.getNome());
        }*
         */
        /**
         * List<Estudante> estudantes = EstudanteServico.buscarTodos(); for
         * (Estudante estudante : estudantes) {
         * System.out.println(estudante.getNome());
         *
         *
         * }
         *
         *
         * Estudante aluno = new Estudante();
         *
         * aluno.setNome("diego"); aluno.setEmail("diegogon@gmail.com");
         * aluno.setRa("20202212115"); aluno.setSenha("123456");
         * aluno.setTelefone("21212212"); EstudanteServico.inserir(aluno);
         *
         *
         *
         * Date data = new Date(); ReservaBiblioteca reserva = new
         * ReservaBiblioteca(); reserva.setEstudante(aluno);
         * reserva.setDataHoraEmprestimo(data);
         * reserva.setData_Hora_Devolucao(data); reserva.setNumero(1);
         * reserva.setAtivo(true); ReservaBibliotecaServico.inserir(reserva);
         *
         *
         *
         *
         * Estudante aluno = new Estudante();
         *
         * aluno.setNome("diego"); aluno.setEmail("diegogon@gmail.com");
         * aluno.setRa("20202212115"); aluno.setSenha("123456");
         * aluno.setTelefone("21212212"); EstudanteServico.inserir(aluno);
         *
         * Estudante aluno = EstudanteServico.buscarPorId(1);
         *
         * List<ReservaBiblioteca> reservas; 
         * reservas = ReservaBibliotecaServico.buscarTodos(); aluno.setReservasB(reservas);
         * 
         * for (ReservaBiblioteca reserva : reservas) {
         * System.out.println(reserva.getNumero()); }
        *
         */
        
        

       


          /**  Date data = new Date();
            ReservaBiblioteca reservaS = new ReservaBiblioteca();
            
            reservaS.setEstudante(aluno);
            reservaS.setDataHoraEmprestimo(data);
            reservaS.setData_Hora_Devolucao(data);
            reservaS.setNumero(7);
            reservaS.setAtivo(true);
         1   ReservaBibliotecaServico.inserir(reservaS);
          
         
            
            
            
            
            System.out.println("to aqui");
            List<ReservaBiblioteca> bi = ReservaBibliotecaServico.buscarPorAluno(1);
            
            for (ReservaBiblioteca reserva : bi) {
                System.out.println("Aqui agora");
            System.out.println(reserva.getNumero());
            }
            
            ReservaSaguaoServico.apagaPorNumero(1);**/
          
          
          
         HistoricoSaguao registro = new HistoricoSaguao();
         
         registro.setId(10);
         registro.setRa("101010");
         HistoricoSaguaoServico.inserir(registro);
        }
        
    
        
       
          
        
    }

