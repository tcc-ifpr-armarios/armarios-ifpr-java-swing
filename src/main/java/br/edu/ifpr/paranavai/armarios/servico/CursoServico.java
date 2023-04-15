/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifpr.paranavai.armarios.servico;

import br.edu.ifpr.paranavai.armarios.dao.CursoDao;
import br.edu.ifpr.paranavai.armarios.dao.impl.CursoDaoImpl;
import br.edu.ifpr.paranavai.armarios.excecoes.CursoException;
import br.edu.ifpr.paranavai.armarios.modelo.Curso;

/**
 *
 * @author teren
 */
public class CursoServico {
    private static CursoDao dao = new CursoDaoImpl();
    public static Curso inserir(Curso curso) throws CursoException{
        return dao.inserir(curso);
    }    

    public static void excluir(Curso curso) {
        dao.excluir(curso);
    }
}
