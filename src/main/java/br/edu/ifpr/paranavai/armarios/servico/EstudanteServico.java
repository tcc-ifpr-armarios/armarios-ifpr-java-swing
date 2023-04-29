/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifpr.paranavai.armarios.servico;

import br.edu.ifpr.paranavai.armarios.dao.EstudanteDao;
import br.edu.ifpr.paranavai.armarios.dao.impl.EstudanteDaoImpl;
import br.edu.ifpr.paranavai.armarios.excecoes.EstudanteException;
import br.edu.ifpr.paranavai.armarios.modelo.Estudante;
import br.edu.ifpr.paranavai.armarios.utils.MensagemUtil;

import java.util.List;

public class EstudanteServico {

    private static EstudanteDao dao = new EstudanteDaoImpl();

    public static List<Estudante> buscarTodos() {
        return dao.buscarTodos();
    }

    public static Estudante buscarPorId(Integer id) {
        return dao.buscarPorId(id);
    }

    public static Estudante inserir(Estudante estudante) throws EstudanteException {
        if (estudante.getNome() == null || estudante.getNome().isEmpty()) {
            throw new EstudanteException(MensagemUtil.ESTUDANTE_CAMPO_OBRIGATORIO);
        }
        return dao.inserir(estudante);
    }

    public static void atualizar(Estudante estudante) {
        dao.atualizar(estudante);
    }

    public static void excluir(Estudante estudante) throws EstudanteException {
        dao.excluir(estudante);
    }

    public static List<Estudante> buscarPorNome(String nome) {
        return dao.buscarPorNome(nome);
    }

    public static List<Estudante> buscarPorRa(String ra) {
        return dao.buscarPorRa(ra);
    }

    public static Estudante buscarPorEmail(String email) {
        return dao.buscarPorEmail(email);
    }
}