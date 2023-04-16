/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifpr.paranavai.armarios.controle;

import br.edu.ifpr.paranavai.armarios.modelo.Curso;
import br.edu.ifpr.paranavai.armarios.servico.CursoServico;
import java.util.List;

/**
 *
 * @author Professor Marcelo Figueiredo Terenciani
 */
public class CursoControle {

    public static List<Curso> listarTodosCursos() {
        return CursoServico.buscarTodos();
    }
    
}
