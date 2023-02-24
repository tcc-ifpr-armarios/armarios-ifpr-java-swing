/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifpr.paranavai.armarios.servico;

import br.edu.ifpr.paranavai.armarios.modelo.Localizacao;
import br.edu.ifpr.paranavai.armarios.dao.LocalizacaoDao;
import br.edu.ifpr.paranavai.armarios.dao.LocalizacaoDaoImpl;
import java.util.List;

public class LocalizacaoServico {

    private static LocalizacaoDao dao = new LocalizacaoDaoImpl();

    public static List<Localizacao> buscarTodos() {
        return dao.buscarTodos();
    }

    public static Localizacao buscarPorId(Integer id) {
        return dao.buscarPorId(id);
    }

    public static void inserir(Localizacao localizacao) {
        dao.inserir(localizacao);
    }

    public static void atualizar(Localizacao localizacao) {
        dao.atualizar(localizacao);
    }

    public static void excluir(Localizacao localizacao) {
        dao.excluir(localizacao);
    }
}
