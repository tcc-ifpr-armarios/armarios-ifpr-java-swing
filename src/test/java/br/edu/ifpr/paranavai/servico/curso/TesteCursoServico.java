/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifpr.paranavai.servico.curso;

import br.edu.ifpr.paranavai.armarios.servico.CursoServico;
import br.edu.ifpr.paranavai.armarios.modelo.Curso;
import br.edu.ifpr.paranavai.armarios.conexao.HibernateUtilTeste;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 *
 * @author teren
 */
public class TesteCursoServico {
    // private CursoServico cursoServico;
    private static SessionFactory sessionFactory;
    private Session session;
     
    @BeforeAll
    public static void inicializar() {
        sessionFactory = HibernateUtilTeste.getSessionFactory();
        System.out.println("SessionFactory criada");
    }
     
    @AfterAll
    public static void finalizar() {
        if (sessionFactory != null) sessionFactory.close();
        System.out.println("SessionFactory destruída");
    }
    
    @BeforeEach
    public void abrirSessao() {
        session = sessionFactory.openSession();
        System.out.println("Session criada");
    }
     
    @AfterEach
    public void fecharSessao() {
        if (session != null) session.close();
        System.out.println("Session destruída");
    }  
    
    @Test
    public void deveSalvarUmCursoNoBanco(){
        System.out.println("Executando teste deveSalvarUmCursoNoBanco");
        Curso curso = new Curso();
        curso.setNome("Bacharelado em Engenharia de Software");
        
        curso = CursoServico.inserir(curso);
        
        Assertions.assertTrue(curso.getId() > 0);
    }
}
