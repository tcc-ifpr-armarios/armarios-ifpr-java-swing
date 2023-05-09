package br.edu.ifpr.paranavai.armarios.controle;

import br.edu.ifpr.paranavai.armarios.excecoes.EstudanteException;
import br.edu.ifpr.paranavai.armarios.modelo.Estudante;
import br.edu.ifpr.paranavai.armarios.servico.EstudanteServico;
import java.util.List;

/**
 *
 * @author professor Marcelo F. Terenciani
 */
public class EstudanteControle {

    public static List<Estudante> listarTodosEstudantes() {
        return EstudanteServico.buscarTodos();
    }
    
    public static Estudante buscarPorId(int idEstudante) {
        return EstudanteServico.buscarPorId(idEstudante);
    }
    
    public static void excluir(Estudante estudante) throws EstudanteException {
        EstudanteServico.excluir(estudante);
    }
    
    public static Estudante atualizar(Estudante estudante) throws EstudanteException {
        return EstudanteServico.atualizar(estudante);
    }
    
    public static Estudante inserir(Estudante estudante) throws EstudanteException {
        return EstudanteServico.inserir(estudante);
    }
}
